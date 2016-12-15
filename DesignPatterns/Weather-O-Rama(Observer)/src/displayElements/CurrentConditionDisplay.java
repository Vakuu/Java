package displayElements;

import intf.DisplayElement;
//import intf.Observable;
//import intf.Observer;
import observables.WeatherData;
import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;
	//private Observable weatherData;
	Observable observable;

	public CurrentConditionDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	public void update(Observable obs, Object arg) {
		if (obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)obs;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
		
		//display();
//	public void update(float temperature, float humidity, float pressure) {
//		this.temperature = temperature;
//		this.humidity = humidity;
//		display();
//
	}

	public void display() {
		System.out.println("Current conditions: " + temperature
				+ "F degrees and " + humidity + "% humidity.");

	}
}
