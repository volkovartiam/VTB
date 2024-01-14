package examples.nine_9.annotations_part2;

import java.util.ArrayList;

public class Verifiable implements Doc {
    @Max (length = 600)
    int gr = 545;
    Verifiable verBLLLLL;

    @NotNull
    int[] verifiable =  {5, 6, 87};

    @NotNull
    private boolean bool;
    char c = 120;

    @Min (length = 5)
    private byte f = 3;

    @NotNull
    int[] array = null;

    @NotNull
    @NotEmpty
    private ArrayList<Integer> map = new ArrayList<>();

    @Regexp
    String str1 = "abra-kadabra";
    @Regexp
    String str2 = "d12  ddf";


    @Max (length = 500_000)
    @Min (length = 0)
    public double pow(int a, int b) {
        double answer = a;
        if (b > 0) {
            for (int i = 1; i < b; i++) {
                answer = a * answer;
            }
        }
        else if (b < 0) {
            answer = 1;
            if(a != 0){
                for (int i = 0; i < Math.abs(b); i++) {
                    answer = answer * 1/a;;
                }
            }
        }
        return answer;
    }
}
