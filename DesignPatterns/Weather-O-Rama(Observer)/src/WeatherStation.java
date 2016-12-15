import observables.WeatherData;
import displayElements.CurrentConditionDisplay;

public class WeatherStation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionDisplay ccd = new CurrentConditionDisplay(weatherData);
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	
	// A test of question from interview

//	public static void aMethod() throws Exception {
//		try {
//			System.out.print("A ");
//			throw new Exception();
//		} finally {
//			System.out.print("F ");
//		}
//
//	}
//
//	public static void main(String[] args) {
//		try {
//			System.out.print("1 ");
//			aMethod();
//			System.out.print("2 ");
//		} catch (Exception e) {
//			System.out.print("E ");
//		}
//		System.out.print("F ");
	}

}
