package book.ch14;

public class UserException extends Exception {
	private int port = 7000;
	public UserException() {}
	public UserException(String msg) {
		super(msg);//super는 Exception을 말한다.
	}
	public UserException(String msg, int port) {
		super(msg);//super는 Exception을 말한다.
		//super(msg,port); port는 하위가 가지고 잇는거니깐 부모가 알지 못한다.
	}
	public static void main(String[] args) {

	}
	public int getPort() {
		return port;
	}

}
