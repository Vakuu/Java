import java.util.Scanner;
import java.util.Vector;

public class GPS {

	public static Vector<Integer> getGasStations(int tripDistance, int tankSize, Vector<Integer> gasStations) {

		int currentGasStation = 0;
		int bestNextGasStation = tankSize;
		Vector<Integer> resVector = new Vector<Integer>();

		for (int i = 0; i < gasStations.size(); i++) {
			if (gasStations.get(i) <= bestNextGasStation) {
				currentGasStation = gasStations.get(i);
				if (i == gasStations.size() - 1) {
					resVector.add(currentGasStation);
				}
			} else {
				bestNextGasStation = currentGasStation + tankSize;
				resVector.add(currentGasStation);
				i--;
				if (bestNextGasStation >= tripDistance) {
					break;
				}
			}
		}

		return resVector;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			int tripDistance = scanner.nextInt();
			int tankSize = scanner.nextInt();

			int gasStationsCount = scanner.nextInt();
			Vector<Integer> gasStations = new Vector<Integer>();

			for (int i = 0; i < gasStationsCount; i++) {
				gasStations.add(scanner.nextInt());
			}

			Vector<Integer> result = getGasStations(tripDistance, tankSize, gasStations);

			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i));
			}
		} finally {
			scanner.close();
		}
	}
}
