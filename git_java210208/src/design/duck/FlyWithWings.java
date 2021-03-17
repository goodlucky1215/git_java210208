package design.duck;
/*
 * 단독으로는 인스턴스화 할 수 없다.
 * 반드시 구현체 클래스가 있어야 함.
 * 메서드 오버라이딩을 꼭 해야 함.
 * 만일 하지 않으면 너도 인터페이스가 되어야 함.
 */
public class FlyWithWings implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("날아올라~저 하늘~~오리날다~~~");

	}

}
