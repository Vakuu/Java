package condiments;

import beverages.Beverage;

public final class Soy extends CondimentDecorator {

Beverage beverage;
	
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}
	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	public double cost() {
		return .15 + beverage.cost();
	}

}
