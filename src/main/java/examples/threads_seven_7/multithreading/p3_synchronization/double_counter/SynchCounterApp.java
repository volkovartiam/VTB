package examples.threads_seven_7.multithreading.p3_synchronization.double_counter;

public class SynchCounterApp {
    public static void main(String[] args) {
        SynchDoubleCounter synchDoubleCounter = new SynchDoubleCounter();
        //NotCorrectSynchDoubleCounter synchDoubleCounter = new NotCorrectSynchDoubleCounter();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchDoubleCounter.inc1();
                System.out.println("sdc.value1: " + synchDoubleCounter.value1());
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchDoubleCounter.dec1();
                System.out.println("sdc.value1: " + synchDoubleCounter.value1());
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchDoubleCounter.inc2();
                System.out.println("sdc.value2: " + synchDoubleCounter.value2());
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchDoubleCounter.dec2();
                System.out.println("sdc.value2: " + synchDoubleCounter.value2());
            }
        }).start();
    }
}
