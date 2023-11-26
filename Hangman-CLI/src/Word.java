import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

//Handles the selection of words, obfuscating the word and displaying the current letters

public class Word 
{
	String chosenWord;
	char[] letters;
	char[] currentLetters;
	char[] wrongLetters;
	int wrongLettersCount = 0;

	Word(BufferedReader wordList)
	{
		//add all the words from the wordList into an ArrayList
		ArrayList<String> words = new ArrayList<String>();
		String word = null;
		try 
		{
			word = wordList.readLine();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}

		while (word != null) 
		{
		    words.add(word);
		    try 
		    {
				word = wordList.readLine();
			} 
		    catch (IOException e) 
		    {
				e.printStackTrace();
			}
		}
		
		//choose a random word from the ArrayList and obfuscate it
		Random r = new Random();
		String chosenWord = words.get(r.nextInt(words.size()));
		letters = chosenWord.toCharArray();
		currentLetters = new char[letters.length];
		obfuscate(letters);
		System.out.println(currentLetters);
	}

	//make an char array of the same length as the word and fill it with blanks
	public void obfuscate(char[] letters)
	{
		for (int i = 0; i < letters.length; i++)
			currentLetters[i] = '#';
	}
	
	//show the final answer
	public void reveal() 
	{
		System.out.println("The word is " + new String(letters));		
	}

	//return true if the input letter is in the word
	public boolean compare(String input) 
	{
		char[] inputChar = input.toCharArray();
		boolean correctLetter = false;
		for (int i = 0; i < letters.length; i++)
		{
			if (inputChar[0] == letters[i])
			{
				currentLetters[i] = inputChar[0];
				correctLetter = true;
			}	
		}
		
		return correctLetter;
	}

	public void display() 
	{
		System.out.println(currentLetters);
	}

	public void winCheck() 
	{
		if (Arrays.equals(letters, currentLetters))
			Game.win();		
	}
	
}
