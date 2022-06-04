import java.util.Scanner;

public class BOJ_B2_1681_줄세우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxCnt = sc.nextInt();
        int not = sc.nextInt();

        int num = 1, cnt = 0, ans = 0;
        while (maxCnt != cnt){
            if(!Integer.toString(num).contains(Integer.toString(not))){
                cnt++;
                ans = num;
            }
            num++;
        }
        System.out.println(ans);
    }
}
