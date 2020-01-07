package javainterview.chapter6;

public class Client {
    private StrategyLogger logger;

    public Client(StrategyLogger logger) {
        this.logger = logger;
    }

    public void doWork(int count){
        if (count % 2 ==0){
            logger.write("Count is: " + count);
        }
    }
}
