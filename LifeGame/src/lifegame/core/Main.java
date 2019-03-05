package lifegame.core;

import lifegame.graphic.*;

public class Main {
	
	public static Boolean[][] afterProcess = new Boolean[10][10];
	public static Box[][] gameBoard = new Box[10][10];
	public static Window fenetre;
	
	public static void main(String[] args) throws InterruptedException {	
		

		createBoard();
		fenetre = new Window();
		WinPop fenetrePop = new WinPop();
		gameBoard[2][4].full = true;
		gameBoard[3][4].full = true;
		gameBoard[4][4].full = true;
		turn();
		
		
		
	}
	
	public static void turn() {
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
		fenetre.setButtons(gameBoard);
	}
	
	
	
	public static int howMuchCaseIsNear(int x, int y) {
		int count = 0;
		for(int i = -1; i < 2; i++ ) { // => Y
			for(int j = -1; j < 2 ; j++) { // => X
				if((y + i >= 0 && y + i < 10) && (x + j >= 0 && x + j < 10) && (j != 0 || i !=0)) {
					if(gameBoard[y + i][x + j].full) {
						count += 1;
					}					
				}
			}
		}
		//System.out.println(count);
		return count;
		
	}

	public static void changeBoxState(String place) {

    	System.out.println("Pos : " + place);
    	String[] test = place.split("_");
    	int x = Integer.parseInt(test[0]);
    	int y = Integer.parseInt(test[1]);
    	
		if(gameBoard[x][y].full != true) {
			gameBoard[x][y].full = true;
		}
		fenetre.setButtons(gameBoard);
		
	}
	
	private static void createBoard() {
		
		for(int i = 0; i < 10 ; i++) {
			for(int j = 0 ; j < 10 ; j++) {
				gameBoard[i][j] = new Box();
			}
		}
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
