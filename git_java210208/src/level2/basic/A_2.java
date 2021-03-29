package level2.basic;

import javax.swing.JButton;
import javax.swing.JFrame;

public class A_2 extends JFrame {
	JButton jbtn = null;
	boolean isView = false;
	public A_2() {
		initDisplay();
	}
	public A_2(boolean isView) {
		this.isView = isView;
		initDisplay();
	}
	public void initDisplay() {
		this.setSize(500,300); //상수로 처리
		this.setVisible(isView);
	}
	public static void main(String[] args) {
		new A_2(true);
	}

}
