package observables;

//import intf.Observable;
//import intf.Observer;
import java.util.Observable;
import java.util.Observer;

import java.util.ArrayList;

public class WeatherData extends Observable {
	// private ArrayList<Observer> observers;
	public float temperature;
	private float humidity;
	private float pressure;

	public WeatherData() {
		// observers = new ArrayList<Observer>();
	}

//	public void regObs(Observer o) {
//		observers.add(o);
//
//	}
//
//	public void remObs(Observer o) {
//		int i = observers.indexOf(o);
//		if (i > 0) {
//			observers.remove(i);
//		}
//
//	}

//	public void notifyObs() {
////		for (Observer observer : observers) {
////			observer.update(this, null);
////		}
//		
//	}

	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	}

	public void setMeasurements(float temperature, float humidity,
			float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

	public float getTemperature() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}

}
