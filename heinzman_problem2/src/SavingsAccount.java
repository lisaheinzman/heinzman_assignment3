public class SavingsAccount {
	private static double annualInterestRate;
	private double savingsBalance = 0.00;

	public SavingsAccount()
	{
        savingsBalance = 0;
        annualInterestRate = 0;
    }

	public SavingsAccount(double balance) 
    {
		savingsBalance = balance;
		annualInterestRate = 0;
    }

	public void calculateMonthlyInterest() 
	{
		double monthlyInterest = (savingsBalance * annualInterestRate) / 12;
        savingsBalance = savingsBalance + monthlyInterest;
    }

    public void modifyInterestRate(double updatedInterestRate) 
    {
        annualInterestRate = updatedInterestRate;
    }

    public double printNewBalances() 
    {
    	System.out.printf("$%.2f", +savingsBalance);
        return savingsBalance;
    }

}