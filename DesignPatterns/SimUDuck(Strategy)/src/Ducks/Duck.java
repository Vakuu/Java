package Ducks;

import intf.FlyBehavior;
import intf.QuackBehavior;

public abstract class Duck {

	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;

	public void swim() {
		System.out.println("I swim!");
	}

	public void display() {
		System.out.println("I look pretty!");
	}

	public void performQuack() {
		quackBehavior.quack();
	}

	public void performFly() {
		flyBehavior.fly();
	}
}