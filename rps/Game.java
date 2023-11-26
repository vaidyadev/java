package rps;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.util.Random;

public class Game {
	
	JLabel rndm;
	JLabel win;
	JLabel loss;
	JFrame frame;
	JButton rock;
	JButton paper;
	JButton scissor;
	JButton again;
	JLabel status;
	JLabel option;
	JLabel col;
	JLabel you;
	
	
	public void gameWindow() {
		frame = new JFrame();
		Font small = new Font("Segoe Script", Font.PLAIN, 12);
		Font score = new Font("Segoe Script", Font.BOLD, 50);
		
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
		
		//-----------------SCOREBOARD------------------------------
		you = new JLabel("YOU      COMPUTER");
		you.setBounds(165, 150, 150, 50);
		you.setForeground(Color.decode("#373737"));
		you.setFont(small);
		win = new JLabel("0");
		win.setBounds(165, 185, 150, 50);
		win.setForeground(Color.decode("#373737"));
		win.setFont(score);
		col = new JLabel(":");
		col.setBounds(210, 185, 150, 50);
		col.setForeground(Color.decode("#373737"));
		col.setFont(score);
		loss = new JLabel("0");
		loss.setBounds(235, 185, 150, 50);
		loss.setForeground(Color.decode("#373737"));
		loss.setFont(score);
		frame.add(win);
		frame.add(loss);
		frame.add(col);
		frame.add(you);
		//---------------------------------------------------------
		
		//---------------STATUS------------------------------------
		status = new JLabel();
		status.setBounds(125, 230, 250, 50);
		status.setForeground(Color.decode("#373737"));
		status.setFont(new Font("Segoe Script", Font.BOLD, 50));
		frame.add(status);
		//---------------------------------------------------------
		
		//------------------OPTION TEXT----------------------------
		option = new JLabel();
		option.setBounds(180, 300, 150, 30);
		option.setForeground(Color.decode("#373737"));
		option.setFont(new Font("Segoe Script", Font.BOLD, 20));
		frame.add(option);
		//----------------------------------------------------------
		
		//------------------RANDOM TEXT--------------------------------
		rndm = new JLabel();
		rndm.setBounds(180, 100, 150, 30);
		rndm.setForeground(Color.decode("#373737"));
		rndm.setFont(new Font("Segoe Script", Font.BOLD, 20));
		frame.add(rndm);
		//--------------------------------------------------------------
		
		//-----------------ROCK BUTTON----------------------------------
		rock = new JButton("ROCK");
		rock.setBounds(50, 375, 100, 50);
		rock.setFont(small);
		rock.setForeground(Color.decode("#e5dfe8"));
		rock.setBackground(Color.decode("#373737"));
		frame.add(rock);
		rock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				option.setText("ROCK");
				check(operation(0));
			}
		});
		//-------------------------------------------------------
		
		//---------------PAPER BUTTON--------------------------------
		paper = new JButton("PAPER");
		paper.setBounds(175, 375, 100, 50);
		paper.setFont(small);
		paper.setForeground(Color.decode("#e5dfe8"));
		paper.setBackground(Color.decode("#373737"));
		frame.add(paper);
		paper.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				option.setText("PAPER");
				check(operation(1));
			}
		});
		//------------------------------------------------------------
		
		//--------------------SCISSORS BUTTON-------------------------
		scissor = new JButton("SCISSORS");
		scissor.setBounds(300, 375, 100, 50);
		scissor.setFont(small);
		scissor.setForeground(Color.decode("#e5dfe8"));
		scissor.setBackground(Color.decode("#373737"));
		frame.add(scissor);
		scissor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				option.setText("SCISSORS");
				check(operation(2));
			}
		});
		//-------------------------------------------------------------
		
		//-----------PLAY AGAIN-----------------------------------------
		again = new JButton("PLAY AGAIN");
		again.setBounds(50, 375, 350, 50);
		again.setFont(small);
		again.setForeground(Color.decode("#e5dfe8"));
		again.setBackground(Color.decode("#373737"));
		again.setVisible(false);
		frame.add(again);
		again.addActionListener((ActionEvent e) -> {
                    frame.dispose();
                    Game game = new Game();
                    game.gameWindow();
                });
		//--------------------------------------------------------------
		
		//------------------------FRAME--------------------------------
		frame.setSize(450,450);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);  
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.getContentPane().setBackground(Color.decode("#e5dfe8"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//-----------------------------------------------------------------
	}
	
	//---------GENERATING OPPONENT AND VALUATING RESULT-------------------
	private int operation(int op) {
		Random random = new Random();
		int k = random.nextInt(3);
		if(k==0)
			rndm.setText("ROCK");
		else if(k==1)
			rndm.setText("PAPER");
		else
			rndm.setText("SCISSORS");
		if(op==k)
			return 0;
		else if(k==0 && op==2)
			return -1;
		else if(k==2 && op==0)
			return 1;
		else if(k<op)
			return 1;
		else
			return -1;
	}
	//-------------------------------------------------------------------------------
	
	int won = 0, lost = 0;
	//--------UPDATING SCORES AND CHECKING STATUS---------------------------
	private void check(int i) {
		if(i==-1)
			lost++;
		else if(i==1)
			won++;
		win.setText(String.valueOf(won));
		loss.setText(String.valueOf(lost));
		if(won == 5) {
			rndm.setVisible(false);
			option.setVisible(false);
			win.setBounds(165, 80, 150, 50);
			col.setBounds(210, 80, 150, 50);
			loss.setBounds(235, 80, 150, 50);
			status.setText("WON!!!");
			again.setVisible(true);
			rock.setVisible(false);
			paper.setVisible(false);
			scissor.setVisible(false);
			you.setVisible(false);
		}
		if(lost == 5) {
			rndm.setVisible(false);
			option.setVisible(false);
			win.setBounds(165, 80, 150, 50);
			col.setBounds(210, 80, 150, 50);
			loss.setBounds(235, 80, 150, 50);
			status.setText("LOST!!!");
			again.setVisible(true);
			rock.setVisible(false);
			paper.setVisible(false);
			scissor.setVisible(false);
			you.setVisible(false);
		}
	}
	//-----------------------------------------------------------------------
}