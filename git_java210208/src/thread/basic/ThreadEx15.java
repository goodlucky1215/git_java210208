package thread.basic;

import oracle.security.o3logon.a;

public class ThreadEx15 {

	public static void main(String[] args) {
		A15 th1 = new A15();
		B15 th2 = new B15();
		
		th1.();
		th2.();
		try {
			th1. (5000);
			Thread. (5000);
	//sleep(): 작업 흐름 대기시간 설정한다. 5초동안 대기시간 갖은 후에 다음 문자의 실행 흐름을 이어간다.
		} catch(InterruptedException e) {}
		System.out.println("<<main 종료>>");
	}

}
