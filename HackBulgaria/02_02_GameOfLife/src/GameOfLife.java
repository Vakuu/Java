import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GameOfLife {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x, y;
		String[] dimentions = new String[2];

		System.out.println("setting and loading a 'Game Of Life' world.");
		System.out.println("Give dimentions of the world (example 20x20):");

		dimentions = scanner.next().split("x");

		x = Integer.parseInt(dimentions[0]);
		y = Integer.parseInt(dimentions[1]);

		int[][] initialWorldMap = new int[x][y];

		try {

			System.out.println(
					"There are ini files for the famous objects in Game Of Life. (Boat, Beacon, Blinker, Glider, GliderGun, Heart, Pulsar");
			System.out.println("On the next line enter how many objects you want to load on the map:");
			int numbOfObjects = scanner.nextInt();
			System.out.println(
					"On each of the next line give an object and starting point coordinates (example Pulsar-5x5):");
			String[] nameAndStartCoords = new String[2];
			String[] startCoords = new String[2];
			String[] cellCoords = new String[2];
			int startX, startY, xCoord, yCoord;

			for (int i = 0; i < numbOfObjects; i++) {
				System.out.println("Object " + i + 1 + " of " + numbOfObjects + ":");
				nameAndStartCoords = scanner.next().split("-");
				startCoords = nameAndStartCoords[1].split("x");
				startX = Integer.parseInt(startCoords[0]);
				startY = Integer.parseInt(startCoords[1]);
				String path = GameOfLife.class.getProtectionDomain().getCodeSource().getLocation().getPath()
						+ nameAndStartCoords[0] + ".ini";
				String[] fileLines = Listify.readToArray(path.substring(1));
				
				for (int fl = 0; fl < fileLines.length; fl++) {
					if ((fileLines[i].trim().indexOf('x') > -1)) {
						cellCoords = fileLines[fl].split("x");
						xCoord = Integer.parseInt(cellCoords[1]);
						yCoord = Integer.parseInt(cellCoords[0]);
						initialWorldMap[(startX + xCoord) % x][(startY + yCoord) % y] = 1;
					} else {
						continue;
					}
				}
			}
		} finally {
			scanner.close();
		}

		String full = "\u25A0";// 25AA
		String empty = "\u25A1";// 25AB
		int[][] currWorldMap = new int[x][y];
		int[][] nextWorldMap = new int[x][y];

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				currWorldMap[i][j] = initialWorldMap[i][j];
				nextWorldMap[i][j] = initialWorldMap[i][j];
			}
		}

		while (initialWorldMap.length > 0) {
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					if (currWorldMap[i][j] == 1) {
						System.out.print(full);
					} else {
						System.out.print(empty);
					}
					if (j == y - 1)
						System.out.print("\n");
				}
			}

			int count;
			for (int k = 0; k < x; k++) {
				for (int l = 0; l < y; l++) {
					count = 0;

					for (int i = -1; i <= 1; i += 1) {
						for (int j = -1; j <= 1; j += 1) {
							int neighborX = (k + i + x) % x;
							int neighborY = (l + j + y) % y;

							if (neighborX != k || neighborY != l) {
								if (currWorldMap[neighborX][neighborY] == 1) {
									count++;
								}
							}
						}
					}

					if (currWorldMap[k][l] == 1) {
						if ((count < 2) || (count > 3)) {
							nextWorldMap[k][l] = 0;
						}
					} else {
						if (count == 3) {
							nextWorldMap[k][l] = 1;
						}
					}
				}
			}

			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					currWorldMap[i][j] = nextWorldMap[i][j];
				}
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}

	public static class Listify {
		public static String[] readToArray(String filename) {
			List<String> contents = new LinkedList<>();
			try {
				contents = read(filename);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			return contents.toArray(new String[contents.size()]);
		}

		private static List<String> read(String filename) throws java.io.IOException {
			return Files.readAllLines(Paths.get(filename));
		}
	}
}