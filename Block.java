package tetrisV8;

enum Block {
    COLORED("C"), SOLID("S"), BOMB("B"), EMPTY(" ");

    Block(String text) {
        __text = text;
    }
    
    public String toString() {
        return __text;
    }
    
    String __text;
       
}