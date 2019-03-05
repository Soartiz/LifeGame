package lifegame.graphic;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lifegame.core.*;

public class WinPop extends JFrame{
	public JButton auto;
	
	public WinPop() {
		super("GameStat");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(200, 200);
		setLayout(null);
		JButton nextTurnBTN = new JButton("NextTurn");		
		nextTurnBTN.setHorizontalAlignment(SwingConstants.CENTER);
		nextTurnBTN.setSize(100,25);
		nextTurnBTN.setLocation(50,85);
		nextTurnBTN.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                Main.turn();
            }
		});
		add(nextTurnBTN);
		setVisible(true);
		JButton close = new JButton("Close");
		close.setSize(100,25);
		close.setLocation(50,105);
		close.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
		});
		add(close);
		auto = new JButton("Auto");
		auto.setSize(100,25);
		auto.setLocation(50,125);
		auto.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                Main.changeGameState();
            }
		});
		add(auto);
	}
}
