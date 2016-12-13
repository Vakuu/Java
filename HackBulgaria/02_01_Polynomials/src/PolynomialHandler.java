
public class PolynomialHandler {

	public static Polynom add(Polynom a, Polynom b) {
		int[] smaller = a.getMultipliers();
		int[] bigger = b.getMultipliers();

		if (smaller.length > bigger.length) {
			smaller = b.getMultipliers();
			bigger = a.getMultipliers();
		}

		int[] temp = new int[bigger.length];

		for (int i = 0; i < smaller.length; i++) {
			temp[i] = smaller[i] + bigger[i];
		}

		if (bigger.length > smaller.length) {// not equal cause they can be with equal length
			for (int i = smaller.length; i < bigger.length; i++) {
				temp[i] = bigger[i];
			}
		}

		Polynom res = new Polynom(temp);
		return res;
	}

	public static Polynom Sub(Polynom a, Polynom b) {
		return add(a, multplByConst(b, -1));
	}

	public static Polynom multplByConst(Polynom a, int cons) {
		int[] multipliers = a.getMultipliers();

		for (int i = 0; i < multipliers.length; i++) {
			multipliers[i] *= cons;
		}

		return new Polynom(multipliers);
	}

	public static Polynom Mul(Polynom a, Polynom b) {
		int[] aMultipliers = a.getMultipliers();
		int[] bMultipliers = b.getMultipliers();
		int aLength = aMultipliers.length;
		int bLength = bMultipliers.length;

		int[] res = new int[aLength + bLength];

		for (int i = 0; i < aLength; i++) {
			for (int j = 0; j < bLength; j++) {
				res[i + j] += aMultipliers[i] * bMultipliers[j];
			}
		}

		return new Polynom(res);
	}

	public static Polynom derivative(Polynom a) {
		int[] work = a.getMultipliers();
		int[] resMultipliers = new int[work.length - 1];
		for (int i = resMultipliers.length; i > 0; i--) {
			resMultipliers[i - 1] = i * work[i];
		}

		return new Polynom(resMultipliers);
	}

	// Horner's method for computing a polynomial at certain point
	public static int eval(Polynom a, int x) {
		int res = 0;
		int[] multipliers = a.getMultipliers();

		for (int i = multipliers.length - 1; i >= 0; i--)
			res = multipliers[i] + (x * res);

		return res;
	}

	public static Polynom fromString(String strPolynom) {

		String normalizedStrPolynom = "";
		normalizedStrPolynom = strPolynom.replace(" ", "");

		if (strPolynom.equals("")) {
			normalizedStrPolynom = "0";
		} else {
			normalizedStrPolynom = normalizedStrPolynom.replace("-", "+-");
			// so we can split by "+" and negative signs to be preserved for
			// further parsing

			normalizedStrPolynom = normalizedStrPolynom.replace("^", "");
			// so we can split by "x"
		}

		String[] singlePolynoms = normalizedStrPolynom.split("\\+");
		String[] coefAndExponent = new String[2];
		int highestExponent = 0;
		int tempExp = 0;

		for (int i = 0; i < singlePolynoms.length; i++) {
			if (singlePolynoms[i].indexOf('x') < 0) {
				// from 10 -> 10x0 cause x^0=1
				singlePolynoms[i] += "x0";
			}

			if (singlePolynoms[i].substring(0, 1).equals("x")) {
				// from x2 -> 1x2 for parsable int from both sides of x
				singlePolynoms[i] = "1" + singlePolynoms[i];
			}

			if (singlePolynoms[i].substring(singlePolynoms[i].length() - 1, singlePolynoms[i].length()).equals("x")) {
				// from 7x -> 7x1 for parsable int from both sides of x
				singlePolynoms[i] = singlePolynoms[i] + "1";
			}

			coefAndExponent = singlePolynoms[i].split("x");
			tempExp = Integer.parseInt(coefAndExponent[1]);

			if (highestExponent < tempExp) {
				highestExponent = tempExp;
			}
		}
		// now we have found the highest degree and we have completely
		// normalized polynomial
		// from example: x^4 + x^2 + 5x + 4 to-> 1x4;1x2;5x1;4x0;
		// The algorithm till here is for to be able to handle disordered polynomials

		int[] multipliers = new int[highestExponent + 1];

		for (int i = 0; i < singlePolynoms.length; i++) {
			coefAndExponent = singlePolynoms[i].split("x");

			// the next line is with "+=" so it can handle summing same degrees
			// example: 2x^2 + x^4 + x^2 +...-> 1x4;3x2;...
			multipliers[Integer.parseInt(coefAndExponent[1])] += Integer.parseInt(coefAndExponent[0]);
		}

		return new Polynom(multipliers);
	}

	public static String toString(Polynom a) {

		int[] multipliers = a.getMultipliers();
		String strPolynom = "";

		for (int i = multipliers.length - 1; i >= 0; i--) {
			if (multipliers[i] == 0) {
				continue;
			}
			if (multipliers[i] < 0) {
				strPolynom += multipliers[i];
			}
			if (multipliers[i] > 0) {
				strPolynom += "+" + multipliers[i];
			}
			if (i == 1) {
				strPolynom += "x";
			} else if (i > 0) {
				strPolynom += "x^" + i;
			}
		}

		if (!strPolynom.equals("")) {
			if (strPolynom.substring(0, 1).equals("+")) {
				strPolynom = strPolynom.substring(1);
			}
		} else {
			strPolynom = "0";
		}
		return strPolynom;
	}
	
	public static void main(String[] args) {
		Polynom aPolynom = fromString("4x^3 + 3x^2 + 2x + 1");
		Polynom bPolynom = fromString("2x^4 + 3x^2 - 10x + 3");
		int C = 3;

		System.out.println("a = " + toString(aPolynom));
		System.out.println("b = " + toString(bPolynom));
		System.out.println();

		Polynom cPolynom = add(aPolynom, bPolynom);
		System.out.println("Addng a+b\n" + toString(cPolynom));
		System.out.println();

		Polynom fPolynom = multplByConst(bPolynom, C);
		System.out.println("Multiplying by Constant a*C\n" + toString(fPolynom));
		System.out.println();

		Polynom dPolynom = Sub(aPolynom, bPolynom);
		System.out.println("Substracting a-b\n" + toString(dPolynom));
		System.out.println();

		Polynom ePolynom = Mul(aPolynom, bPolynom);
		System.out.println("Multiplying a*b\n" + toString(ePolynom));
		System.out.println();

		Polynom gPolynom = derivative(derivative(aPolynom));
		System.out.println("Derivative:\n" + toString(gPolynom));
		System.out.println();

		System.out.println("evaluating at point of x=" + C + ":\n" + eval(aPolynom, C));
		System.out.println();
	}
}
