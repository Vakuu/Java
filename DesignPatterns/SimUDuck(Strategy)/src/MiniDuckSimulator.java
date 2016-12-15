import Ducks.Duck;
import Ducks.RubberDuck;
import Ducks.WoodenDuck;


public class MiniDuckSimulator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Duck rubberDuck = new RubberDuck();
		Duck woodenDuck = new WoodenDuck();
		
		System.out.println("Rubber duck performance:");
		rubberDuck.performFly();
		rubberDuck.performQuack();
		
		System.out.println("\nWooden duck performance:");
		woodenDuck.performFly();
		woodenDuck.performQuack();
		
		
	}

}
