package tetrisV8;

import tetrisV8.Block.*;

class RSKill {
    RSKill(Block[][] rowStack, int killCount) {
        __rowStack = rowStack;
        __killCount = killCount;
    }
    
    Block[][] rs() {
        return __rowStack;
    }
    
    int kills() {
        return __killCount;
    }
    
    
    Block[][] __rowStack;
    int __killCount;
}