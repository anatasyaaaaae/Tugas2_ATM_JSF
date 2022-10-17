package atm.mvc;

public class Tampilan  
 {     
    public static Tampilan instance = new Tampilan();
    
    public Tampilan(){}
    
    public static Tampilan getInstance() {
        return instance;
    }
    
   public void displayPesan(String message){  
     System.out.print(message);  
   }
   
   public void displayPesanBaris(String message){  
     System.out.println(message);  
   }
   
   public void displaySaldo(int jumlah){  
     System.out.println(jumlah);  
   }
 }    
 