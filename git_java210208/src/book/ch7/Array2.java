package book.ch7;

public class Array2 {
	int x = 3;
	String names[]=null;
	String enames[]= {"s","k","w"};
	public static void main(String[] args) {
		Array2 a2 = new Array2();
		boolean isOk[] = new boolean[a2.x];
		for(boolean bo:isOk) {
			System.out.println(bo);
		}
		a2.names = new String[] {"ee","dd","ss"};

	}

}
