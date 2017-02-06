
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import functions.F1;
import functions.F2;
import functions.F3;
import functions.F4;

public class Parser {

	public static int evaluate(String formula, int x) {
		int res = x;
		String[] ComposElements = formula.split("\\.");
		List<String> itemList = Arrays.asList(ComposElements);
		Collections.reverse(itemList);
		for (String element : itemList) {
			switch (element) {
			case "f1":
				res = new F1(res).res();
				break;
			case "f2":
				res = new F2(res).res();
				break;
			case "f3":
				res = new F3(res).res();
				break;
			case "f4":
				res = new F4(res).res();
				break;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();
		int x = scanner.nextInt();
		try {
			System.out.println(evaluate(input, x));
		} finally {
			scanner.close();
		}

	}

}