package intf;

public interface Observable {
	public void regObs(Observer o);
	public void remObs(Observer o);
	public void notifyObs();
}
