package design.duck;

public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("조용~~(눈물..나도 말하고 싶어..)");

	}

}
