package ch.mitti.ackermann;

public class Ackermann {
	
	
	public int A(int m, int n){
		int res;
		
		if(m==0){
			res = n+1;
		}
		
		else if(n==0){
			res = A(m-1,1);
		}
		
		else {
			res = A(m-1, A(m,n-1));
		}
		
		return res;
	}
	
	public static void main(String[] args){
		Ackermann ackermann = new Ackermann();
		int res = 0;
		res = ackermann.A(3, 10);
		System.out.println(res);
	}
}
