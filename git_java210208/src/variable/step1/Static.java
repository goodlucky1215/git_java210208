package variable.step1;

public class Static {
	/*
	 * non-static타입은 static영역에서 접근 불가, 호출 안돼, 사용 못 해
	 */
	static void avg() { //사용자 정의 메소드 입니다.
		System.out.println("avg호출 성공");
	}
	public static void main(String[] args) {
		//if(args==null | args.length==0) 
		if(args.length==0) {
			//아래 문장은 조건에 따라 한 번도 실행기회를 못 가질 수도 있다.
			System.out.println("입력 ㄱㄱ");
			return;//main메소드 탈출하기
		}
		System.out.println(args[0]+10);//20이 출력되는 코드로 수정하시오.
		int imsi=Integer.parseInt(args[0]);
		System.out.println(imsi+10);//20이 출력 되도록!
		System.out.println("========>"+(int)(imsi+10));//20이 출력 되도록!
		//주소번지 없이도 호출할 수 있는 메소드가 있다. 메소드 이름 앞에 static이 있다면....
		//main메소드는 자바가 제공하는 메소드 입니다. (o)
		//사용자 정의 메소드도 가능하다.
		//내가 필요한 메소드는 문자열을 집어 넣으면 int타입으로 변환하여서 반환해주는 메소드가 필요하다.
		//parseInt()입니다.
		//네이버나 구글링을 해서 위 요구사항을 만족하는 코드를 작성해 보시오.
		Static.avg();
	}

}

//자바에서 제공하는 메소드를 사용했을때 직접 만들어서 쓰는것보다 단점이 있을수도 있나요
//그럴 수도 있지만 대부분은 자바가상머신이 만든 것을 쓰는 것이 안전할 수 있다.(예를 들면 쓰래드보다 더블쓰래드 쓸때...)
