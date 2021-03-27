package TextBook.Book_chapter2;

public class PredatoryCreditCard extends CreditCard{

    private double apr;

    public PredatoryCreditCard(String cust, String bk , String acnt , int lim , double initialBal , double rate){
        super(cust,bk,acnt,lim,initialBal);
        apr = rate;
    }

    public void processMonth(){
        
    }
}
