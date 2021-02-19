package book.ch7;
/*
 * 배열은 한 번 선언하면 원소의 수를 조정 불가
 * 끼워넣기가 안됨.
 * 배열의 주번.length명사형 - 원소의 갯수이다. "hello".length() - 문자열 길이이다.
 */
public class Array1 {
	int empnos[] = new int[14];
	public void printArray(int empnos[]) {
		int cnt = 0;
		for(int i=0;i<empnos.length;i++) {
			System.out.println(++cnt+"번방 : "+empnos[i]);
		}
	}
	public static void main(String[] args) {
		int empnos[] = new int[14];
		//저 14개 방에는 어떤 값이 들어있을까요?
		Array1 a1 = new Array1();
		Array1 a2 = new Array1();
		a1.printArray(empnos);
	}

}
