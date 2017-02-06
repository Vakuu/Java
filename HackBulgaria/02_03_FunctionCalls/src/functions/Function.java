package functions;

public abstract class Function {

	String description = "Unknown Function";
	int value=0;
	
	public String getDescription() {
		return description;
	}
	
	public abstract int res();
}
