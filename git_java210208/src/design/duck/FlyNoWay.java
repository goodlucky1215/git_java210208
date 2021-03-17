package design.duck;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("못 난다긔...날고 싶다긔....");

	}

}
