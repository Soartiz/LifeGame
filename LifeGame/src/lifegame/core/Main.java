package lifegame.core;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lifegame.graphic.*;

public class Main {
	
	public static Box[][] gameBoard;
	public static Window fenetre;
	public static WinPop fenetrePop;
	
	public static int boardSizeX = 10;
	public static int boardSizeY = 10;
	public static boolean gameState = false;
	public static int sleepTime = 250;

	
	public static void main(String[] args) throws InterruptedException, IOException {	
		
		long last_time = System.nanoTime();
		CreatePlat();
		fenetrePop = new WinPop();
		while(true) {
			turn(false);
			Thread.sleep(sleepTime);
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
	public static void turn(boolean forced) {
		if(gameState || forced) {
			for(int i = 0; i < boardSizeX ; i++) {
				for(int j = 0 ; j < boardSizeY ; j++) {
					gameBoard[i][j].process(j, i);
				}
			}
			for(int i = 0; i < boardSizeX ; i++) {
				for(int j = 0 ; j < boardSizeY ; j++) {
					gameBoard[i][j].setFull(gameBoard[i][j].getFullAfterProcess());
				}
			}
			fenetre.setButtons();
		}
	}

	/*
	 * howMuchCaseIsNear permet de conter le nombre de voisins en vie
	 * */
	public static int howMuchCaseIsNear(int x, int y) {
		int count = 0;
		for(int i = -1; i < 2; i++ ) { // => Y
			for(int j = -1; j < 2 ; j++) { // => X
				if((y + i >= 0 && y + i < boardSizeY) && (x + j >= 0 && x + j < boardSizeX) && (j != 0 || i !=0)) {
					if(gameBoard[y + i][x + j].getFull()) {
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
		gameBoard[x][y].setFull(!gameBoard[x][y].getFull());
		fenetre.setButtons();
	}
	
	public static void sliderAffect(int test) {
		sleepTime = test;
	}
	
	public static void CreatePlat() {
		if(fenetre == null) {
			fenetre = new Window();
			createBoard();
		}
		fenetre.setButtons();
	}
	public static void Save() throws IOException {

		BufferedWriter writer = new BufferedWriter(new FileWriter("gameOfLife.txt"));
		writer.write(boadToString());
		writer.close();		
	}
	
	public static void Load() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("gameOfLife.txt"));
		String line = "";
		List<String> tab = new ArrayList<String>();
		while((line = reader.readLine()) != null) {
			tab.add(line);
		}
		gameBoard = stringToBoard(tab);
		fenetre.setButtons();
		
	}
	private static Box[][] stringToBoard(List<String> line){
		Box[][] board = new Box[line.get(0).length()][line.size()];
		for(int i = 0; i < boardSizeX ; i++) {
			String currentLine = line.get(i);
			for(int j = 0 ; j < boardSizeY ; j++) {
				board[i][j] = new Box(currentLine.charAt(j));
			}
		}
		
		return board;
	}
	private static String boadToString() {
		
		String s = "";
		for(int i = 0; i < boardSizeX ; i++) {
			for(int j = 0 ; j < boardSizeY ; j++) {
				s += gameBoard[i][j].toString();
			}
			s += "\n";
		}
		return s;
	}
	
	
	private static String boardToBeautifullString() {
		String s = "|   |";
		for(int i = 0; i < boardSizeX ; i++) {
			s += " " + i + " |";
		}
		s += "\n";
		for(int i = 0; i < boardSizeX ; i++) {
			s += "| " + i + " |";
			for(int j = 0 ; j < boardSizeY ; j++) {
				s += gameBoard[i][j].toString();
				s += "|";
			}
			s += "\n";
		}
		return s;
	}
	private static void createBoard() {
		gameBoard = new Box[boardSizeX][boardSizeY];
		for(int i = 0; i < boardSizeX ; i++) {
			for(int j = 0 ; j < boardSizeY ; j++) {
				gameBoard[i][j] = new Box('O');
			}
		}
	}
}
