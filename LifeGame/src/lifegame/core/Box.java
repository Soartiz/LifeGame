package lifegame.core;

public class Box {

	private boolean full = false;
	private boolean fullAfterProcess;
	
	public void process(int x, int y) {
		
		int count = Main.howMuchCaseIsNear(x, y);
		if(count == 3 && full == false) {
			fullAfterProcess = true;
		}
		else if((count >= 4 || count <= 1 ) && full == true) {
			fullAfterProcess = false;
		}
		else if((count == 2 || count == 3) && full == true) {
			fullAfterProcess = true;
		}
	}
	
	public void setFull(boolean _full) {
		full = _full;
	}
	public boolean getFull() {
		return full;
	}
	public void setFullAfterProcess(boolean _full) {
		fullAfterProcess = _full;
	}
	public boolean getFullAfterProcess() {
		return fullAfterProcess;
	}
	
	public String toString() {
		if(full) {
			return " X ";
		}
		return "   ";
	}
}
