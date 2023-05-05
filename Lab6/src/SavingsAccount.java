public class SavingsAccount extends BankAccount {

    private static double RATE = 0.025;
    private static int savingsNumber = 0;
    
    private int savingsAccountNumber;
    private String accountNumber;
    
    public SavingsAccount(String name, double initialBalance) {
        super(name, initialBalance);
        savingsNumber++;
        savingsAccountNumber = savingsNumber;
        accountNumber = super.getAccountNumber() + "-" + savingsAccountNumber;
    }
    
    public void postInterest() {
        double interest = getBalance() * RATE / 12;
        deposit(interest);
    }
    
    @Override
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public SavingsAccount(SavingsAccount original, double initialBalance) {
        super(original, initialBalance);
        savingsNumber++;
        savingsAccountNumber = savingsNumber;
        accountNumber = super.getAccountNumber() + "-" + savingsAccountNumber;
    }
}
