import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
 * Author Tobechi Onwenu
 * Class: ICS 141
 * Game Bulls and Cows game
 * Assingment 6, 7 and 8.
 */

public class BCPlayer {

	// need to have a word
	// A5: we will have hard coded word
	private String guess;
	private String gameWord;

	// need to have the maximum rounds permitted
	// needed for A8
	public static final int MAX_ROUNDS = 10;

	// Create scanner object
	Scanner input = new Scanner(System.in);

	// For A7, we need to get hold of all the words from the text file
	private static ArrayList<String> wordBank = new ArrayList<String>();

	// a collection to get hold of all the guesses (guess_no, word_guessed,
	// bulls_count, cows_count)
	private ArrayList<Guess> guessList = new ArrayList<Guess>();

	// gameStatus
	private boolean gameEnded = false;

	// what methods do we need here?

	public BCPlayer() {
		this("word_list.txt");
	}

	public BCPlayer(String file_name) {
	}

	// TODO
//		pass in the file object to the scanner
//		pass the path to the file as a parameter
//		read each line in a loop
	public ArrayList<String> textWord() {

		Scanner input = null;
		try {
			File file = new File("word_list.txt");
			input = new Scanner(file);
			while (input.hasNext()) {
				wordBank.add(input.nextLine());
			}
		} catch (Exception e) {
			String error = e.getMessage();
			System.out.println(error);
		}

		input.close();
		return wordBank;
	}

	// get a random word based on the length
	public String getRandomWordByLength(int x) {
		System.out.println("\nEnter your desired game word here:");
		x = input.nextInt();
		ArrayList<String> randomWord = new ArrayList<String>();

		for (String rw : textWord()) {
			if (rw.length() == x) {
				randomWord.add(rw);
			}
		}
		if (randomWord.isEmpty()) {
			return "";
		}
		Random selectedWord = new Random();

		String wordChoice = randomWord.get(selectedWord.nextInt(randomWord.size()));
		return wordChoice.toUpperCase();
	}

	String wordChoosen = getRandomWordByLength(4);

	// calculate the bulls count
	public int getBulls(String guessed_word) {
		return 0;
	}

	// calculate the cows count
	public int getCows(String guessed_word)

	{
		return 0;
	}

	// compare the guessed_word to gameword
	// return bulls and cows calculated
	public int[] bullsAndCows(String guess_word) {
		int bulls = 0;
		int cows = 0;

		// Retrieving only one game word
		gameWord = wordChoosen;
		
		// print out gameWord
		System.out.println("\nGame word is " + gameWord + "\n");

		for (int i = 0; i < guess_word.length(); i++) {
			if (gameWord.charAt(i) == guess_word.charAt(i)) {
				bulls++;
			} else if (guess.contains(String.valueOf(gameWord.charAt(i)))) {
				cows++;
			}
		}
		return new int[] { bulls, cows };
	}

	// this method returns -1 if the number of rounds exceeds the permissible rounds
	// returns 1 if the guess is correct
	// returns 0 if the guess is incorrect
	public int validateGuess(Guess some_guess) {
		some_guess.setWordGuessed(guess);
		if (some_guess.getWordGuessed().equals(wordChoosen)) {
			return 1;
		}
		if (some_guess.getGuessNumber() > MAX_ROUNDS) {
			return -1;
		}
		return 0;
	}

	// game keeps on going until the user wins (A6 and A7) or until the MAX_ROUNDS
	// is exceeded
	public void startGame() {
		// For A6 logic

		int guess_number = 0;
		Guess guess_x = null;

		while (gameEnded == false) {

			// keep track of guess number
			guess_number = guess_number + 1;
			

			// ask the user for the guess (guessed_word)
			System.out.print("\nEnter a guess word here: ");
			guess = input.next().toUpperCase();

			// calculate the bulls and cows count
			// todo;
			int[] bullAndCows = bullsAndCows(guess);

			// add this to guess list
			// todo
			guess_x = new Guess(guess, guess_number, bullAndCows[0], bullAndCows[1]);
			guessList.add(guess_x);
			System.out.println(guessList.toString());

			// update guess attempts
			guess_x.setGuessNumber(guess_number++);

			// check the status of the guess (validateThe Guess)
			// to determine whether the game ended or not
			// exit the loop if you get back 1 or -1
			if (validateGuess(guess_x) == 1) {
				// display message for correct guess
				System.out.println("Congratulations you won.");
				gameEnded = true;
			} else if (validateGuess(guess_x) == -1) {
				System.out.println("\n Sorry you lost.");
				gameEnded = true;
			} else if (validateGuess(guess_x) == 0) {
				gameEnded = false;
			}

		}
		input.close();
	}

	public static void main(String[] args) throws Exception {
		// construct a BCPlayer object
		BCPlayer bcp = new BCPlayer("word_list.txt");
		bcp.startGame();

		// keep playing until the game ends
	}

}