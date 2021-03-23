package book.ch8;

public class Sub extends Super {
	public Sub() {
		System.out.println("super() 호출 성공");
	}
	public Sub(String title) {
		System.out.println("Sub(String) 호출 성공");
		this.title = title;
	}
	@Override
	public void methodA(){
		System.out.println("sub 슈퍼 A호출 성공");
	}
	/* 부모가 가지고 있는 메소드의 형태가 아니면 오버라이드가 아니다.
	@Override
	public void methodA(int x){
		System.out.println("sub 슈퍼 A호출(int) 성공");
	}
	*/
	public void methodB(){
		System.out.println("sub 슈퍼 B호출 성공");
	}
}
