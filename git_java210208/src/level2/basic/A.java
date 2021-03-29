package level2.basic;

import javax.swing.JButton;
import javax.swing.JFrame;

public class A extends JFrame {
	JButton jbtn = null;
	B b = null;//타입만 결정 되었으므로 시점에 따라 NullPointerException방지 해야 함.
	//B b = new B(this);
	boolean isView = false;
	public A() {
		jbtn = new JButton("전송2");
		initDisplay();
	}
	public A(boolean isView) {
		this.isView = isView;
		//jbtn = new JButton("전송3");
		jbtn = new JButton();
		//jbtn.setText("전송4");
		initDisplay();
		jbtn.setText("전송5");//**중요 동기화 처리가 되고 있다.
	}
	public void initDisplay() {
		b= new B(this);
		//이렇게 2번하면 2번 씩 찍힘.
		jbtn.addActionListener(b);
		jbtn.addActionListener(b);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add("Center",jbtn);
		this.setSize(500,300); //상수로 처리
		this.setVisible(isView);
	}
	public static void main(String[] args) {
		new A(true);
	}

}
