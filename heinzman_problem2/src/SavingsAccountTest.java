public class SavingsAccountTest{
	public static void main (String[] args)
	{
		int i;
		SavingsAccount saver1 = new SavingsAccount(2000);
	    SavingsAccount saver2 = new SavingsAccount(3000);
	    System.out.println("* * * * * * *    4%    * * * * * * *");
	    System.out.println("Month        Saver 1         Saver 2");
	    for (i = 1; i <= 12; i++) {
	    	saver1.modifyInterestRate(.04);
	    	saver2.modifyInterestRate(.04);
	    	System.out.print("  "+i);
	    	if(i<10)
	    	{
	    		System.out.print(" ");
	    	}
	    	System.out.print("        ");
	    	saver1.calculateMonthlyInterest();
	    	saver1.printNewBalances();
	    	
	        System.out.print("         ");
	        saver2.calculateMonthlyInterest();
	        saver2.printNewBalances();
	        System.out.println("");
	    }
	    System.out.println("");
	    System.out.println("* * * * * * *    5%    * * * * * * *");
	    System.out.println("Month        Saver 1         Saver 2");
	    for (i = 1; i <= 12; i++) {
	    	saver1.modifyInterestRate(.05);
	    	saver2.modifyInterestRate(.05);
	    	System.out.print("  "+i);
	    	if(i<10)
	    	{
	    		System.out.print(" ");
	    	};
	    	System.out.print("        ");
	    	saver1.calculateMonthlyInterest();
	    	saver1.printNewBalances();
	        System.out.print("         ");
	        saver2.calculateMonthlyInterest();
	        saver2.printNewBalances();
	        System.out.println("");
	    }
	}
}
