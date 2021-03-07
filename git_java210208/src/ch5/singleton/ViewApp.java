package ch5.singleton;


import javax.swing.JButton;
import javax.swing.JFrame;

public class ViewApp {
	//setSize하기 전에 인스턴스화를 하였다.
	JFrame jf = new JFrame();
	JFrame jf2 = null;
	JButton jbtn = new JButton("전송");
	public void initDisplay() {
		jf2 = new JFrame();
		//디폴트 생성자는 제공해주지만 파라미터를 갖는 생성자는 제공되지 않습니다.
		EventHandler eh = new EventHandler(this);
		//eh안에는 ActionListener가 있어 그래서 actionPerformed를 사용할 수 있고,
		//그렇게 때문에 addActionListener에 eh를 넣어줘야
		//addActionListener가 작동이 될 수 있어.
		//jbtn버튼을 나는 작동을 시키고 싶어.
		//그래서 eh 생성자로 ViewApp을 넣어준것이고,
		//그래서 jbtn이 전역변수로써 JButton("전송")으로 인식되어 있기때문에
		//작동이 가능해진다.
		jbtn.addActionListener(eh);
		jf2.add("North",jbtn);
		jf2.setSize(300,200);
		jf2.setVisible(true);
		
	}
	public static void main(String[] args) {
		ViewApp va = new ViewApp();
		va.initDisplay();
	}

}
