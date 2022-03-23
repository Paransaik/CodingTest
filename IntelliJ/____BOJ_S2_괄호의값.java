import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class ____BOJ_S2_괄호의값 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int ans = 0, allSum = 0, sum = 0;
	
	public static void main(String[] args) throws Exception {
		Stack<Character> stk = new Stack<>();
		
		char[] str;
		str = br.readLine().toCharArray();
		for (int i = 0; i < str.length; i++) {
			if (stk.isEmpty()) ans += allSum;
			switch (str[i]){
			case '(': case '[': stk.push(str[i]); break;
			case ')': 
				if ((!stk.isEmpty()) && stk.pop() == '(') {
					if (allSum == 0) {
						sum += 2;
					}
					 
					break;
				}
				
			}
		}
		
		int flag = 1;
		int dummy = Integer.parseInt(br.readLine());
		String[] bracket = br.readLine().split("");

		for (String s : bracket) {
			switch (s) {
//			case "(": case "{": case "[": case "<": stack.push(s); break;
//			case ")": if (stack.empty() || !stack.pop().​contentEquals("(")) flag = 0; break;
//			case "]": if (stack.empty() || !stack.pop().contentEquals("[")) flag = 0; break;
//			case "}": if (stack.empty() || !stack.pop().contentEquals("{")) flag = 0; break;
//			case ">": if (stack.empty() || !stack.pop().contentEquals("<")) flag = 0; break;
			}
		}
	}

}
