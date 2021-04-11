package UI.hanbit;

import javax.swing.JFrame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookManager extends JFrame {
	Logger logger = LogManager.getLogger(BookManager.class);
	//선언부
	//1번과 2번의 차이를 보기위한 실험 
	JFrame jf = new JFrame();//new Window() 1.
	//JFrame bm = new BookManager();//new JFrame()2.
	//BookManager bm2 = new BookManager();//new JFrame()
	//static JFrame bm = new BookManager();
	//static BookManager bm2 = new BookManager();
	static BookManager bm3 = null; //선언만 되어있다 - 게으른 인스턴스화 - nullpointerexeception
	//생성자
	public BookManager() {//2.
		//bm.initDisplay();
		//jf.initDisplay();
		//initDisplay();
		//a와 b의 차이를 아는지!
		//여기서 this는 BookManager를 의미 a
		//this.setSize(500, 300);
		//super는 JFrame을 의미 b 
		//super.setSize(600, 700);
		//bm3.setSize(600, 700);  ㄱ.이거는 안되고
		this.setSize(600, 700); //ㄴ.얘는 JVM이 this를 관리하기때문에 먼저 메모리에 상주 시키고 돌기때문에 돌아간다.
		//우리는 setVisible에 대해서 오버라이딩을 하지 않았다. 따라서 부모의 메소드가 호출되었다.
		//bm.setVisible(true);
		this.setVisible(true);
	}
	//화면처리부
	public void initDisplay() {
		logger.info("initDisplay 호출 성공");
	}
	//메인 메소드
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new BookManager();
		//bm2.initDisplay();
		bm3 = new BookManager();//1.생성자 호출
		bm3.initDisplay();
	}

}
