package javainterview.chapter6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public interface StrategyLogger {
    void write(String message);
}

class ConsoleLogging implements StrategyLogger{

    @Override
    public void write(String message) {
        System.out.println(message);
    }
}

class FileLogging implements StrategyLogger{

    private File toWrite;

    public FileLogging(File toWrite){
        this.toWrite = toWrite;
    }

    @Override
    public void write(String message) {
        try{
            FileWriter fileWriter = new FileWriter(toWrite);
            fileWriter.write(message);
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
