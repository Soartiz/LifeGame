package lifegame.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import lifegame.core.Box;
import lifegame.core.Main;

public class Window extends JFrame{
	JButton[][] buttonsGrid = new JButton[10][10];
		
	
	public Window() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 1000);
        for(int _x = 0; _x < 10; _x++) {
            for(int _y = 0; _y < 10; _y++) {
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
    			buttonsGrid[_x][_y].setBackground(Color.cyan);
        	}
    	}
        setLayout(new GridLayout(10,10));

        setVisible(true);
	}
    public void setButtons(Box[][] currentBoard) {
        for(int _x = 0; _x < 10; _x++) {
            for(int _y = 0; _y < 10; _y++) {
            	buttonsGrid[_x][_y].setBackground(Color.white);
        		if(currentBoard[_x][_y].full == true) {
        			buttonsGrid[_x][_y].setBackground(Color.black);
        		}
        	}
    	}
    }
	
	
}
