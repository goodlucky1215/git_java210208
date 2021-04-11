package UI.hanbit;

import javax.swing.JFrame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookManager2 extends JFrame {
	Logger logger = LogManager.getLogger(BookManager2.class);
	//선언부
	JFrame jf = new JFrame();//new Window()
	JFrame bm = new BookManager2();//new JFrame()
	//생성자
	public BookManager2() {
		//bm.initDisplay();
		//jf.initDisplay();
		System.out.println("1");
		initDisplay();
		System.out.println("2");
	}
	//화면처리부
	public void initDisplay() {
		System.out.println("3");
		logger.info("initDisplay 호출 성공");
		this.setSize(500, 300);
		System.out.println("4");
		this.setVisible(true);
		System.out.println("5");
	}
	//메인 메소드
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BookManager2();
		//전역변수는 이미 메모리에 올라가 있다 -> 내가 main을 돌리면서 실행이 됨.
		//그런데 main이 켜짐과 동시에 bm은 생성자를 가지므로 안에서 돌아간다.
		//bm이 돌아가면 BookManager2()가 계속 new돼서 계속 켜지니깐 문제가 되는건가?
		
	}

}
