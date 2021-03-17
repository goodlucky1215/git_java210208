package design.duck;

public class WoodDuck extends Duck {
	public WoodDuck() {
		flyBehavior   = new FlyNoWay();
		quackBehavior = new MuteQuack();
	}
	@Override
	public void display() {
		System.out.println("나는 나무 오리야...피노키오처럼 생명을 얻고 싶어");

	}

}
