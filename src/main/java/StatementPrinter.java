

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;

public class StatementPrinter {



  public String print(Invoice invoice, Map<String, Play> plays) {
    StringBuffer sb = new StringBuffer();
    
    sb.append(String.format("Statement for %s\n", invoice.customer));
    
    NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

    for (Performance perf : invoice.performances) {
      
      Play play = plays.get(perf.playID);
      
      BigDecimal thisAmount = perf.getAmount(play);
      
      
      sb.append(String.format("  %s: %s (%s seats)\n", play.name, frmt.format(thisAmount.doubleValue()), perf.audience));
      
    }
    
    sb.append(String.format("Amount owed is %s\n", frmt.format(invoice.getTotalAmount(plays).doubleValue())));
    
    sb.append(String.format("You earned %s credits\n", invoice.getEarnedCredits(plays)));
    

    return    sb.toString();
  }

   
    
  

  public static String tohtml(Invoice invoice ,Map<String, Play> plays ) {
    
    
  
    String result = String.format(" <p>Customer:%s</p>", invoice.customer);

    NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);
    StringBuffer str = new StringBuffer(result);
    str.append("<tr><th>Piece</th><th>Price</th><th>Seatsold</th></tr>");
    for (Performance perf : invoice.performances) {
      Play play = plays.get(perf.playID);
       BigDecimal thisAmount =perf.getAmount(play);
 str.append(String.format(" <tr><td>%s</td><td>%s</td><td>%s</td></tr> ",play.name, frmt.format(thisAmount.doubleValue()), perf.audience ));
     
    }
    str.append(String.format("<tr><td>Amount owed is</td><td> %s</td></tr>", frmt.format(invoice.getTotalAmount(plays).doubleValue())));
   
    str.append(String.format("<tr><td>Fidelity point earned</td><td> %s</td></tr>", invoice.getEarnedCredits(plays)));
 
    
    
    return str.toString();

    
  
  }
                   
}
  
  
             
  
  

  



