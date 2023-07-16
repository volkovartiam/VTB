package examples.exceptions_three_3;

public class MyArrayDataException extends Exception{


    public MyArrayDataException(int row, int column) {
        System.out.println("Not valid data in arrays. " +
                           "In row = " + row + ", column = " + column);
    }

}
