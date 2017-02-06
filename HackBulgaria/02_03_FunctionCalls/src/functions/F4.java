package functions;

public final class F4 extends Function {

	public F4(int x) {
		description = "f1 times 2";
		F1 a= new F1(x);
		value=a.res()*2;
	}
	
	public int res() {
		return this.value;
	}

}
