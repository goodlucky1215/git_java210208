package UI.hanbit;

import javax.swing.JFrame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookManager3 extends JFrame {
	Logger logger = LogManager.getLogger(BookManager3.class);
	JFrame jf = new JFrame();
	static BookManager3 bm3 = null;
	//생성자
	public BookManager3() {
		bm3.setSize(600, 700);
		//this.setSize(600, 700);

		bm3.setVisible(true);
		//this.setVisible(true);
		System.out.println(this);
	}
	//화면처리부
	public void initDisplay() {
		logger.info("initDisplay 호출 성공");
	}
	//메인 메소드
	public static void main(String[] args) {
		bm3 = new BookManager3();
		//메모리에는 전역변수 값만 일단 저장된 상태 -> 실행은 아직
		//->내가 main을 돌리면 이제 실행이 됨. -> bm3를 인스턴스화 해줌. 그리면 생성자가 돌아가는데,
		//->bm3가 인스턴스화 되는 과정에서 안에 setSize랑 setVisible이 처리되면서
		//->bm3가  아직 인스턴스화가 다 안된 상태고 그래서 에러가 되는 것이다.
		//그런데 setSize(600, 700), setVisible(true)를 this로 돌리게 되면, 
		//JVM은 이 전체 자체를 인식하게 되고 그래서 this를 사용하면 
		//this도 결국엔 얘가 돌아가야 의미가 있다. bm3가 
		bm3.initDisplay();
		System.out.println(bm3);
	}

}
