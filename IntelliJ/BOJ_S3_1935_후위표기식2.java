import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Stack;

public class BOJ_S3_1935_후위표기식2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        int num = Integer.parseInt(br.readLine());
        int[] alpha = new int[num];
        String[] oper = br.readLine().split("");
        for (int i = 0; i < num; i++) {
            alpha[i] = Integer.parseInt(br.readLine());
        }

        for (String s : oper) {
            switch (s) {
                case "+":
                    stack.push(String.valueOf(Double.parseDouble(stack.pop()) + Double.parseDouble(stack.pop())));
                    break;
                case "-":
                    BigDecimal bg2 = BigDecimal.valueOf(Double.parseDouble(stack.pop()));
                    BigDecimal bg1 = BigDecimal.valueOf(Double.parseDouble(stack.pop()));
                    stack.push(String.valueOf(bg1.subtract(bg2)));
                    break;
                case "*":
                    stack.push(String.valueOf(Double.parseDouble(stack.pop()) * Double.parseDouble(stack.pop())));
                    break;
                case "/":
                    double d2 = Double.parseDouble(stack.pop());
                    double d1 = Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(d1 / d2));
                    break;
                default:
                    stack.push(String.valueOf(alpha[s.charAt(0) - 'A']));
                    break;
            }
        }
        System.out.printf("%.2f", Double.parseDouble(stack.pop()));
    }
}
