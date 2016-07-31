package tetrisV8;

import static tetrisV8.Block.*;

enum Piece {

    L0_34(3, new int[] {0, 0, 0},
        new Block[][] {{EMPTY, EMPTY, COLORED},
                       {COLORED, COLORED, COLORED}},
        4, new int[] {0, 0, 0}),
    L0_25(2, new int[] {0, 0, 0},
        new Block[][] {{EMPTY, EMPTY, COLORED},
                       {COLORED, COLORED, COLORED}},
        5, new int[] {0, 1, 0}),
    L0_16(1, new int[] {0, 0, 0},
        new Block[][] {{EMPTY, EMPTY, COLORED},
                       {COLORED, COLORED, COLORED}},
        6, new int[] {0, 9, 0}),    
    L0_07(0, new int[] {0, 0, 0},
        new Block[][] {{EMPTY, EMPTY, COLORED},
                       {COLORED, COLORED, COLORED}},
        7, new int[] {0, 10, 0}),    
    L0_43(4, new int[] {0, 0, 0},
        new Block[][] {{EMPTY, EMPTY, COLORED},
                       {COLORED, COLORED, COLORED}},
        3, new int[] {0, 0, 1}),    
    L0_52(5, new int[] {0, 0, 0},
        new Block[][] {{EMPTY, EMPTY, COLORED},
                       {COLORED, COLORED, COLORED}},
        2, new int[] {0, 0, 2}),    
    L0_61(6, new int[] {0, 0, 0},
        new Block[][] {{EMPTY, EMPTY, COLORED},
                       {COLORED, COLORED, COLORED}},
        1, new int[] {0, 0, 9}),    
    L0_70(7, new int[] {0, 0, 0},
        new Block[][] {{EMPTY, EMPTY, COLORED},
                       {COLORED, COLORED, COLORED}},
        0, new int[] {0, 0, 10}),
        
        
    L1_44(4, new int[] {0, 0},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, EMPTY},
                       {COLORED, COLORED}},
        4, new int[] {1, 0, 0}),    
    L1_35(3, new int[] {0, 0},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, EMPTY},
                       {COLORED, COLORED}},
        5, new int[] {1, 1, 0}),    
    L1_26(2, new int[] {0, 0},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, EMPTY},
                       {COLORED, COLORED}},
        6, new int[] {1, 2, 0}),    
    L1_17(1, new int[] {0, 0},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, EMPTY},
                       {COLORED, COLORED}},
        7, new int[] {1, 9, 0}),    
    L1_08(0, new int[] {0, 0},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, EMPTY},
                       {COLORED, COLORED}},
        8, new int[] {1, 10, 0}),    
    L1_53(5, new int[] {0, 0},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, EMPTY},
                       {COLORED, COLORED}},
        3, new int[] {1, 0, 1}),    
    L1_62(6, new int[] {0, 0},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, EMPTY},
                       {COLORED, COLORED}},
        2, new int[] {1, 0, 2}),    
    L1_71(7, new int[] {0, 0},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, EMPTY},
                       {COLORED, COLORED}},
        1, new int[] {1, 0, 9}),    
    L1_80(8, new int[] {0, 0},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, EMPTY},
                       {COLORED, COLORED}},
        0, new int[] {1, 0, 10}),
        
    L2_34(3, new int[] {0, 1, 1}, 
        new Block[][] {{COLORED, COLORED, COLORED},
                       {COLORED, EMPTY, EMPTY}},
        4, new int[] {2, 0, 0}),    
    L2_25(2, new int[] {0, 1, 1}, 
        new Block[][] {{COLORED, COLORED, COLORED},
                       {COLORED, EMPTY, EMPTY}},
        5, new int[] {2, 1, 0}),    
    L2_16(1, new int[] {0, 1, 1}, 
        new Block[][] {{COLORED, COLORED, COLORED},
                       {COLORED, EMPTY, EMPTY}},
        6, new int[] {2, 9, 0}),    
    L2_07(0, new int[] {0, 1, 1}, 
        new Block[][] {{COLORED, COLORED, COLORED},
                       {COLORED, EMPTY, EMPTY}},
        7, new int[] {2, 10, 0}),    
    L2_43(4, new int[] {0, 1, 1}, 
        new Block[][] {{COLORED, COLORED, COLORED},
                       {COLORED, EMPTY, EMPTY}},
        3, new int[] {2, 0, 1}),    
    L2_52(5, new int[] {0, 1, 1}, 
        new Block[][] {{COLORED, COLORED, COLORED},
                       {COLORED, EMPTY, EMPTY}},
        2, new int[] {2, 0, 2}),    
    L2_61(6, new int[] {0, 1, 1}, 
        new Block[][] {{COLORED, COLORED, COLORED},
                       {COLORED, EMPTY, EMPTY}},
        1, new int[] {2, 0, 9}),    
    L2_70(7, new int[] {0, 1, 1}, 
        new Block[][] {{COLORED, COLORED, COLORED},
                       {COLORED, EMPTY, EMPTY}},
        0, new int[] {2, 0, 10}),    
        
        
        
    L3_35(3, new int[] {2, 0}, 
        new Block[][] {{COLORED, COLORED},
                       {EMPTY, COLORED},
                       {EMPTY, COLORED}},
        5, new int[] {3, 0, 0}),    
    L3_26(2, new int[] {2, 0}, 
        new Block[][] {{COLORED, COLORED},
                       {EMPTY, COLORED},
                       {EMPTY, COLORED}},
        6, new int[] {3, 1, 0}),    
    L3_17(1, new int[] {2, 0}, 
        new Block[][] {{COLORED, COLORED},
                       {EMPTY, COLORED},
                       {EMPTY, COLORED}},
        7, new int[] {3, 9, 0}),    
    L3_08(0, new int[] {2, 0}, 
        new Block[][] {{COLORED, COLORED},
                       {EMPTY, COLORED},
                       {EMPTY, COLORED}},
        8, new int[] {3, 10, 0}),    
    L3_44(4, new int[] {2, 0}, 
        new Block[][] {{COLORED, COLORED},
                       {EMPTY, COLORED},
                       {EMPTY, COLORED}},
        4, new int[] {3, 0, 1}),    
    L3_53(5, new int[] {2, 0}, 
        new Block[][] {{COLORED, COLORED},
                       {EMPTY, COLORED},
                       {EMPTY, COLORED}},
        3, new int[] {3, 0, 2}),    
    L3_62(6, new int[] {2, 0}, 
        new Block[][] {{COLORED, COLORED},
                       {EMPTY, COLORED},
                       {EMPTY, COLORED}},
        2, new int[] {3, 0, 3}),    
    L3_71(7, new int[] {2, 0}, 
        new Block[][] {{COLORED, COLORED},
                       {EMPTY, COLORED},
                       {EMPTY, COLORED}},
        1, new int[] {3, 0, 9}),    
    L3_80(8, new int[] {2, 0}, 
        new Block[][] {{COLORED, COLORED},
                       {EMPTY, COLORED},
                       {EMPTY, COLORED}},
        0, new int[] {3, 0, 10}),    

                       
                       
    I0_33(3, new int[] {0, 0, 0, 0},
        new Block[][] {{COLORED, COLORED, COLORED, COLORED}},
        3, new int[] {0, 0, 0}),
    I0_24(2, new int[] {0, 0, 0, 0},
        new Block[][] {{COLORED, COLORED, COLORED, COLORED}},
        4, new int[] {0, 1, 0}),    
    I0_15(1, new int[] {0, 0, 0, 0},
        new Block[][] {{COLORED, COLORED, COLORED, COLORED}},
        5, new int[] {0, 9, 0}),    
    I0_06(0, new int[] {0, 0, 0, 0},
        new Block[][] {{COLORED, COLORED, COLORED, COLORED}},
        6, new int[] {0, 10, 0}),    
    I0_42(4, new int[] {0, 0, 0, 0},
        new Block[][] {{COLORED, COLORED, COLORED, COLORED}},
        2, new int[] {0, 0, 1}),    
    I0_51(5, new int[] {0, 0, 0, 0},
        new Block[][] {{COLORED, COLORED, COLORED, COLORED}},
        1, new int[] {0, 0, 9}),    
    I0_60(6, new int[] {0, 0, 0, 0},
        new Block[][] {{COLORED, COLORED, COLORED, COLORED}},
        0, new int[] {0, 0, 10}),
        
    I1_54(5, new int[] {0},
        new Block[][] {{COLORED},
                       {COLORED},
                       {COLORED},
                       {COLORED}},
        4, new int[] {1, 0, 0}),    
    I1_45(4, new int[] {0},
        new Block[][] {{COLORED},
                       {COLORED},
                       {COLORED},
                       {COLORED}},
        5, new int[] {1, 1, 0}),    
    I1_36(3, new int[] {0},
        new Block[][] {{COLORED},
                       {COLORED},
                       {COLORED},
                       {COLORED}},
        6, new int[] {1, 2, 0}),    
    I1_27(2, new int[] {0},
        new Block[][] {{COLORED},
                       {COLORED},
                       {COLORED},
                       {COLORED}},
        7, new int[] {1, 3, 0}),    
    I1_18(1, new int[] {0},
        new Block[][] {{COLORED},
                       {COLORED},
                       {COLORED},
                       {COLORED}},
        8, new int[] {1, 9, 0}),    
    I1_09(0, new int[] {0},
        new Block[][] {{COLORED},
                       {COLORED},
                       {COLORED},
                       {COLORED}},
        9, new int[] {1, 10, 0}),    
    I1_63(6, new int[] {0},
        new Block[][] {{COLORED},
                       {COLORED},
                       {COLORED},
                       {COLORED}},
        3, new int[] {1, 0, 1}),    
    I1_72(7, new int[] {0},
        new Block[][] {{COLORED},
                       {COLORED},
                       {COLORED},
                       {COLORED}},
        2, new int[] {1, 0, 2}),    
    I1_81(8, new int[] {0},
        new Block[][] {{COLORED},
                       {COLORED},
                       {COLORED},
                       {COLORED}},
        1, new int[] {1, 0, 9}),    
    I1_90(9, new int[] {0},
        new Block[][] {{COLORED},
                       {COLORED},
                       {COLORED},
                       {COLORED}},
        0, new int[] {1, 0, 10}),            

    T0_34(3, new int[] {0, 0, 0},
        new Block[][] {{EMPTY, COLORED, EMPTY},
                       {COLORED, COLORED, COLORED}},
        4, new int[] {0, 0, 0}),    
    T0_25(2, new int[] {0, 0, 0},
        new Block[][] {{EMPTY, COLORED, EMPTY},
                       {COLORED, COLORED, COLORED}},
        5, new int[] {0, 1, 0}),    
    T0_16(1, new int[] {0, 0, 0},
        new Block[][] {{EMPTY, COLORED, EMPTY},
                       {COLORED, COLORED, COLORED}},
        6, new int[] {0, 9, 0}),    
    T0_07(0, new int[] {0, 0, 0},
        new Block[][] {{EMPTY, COLORED, EMPTY},
                       {COLORED, COLORED, COLORED}},
        7, new int[] {0, 10, 0}),    
    T0_43(4, new int[] {0, 0, 0},
        new Block[][] {{EMPTY, COLORED, EMPTY},
                       {COLORED, COLORED, COLORED}},
        3, new int[] {0, 0, 1}),    
    T0_52(5, new int[] {0, 0, 0},
        new Block[][] {{EMPTY, COLORED, EMPTY},
                       {COLORED, COLORED, COLORED}},
        2, new int[] {0, 0, 2}),    
    T0_61(6, new int[] {0, 0, 0},
        new Block[][] {{EMPTY, COLORED, EMPTY},
                       {COLORED, COLORED, COLORED}},
        1, new int[] {0, 0, 9}),    
    T0_70(7, new int[] {0, 0, 0},
        new Block[][] {{EMPTY, COLORED, EMPTY},
                       {COLORED, COLORED, COLORED}},
        0, new int[] {0, 0, 10}),
        
    T1_44(4, new int[] {0, 1},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, COLORED},
                       {COLORED, EMPTY}},
        4, new int[] {1, 0, 0}),    
    T1_35(3, new int[] {0, 1},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, COLORED},
                       {COLORED, EMPTY}},
        5, new int[] {1, 1, 0}),    
    T1_26(2, new int[] {0, 1},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, COLORED},
                       {COLORED, EMPTY}},
        6, new int[] {1, 2, 0}),    
    T1_17(1, new int[] {0, 1},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, COLORED},
                       {COLORED, EMPTY}},
        7, new int[] {1, 9, 0}),    
    T1_08(0, new int[] {0, 1},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, COLORED},
                       {COLORED, EMPTY}},
        8, new int[] {1, 10, 0}),    
    T1_53(5, new int[] {0, 1},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, COLORED},
                       {COLORED, EMPTY}},
        3, new int[] {1, 0, 1}),    
    T1_62(6, new int[] {0, 1},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, COLORED},
                       {COLORED, EMPTY}},
        2, new int[] {1, 0, 2}),    
    T1_71(7, new int[] {0, 1},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, COLORED},
                       {COLORED, EMPTY}},
        1, new int[] {1, 0, 9}),    
    T1_80(8, new int[] {0, 1},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, COLORED},
                       {COLORED, EMPTY}},
        0, new int[] {1, 0, 10}),
        
    T2_34(3, new int[] {1, 0, 1},
        new Block[][] {{COLORED, COLORED, COLORED},
                       {EMPTY, COLORED, EMPTY}},
        4, new int[] {2, 0, 0}),
    T2_25(2, new int[] {1, 0, 1},
        new Block[][] {{COLORED, COLORED, COLORED},
                       {EMPTY, COLORED, EMPTY}},
        5, new int[] {2, 1, 0}),
    T2_16(1, new int[] {1, 0, 1},
        new Block[][] {{COLORED, COLORED, COLORED},
                       {EMPTY, COLORED, EMPTY}},
        6, new int[] {2, 9, 0}),
    T2_07(0, new int[] {1, 0, 1},
        new Block[][] {{COLORED, COLORED, COLORED},
                       {EMPTY, COLORED, EMPTY}},
        7, new int[] {2, 10, 0}),
    T2_43(4, new int[] {1, 0, 1},
        new Block[][] {{COLORED, COLORED, COLORED},
                       {EMPTY, COLORED, EMPTY}},
        3, new int[] {2, 0, 1}),
    T2_52(5, new int[] {1, 0, 1},
        new Block[][] {{COLORED, COLORED, COLORED},
                       {EMPTY, COLORED, EMPTY}},
        2, new int[] {2, 0, 2}),
    T2_61(6, new int[] {1, 0, 1},
        new Block[][] {{COLORED, COLORED, COLORED},
                       {EMPTY, COLORED, EMPTY}},
        1, new int[] {2, 0, 9}),
    T2_70(7, new int[] {1, 0, 1},
        new Block[][] {{COLORED, COLORED, COLORED},
                       {EMPTY, COLORED, EMPTY}},
        0, new int[] {2, 0, 10}),
        
    T3_35(3, new int[] {1, 0},
        new Block[][] {{EMPTY, COLORED},
                       {COLORED, COLORED},
                       {EMPTY, COLORED}},
        5, new int[] {3, 0, 0}),
    T3_26(2, new int[] {1, 0},
        new Block[][] {{EMPTY, COLORED},
                       {COLORED, COLORED},
                       {EMPTY, COLORED}},
        6, new int[] {3, 1, 0}),
    T3_17(1, new int[] {1, 0},
        new Block[][] {{EMPTY, COLORED},
                       {COLORED, COLORED},
                       {EMPTY, COLORED}},
        7, new int[] {3, 9, 0}),
    T3_08(0, new int[] {1, 0},
        new Block[][] {{EMPTY, COLORED},
                       {COLORED, COLORED},
                       {EMPTY, COLORED}},
        8, new int[] {3, 10, 0}),
    T3_44(4, new int[] {1, 0},
        new Block[][] {{EMPTY, COLORED},
                       {COLORED, COLORED},
                       {EMPTY, COLORED}},
        4, new int[] {3, 0, 1}),
    T3_53(5, new int[] {1, 0},
        new Block[][] {{EMPTY, COLORED},
                       {COLORED, COLORED},
                       {EMPTY, COLORED}},
        3, new int[] {3, 0, 2}),
    T3_62(6, new int[] {1, 0},
        new Block[][] {{EMPTY, COLORED},
                       {COLORED, COLORED},
                       {EMPTY, COLORED}},
        2, new int[] {3, 0, 3}),
    T3_71(7, new int[] {1, 0},
        new Block[][] {{EMPTY, COLORED},
                       {COLORED, COLORED},
                       {EMPTY, COLORED}},
        1, new int[] {3, 0, 9}),
    T3_80(8, new int[] {1, 0},
        new Block[][] {{EMPTY, COLORED},
                       {COLORED, COLORED},
                       {EMPTY, COLORED}},
        0, new int[] {3, 0, 10}),

        
        
    RL0_34(3, new int[] {0, 0, 0},
        new Block[][] {{COLORED, EMPTY, EMPTY},
                       {COLORED, COLORED, COLORED}},
        4, new int[] {0, 0, 0}),
    RL0_25(2, new int[] {0, 0, 0},
        new Block[][] {{COLORED, EMPTY, EMPTY},
                       {COLORED, COLORED, COLORED}},
        5, new int[] {0, 1, 0}),
    RL0_16(1, new int[] {0, 0, 0},
        new Block[][] {{COLORED, EMPTY, EMPTY},
                       {COLORED, COLORED, COLORED}},
        6, new int[] {0, 9, 0}),
    RL0_07(0, new int[] {0, 0, 0},
        new Block[][] {{COLORED, EMPTY, EMPTY},
                       {COLORED, COLORED, COLORED}},
        7, new int[] {0, 10, 0}),
    RL0_43(4, new int[] {0, 0, 0},
        new Block[][] {{COLORED, EMPTY, EMPTY},
                       {COLORED, COLORED, COLORED}},
        3, new int[] {0, 0, 1}),
    RL0_52(5, new int[] {0, 0, 0},
        new Block[][] {{COLORED, EMPTY, EMPTY},
                       {COLORED, COLORED, COLORED}},
        2, new int[] {0, 0, 2}),
    RL0_61(6, new int[] {0, 0, 0},
        new Block[][] {{COLORED, EMPTY, EMPTY},
                       {COLORED, COLORED, COLORED}},
        1, new int[] {0, 0, 9}),
    RL0_70(7, new int[] {0, 0, 0},
        new Block[][] {{COLORED, EMPTY, EMPTY},
                       {COLORED, COLORED, COLORED}},
        0, new int[] {0, 0, 10}),

    RL1_44(4, new int[] {0, 2},
        new Block[][] {{COLORED, COLORED},
                       {COLORED, EMPTY},
                       {COLORED, EMPTY}},
        4, new int[] {1, 0, 0}),
    RL1_35(3, new int[] {0, 2},
        new Block[][] {{COLORED, COLORED},
                       {COLORED, EMPTY},
                       {COLORED, EMPTY}},
        5, new int[] {1, 1, 0}),
    RL1_26(2, new int[] {0, 2},
        new Block[][] {{COLORED, COLORED},
                       {COLORED, EMPTY},
                       {COLORED, EMPTY}},
        6, new int[] {1, 2, 0}),
    RL1_17(1, new int[] {0, 2},
        new Block[][] {{COLORED, COLORED},
                       {COLORED, EMPTY},
                       {COLORED, EMPTY}},
        7, new int[] {1, 9, 0}),
    RL1_08(0, new int[] {0, 2},
        new Block[][] {{COLORED, COLORED},
                       {COLORED, EMPTY},
                       {COLORED, EMPTY}},
        8, new int[] {1, 10, 0}),
    RL1_53(5, new int[] {0, 2},
        new Block[][] {{COLORED, COLORED},
                       {COLORED, EMPTY},
                       {COLORED, EMPTY}},
        3, new int[] {1, 0, 1}),
    RL1_62(6, new int[] {0, 2},
        new Block[][] {{COLORED, COLORED},
                       {COLORED, EMPTY},
                       {COLORED, EMPTY}},
        2, new int[] {1, 0, 2}),
    RL1_71(7, new int[] {0, 2},
        new Block[][] {{COLORED, COLORED},
                       {COLORED, EMPTY},
                       {COLORED, EMPTY}},
        1, new int[] {1, 0, 9}),
    RL1_80(8, new int[] {0, 2},
        new Block[][] {{COLORED, COLORED},
                       {COLORED, EMPTY},
                       {COLORED, EMPTY}},
        0, new int[] {1, 0, 10}),

    RL2_34(3, new int[] {1, 1, 0},
        new Block[][] {{COLORED, COLORED, COLORED},
                       {EMPTY, EMPTY, COLORED}},
        4, new int[] {2, 0, 0}),
    RL2_25(2, new int[] {1, 1, 0},
        new Block[][] {{COLORED, COLORED, COLORED},
                       {EMPTY, EMPTY, COLORED}},
        5, new int[] {2, 1, 0}),
    RL2_16(1, new int[] {1, 1, 0},
        new Block[][] {{COLORED, COLORED, COLORED},
                       {EMPTY, EMPTY, COLORED}},
        6, new int[] {2, 9, 0}),
    RL2_07(0, new int[] {1, 1, 0},
        new Block[][] {{COLORED, COLORED, COLORED},
                       {EMPTY, EMPTY, COLORED}},
        7, new int[] {2, 10, 0}),
    RL2_43(4, new int[] {1, 1, 0},
        new Block[][] {{COLORED, COLORED, COLORED},
                       {EMPTY, EMPTY, COLORED}},
        3, new int[] {2, 0, 1}),
    RL2_52(5, new int[] {1, 1, 0},
        new Block[][] {{COLORED, COLORED, COLORED},
                       {EMPTY, EMPTY, COLORED}},
        2, new int[] {2, 0, 2}),
    RL2_61(6, new int[] {1, 1, 0},
        new Block[][] {{COLORED, COLORED, COLORED},
                       {EMPTY, EMPTY, COLORED}},
        1, new int[] {2, 0, 9}),
    RL2_70(7, new int[] {1, 1, 0},
        new Block[][] {{COLORED, COLORED, COLORED},
                       {EMPTY, EMPTY, COLORED}},
        0, new int[] {2, 0, 10}),

    RL3_35(3, new int[] {0, 0},
        new Block[][] {{EMPTY, COLORED},
                       {EMPTY, COLORED},
                       {COLORED, COLORED}},
        5, new int[] {3, 0, 0}),
    RL3_26(2, new int[] {0, 0},
        new Block[][] {{EMPTY, COLORED},
                       {EMPTY, COLORED},
                       {COLORED, COLORED}},
        6, new int[] {3, 1, 0}),
    RL3_17(1, new int[] {0, 0},
        new Block[][] {{EMPTY, COLORED},
                       {EMPTY, COLORED},
                       {COLORED, COLORED}},
        7, new int[] {3, 9, 0}),
    RL3_08(0, new int[] {0, 0},
        new Block[][] {{EMPTY, COLORED},
                       {EMPTY, COLORED},
                       {COLORED, COLORED}},
        8, new int[] {3, 10, 0}),
    RL3_44(4, new int[] {0, 0},
        new Block[][] {{EMPTY, COLORED},
                       {EMPTY, COLORED},
                       {COLORED, COLORED}},
        4, new int[] {3, 0, 1}),
    RL3_53(5, new int[] {0, 0},
        new Block[][] {{EMPTY, COLORED},
                       {EMPTY, COLORED},
                       {COLORED, COLORED}},
        3, new int[] {3, 0, 2}),
    RL3_62(6, new int[] {0, 0},
        new Block[][] {{EMPTY, COLORED},
                       {EMPTY, COLORED},
                       {COLORED, COLORED}},
        2, new int[] {3, 0, 3}),
    RL3_71(7, new int[] {0, 0},
        new Block[][] {{EMPTY, COLORED},
                       {EMPTY, COLORED},
                       {COLORED, COLORED}},
        1, new int[] {3, 0, 9}),
    RL3_80(8, new int[] {0, 0},
        new Block[][] {{EMPTY, COLORED},
                       {EMPTY, COLORED},
                       {COLORED, COLORED}},
        0, new int[] {3, 0, 10}),

    

    SQ_44(4, new int[] {0, 0},
        new Block[][] {{COLORED, COLORED},
                       {COLORED, COLORED}},
        4, new int[] {0, 0, 0}),
    SQ_35(3, new int[] {0, 0},
        new Block[][] {{COLORED, COLORED},
                       {COLORED, COLORED}},
        5, new int[] {0, 1, 0}),
    SQ_26(2, new int[] {0, 0},
        new Block[][] {{COLORED, COLORED},
                       {COLORED, COLORED}},
        6, new int[] {0, 2, 0}),
    SQ_17(1, new int[] {0, 0},
        new Block[][] {{COLORED, COLORED},
                       {COLORED, COLORED}},
        7, new int[] {0, 9, 0}),

    SQ_08(0, new int[] {0, 0},
        new Block[][] {{COLORED, COLORED},
                       {COLORED, COLORED}},
        8, new int[] {0, 10, 0}),

    SQ_53(5, new int[] {0, 0},
        new Block[][] {{COLORED, COLORED},
                       {COLORED, COLORED}},
        3, new int[] {0, 0, 1}),

    SQ_62(6, new int[] {0, 0},
        new Block[][] {{COLORED, COLORED},
                       {COLORED, COLORED}},
        2, new int[] {0, 0, 2}),

    SQ_71(7, new int[] {0, 0},
        new Block[][] {{COLORED, COLORED},
                       {COLORED, COLORED}},
        1, new int[] {0, 0, 9}),    
    SQ_80(8, new int[] {0, 0},
        new Block[][] {{COLORED, COLORED},
                       {COLORED, COLORED}},
        0, new int[] {0, 0, 10}),


        
        
    Z0_34(3, new int[] {1, 0, 0},
        new Block[][] {{COLORED, COLORED, EMPTY},
                       {EMPTY, COLORED, COLORED}},
        4, new int[] {0, 0, 0}),
    Z0_25(2, new int[] {1, 0, 0},
        new Block[][] {{COLORED, COLORED, EMPTY},
                       {EMPTY, COLORED, COLORED}},
        5, new int[] {0, 1, 0}),
    Z0_16(1, new int[] {1, 0, 0},
        new Block[][] {{COLORED, COLORED, EMPTY},
                       {EMPTY, COLORED, COLORED}},
        6, new int[] {0, 9, 0}),
    Z0_07(0, new int[] {1, 0, 0},
        new Block[][] {{COLORED, COLORED, EMPTY},
                       {EMPTY, COLORED, COLORED}},
        7, new int[] {0, 10, 0}),
    Z0_43(4, new int[] {1, 0, 0},
        new Block[][] {{COLORED, COLORED, EMPTY},
                       {EMPTY, COLORED, COLORED}},
        3, new int[] {0, 0, 1}),
    Z0_52(5, new int[] {1, 0, 0},
        new Block[][] {{COLORED, COLORED, EMPTY},
                       {EMPTY, COLORED, COLORED}},
        2, new int[] {0, 0, 2}),
    Z0_61(6, new int[] {1, 0, 0},
        new Block[][] {{COLORED, COLORED, EMPTY},
                       {EMPTY, COLORED, COLORED}},
        1, new int[] {0, 0, 9}),
    Z0_70(7, new int[] {1, 0, 0},
        new Block[][] {{COLORED, COLORED, EMPTY},
                       {EMPTY, COLORED, COLORED}},
        0, new int[] {0, 0, 10}),

    Z1_44(4, new int[] {0, 1},
        new Block[][] {{EMPTY, COLORED},
                       {COLORED, COLORED},
                       {COLORED, EMPTY}},
        4, new int[] {1, 0, 0}),
    Z1_35(3, new int[] {0, 1},
        new Block[][] {{EMPTY, COLORED},
                       {COLORED, COLORED},
                       {COLORED, EMPTY}},
        5, new int[] {1, 1, 0}),
    Z1_26(2, new int[] {0, 1},
        new Block[][] {{EMPTY, COLORED},
                       {COLORED, COLORED},
                       {COLORED, EMPTY}},
        6, new int[] {1, 2, 0}),
    Z1_17(1, new int[] {0, 1},
        new Block[][] {{EMPTY, COLORED},
                       {COLORED, COLORED},
                       {COLORED, EMPTY}},
        7, new int[] {1, 9, 0}),
    Z1_08(0, new int[] {0, 1},
        new Block[][] {{EMPTY, COLORED},
                       {COLORED, COLORED},
                       {COLORED, EMPTY}},
        8, new int[] {1, 10, 0}),
    Z1_53(5, new int[] {0, 1},
        new Block[][] {{EMPTY, COLORED},
                       {COLORED, COLORED},
                       {COLORED, EMPTY}},
        3, new int[] {1, 0, 1}),
    Z1_62(6, new int[] {0, 1},
        new Block[][] {{EMPTY, COLORED},
                       {COLORED, COLORED},
                       {COLORED, EMPTY}},
        2, new int[] {1, 0, 2}),
    Z1_71(7, new int[] {0, 1},
        new Block[][] {{EMPTY, COLORED},
                       {COLORED, COLORED},
                       {COLORED, EMPTY}},
        1, new int[] {1, 0, 9}),
    Z1_80(8, new int[] {0, 1},
        new Block[][] {{EMPTY, COLORED},
                       {COLORED, COLORED},
                       {COLORED, EMPTY}},
        0, new int[] {1, 0, 10}),

    
    S0_34(3, new int[] {0, 0, 1},
        new Block[][] {{EMPTY, COLORED, COLORED},
                       {COLORED, COLORED, EMPTY}},
        4, new int[] {0, 0, 0}),
    S0_25(2, new int[] {0, 0, 1},
        new Block[][] {{EMPTY, COLORED, COLORED},
                       {COLORED, COLORED, EMPTY}},
        5, new int[] {0, 1, 0}),
    S0_16(1, new int[] {0, 0, 1},
        new Block[][] {{EMPTY, COLORED, COLORED},
                       {COLORED, COLORED, EMPTY}},
        6, new int[] {0, 9, 0}),
    S0_07(0, new int[] {0, 0, 1},
        new Block[][] {{EMPTY, COLORED, COLORED},
                       {COLORED, COLORED, EMPTY}},
        7, new int[] {0, 10, 0}),
    S0_43(4, new int[] {0, 0, 1},
        new Block[][] {{EMPTY, COLORED, COLORED},
                       {COLORED, COLORED, EMPTY}},
        3, new int[] {0, 0, 1}),
    S0_52(5, new int[] {0, 0, 1},
        new Block[][] {{EMPTY, COLORED, COLORED},
                       {COLORED, COLORED, EMPTY}},
        2, new int[] {0, 0, 2}),
    S0_61(6, new int[] {0, 0, 1},
        new Block[][] {{EMPTY, COLORED, COLORED},
                       {COLORED, COLORED, EMPTY}},
        1, new int[] {0, 0, 9}),
    S0_70(7, new int[] {0, 0, 1},
        new Block[][] {{EMPTY, COLORED, COLORED},
                       {COLORED, COLORED, EMPTY}},
        0, new int[] {0, 0, 10}),

    S1_44(4, new int[] {1, 0},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, COLORED},
                       {EMPTY, COLORED}},
        4, new int[] {1, 0, 0}),
    S1_35(3, new int[] {1, 0},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, COLORED},
                       {EMPTY, COLORED}},
        5, new int[] {1, 1, 0}),
    S1_26(2, new int[] {1, 0},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, COLORED},
                       {EMPTY, COLORED}},
        6, new int[] {1, 2, 0}),
    S1_17(1, new int[] {1, 0},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, COLORED},
                       {EMPTY, COLORED}},
        7, new int[] {1, 9, 0}),
    S1_08(0, new int[] {1, 0},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, COLORED},
                       {EMPTY, COLORED}},
        8, new int[] {1, 10, 0}),
    S1_53(5, new int[] {1, 0},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, COLORED},
                       {EMPTY, COLORED}},
        3, new int[] {1, 0, 1}),
    S1_62(6, new int[] {1, 0},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, COLORED},
                       {EMPTY, COLORED}},
        2, new int[] {1, 0, 2}),
    S1_71(7, new int[] {1, 0},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, COLORED},
                       {EMPTY, COLORED}},
        1, new int[] {1, 0, 9}),
    S1_80(8, new int[] {1, 0},
        new Block[][] {{COLORED, EMPTY},
                       {COLORED, COLORED},
                       {EMPTY, COLORED}},
        0, new int[] {1, 0, 10}),


    NULLPIECE(0, null, null, 0, null);
    
    Piece(int leftWidth, int[] bottomOffset, Block[][] components, int rightWidth, int[] move) {
        __leftWidth = leftWidth;
        __bottomOffset = bottomOffset;
        __components = components;
        __rightWidth = rightWidth;
        __move = move;
    }

    int getLeft() {
        return __leftWidth;
    }
    
    int[] getOffsets() {
        return __bottomOffset;
    }
    
    int width() {
        return __bottomOffset.length;
    }
    
    int height() {
        return __components.length;
    }
    
    Block[][] getComponents() {
        return __components;
    }
    
    int getRight() {
        return __rightWidth;
    }
    
    int[] getMove() {
        return __move;
    }
    
    

