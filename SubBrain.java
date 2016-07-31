package tetrisV8;

import java.util.Arrays;
import java.util.ArrayList;

import static tetrisV8.Block.*;
import static tetrisV8.Piece.*;

class SubBrain implements Runnable {
    
    
    void update(Piece[] bestPieces, int[] bestScores, Block[][][] simRSArray,
        int index, Piece[] assignedPieces, Block[][] rowStack, Piece[] queue,
        Piece other, int strat, int numMoves, int dContKillParam) {
        __bestPieces = bestPieces;
        __bestScores = bestScores;
        __simRSArray = simRSArray;
        
        __index = index;
        __assignedPieces = assignedPieces;
        __rowStack = rowStack;
        __queue = queue;
        __other = other;
        __strat = strat;
        __numMoves = numMoves;
        dContKill = dContKillParam;
    }
    
    
    public void run() {
    
        int[] colEmps = countColEmps(__rowStack);
        int[] topBomb = findBomb(__rowStack);
        int bestScore = -100000;
        Piece bestPiece = Piece.I0_33;
        int bestContKill = 0;
        Piece p;
        int startIndex = (__index%2==0) ? 0 : __assignedPieces.length/2;
        int endIndex = (__index%2==0) ? __assignedPieces.length/2 :
            __assignedPieces.length;
        for (int i = startIndex; i < endIndex; i++) {
            p = __assignedPieces[i];
            RSKill rsk = embedPiece(__rowStack, p, colEmps, topBomb);
            Block[][] resultRS = rsk.rs();
            int kills = rsk.kills();
            int indContKill = (kills > 0)?(dContKill+1):0;
            int score = evalRowStack(resultRS, kills, __numMoves, null, __queue, 0, indContKill, topBomb, __strat);
            if (score > bestScore) {
                bestContKill = indContKill;
                bestScore = score;
                bestPiece = p;
                __simRS = resultRS;
            }
        }

        dContKill = bestContKill;

        __bestPieces[__index] = bestPiece;
        __bestScores[__index] = bestScore;
        __simRSArray[__index] = __simRS;
    }
    
    
    /**Returns array that contains number of nulls at top of each column*/
    static int[] countColEmps(Block[][] __rowStack) {
        /**Check to see that the null being observed is unobstructed above.*/
        boolean[] stillTop = new boolean[10];
        Arrays.fill(stillTop, Boolean.TRUE);
        int[] colTopNulls = new int[10];
        Arrays.fill(colTopNulls, 0); //Probably don't need this line
        for (Block[] row : __rowStack) {
            for (int col = 0; col < 10; col++) {
                if (stillTop[col] && (row[col] == EMPTY)) {
                    colTopNulls[col] += 1;
                } else {
                    stillTop[col] = false;
                }
            }
        }
        return colTopNulls;
    }
        
        
    static int[] findBomb(Block[][] rowStack) {
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 10; col++) {
                if (rowStack[row][col] == BOMB) {
                    return new int[] {row, col};
                }
            }
        }
        return null;
    }
        
    
    /**Return __rowStack with Piece P dropped in*/
    static RSKill embedPiece(Block[][] rowStack, Piece p, int[] colEmps, int[] topBomb) {
        Block[][] resultRS = new Block[20][10];
        for (int rowIndex = 0; rowIndex < 20; rowIndex++) {
            for (int colIndex = 0; colIndex < 10; colIndex++) {
                resultRS[rowIndex][colIndex] = rowStack[rowIndex][colIndex];
            }
        }
        int[] relNulls = Arrays.copyOfRange(colEmps, p.getLeft(), p.getLeft() + p.width());
        int[] possibleMvmts = new int[p.width()];
        int mvmt = 20;
        for (int i = 0; i < p.width(); i++) {
            if ((relNulls[i] + p.getOffsets()[i]) < mvmt) {
                mvmt = relNulls[i] + p.getOffsets()[i];
            }
        }
        for (int rowComp = 0; rowComp < p.height(); rowComp++) {
            for (int colComp = 0; colComp < p.width(); colComp++) {
                if (p.getComponents()[rowComp][colComp] != EMPTY
                    && (mvmt-p.height()+rowComp >= 0)) {
                    resultRS[mvmt-p.height()+rowComp][colComp+p.getLeft()]
                        = p.getComponents()[rowComp][colComp];
                }
            }
        }
        
        // The below gets rid of all filled rows
        ArrayList<Integer> rowsToKill = new ArrayList<Integer>();
        for (int rowNum = 0; rowNum < 20; rowNum++) {
            boolean rowFilled = true;
            for (Block b : resultRS[rowNum]) {
                if (b != COLORED) {
                    rowFilled = false;
                    break;
                }
            }
            if (rowFilled) {
                rowsToKill.add(rowNum);
            }
        }
        boolean topBlown = false;
        if ((topBomb != null)
            && (topBomb[0] - 1 >= 0)
                && (rowStack[topBomb[0] - 1][topBomb[1]] == EMPTY)
                    && (resultRS[topBomb[0] - 1][topBomb[1]] == COLORED)) {
            rowsToKill.add(topBomb[0]);
            topBlown = true;
        }
        if (topBlown
            && (topBomb[0] + 1 <= 19)
                && (rowStack[topBomb[0] + 1][topBomb[1]] == BOMB)) {
            rowsToKill.add(topBomb[0] + 1);
        }
        int kills = 0;
        for (int row : rowsToKill) {
            killRow(resultRS, row);
            kills += 1;
        }
        return new RSKill(resultRS, kills);
    }
    
    static void killRow(Block[][] rowStack, int rowNum) {
        for (int aboveRow = rowNum; aboveRow > 0; aboveRow--) {
            rowStack[aboveRow] = rowStack[aboveRow - 1];
        }
        rowStack[0] = EMPROW;
    }
    
    
    /**Evaluate score of resultant __rowStack, after having piece (curr or held) embedded*/
    static int evalRowStack(Block[][] rowStack, int kills,
        int depth, Piece other, Piece[] queue, int index, int contKills,
            int[] topBombOrig, int strat) {
        
        int simpleEval;
        
        if (strat == 0) {
            simpleEval = simpleEvalRowStack(rowStack, kills, contKills, topBombOrig);
        } else {
            simpleEval = stratEvalRowStack(rowStack, kills, contKills, topBombOrig);
        }
        
        if (depth == 0 || simpleEval == 100000) {
            return simpleEval;
        }
        
        int bestScore = simpleEval;
        int[] colEmps = countColEmps(rowStack);
        int[] topBomb = findBomb(rowStack);
        RSKill nRSK;
        for (Piece p : queue[index].relatedPieces()[strat]) {
            nRSK = embedPiece(rowStack, p, colEmps, topBomb);
            int ncKills = (nRSK.kills() > 0)? contKills+1 : 0;
            int s = evalRowStack(
                nRSK.rs(), nRSK.kills(), depth-1, other, queue,
                    index+1, ncKills, topBomb, strat
            );
            if (s > bestScore) {
                bestScore = s;
            }
        }
        if (other != null && other != queue[index]) {
            for (Piece p : other.relatedPieces()[strat]) {
                nRSK = embedPiece(rowStack, p, colEmps, topBomb);
                int ncKills = (nRSK.kills() > 0)? contKills+1 : 0;
                int s = evalRowStack(
                    nRSK.rs(), nRSK.kills(), depth-1, queue[index], queue,
                        index+1, ncKills, topBomb, strat
                );
                if (s > bestScore) {
                    bestScore = s;
                }
            }
        }
        return bestScore;
    }
    
    /** rowStack   = rowStack to be evaluated after piece is embedded
        kills      = kills that happened during embedding piece
        contKills  = continuous kills that happened prior to reaching this rowStack*/
    static int simpleEvalRowStack(Block[][] rowStack, int kills, int contKills, 
        int[] topBomb) {
        int top = 20;
        int[] tops = new int[10];
        Arrays.fill(tops, 20);
        int gaps = 0;
        for (int rowNum = 0; rowNum < 20; rowNum++) {
            for (int colNum = 0; colNum < 10; colNum++) {
                if ((top == 20) && (rowStack[rowNum][colNum] == COLORED)) {
                    top = rowNum;
                }
                if ((tops[colNum] == 20) && (rowStack[rowNum][colNum] != EMPTY)) {
                    tops[colNum] = rowNum;
                }
                if ((rowNum > 0)
                    && (rowStack[rowNum][colNum] == EMPTY)
                        && (tops[colNum] != 20)) {
                    gaps += 1;
                }
            }
            if ((rowStack[rowNum][0] == SOLID)
                || (rowStack[rowNum][1] == SOLID)
                    || (rowStack[rowNum][2] == SOLID)) {
                break;
            }
        }
        if (allEmps(tops) && topBomb == null) {
            return 100000;
        }
        int right2Dif = Math.abs(tops[9] - tops[8]);
        int left2Dif =  Math.abs(tops[0] - tops[1]);
        contKills = (contKills == 1)?2:contKills;
        int topsTot = 0;
        for (int t : tops) {
            topsTot += t;
        }
        int topsAvg = topsTot / tops.length;
        int topsDif = 0;
        for (int t : tops) {
            topsDif += Math.abs(topsAvg - t);
        }
        
        int onBomb = (topBomb == null)?0:tops[topBomb[1]];
        top = (top < 3) ? top - 5 : top;
        
        return 12 * top - 32 * gaps + kills * kills - 4 * topsDif //topsDif*4, 25*gaps
            - right2Dif * right2Dif - left2Dif * left2Dif + 3 * contKills * contKills + 7 * onBomb;
    }
          

    /** rowStack   = rowStack to be evaluated after piece is embedded
        kills      = kills that happened during embedding piece
        contKills  = continuous kills that happened prior to reaching this rowStack*/
    static int stratEvalRowStack(Block[][] rowStack, int kills, int contKills, 
        int[] topBomb) {
        int[] tops = new int[10];
        Arrays.fill(tops, 20);
        int gaps = 0;
        for (int rowNum = 0; rowNum < 20; rowNum++) {
            for (int colNum = 0; colNum < 7; colNum++) {
                if ((tops[colNum] == 20) && (rowStack[rowNum][colNum] != EMPTY)) {
                    tops[colNum] = rowNum;
                }
                if ((rowNum > 0)
                    && (rowStack[rowNum][colNum] == EMPTY)
                        && (tops[colNum] != 20)) {
                    gaps += 1;
                }
            }
            for (int colNum = 7; colNum < 10; colNum++) {
                if ((tops[colNum] == 20) && (rowStack[rowNum][colNum] != EMPTY)) {
                    tops[colNum] = rowNum;
                }
                if ((rowNum > 0)
                    && (rowStack[rowNum][colNum] == EMPTY)
                        && (tops[colNum] != 20)) {
                    gaps += 6;
                }
            }
            if ((rowStack[rowNum][0] == SOLID)
                || (rowStack[rowNum][1] == SOLID)
                    || (rowStack[rowNum][2] == SOLID)) {
                for (int i = 0; i < 10; i++) {
                    if (tops[i] == 20) {
                        tops[i] = rowNum;
                    }
                }
                break;
            }
        }
        if (allEmps(tops) && topBomb == null) {
            return 100000;
        }
        int topsTotL = 0;
        int topsTotR = 0;
        
        for (int i = 0; i < 7; i++) {
            topsTotL += tops[i];
        }
        for (int i = 7; i < 10; i++) {
            topsTotR += tops[i];
        }
        int topsAvgL = topsTotL / 7;
        int topsAvgR = topsTotR / 3;
        int topsDifL = 0;
        int topsDifR = 0;
        for (int i = 0; i < 7; i++) {
            topsDifL += Math.abs(tops[i] - topsAvgL);
        }
        for (int i = 7; i < 10; i++) {
            topsDifR += Math.abs(tops[i] - topsAvgR);
        }
        
        contKills = (contKills == 1)?2:contKills;
        int right2Dif = Math.abs(tops[9] - tops[8]);
        int left2Dif = Math.abs(tops[0] - tops[1]);
        

        return 7 * topsTotR - 2 * topsTotL - 28 * gaps - right2Dif * right2Dif
            - left2Dif * left2Dif - 6 * topsDifL - 3 * topsDifR + contKills * contKills;
    }
    
    static boolean allEmps(int[] cols) {
        for (int e : cols) {
            if (e != 20) {
                return false;
            }
        }
        return true;
    }
    
    Block[][] simRS() {
        return __simRS;
    }
    
    Piece[] __bestPieces;
    int[] __bestScores;
    int __index;
    Piece[] __assignedPieces;
    Block[][] __rowStack;
    Piece[] __queue;
    Piece __other;
    int __strat;
    int __numMoves;
    
    Block[][] __simRS = null;
    int dContKill;
    Block[][][] __simRSArray;
    static final Block[] EMPROW = new Block[] {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, 
                            EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};
}

