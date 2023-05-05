public class CheckingAccount extends BankAccount {

    private static final double FEE = 0.15;
    String name;
    public CheckingAccount(String name, int initialAmount) {
        super(name, initialAmount);
        setAccountNumber(getAccountNumber() + "-10");
        this.name = name;
    }
    
    @Override
    public boolean withdraw(double amount) {
        boolean result = super.withdraw(amount + FEE);
        return result;
    }

	public String getOwner() {
		return name;
	}
}