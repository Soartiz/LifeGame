package lifegame.graphic;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import lifegame.core.*;

public class WinPop extends JFrame{
	public JButton auto;
	
	public WinPop() {
		super("GameStat");

        setLayout(new GridLayout(5, 0));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(200, 200);
		setVisible(true);
		
		JButton nextTurnBTN = new JButton("NextTurn");
		nextTurnBTN.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                Main.turn(true);
            }
		});
		add(nextTurnBTN);
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                try {
					Main.Save();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
		});
		add(save);
		JButton close = new JButton("Close");
		close.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
		});
		add(close);
		auto = new JButton("Auto");
		auto.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                Main.changeGameState();
            }
		});
		add(auto);
		JSlider speedSLID = new JSlider();
		speedSLID.setMaximum(500);
		speedSLID.setMinimum(0);
		speedSLID.setValue(250);
		speedSLID.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				 Main.sliderAffect(500-speedSLID.getValue());
			}
		});
		add(speedSLID);
	}
}
