import java.util.Scanner;
import java.security.SecureRandom;
public class CAI3
{
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
	
	public static int readResponse(int count) 
	{
		Scanner b = new Scanner(System.in);
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
	public static int quiz()
	{
		int i;
		int count = 0;
		for(i = 0; i < 10; i++) 
		{
			SecureRandom rand = new SecureRandom();
			int randInt1 = rand.nextInt(10);
			int randInt2 = rand.nextInt(10);
			askQuestion(randInt1, randInt2);
			int response = readResponse(count);
			switch (isAnswerCorrect(response, randInt1, randInt2))
			{
				case 0: displayIncorrectResponse();
				break;
				case 1: displayCorrectResponse();
				break;
			}
		}
		if (count >= 8)
		{
			System.out.println("Congratulations, you are ready to go to the next level!");
		}
		if (count < 8)
		{
			System.out.println("Please ask your teacher for extra help.");
		}
		return 0;
	}
	public static void main(String[] args)
	{
		quiz();
	}
	 
}

