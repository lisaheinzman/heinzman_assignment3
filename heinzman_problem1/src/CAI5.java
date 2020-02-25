import java.util.Scanner;
import java.security.SecureRandom;
import java.lang.Math;

public class CAI5
{
	static Scanner b = new Scanner(System.in);
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
	
	public static int isAnswerCorrect(int response, int randInt1, int randInt2, int problemType)
		{
			int answer = 0;
			switch(problemType)
			{
				case 1: answer = randInt1 + randInt2;
				break;
				case 2: answer = randInt1 * randInt2;
				break;
				case 3: answer = randInt1 - randInt2;
				break;
				case 4: answer = randInt1 / randInt2;
				break;
			}
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
	
	public static void askQuestion(int randInt1, int randInt2, int problemType)
	{
		String word = " plus"; 
		switch(problemType)
		{ 
			case 1: word = "plus";
			break;
			case 2: word = "times";
			break;
			case 3: word = "minus";
			break;
			case 4: word = "divided by";
			break;
				
		}
		System.out.println("How much is "+ randInt1+" " + word + " "+randInt2+  "?");
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
	
	public static int readProblemType()
	{	
		int problemType;
		System.out.println("Enter arithmetic option: ");
		System.out.println(" *********************");
		System.out.println(" * 1. addition       *");
		System.out.println(" * 2. multiplication *");
		System.out.println(" * 3. subtraction    *");
		System.out.println(" * 4. division       *");
		System.out.println(" * 5. random         *");
		System.out.println(" *********************");
		problemType = b.nextInt();
		return problemType;
	}
	
	
	public static int quiz()
	{
		int i;
		int count = 0;
		int flag = 0;
		int difficulty = readDifficulty(b);
		int problemType = readProblemType();
		if (problemType == 5)
		{
			flag =1;
		}
		for(i = 0; i < 10; i++) 
		{
			if (flag == 1)
			{
				SecureRandom rand = new SecureRandom();
				problemType = rand.nextInt(4) + 1;
			}
			int randInt1 = generateQuestionArgument(difficulty);
			int randInt2 = generateQuestionArgument(difficulty);
			askQuestion(randInt1, randInt2, problemType);
			int response = readResponse(count,b);
			switch (isAnswerCorrect(response, randInt1, randInt2, problemType))
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