Piece[][] relatedPieces() {
    Piece[][] pieces = null;
    switch (this) {
        case L0_34:
            pieces = new Piece[][]
            {   
                {
                    L0_25, L0_16, L0_07, L0_52, L0_61, L0_70, L1_44, L1_35, L1_26,
                    L1_17, L1_08, L1_53, L1_62, L1_71, L1_80, L2_34, L2_25, L2_16, L2_07, L2_43, L2_52,
                    L2_61, L2_70, L3_35, L3_26, L3_17, L3_08, L3_44, L3_53, L3_62, L3_71, L3_80, L0_34 ,L0_43
                },
                {
                    L0_25, L0_16, L0_07, L1_44, L1_35, L1_26,
                    L1_17, L1_08, L1_53, L2_34, L2_25, L2_16, L2_07, L2_43,
                    L3_35, L3_26, L3_17, L3_08, L3_44, L3_53, L0_34 ,L0_43
                }
            };
            break;

        case I0_33:
            pieces = new Piece[][]
            {
                {
                    I0_24, I0_15, I0_06, I0_42, I0_51, I0_60, 
                    I1_18, I1_09, I1_81, I1_90, I1_54, I1_45, I1_36, I1_27,  
                    I1_63, I1_72, I0_33
                },
                {
                    I0_24, I0_15, I0_06,
                    I1_18, I1_09, I1_54, I1_45, I1_36, I1_27,  
                    I1_63, I0_33
                }
            };
            break;

        case T0_34:
            pieces = new Piece[][]
            {
                {
                    T0_25, T0_16, T0_07,  T0_52, T0_61, T0_70, T1_44, T1_35, T1_26, T1_17, 
                    T1_08, T1_53, T1_62, T1_71, T1_80, T2_34, T2_25, T2_16, T2_07, T2_43, T2_52, T2_61, 
                    T2_70, T3_35, T3_26, T3_17, T3_08, T3_44, T3_53, T3_62, T3_71, T3_80,
                    T0_34, T0_43
                },
                {
                    T0_25, T0_16, T0_07, T1_44, T1_35, T1_26, T1_17, 
                    T1_08, T1_53, T2_34, T2_25, T2_16, T2_07, T2_43,
                    T3_35, T3_26, T3_17, T3_08, T3_44, T3_53,
                    T0_34, T0_43
                }
            };
            break;
            
        case RL0_34:
            pieces = new Piece[][]
            {
                {
                    RL0_25, RL0_16, RL0_07, RL0_43, RL0_52, RL0_61, RL0_70, RL1_44, RL1_35, RL1_26, 
                    RL1_17, RL1_08, RL1_53, RL1_62, RL1_71, RL1_80, RL2_34, RL2_25, RL2_16, RL2_07,  
                    RL2_52, RL2_61, RL2_70, RL3_35, RL3_26, RL3_17, RL3_08, RL3_44, RL3_53, RL3_62, 
                    RL3_71, RL3_80, RL0_34, RL2_43
                },
                {
                    RL0_25, RL0_16, RL0_07, RL0_43, RL1_44, RL1_35, RL1_26, 
                    RL1_17, RL1_08, RL1_53, RL2_34, RL2_25, RL2_16, RL2_07,  
                    RL3_35, RL3_26, RL3_17, RL3_08, RL3_44, RL3_53,
                    RL0_34, RL2_43
                }
            };
            break;
            
        case SQ_44:
            pieces = new Piece[][]
            {
                {
                    SQ_26, SQ_17, SQ_08, SQ_62, SQ_71, SQ_80, SQ_44, SQ_35, SQ_53
                },
                {
                    SQ_26, SQ_17, SQ_08, SQ_44, SQ_35, SQ_53
                }
            };
            break;

        case Z0_34:
            pieces = new Piece[][]
            {
                {
                    Z0_25, Z0_16, Z0_07, Z0_52, Z0_61, Z0_70, Z1_44, Z1_35, Z1_26, Z1_17,
                    Z1_08, Z1_53, Z1_62, Z1_71, Z1_80, Z0_34, Z0_43
                },
                {
                    Z0_25, Z0_16, Z0_07, Z1_44, Z1_35, Z1_26, Z1_17,
                    Z1_08, Z1_53, Z0_34, Z0_43
                }
            };
            break;

        case S0_34:
            pieces = new Piece[][]
            {
                {
                    S0_25, S0_16, S0_07, S0_52, S0_61, S0_70, S1_44, S1_35, S1_26, S1_17,
                    S1_08, S1_53, S1_62, S1_71, S1_80, S0_34, S0_43
                },
                {
                    S0_25, S0_16, S0_07, S1_44, S1_35, S1_26, S1_17,
                    S1_08, S1_53, S0_34, S0_43
                }
            };
            break;
    }
    return pieces;
}
    
    private int __leftWidth;
    private int[] __bottomOffset;
    private Block[][] __components;
    private int __rightWidth;
    private int[] __move;
    
}