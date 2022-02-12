package Eclipse;

public class Tip {
//	@리스트 합치는 법
//	리스트.stream().mapToInt(Integer::intValue).sum();
//	lst.stream().mapToInt(i -> i).sum();
	
//	@배열 합치는 법
//	IntStream.of(배열).sum();
//	Arrays.stream().sum()

//  @Collections 함수들
//	Collections.reverse(list);
//  Collections.max(list);
//	Collections.min(list);

//	@자바 String 숫자를 자릿수별 int 배열로 분할
//	String str = "12345";
//  int[] digits = Stream.of(str.split("")).mapToInt(Integer::parseInt).toArray();
//  System.out.println( Arrays.toString(digits) );

//	@문자열 -> char
//	str.charToArray();
	
//	@자바 string -> char
//	str.charAt(인덱스);
//	str.toCharArray();
	
//	@자바 char -> string
//	String str = String.valueOf(c); // 실행속도가 "" 보다 15배 빠름
//	String str = Character.toString(c);
//	String str = ch + "";
	
	
////	StringBuileder 주요 메소드	
//	StringBuilder append(String s) : StringBuilder 뒤에 값을 붙임
//	StringBuilder delete(int start , int end) : 특정 인덱스부터 인덱스까지를 삭제
//	StringBuilder insert(int offet, any primitive of a char[]) : 문자를 삽입함
//	StringBuilder replace(int start , int end , String s) : 일부를 String 객체로 치환
//	StringBuilder reverse() : 순서를 뒤집음
//	StringBuilder setCharAt(int index , char ch) : 주어진 문자를 치환
//	StringBuilder indexOf(String s) : 값이 어느 인덱스에 들어있는지 확인
//	StringBuilder subString(int start, int end) : start와 end 사이의 값을 잘라옴.
	

//char input[] = list.charToArray()

//Char > int
//char myChar = '5';
//int myInt = Character.getNumericValue(myChar);        
//System.out.println("Value after conversion to int: " + myInt);
	
//	한줄에 공백 없이 문자열을 배열로 받기
//	int N = sc.nextInt();
//	char[][] map = new char[N][N];
//	for (int i = 0; i < N; i++) {
//	    String line = sc.next();
//	    for (int j = 0; j < N; j++) {
//	        map[i][j] = line.charAt(j);
//	    }
//	}
}
