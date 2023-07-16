package examples.exceptions_three_3;

public class MyArraySizeException extends Exception{

    String message = "Not valid array size";

    public MyArraySizeException() {
        System.out.println(message);
    }

}
