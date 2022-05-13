import java.util.Scanner;

public class BOJ_B3_11966_2의제곱인가IMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int binary = sc.nextInt();
        boolean flag = false;
        for (int i = 0; i < 32; i++) {
            if(binary == (1 << i)){
                flag = true;
                break;
            }
        }
        if(flag) System.out.println(1);
        else System.out.println(0);
    }
}
