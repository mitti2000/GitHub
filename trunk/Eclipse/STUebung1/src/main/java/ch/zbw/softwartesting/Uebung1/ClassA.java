package ch.zbw.softwartesting.Uebung1;

public class ClassA {
	private ClassB classB;
	private ClassC classC;

	public ClassA(ClassB classB, ClassC classC) {
		this.classB = classB;
		this.classC = classC;
	}

	public void calculate() throws Exception {
		if (this.classB.isExecutable()) {
			this.classC.run();
		} else {
			throw new Exception("Die Berechnung kann zur Zeit nicht ausgeführt werden!");
		}
	}

	public boolean isResultCorrect() {
		if (this.classC.getResult() == "Correct") {
			return true;
		}

		return false;
	}
}
