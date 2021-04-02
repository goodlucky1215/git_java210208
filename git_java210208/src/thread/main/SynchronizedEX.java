package thread.main;

public class SynchronizedEX {

	public static void main(String[] args) {
		ATM atm = new ATM();
		Thread ey  = new Thread(atm,"ey");
		Thread ht  = new Thread(atm,"ht");
		ey.start();
		ht.start();
		//돌려보면 알겠지만 한명이 들어가면
		//걔가 돈을 다 가져감.
		//why? synchronized로 막혀있으니깐 - deadlock상태가됨
		//이를 막기 위해 wait()와 notify(), notifyAll()을 써서
		//스래드가 나눠 가질 수 있도록!!
	}

}
