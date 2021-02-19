package variable.step1;

public class MainMethod {
	/**************************
	 * 
	 * @param args - 파라미터의 타입은 배열입니다.
	 * String args[] = new String[3];
	 * main메소드는 좀 특별한 경우라서 따로 설명하기
	 * 오늘의 학습 목표
	 * main메소드에 대해서 설명할 수 있다.
	 **************************/
	public static void main(String[] args) {
		System.out.println(args[0]);
		//만일 숫자라면 20을 출력한다.
		//만일 문자라면 1010을 출력할거야.
		//int+int=int
		//int+String=붙여쓰기다.
		System.out.println(args[0]+10);
		//너는 타입이 뭐니?
		//타입을 체크할 수 있는 연산자가 있다. - 왜냐하면 자바는 컴파일할 때 타입을 따지니까...
		if(args[0] instanceof String) {
			System.out.println("나는 문자열이야");
		}
		else {
			System.out.println("나는 문자열 아니야!!!!");
		}
		
		if(true) { //else를 실행할 경우는 죽어도 없다. 왜? 상수니까
			System.out.println("나는 참 입니다.");
		}
		else {
			System.out.println("나는 거짓 입니다.");
		}
		
		for(int i=0;i<100;i=i+1) {
			if(true) {
				System.out.println(i+": 나는 참 이야~~");
			}
		}///end of for
	}

}
