package rps;

import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class FrontPage extends JFrame{
	public static void front() {
		JFrame frame = new JFrame();
		Font big = new Font("Segoe Script", Font.PLAIN, 150);
		Font small = new Font("Segoe Script", Font.PLAIN, 25);
		
		//-----------------HEAD----------------------------------
		JLabel r = new JLabel("R");
		r.setBounds(30, 20, 150, 150);
		r.setFont(big);
		r.setForeground(Color.decode("#373737"));
		JLabel p = new JLabel("P");
		p.setBounds(140, 20, 150, 150);
		p.setFont(big);
		p.setForeground(Color.decode("#373737"));
		JLabel s = new JLabel("S");
		s.setBounds(250, 20, 150, 150);
		s.setFont(big);
		s.setForeground(Color.decode("#373737"));
		JLabel ock = new JLabel("ock");
		ock.setBounds(70, 115, 50, 25);
		ock.setFont(small);
		ock.setForeground(Color.decode("#373737"));
		JLabel aper = new JLabel("aper");
		aper.setBounds(185, 115, 100, 25);
		aper.setFont(small);
		aper.setForeground(Color.decode("#373737"));
		JLabel cissors = new JLabel("cissors");
		cissors.setBounds(330, 115, 100, 25);
		cissors.setFont(small);
		cissors.setForeground(Color.decode("#373737"));
		frame.add(r);
		frame.add(p);
		frame.add(s);
		frame.add(ock);
		frame.add(aper);
		frame.add(cissors);
		//-------------------------------------------------------
		
		//-------------------------PLAY BUTTON--------------------------------
		JButton play = new JButton("PLAY");
		play.setBounds(150, 190, 150, 50);
		play.setFont(small);
		play.setForeground(Color.decode("#e5dfe8"));
		play.setBackground(Color.decode("#373737"));
		play.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Game game= new Game();
				game.gameWindow();
			}
		});
		frame.add(play);
		//-------------------------------------------------------------
		
		//----------------------------HOWTO-----------------------------------
		JButton help = new JButton("HELP");
		help.setBounds(150, 270, 150, 50);
		help.setFont(small);
		help.setForeground(Color.decode("#e5dfe8"));
		help.setBackground(Color.decode("#373737"));
		help.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Help help = new Help();
				help.helpWindow();
			}
		});
		frame.add(help);
		//---------------------------------------------------------------------
		
		//-------------------------------QUIT----------------------------------
		JButton quit = new JButton("QUIT");
		quit.setBounds(150, 350, 150, 50);
		quit.setFont(small);
		quit.setForeground(Color.decode("#e5dfe8"));
		quit.setBackground(Color.decode("#373737"));
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frame.add(quit);
		//---------------------------------------------------------------------
		
		//------------FRAME---------------------------------------------
		frame.setSize(450,450);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);  
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.getContentPane().setBackground(Color.decode("#e5dfe8"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//----------------------------------------------------------------
	}
}