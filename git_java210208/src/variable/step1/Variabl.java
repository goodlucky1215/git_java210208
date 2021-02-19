package variable.step1;

public class Variabl {
	//선언부
	
	//메소드 선언
	void methodA(int x) {
		
	}
	double methodB(int x) {//x는 지역 밖에서는 사용불가
		return 3.14;
	}
	//메인메소드  - exe파일로 만들 수 있어요.
	/*
	 * @return void이다. -비어있다. - 돌려 받을 수 있는 값이 없다. - 이것 때문에 에러가 발생 할 수도 있다.
	 * @param arge
	 */
	public static void main(String[] args) {
		//System:나의 컴퓨터, out속성:출력장치(하드웨어-모니터, 프린터....), print():이건 illegal, print(int i):(o)
		System.out.print(5); //줄바꿈이 안됨, 메소드를 호출할 수 있니? 너는? 주소번지.methodA();
		//메소드 선언할 때는 좌중괄호 우중괄호를 사용하고...
		//메소드 호출할때는 ;
		//API, XXX.jar, 이 안(클래스[소스가 만들어졌으니까 구체적이다]안에 객체[결정되지 않았다.Sonata.java, class Sonata{}])에 있는 것을 꺼내쓴다.
		//print메소드는 여러개이다. 같은 이름의 메소드를 여러개 만들 수도 있다.
		//SELECT 이름 FROM 회원 집합
		//WHERE 아이디='test'
		//AND 비번='123'
		//System.out.print(); //줄바꿈이 안됨. - 반환값이 없으니깐 에러인거야? 출력결과물
		Variabl v= new Variabl();
		System.out.print(v.methodB(1));
		//System.out.print(v.methodA(1));		
		System.out.print(1+" "+1); 
		System.out.print(10+10); 
		System.out.print(10+"10"); 
		System.out.print("    "); 
		System.out.println(); //줄바꿈이  추가된 메소드.

	}

}