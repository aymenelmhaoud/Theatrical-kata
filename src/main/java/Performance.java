import java.math.BigDecimal;

public class Performance {

  public String playID;
  public int audience;

  public Performance(String playID, int audience) {
    this.playID = playID;
    this.audience = audience;
  }

  public BigDecimal getAmount(Play play) {

    BigDecimal result;
    
    switch (play.type) {
      case Play.TRAGEDY:
        result = new BigDecimal(400);
        if (this.audience > 30) {
          result = result.add(new BigDecimal(10 * (this.audience - 30)));
        }
        break;
      case Play.COMEDY:
        result = new BigDecimal(300);
        if (this.audience > 20) {
          result = result.add(new BigDecimal(100 + 5 * (this.audience - 20)));
        }
        result = result.add(new BigDecimal(3 * (this.audience)));
        break;
      default:
        throw new Error("unknown type: ${play.type}");
    }
    return result;
  }

}

