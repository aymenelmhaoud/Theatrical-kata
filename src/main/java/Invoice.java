import java.math.BigDecimal;
import java.util.*;

public class Invoice {

  public Customer customer;
  public List<Performance> performances;

  public Invoice(Customer customer, List<Performance> performances) {
    this.customer = customer;
    this.performances = performances;
  }

  
  public BigDecimal getTotalAmount(Map<String, Play> plays) {

    BigDecimal totalAmount = new BigDecimal(0);
    
    for (Performance perf : performances) {

      Play play = plays.get(perf.playID);
      
      BigDecimal thisAmount = perf.getAmount(play);

      totalAmount = totalAmount.add(thisAmount);
    }
    
	if(customer.Solde >= 150) {
		customer.getreduction();
		totalAmount.subtract(new BigDecimal(15));


	}

    return totalAmount;
  }

  public int getEarnedCredits(Map<String, Play> plays) {
    int credit = 0;
    for (Performance perf : performances) {

      Play play = plays.get(perf.playID);
      
      credit += Math.max(perf.audience - 30, 0);
      if (Play.COMEDY.equals(play.type)) credit += Math.floor(perf.audience / 5);
    }

	customer.addcredit(credit);
    return credit;
  }
}