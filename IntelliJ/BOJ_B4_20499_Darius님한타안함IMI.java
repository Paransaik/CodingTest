import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_B4_20499_Darius님한타안함IMI {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split("/");
        if(Integer.parseInt(a[0]) + Integer.parseInt(a[2]) < Integer.parseInt(a[1]) || Integer.parseInt(a[1]) == 0){
            System.out.println("hasu");
        } else System.out.println("gosu");
    }
}