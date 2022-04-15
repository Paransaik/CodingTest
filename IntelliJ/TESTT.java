import java.util.*;

public class TESTT {

    public static final int MAX = 100;

    public static void main(String[] args) {
        System.out.println(20&(1<<4));
        System.out.println(20&(1<<2));


//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        p1(a);
//        System.out.println(p1R(a));
//        p2(a);
    }

    public static void p1(int a) {
        int[] memo = new int[MAX];
        memo[1] = 2;
        memo[2] = 3;
        for (int i = 3; i < MAX; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        System.out.println(memo[a]);
    }

    public static int p1R(int a) {
        if (a < 1) return 0;
        if (a == 1) return 2;
        if (a == 2) return 3;
        return p1R(a - 1) + p1R(a - 2);
    }

    public static void p2(int a) {
        int[] memo = new int[MAX];
        memo[1] = 2;
        memo[2] = 5;
        for (int i = 3; i < MAX; i++) {
            memo[i] = 2 * memo[i - 1] + memo[i - 2];
        }
        System.out.println(memo[a]);
    }
}






































