package examples.threads_seven_7.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsEx_2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future future = executorService.submit( () -> print("1") );
        //future.get();

        System.out.println( future.get() );
        System.out.print("Other task");
        print("5");
    }

    private static void print(String string){
        for (int i = 0; i < 1_000; i++) {
            System.out.println(string + "  " + i);
        }
    }

}
