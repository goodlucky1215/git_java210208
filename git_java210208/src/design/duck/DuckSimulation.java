package design.duck;

public class DuckSimulation{

	public static void main(String[] args) {
		//Duck myDuck1 = new Duck();
		Duck myDuck = new WoodDuck();
		int b = myDuck.i+10;
		myDuck.display();
		myDuck.performFly();
		myDuck.performQuack();
		myDuck.swimming();
		System.out.println();
		Duck herDuck = new RubberDuck();
		herDuck.display();
		herDuck.performFly();
		herDuck.performQuack();
		System.out.println();
		Duck himDuck = new MallardDuck();
		himDuck.display();
		himDuck.performFly();
		himDuck.performQuack();

	}

}
