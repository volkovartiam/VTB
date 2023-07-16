package examples.threads_seven_7.exeutors;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsEx_1 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute( () -> print("1") );
        executorService.execute( () -> print("2") );
        executorService.execute( () -> print("3") );
        executorService.shutdown();

        System.out.print("Other task");
        print("5");
    }

    private static void print(String string){
        for (int i = 0; i < 1_000; i++) {
            System.out.println(string + "  " + i);
        }
    }

}
