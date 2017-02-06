package functions;

public final class F1 extends Function {

	public F1(int x) {
		description = "f2 plus f3";
		F2 a= new F2(x);
		F3 b= new F3(x);
		value=a.res()+b.res();
	}
	
	public int res() {
		return this.value;
	}

}
