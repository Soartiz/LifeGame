package lifegame.core;

import lifegame.graphic.*;

public class Main {
	
	public static Box[][] gameBoard;
	public static Window fenetre;
	public static WinPop fenetrePop;
	
	public static int boardSize = 50;
	public static boolean gameState = false;
	
	public static void main(String[] args) throws InterruptedException {	
		
		long last_time = System.nanoTime();
		
		createBoard();
		fenetre = new Window();
		fenetrePop = new WinPop();
		while(true) {
			System.out.println(gameState);
			if(gameState) {
				turn();
				Thread.sleep(500);
			}
		}
		
	}
	
	public static void changeGameState() {
		gameState = !gameState;
		System.out.println(gameState);
		if(gameState) {
			fenetrePop.auto.setLabel("Stop"); 
		}else {
			fenetrePop.auto.setLabel("Auto");			
		}
	}
	
	/*
	 * Turn permet de jouer un instant de vie
	 * */
	public static void turn() {
		for(int i = 0; i < boardSize ; i++) {
			for(int j = 0 ; j < boardSize ; j++) {
				gameBoard[i][j].process(j, i);
			}
		}
		for(int i = 0; i < boardSize ; i++) {
			for(int j = 0 ; j < boardSize ; j++) {
				gameBoard[i][j].full = gameBoard[i][j].fullAfterProcess;
			}
		}
		fenetre.setButtons();
	}

	/*
	 * howMuchCaseIsNear permet de conter le nombre de voisins en vie
	 * */
	public static int howMuchCaseIsNear(int x, int y) {
		int count = 0;
		for(int i = -1; i < 2; i++ ) { // => Y
			for(int j = -1; j < 2 ; j++) { // => X
				if((y + i >= 0 && y + i < boardSize) && (x + j >= 0 && x + j < boardSize) && (j != 0 || i !=0)) {
					if(gameBoard[y + i][x + j].full) {
						// System.out.println((y + i) + "_" + (x + j));
						count += 1;
					}					
				}
			}
		}
		return count;		
	}
	/*
	 * changeBoxState permet de passer une morte à vivante
	 * */
	public static void changeBoxState(String place) {
    	String[] test = place.split("_");
    	int x = Integer.parseInt(test[0]);
    	int y = Integer.parseInt(test[1]);
    	
		gameBoard[x][y].full = !gameBoard[x][y].full;
		fenetre.setButtons();
	}
	
	private static void createBoard() {
		gameBoard = new Box[boardSize][boardSize];
		for(int i = 0; i < boardSize ; i++) {
			for(int j = 0 ; j < boardSize ; j++) {
				gameBoard[i][j] = new Box();
			}
		}
	}
}
