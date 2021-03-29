package level2.basic;

import javax.swing.JButton;
import javax.swing.JFrame;

public class A_6 extends JFrame {
	JButton jbtn = null;
	B_2 b = null;
	//B b = new B(this);
	boolean isView = false;
	public A_6() {
		jbtn = new JButton("전송2");
		initDisplay();
	}
	public A_6(boolean isView) {
		this.isView = isView;
		//jbtn = new JButton("전송3");
		jbtn = new JButton();
		//jbtn.setText("전송4");
		initDisplay();
		jbtn.setText("전송5");//**중요 동기화 처리가 되고 있다.
	}
	public void initDisplay() {
		b= new B_2(this);
		//이렇게 2번하면 2번 씩 찍힘.
		jbtn.addActionListener(b);
		jbtn.addActionListener(b);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add("Center",jbtn);
		this.setSize(500,300); //상수로 처리
		this.setVisible(isView);
	}
	public static void main(String[] args) {
		new A_6(true);
	}

}
