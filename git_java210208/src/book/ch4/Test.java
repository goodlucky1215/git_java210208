package book.ch4;

public class Test {
	void findswich3(int i) {
		switch(i%7){
			case 0: System.out.println("buzz");return;
			default: System.out.println(i);
		}
	}
	void findswich2(int i) {
		switch(i%5){
			case 0: System.out.println("fizz");return;
			default: findswich3(i);
		}
	}
	void findswich1(int i) {
		switch(i%35){
			case 0: System.out.println("fizzbuzz");return;
			default: findswich2(i);
		}
	}
	void findNum(int num) {
		for(int i=1;i<=num;i++) {
			findswich1(i);
		}
	}
	public static void main(String[] args) {
		Test result = new Test();
		result.findNum(100);
	}

}
