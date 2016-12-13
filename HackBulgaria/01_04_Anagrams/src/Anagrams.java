import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {

	public static boolean areAnagrams(String a, String b) {

		char[] aToCharArray = a.toCharArray();
		char[] bToCharArray = b.toCharArray();

		Arrays.sort(aToCharArray);
		Arrays.sort(bToCharArray);

		if (Arrays.equals(aToCharArray, bToCharArray)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			String a = scanner.next().toLowerCase();
			String b = scanner.next().toLowerCase();

			if (areAnagrams(a, b)) {
				System.out.println("ANAGRAMS");
			} else {
				System.out.println("NOT ANAGRAMS");
			}
		} finally {
			scanner.close();
		}
	}
}
