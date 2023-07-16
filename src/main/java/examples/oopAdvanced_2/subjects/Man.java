package examples.oopAdvanced_2.subjects;

public class Man implements Subject {

    public static int numbers;

    private int maximumRunDistance = 120;
    private int traveledDistance = 0;
    boolean isRunnableDistance = true;

    private int jumpHeight = 3;
    private int jumpMaxQuantity = 5;
    boolean isJumped = true;

    public Man(){
        numbers++;
    }

    @Override
    public boolean run(int distance) {
        traveledDistance = traveledDistance + distance;
        isRunnableDistance = traveledDistance <= maximumRunDistance;
        if(isRunnableDistance){
            System.out.println("Man can run distance. TraveledDistance = " + traveledDistance);
        } else {
            System.out.println("Man cannot run this distance");
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
            System.out.println("Man can jump this height");
        } else {
            if (!isJumpedThisTime) {
                System.out.println("Too much jumps");
            }if (!isJumpedThisHeight) {
                System.out.println("Man cannot jump this height");
            }else {
                System.out.println("It's impossible to jump, early was a wall or to much jumps.");
            }
            isJumped = false;
        }
        return isJumped;
    }

    public static void printNumbersOfInstance() {
        String className = "Mans";
        System.out.println("Numbers of " + className + " " + numbers);
    }

    @Override
    public String toString() {
        return "Man";
    }
}
