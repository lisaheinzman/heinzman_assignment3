import java.util.Scanner;
import java.security.SecureRandom;
public class CAI1
{
	public static void displayCorrectResponse() 
	{
		System.out.println("Very Good!");
	}
	public static void displayIncorrectResponse() 
	{
		System.out.println("No. Please try again.");
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
	
	public static int readResponse() 
	{
		Scanner b = new Scanner(System.in);
		int response  = b.nextInt();
		b.close();
		return response;
	}
	public static void askQuestion(int randInt1, int randInt2)
	{
		
		System.out.println("How much is "+ randInt1+  " times "+randInt2+  "?");
	}
	public static void quiz(int Int1, int Int2, int response)
	{
		switch (isAnswerCorrect(response, Int1, Int2))
		{
			case 0: displayIncorrectResponse();
			break;
			case 1: displayCorrectResponse();
			break;
		}
	}
	public static void main(String[] args) {
		SecureRandom rand = new SecureRandom();
		int randInt1 = rand.nextInt(10);
		int randInt2 = rand.nextInt(10);
		askQuestion(randInt1, randInt2);
		int response = readResponse();
		quiz(randInt1, randInt2, response);
	}
	 
}