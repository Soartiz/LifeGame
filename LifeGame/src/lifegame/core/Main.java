package lifegame.core;

public class Main {
	
	public static Boolean[][] afterProcess = new Boolean[10][10];
	public static Box[][] gameBoard = new Box[10][10];
	public static  boolean flag = false;
	
	public static void main(String[] args) {
		
		if(!flag) {
			createBoard();
		}
		
		for(int i = 0; i < 10 ; i++) {
			for(int j = 0 ; j < 10 ; j++) {
				gameBoard[i][j].process(j, i);
			}
		}
		for(int i = 0; i < 10 ; i++) {
			for(int j = 0 ; j < 10 ; j++) {
				gameBoard[i][j].full = gameBoard[i][j].fullAfterProcess;
			}
		}
		
		//displayBoard();
		
	}
	
	public static int howMuchCaseIsNear(int x, int y) {
		
		int count = 0;
		System.out.println(count);
		for(int i = -1; i < 1; i++ ) {
			for(int j = -1; j < 1 ; j++) {
				if(i == -1) {if(y != 0) {if(gameBoard[y + i][x + j].full) {count += 1;}}}
			}
		}
		
		return count;
		
	}

	private static void createBoard() {
		
		for(int i = 0; i < 10 ; i++) {
			for(int j = 0 ; j < 10 ; j++) {
				gameBoard[i][j] = new Box();
			}
		}
		flag = true;
	}
	
	private static void displayBoard() {
		
		String s = "   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |";
		
		for(int i = 0; i < 10 ; i++) {
			s += "\n";
			s += " " +  i + " |" ;
			for(int j = 0 ; j < 10 ; j++) {
				s += gameBoard[i][j].toString() + "|"; 
			}
		}
		System.out.println(s);
	}
}
