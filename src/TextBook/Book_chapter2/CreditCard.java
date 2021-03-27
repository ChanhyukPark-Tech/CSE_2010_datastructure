package TextBook.Book_chapter2;

public class CreditCard {
    //Instance variables:
    private String customer;                // name of the customer (e.g " John Bowman")
    private String bank;                    // name of the bank ( Berkshir hathaway )
    private String account;                 // account identifier ( 22.3.22.12.323)
    private int limit;                      // credit limit (measured in dollars)
    protected double balance;               // current balance (measured in dollars)

    //Constructors:

    public CreditCard(String cust, String bk, String acnt, int lim, double initialBal) {
        this.customer = cust;
        this.bank = bk;
        this.account = acnt;
        this.limit = lim;
        this.balance = initialBal;
    }

    public CreditCard(String cust, String bk, String acnt, int lim) {
        this(cust, bk, acnt, lim, 0.0); // Use a balance of zero as default
    }

    // Accessor methods:

    public String getCustomer() {
        return customer;
    }

    public String getBank() {
        return bank;
    }

    public String getAccount() {
        return account;
    }

    public int getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }

    // Update methods:
    public boolean charge(double price){
        if(price + balance > limit){
            return false;
        }
        balance += price;
        return true;
    }
    public void makePayment(double amount){
        balance -= amount;
    }

    public static void printSummary(CreditCard card){
        System.out.println(card.customer);
        System.out.println(card.bank);
        System.out.println(card.account);
        System.out.println(card.balance);
        System.out.println(card.limit);
    }

    public static void main(String[] args) {

    }
}
