package ch5.singleton;


import javax.swing.JButton;
import javax.swing.JFrame;

public class ViewApp2 {
	//setSize하기 전에 인스턴스화를 하였다.
	JFrame jf = new JFrame();
	JFrame jf2 = null;
	JButton jbtn = null;
	public void initDisplay() {
		jf2 = new JFrame();
		//디폴트 생성자는 제공해주지만 파라미터를 갖는 생성자는 제공되지 않습니다.
		EventHandler2 eh = new EventHandler2(this);
		
		//얘로하면 어떻게 될까?
		//EventHandler2 eh = new EventHandler2(null);
		
		//첫번째 상황
		//이 메소드는 호출 되나요?
		//실행문이기 떄문에 jbtn.addActionListener(eh)==null.addActionListener(eh); 지금 이런 느낌이기 때문에 터진다!!
		//jbtn.addActionListener(eh);//////////
		//jbtn = new JButton("전송");
		
		//두번째 상황
		//그래서 이 순서대로 하면 안 터진다
		jbtn = new JButton("전송");
		jbtn.addActionListener(eh);//////////
		jf2.add("North",jbtn);
		jf2.setSize(300,200);
		jf2.setVisible(true);
		
	}
	public static void main(String[] args) {
		ViewApp2 va = new ViewApp2();
		va.initDisplay();
	}

}
