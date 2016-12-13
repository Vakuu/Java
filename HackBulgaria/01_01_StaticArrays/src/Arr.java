
public class Arr {

	public static String toString(int[] a) {
		String res = "" + a[0];
		if (a.length > 1) {
			for (int i = 1; i < a.length; i++) {
				res += ", " + a[i];
			}
		}

		return res;
	}

	public static void sort(int[] a) {
		int tmp = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = a.length - 1; j > i - 1; j--) {
				if (a[i] > a[j]) {
					tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		}
	}

	public static String reverse(int[] a) {
		String res = "";
		for (int i = a.length - 1; i >= 0; i--) {
			res += a[i] + ", ";
		}
		return res.substring(0, res.length() - 2);
	}

	public static String join(int[] a, String glue) {
		String res = "";
		for (int i = 0; i < a.length; i++) {
			res += a[i] + " -> ";
		}
		return res.substring(0, res.length() - 4);
	}

	public static long sum(int[] a) {
		long res = 0;
		for (int i = 0; i < a.length; i++) {
			res += a[i];
		}
		return res;
	}

	public static int[] range(int a, int b) {
		int[] res = new int[b - a + 1];
		for (int i = a; i <= b; i++) {
			res[i - a] = i;
		}
		return res;
	}

	public static String filterOdd(int[] a) {
		String res = "";
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 != 0) {
				res += a[i] + ", ";
			}
		}
		return res.substring(0, res.length() - 2);
	}

	public static void main(String[] args) {
		int[] a = { 10, 20, -50, 80, 70, 66, -365 };

		System.out.println("Print the array to string:");
		System.out.println(Arr.toString(a));

		System.out.println("Sort the array a itself and print it sorted:");
		Arr.sort(a);
		System.out.println(Arr.toString(a));

		System.out.println("Print the reverse of the sorted array");
		System.out.println(Arr.reverse(a));

		System.out.println("Output each element in a with \"->\" between them");
		System.out.println(Arr.join(a, "->"));

		System.out.println("Output the sum");
		System.out.println(Arr.sum(a));

		System.out.println("Output array with elements from 1 to 10");
		System.out.println(Arr.toString(Arr.range(1, 10)));

		System.out.println("Print only the odd numbers");
		System.out.println(Arr.filterOdd(a));
	}
}