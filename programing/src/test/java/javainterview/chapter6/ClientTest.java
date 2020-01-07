package javainterview.chapter6;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ClientTest {

    @Test
    public void consoleLog() throws Exception{
        Client client = new Client(new ConsoleLogging());
        client.doWork(12);
        client.doWork(11);
    }

    @Test
    public void fileLog() throws Exception{
        File tempFile = File.createTempFile("test", "log");
        Client client = new Client(new FileLogging(tempFile));
        client.doWork(22);
        client.doWork(23);
        client.doWork(25);

        BufferedReader reader = new BufferedReader(new FileReader(tempFile));
        assertThat(reader.readLine()).isEqualTo("Count is: 22");
    }

    @Test
    public void LogWithMock() throws Exception{
        StrategyLogger mockLogger = mock(StrategyLogger.class);
        Client client = new Client(mockLogger);
        client.doWork(1);
        client.doWork(2);
        verify(mockLogger).write("Count is: 2");
    }

}