package examples.oopAdvanced_2.subjects;

public class Robot implements Subject {

    public static int numbers;

    private int maximumRunDistance = 1000;
    private int traveledDistance = 0;
    boolean isRunnableDistance = true;

    private int jumpHeight = 6;
    private int jumpMaxQuantity = 6;
    boolean isJumped = true;

    public Robot(){
        numbers++;
    }

    @Override
    public boolean run(int distance) {
        traveledDistance = traveledDistance + distance;
        isRunnableDistance = traveledDistance <= maximumRunDistance;
        if(isRunnableDistance){
            System.out.println("Robot can run distance. TraveledDistance = " + traveledDistance);
        } else {
            System.out.println("Robot cannot run this distance");
        }
        return isRunnableDistance;
    }

    @Override
    public boolean jump(int height) {
        boolean isJumpedThisHeight = (height <=jumpHeight);
        boolean isJumpedThisTime = jumpMaxQuantity > 0;

        isJumped = isJumpedThisHeight && isJumpedThisTime && isJumped;
        if ( isJumped ) {
            jumpMaxQuantity--;
            System.out.println("Robot can jump this height");
        } else {
            if (!isJumpedThisTime) {
                System.out.println("Too much jumps");
            }if (!isJumpedThisHeight) {
                System.out.println("Robot cannot jump this height");
            }else {
                System.out.println("It's impossible to jump, early was a wall or to much jumps.");
            }
            isJumped = false;
        }
        return isJumped;
    }

    public static void printNumbersOfInstance() {
        String className = "Robots";
        System.out.println("Numbers of " + className + " " + numbers);
    }

    @Override
    public String toString() {
        return "Robot";
    }
}
