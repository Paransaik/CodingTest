import java.util.*;
public class BOJ_B4_1264_모음의개수 {
    public static void main(String[] a) {
        Scanner sc=new Scanner(System.in);
        String s;
        while (!"#".equals(s=sc.nextLine())) {
            System.out.println(s.replaceAll("(?i)[^aeiou]","").length());
        }
    }
}