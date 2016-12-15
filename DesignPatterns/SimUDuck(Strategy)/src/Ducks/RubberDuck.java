package Ducks;

import impl.FlyNoWay;
import impl.Squeak;

public class RubberDuck extends Duck{
	public RubberDuck(){
		flyBehavior = new FlyNoWay();
		quackBehavior = new Squeak();
	}
}
