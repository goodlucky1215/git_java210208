package design.duck;

public class RubberDuck extends Duck {
	public RubberDuck() {
		flyBehavior   = new FlyNoWay();
		quackBehavior = new Squeak();
	}
	@Override
	public void display() {
		System.out.println("나는 고무고무 열매를 먹은 고무 오리~~!!");

	}

}
