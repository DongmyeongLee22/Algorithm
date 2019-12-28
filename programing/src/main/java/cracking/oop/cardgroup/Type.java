package cracking.oop.cardgroup;

public enum Type {
    Club(0), Diamond(1), Heart(2), Spade(3);
    int value;

    Type(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Type getSuitFromValue(int value){
        switch (value){
            case 0:
                return Type.Club;
            case 1:
                return Type.Diamond;
            case 2:
                return Type.Heart;
            case 3:
                return Type.Spade;
        }
        return null;
    }
}
