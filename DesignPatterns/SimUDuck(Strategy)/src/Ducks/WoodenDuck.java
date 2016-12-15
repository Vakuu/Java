package Ducks;

import impl.FlyNoWay;
import impl.MuteQuack;

public class WoodenDuck extends Duck {
	public WoodenDuck(){
		flyBehavior = new FlyNoWay();
		quackBehavior = new MuteQuack();
	}
}
