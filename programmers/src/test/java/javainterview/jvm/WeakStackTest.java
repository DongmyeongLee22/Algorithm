package javainterview.jvm;

import org.junit.Test;

import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class WeakStackTest {

    @Test
    public void executorEx() throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        Runnable runnable = new InfiniteThreadNamePrinter();

        System.out.println("Main Thread: " + Thread.currentThread().getName());
        executor.execute(runnable);

    }

    private static class InfiniteThreadNamePrinter implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("Run from thread: " + Thread.currentThread().getName());
            }
        }
    }

    @Test
    public void waitToComplete() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        executorService.execute(new FiniteThreadNamePrinterLatch(countDownLatch));
        countDownLatch.await(5, TimeUnit.SECONDS);
    }

    private static class FiniteThreadNamePrinterLatch implements Runnable {
        CountDownLatch latch;

        private FiniteThreadNamePrinterLatch(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            for (int i = 0; i < 25; i++) {
                System.out.println("Run From thread: " +
                        Thread.currentThread().getName());
            }
            latch.countDown();
        }
    }

@Test
public void sameThread() throws Exception{
    Executor executor = new Executor() {
        @Override
        public void execute(Runnable command) {
            command.run();
        }
    };

    System.out.println("Main thread: " +
            Thread.currentThread().getName());

    executor.execute(new FiniteThreadName());

}

private static class FiniteThreadName implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 25; i++) {
            System.out.println("Run From thread: " +
                    Thread.currentThread().getName());
        }
    }
}

    @Test
    public void asd() throws Exception {

        WeakStack<ValueContainer> stack = new WeakStack<>();

        ValueContainer expected = new ValueContainer("Vlue for the stack");
        stack.push(new ValueContainer("Vlue for the stack"));

        ValueContainer peekedValue = stack.peek();
        assertEquals(expected, peekedValue);
        assertEquals(expected, stack.peek());
        peekedValue = null;
        System.gc();
        assertNull(stack.peek());
    }

    public class ValueContainer {

        private final String value;


        public ValueContainer(String value) {
            this.value = value;
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.printf("finalizing for [%s]%n", toString());
        }
    }


}