package cracking.oop;

public class Restaurant {

    private static Restaurant instance = null;

    protected Restaurant() {
    }

    public static Restaurant getInstance(){
        if (instance == null){
            return new Restaurant();
        }

        return instance;
    }

}
