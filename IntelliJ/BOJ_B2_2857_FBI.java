import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_B2_2857_FBI {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
            if(br.readLine().contains("FBI")){
                flag = true;
                System.out.print((i + 1)+ " ");
            }
        }
        if(!(flag)){
            System.out.println("HE GOT AWAY!");
        }
    }
}
