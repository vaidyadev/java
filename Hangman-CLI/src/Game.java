import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Simple Hangman game that picks a random word from the dictionary (or any text file given as an argument) and displays an ASCII Hangman when the player guesses wrong.
//Written by Sam Whelan.

public class Game 
{
	static Hangman hangman = null;
	static Word word = null;
	static boolean running = true;
	static String input = null;
	static BufferedReader reader = null;
	static BufferedReader wordList = null;
	
	public static void main(String[] args)
	{
		//if a file is given as an argument, use that as a word list, else use the dictionary
		if (args.length == 0)
			try 
			{
				wordList = new BufferedReader(new FileReader("bin/2of4brif.txt"));
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
		else
			try 
			{
				wordList = new BufferedReader(new FileReader(args[0]));
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
		
		hangman = new Hangman();
		word = new Word(wordList);				
	    reader = new BufferedReader(new InputStreamReader(System.in));
	     
	    //wait for character input, check if it's in the word and display the output
		while (running)
		{
			try 
			{
				input = reader.readLine();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
			if (input != null && !input.trim().equals(""))
			{
			if (word.compare(input) == false)
				hangman.next();
			hangman.draw();
			word.display();	
			word.winCheck();
			hangman.gameOverCheck();
			}
		}		
	}

	public static void gameOver()
	{
		running = false;
		hangman.draw();
		word.reveal();
	}

	public static void win() 
	{
		running = false;
		System.out.println("Congratulations! You Won!");
	}

}
