package as_601;

public class SavingsAccount {
	private double annualInterestRate;
	private double savingsBalance;

	public SavingsAccount() {

	}

	public SavingsAccount(double annualInterestRate, double savingsBalance) {
		super();
		this.annualInterestRate = annualInterestRate;
		this.savingsBalance = savingsBalance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	public double calculateMonthlyInterest() {
		double monthlyInterest = (savingsBalance * (annualInterestRate / 100)) / 12;
		savingsBalance += monthlyInterest;
		return monthlyInterest;
	}

	public static void main(String[] args) {
		SavingsAccount savingsAccount1 = new SavingsAccount(10, 2000);
		SavingsAccount savingsAccount2 = new SavingsAccount(10, 3000);

		System.out.println("annual Interest Rate: " + savingsAccount1.getAnnualInterestRate() + "%");
		System.out.println("Monthly Interest of the first month : " + savingsAccount1.calculateMonthlyInterest());
		System.out.println("Savings Balance after one month: " + savingsAccount1.getSavingsBalance());

		System.out.println("Chang annual Interst Rate to 5 %");
		savingsAccount1.setAnnualInterestRate(5);

		System.out.println("Monthly Interest of the second month: " + savingsAccount1.calculateMonthlyInterest());
		System.out.println("Savings Balance after one month: " + savingsAccount1.getSavingsBalance());

//		System.out.println(savingsAccount1.calculateMonthlyInterest());
//		System.out.println(savingsAccount1.calculateMonthlyInterest());
//		System.out.println(savingsAccount1.calculateMonthlyInterest());
//		System.out.println(savingsAccount1.calculateMonthlyInterest());
//		System.out.println(savingsAccount1.calculateMonthlyInterest());

		System.out.println("-----------------------");

		savingsAccount2.calculateMonthlyInterest();
		System.out.println(savingsAccount2.getSavingsBalance());

	}

}
