package lifegame.graphic;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import lifegame.core.Main;

public class Window extends JFrame{
	
	JButton[][] buttonsGrid;		
	
	public Window() {
		setWindow();
	}
	public void setWindow() {
		buttonsGrid = new JButton[Main.boardSizeX][Main.boardSizeY];
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 1000);
        for(int _x = 0; _x < Main.boardSizeX; _x++) {
            for(int _y = 0; _y < Main.boardSizeY; _y++) {
            	JButton button = new JButton();
            	button.setName(_x + "_" + _y);
            	button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Main.changeBoxState(button.getName());
                    }
                });
        		add(button);
                buttonsGrid[_x][_y] = button;
    			buttonsGrid[_x][_y].setBackground(Color.white);
        	}
    	}
        setLayout(new GridLayout(Main.boardSizeX, Main.boardSizeY));
        setVisible(true);
	}

    public void setButtons() {
        for(int _x = 0; _x < Main.boardSizeX; _x++) {
            for(int _y = 0; _y < Main.boardSizeY; _y++) {
            	buttonsGrid[_x][_y].setBackground(Color.white);
        		if(Main.gameBoard[_x][_y].getFull() == true) {
        			buttonsGrid[_x][_y].setBackground(Color.black);
        		}
        	}
    	}
    }
	
	
}
