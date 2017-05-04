package ch.mitti.fibonacci;


public class Fibonacci {
       int res;
      
       public int zeichnen(int anzahl){
             if(anzahl==1){
                    res = 0;
             }
            
             else if(anzahl==2){
                    res = 1;
             }
            
             else{
                    res = zeichnen(anzahl-1) + zeichnen(anzahl-2);
             }
             return res;
       }
 
       public static void main(String[] args) {
    	   Fibonacci fibonacci = new Fibonacci();
            
             int res = fibonacci.zeichnen(45);
             System.out.println(res);
 
       }
 
}
