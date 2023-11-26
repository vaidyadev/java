package rps;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Help {
	public void helpWindow() {
		JFrame frame = new JFrame();
		Font text = new Font("Copperplate Gothic Bold", Font.PLAIN, 12);
		
		//--------------------BACK BUTTON-------------------------
		JLabel back = new JLabel("< BACK");
		back.setBounds(20, 20, 150, 30);
		back.setForeground(Color.decode("#373737"));
		back.setFont(new Font("Segoe Script", Font.BOLD, 20));
		frame.add(back);
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		//----------------------------------------------------------
		
		//---------------TEXT---------------------------------------
		JLabel txt = new JLabel();
		txt.setFont(text);
		txt.setBounds(10, 60, 430, 370);
		String str = "<html>RULES :<br/> 1. Paper defeats rock.<br/>2. Rock defeats scissors.<br/>3. Scissors defeats paper.<br/><br/>The first to score 5 will win the game."
				+ "The status will be show in the screen. You can use the play again button to play again or back to return back to main menu.</html>";
		txt.setText(str);
		txt.setForeground(Color.decode("#373737"));
		frame.add(txt);
		//----------------------------------------------------------
		
		//-----------------FRAME-----------------------------------
		frame.setSize(450,450);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);  
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.getContentPane().setBackground(Color.decode("#e5dfe8"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//--------------------------------------------------------------
		
		
	}
}