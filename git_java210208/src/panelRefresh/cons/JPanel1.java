package panelRefresh.cons;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//public class JPanel1 extends JDialog{JFrame의 자식인 JDialog를 가져와도 화면 켜짐
 public class JPanel1 extends JPanel{//extends JPanel로 하면 화면이 보이진 않음 -독립적으로 실행이 안된다 (속지 같은 것)
//public class JPanel1 extends JFrame{//화면 extends JFrame하면 켜짐                -독립적으로 실행 가능   (겉에 판 같은 것)
	String cols[] = {"대화명"};
	String data[][] = new String[0][1];
	//이른 인스턴스화를 하면 변화 요인이 발생했을 경우 대처하기가 어렵다.
	//중간에 다른 정보로 변경이나 변화를 주기가 쉽지 않다.
	//이런 상황일 때는 객체 생성으로 인한 생성자 호출에 주의가 필요함.
	
	DefaultTableModel dtm = new DefaultTableModel(data,cols);
	JTable		      jtb = new JTable(dtm);
	JScrollPane		  jsp = new JScrollPane(jtb
							,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
							,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	public JPanel1() {
		initDisplay();
	}
	public void initDisplay() {
		this.setLayout(new BorderLayout());
		this.add("Center",jsp);
		this.setSize(400,300);
		this.setVisible(true);
	}
	public static void main(String args[]) {
		new JPanel1();
	}
}
