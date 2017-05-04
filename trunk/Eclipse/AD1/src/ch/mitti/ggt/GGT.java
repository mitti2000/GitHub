package ch.mitti.ggt;
 
public class GGT {
       int A;
       int B;
      
       public GGT(int A, int B){
             this.A = A;
             this.B = B;
             System.out.println(calcGGT(A,B));
            
       }
      
       public int calcGGT(int A, int B){
             int res;
             if(B>A){
                    int temp = B;
                    B = A;
                    A = temp;
             }
             //System.out.println(A%B);
             if(A % B==0) {
                    res = B;
                    return res;
             }
             else{
                    res = calcGGT(B,A%B);
             }
            
             return res;
       }
      
      
       public static void main(String[] args){
             GGT ggt = new GGT(3528, 3780);
       }
}