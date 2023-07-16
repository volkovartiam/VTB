package examples.threads_seven_7.executors;

import java.util.concurrent.*;

public class ExecutorsEx_3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future future = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("Callable example");
                return "result from thread";
            }
        });
        System.out.println("future.get() " + future.get() );
        executorService.shutdown();

    }

    private static void print(String string){
        for (int i = 0; i < 1_000; i++) {
            System.out.println(string + "  " + i);
        }
    }

}
