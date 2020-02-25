import java.util.Scanner;
import java.security.SecureRandom;
import java.lang.Math;

public class CAI4
{
	public static void displayCompletionMessage(int count)
	{
		if (count >= 8)
		{
			System.out.println("Congratulations, you are ready to go to the next level!");
		}
		if (count < 8)
		{
			System.out.println("Please ask your teacher for extra help.");
		}
	}
	
	public static void displayCorrectResponse() 
	{
		SecureRandom rand = new SecureRandom();
		int randInt = rand.nextInt(4);
		switch(randInt) 
		{
		case 0:
			System.out.println("Very Good!");
			break;
		case 1:
			System.out.println("Excellent!");
			break;
		case 2:
			System.out.println("Nice Work!");
			break;
		case 3:
			System.out.println("Keep up the good work!");
			break;
		}	
	}
	
	public static void displayIncorrectResponse() 
	{
		SecureRandom rand = new SecureRandom();
		int randInt = rand.nextInt(4);
		switch(randInt) 
		{
		case 0:
			System.out.println("No. Please try again.");
			break;
		case 1:
			System.out.println("Wrong. Try once more.");
			break;
		case 2:
			System.out.println("Don’t give up!");
			break;
		case 3:
			System.out.println("No. Keep trying.");
			break;
		}
	}
	
	public static int isAnswerCorrect(int response, int randInt1, int randInt2)
		{
			int answer = randInt1 * randInt2;
			if (answer == response)
			{
				return 1;
				
			}	
			if (answer != response)
			{
				return 0;
			}
			return 0;
		}
	
	
	public static int readResponse(int count, Scanner b) 
	{
		int response  = b.nextInt();
		if (count == 10)
		{
		b.close();
		}
		return response;
	}
	
	public static void askQuestion(int randInt1, int randInt2)
	{
		System.out.println("How much is "+ randInt1+  " times "+randInt2+  "?");
	}
	
	public static int generateQuestionArgument(int difficulty)
	{
		int randInt;
		int i = (int) Math.pow(10, difficulty);
		SecureRandom rand = new SecureRandom();
		randInt = rand.nextInt(i);
		return randInt;
	}
	
	public static int readDifficulty(Scanner b)
	{
		int difficulty; 
		System.out.println("Enter Difficulty Level:");
		difficulty  = b.nextInt();
		return difficulty;
	}
	
	static Scanner b = new Scanner(System.in);
	public static int quiz()
	{
		int i;
		int count = 0;
		int difficulty = readDifficulty(b);
		for(i = 0; i < 10; i++) 
		{
			int randInt1 = generateQuestionArgument(difficulty);
			int randInt2 = generateQuestionArgument(difficulty);
			askQuestion(randInt1, randInt2);
			int response = readResponse(count,b);
			switch (isAnswerCorrect(response, randInt1, randInt2))
			{
				case 0: displayIncorrectResponse();
				break;
				case 1: displayCorrectResponse();
				break;
			}
		}
		displayCompletionMessage(count);
		return 0;
	}
	
	public static void main(String[] args)
	{
		quiz();	
		b.close();
	} 
}
