public class Polynom {
	private final int[] multipliers;
	//the second data for the degree is the index of the array
	public Polynom(final int[] multipliers) {
		int[] temp = new int[multipliers.length];

		for (int i = 0; i < multipliers.length; i++) {
			temp[i] = multipliers[i];
		}

		this.multipliers = temp;
	}

	public int[] getMultipliers() {
		int[] notByReference = new int[this.multipliers.length];

		for (int i = 0; i < this.multipliers.length; i++) {
			notByReference[i] = this.multipliers[i];
		}

		return notByReference;
	}
}
