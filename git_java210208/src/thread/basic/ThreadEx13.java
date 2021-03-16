package thread.basic;
class A extends Thread{
	@Override
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print("-");
		}
		System.out.println("[[[ A스레드 run ]]]");		
	}
}
//class B extends Thread{
class B extends Runable target(){
	@Override
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print("|");
		}
		System.out.println("[[[ B스레드 run ]]]");		
	}
}

public class ThreadEx13 {
	
	static long startTime = 0;
	/*
	 * 29[main thread시작] -> 30[스레드로딩-ready상태---go시점은? 32번의 start()부분] -> 31 -> 32[A run call] -> 33[B run call]
	 * 4 -> 5 -> 6(--------------||||||-------------|||||)과 13번이 켜지면서 둘이 번가락하게 됨.
	 * 14 -> 15 -> 16(|||||||---------------|||||||||||||) 후에 -> 42번으로 끝
	 */
	public static void main(String[] args) {
		A th1 = new A();
		B th  = new B();
		Thread th2 = new Thread(th);
		th2.start();
		th1.start();
		//쓰래드가 활동한 시간을 계산함.
		startTime = System.currentTimeMillis();
		
		try {
			th1.join(); //th1의 작업이 끝날 때까지 기다린다.
			th2.join(); //th2의 작업이 끝날 때까지 기다린다.
		} catch(InterruptedException e) {}
		
		System.out.println("소요시간: "+(System.currentTimeMillis()-ThreadEx13.startTime));
	}

}
