public class Customer {
    public String name;
    public int Clientnum;
    public int Solde;

    public Customer(String name , int Clientnum, int Solde){
        this.name=name;
        this.Clientnum=Clientnum;
        this.Solde=Solde;

    }
    public int addcredit(int credit){
        return this.Solde+=credit;

    }
    public void getreduction(){
        if( this.Solde>=150){
         this.Solde-=150;
        
        }
              
          
               
        }

    }


    

