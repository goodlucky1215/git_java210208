package UI.hanbit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JInternalFrameEx extends JFrame implements ActionListener {
	//선언부를 상속, 인터페이스 -> 다형성
	//인터페이스 - 메소드 오버라이드를 통해서          -> 결합도가 낮아진다. 
	//인터페이스 - 다른 클래스에어도 사용 할 수 있다 -> 결합도가 낮아진다. 
	//선언부(상속, 인터페이스) = 생성부(구현체 클래스)
	//ActionListener a = new JInternalFrameEx();
	
	//전변의 성격을 갖음////////////////////////////
	//이미 이른 인스턴스화 - 이미 RAM에 상주 - 그러나 아직 실행되지 않는다. - ㅡmain메소드가 실행되지 않았으니깐. -> JVM이 이를 해줌  -> 생성자가 콜 되야한다.
	JDesktopPane desktop = new JDesktopPane(); 
	
	JMenuItem openItem = new JMenuItem("New");
	JMenuItem closeItem = new JMenuItem("Close");
	JMenuItem exitItem = new JMenuItem("Exit");
	
	int cnt=1;
	/////////////////전변///////////////////////
	
	public JInternalFrameEx() {//생성자
		//JInternalFrameEx == this임
		//아래와 같이 쓴다면? 컴파일에러 생성자중에 파라미터가 String것이 없으니깐 
		//this("JInternalFrame 테스트");
		
		//이 super는 JFrame
		super("JInternalFrame 테스트");
		
		buildGUI();
		
		//여기 앞에 this.이 생략되 있는 것과 같다.
		setBounds(300,200,500,400);
		setVisible(true);
	}
	
	void buildGUI() {
    	//여기 앞에 this.이 생략되있다.
		add(desktop, BorderLayout.CENTER); //위치 - 배치
		
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		JMenu fileMenu = new JMenu("File");
		menubar.add(fileMenu);
		
		fileMenu.add(openItem);
		fileMenu.add(closeItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		openItem.addActionListener(this);
		closeItem.addActionListener(this);
		exitItem.addActionListener(this);
	}

	public void openFrame() {
		JInternalFrame frame = new JInternalFrame("새문서"+cnt, true, true, true, true );
		
		JLabel imageLabel = new JLabel("새문서");
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().add(imageLabel);
		if(cnt==1)
			frame.setSize(200,200);
		else
			frame.setBounds((cnt-1)*20, (cnt-1)*20, 200, 200);
		
		cnt++;

		desktop.add(frame);
		frame.setVisible(true);
	}
	
	public void closeFrame() {	
		JInternalFrame frame = desktop.getSelectedFrame();
		if(frame == null) { return; }		
		frame.setVisible(false);
		frame.dispose();	
	}
	
	public void actionPerformed(ActionEvent e) {
	
		Object obj = e.getSource();
		
		if(obj == openItem) {
			openFrame();
		}
		else if(obj == closeItem) {
			closeFrame();
		}
		else if(obj == exitItem) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	
	public static void main(String[] args){
		new JInternalFrameEx();
	}
}
