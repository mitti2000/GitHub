package ch.mitti.methoden_polymorphie;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Operation> ops= new ArrayList<Operation>();
		
		double t1 = 10;
		double t2 = 5;
		
		ops.add(new OpPlus());
		ops.add(new OpMinus());
		ops.add(new OpMultiplikation());
		ops.add(new OpDivision());
		
		Iterator<Operation> it = ops.iterator();
		while(it.hasNext()){
			Operation temp = it.next();
			temp.setTerm1(t1);
			temp.setTerm2(t2);
			temp.doOperation();
			System.out.println(temp.getResult());
		}

	}

}
