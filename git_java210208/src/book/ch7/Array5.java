package book.ch7;

public class Array5 {
	void methodB(boolean isOk[]) {
		//System.out.println(isOk[3]); 	//NullPointerException
		System.out.println(isOk.length);//NullPointerException
	}
	/*
	 * 11-12(선언만-초기화 안됨-방크기가 결정되지 않음.isOk.length:NullPointerException)
	 */
	public static void main(String[] args) {
		boolean isOk[] = null; //선언만 하였다. 크기가 결정되지 않았다.
		Array5 a5 = new Array5();
		a5.methodB(isOk);
	}

}
/*
 * 변수는 한번에 하나값만 담을 수 있다. - 장애
 * 배열은 한번에 여러개 값을 담을 수 있다.
 * 그러나 다른 타입은 담을 수 없고, -객체 배열
 * 끼워넣기가 불가하다 - 크기를 조절할 수 없다. - ArrayList사용하면 문제가 해결됨
 * 
 * 
 * 자료구조(List계열, Map계열, Set계열) - 늘었다 줄었다, 끼워넣기 가능. 회원탈퇴, 신입사원 등록 등등..
 * FIFO
 * LIFO
 * LILO......
 * 
 * 세션과 쿠키
 * 오라클 서버 - 영원하다
 */
//배열 사용하면서 방크기와 실제 입력한 값, 
//사용하는 값의 갯수가 다를경우 문법적으론 정상이지만 자바오류가 발생하는데 이걸 방지할 수 있는 팁이 있나요
