package functions;

public final class F2 extends Function {

	public F2(int x) {
		description = "times 2";
		value=x*2;
	}
	
	public int res() {
		return this.value;
	}
}
