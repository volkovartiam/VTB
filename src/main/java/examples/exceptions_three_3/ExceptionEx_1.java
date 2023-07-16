package examples.exceptions_three_3;

public class ExceptionEx_1 {

    public static void main(String[] args) {

        String[][] array = { {"1","1","1","1"},
                             {"2","2","2","2"},
                             {"5","5","5","5"},
                             {"10","10","10","10"}  };
        try {
            print( rowSum(array) );
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }


        //wrongSizeException();
        //wrongSizeException_2();
        wrongSizeException_3();
    }

    private static void wrongSizeException() {
        String[][] array = { {"1","1","1","1","1"},
                {"2","2","2","2"},
                {"5","5","5","5"},
                {"10","10","10","10"}  };
        try {
            print( rowSum(array) );
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    private static void wrongSizeException_2() {
        String[][] array = { {"1","1","1","1"},
                             {"2","2","2"},
                             {"5","5","5","5"},
                             {"10","10","10","10"}  };
        try {
            print( rowSum(array) );
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    private static void wrongSizeException_3() {
        String[][] array = { {"1","1","1","1"},
                {"2","2","2", "2"},
                {"5","5","5","5"},
                {"NOT VALID DATA","10","10","10"}  };
        try {
            print( rowSum(array) );
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }


    public static double[] rowSum(String[][] array ) throws MyArraySizeException, MyArrayDataException{
        double[] sumArray = new double[]{0.0, 0.0, 0.0, 0.0};
        if( array.length != 4) {
            throw new MyArraySizeException();
        }
        for (String[] strings : array) {
            if (strings.length != 4) {
                throw new MyArraySizeException();
            }
        }
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[0].length; j++) {
                try{
                    sumArray[i] += Integer.valueOf(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sumArray;
    }

    private static void print(double[] arr){
        for (double d: arr) {
            System.out.print(d + "  " );
        }
        System.out.println("------------------------------------");
    }

}



