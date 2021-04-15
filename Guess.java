

/*================================
 Author     : Tobechi Onwenu
 Class Name : Guess
 Date       :   03/28/2021    
 Course     : ICS141 Programming with Objects (Siva Jasthi)
 Purpose    : Assignment 6, 7 and 8.
=================================*/



public class Guess
{	

	//for representing words guessed
	private String wordGuessed;	

	//for keeping count of guess numbers
	private int guessNumber;	

	//for keeping track of bullsCount
	private int bullsCount;	

	//for keeping track of cowsCount
	private int cowsCount;

	/**
	 * Default Constructor For Guess Class
	 */
	 public Guess()
	 {
 
	 };

	/**
	* Overloded Constructor For Guess Class
	*/
	 public Guess(String a_word_guessed, int a_guess_number, int a_bulls_count, int a_cows_count)
	 { 
		wordGuessed = a_word_guessed;
		guessNumber = a_guess_number;
		bullsCount = a_bulls_count;
		cowsCount = a_cows_count;
	 }

	/**
	 * Set method for the variable wordGuessed
	 */
	public void setWordGuessed(String a_word_guessed)
	{
		wordGuessed = a_word_guessed;
	}

	/**
	 * Set method for the variable guessNumber
	 */
	public void setGuessNumber(int a_guess_number)
	{
		guessNumber = a_guess_number;
	}

	/**
	 * Set method for the variable bullsCount
	 */
	public void setBullsCount(int a_bulls_count)
	{
		bullsCount = a_bulls_count;
	}

	/**
	 * Set method for the variable cowsCount
	 */
	public void setCowsCount(int a_cows_count)
	{
		cowsCount = a_cows_count;
	}

	/**
	 * Get method for the variable wordGuessed
	 */
	public String getWordGuessed( )
	{
		return wordGuessed;
	}

	/**
	 * Get method for the variable guessNumber
	 */
	public int getGuessNumber( )
	{
		return guessNumber;
	}

	/**
	 * Get method for the variable bullsCount
	 */
	public int getBullsCount( )
	{
		return bullsCount;
	}

	/**
	 * Get method for the variable cowsCount
	 */
	public int getCowsCount( )
	{
		return cowsCount;
	}

	/** 
	 * Returns the String representation of Guess object 
	 */
	 public String toString()
	{
		 String temp = 
				 "\nRound: "+guessNumber + "\t\tGuess Word: " + wordGuessed + "\tBulls : " + bullsCount + "\tCows: " + cowsCount + "\t";
		 return temp;
	}

}