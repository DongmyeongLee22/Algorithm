package cracking.oop.cardgroup;

public abstract class Card {

    private boolean available = true;

    protected int facevalue;
    protected Type type;

    public Card(int facevalue, Type type) {
        this.facevalue = facevalue;
        this.type = type;
    }

    public abstract int value();

    public boolean isAvailable(){
        return available;
    }

    public void markUnavailable(){
        available = false;
    }

    public void markAvailable(){
        available = true;
    }

    public void print(){
        String[] faceValues = {"A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        System.out.print(faceValues[facevalue - 1]);
        switch (type){
            case Club:
                System.out.print("c");
                break;
            case Heart:
                System.out.print("h");
                break;
            case Spade:
                System.out.print("s");
                break;
            case Diamond:
                System.out.print("d");
                break;
        }
        System.out.print(" ");
    }
}
