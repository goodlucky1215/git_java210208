package book.ch4;

enum Dogs {collie, harrier, shepherd};

public class Ocjp52 {
	void m() {
		String name = "이순신";
		//switch안에 String 타입 가능
		switch(name){
			case "이순신":
				System.out.print("이순신");
				break;
			case "김유신":
				System.out.print("김유신");
				break;
		}
				
	}
	public static void main(String[] args) {
		Dogs myDog = Dogs.shepherd;
		switch (myDog) {
			case collie:
				System.out.print("collie ");
			case  shepherd:
				System.out.print("shepherd ");
			case harrier:
				System.out.print("harrier ");
		}///end of switch
	}///end of main
}///end of Ocjp52
