package lifegame.core;

public class Box {

	public boolean full = false;
	public boolean fullAfterProcess;
	
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

	@Override
	public String toString() {
		if(full) {
			return " X ";
		}
		return "   ";
	}
	
	
	
	
}
