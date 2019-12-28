package cracking.oop.cardgroup;

public class BlackJackCard extends Card{

    public BlackJackCard(int facevalue, Type type) {
        super(facevalue, type);
    }


    @Override
    public int value() {
        if (isAce()) {
            return 1;
        }else if(isFaceCard()){
            return 10;
        }

        return facevalue;
    }

    public int minValue(){
        if (isAce()){
            return 1;
        }

        return value();
    }

    public int maxValue(){
        if (isAce()){
            return 11;
        }

        return value();
    }

    public boolean isAce(){
        return facevalue == 1;
    }

    public boolean isFaceCard(){
        return facevalue >= 11 && facevalue <= 13;
    }
}
