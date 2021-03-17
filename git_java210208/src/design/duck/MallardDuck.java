package design.duck;

public class MallardDuck extends Duck {
	public MallardDuck() {
		flyBehavior   = new FlyWithWings();
		quackBehavior = new Quack();
	}
	@Override
	public void display() {
		System.out.println("나는 천둥을 맞은 청둥오리~에헴");

	}

}
