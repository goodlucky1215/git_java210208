package book.ch6;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ClassGubun extends JFrame {
	JButton jbtn_search = new JButton("조회");
	JButton jbtn_exit = new JButton("종료");
	public void start() {
		//jbtn_search.addActionListener(this); -> 불가능하다.
		//jbtn_search.addActionListener(ClassGubun$1.class); ->불가능하다.
		//여기서 이렇게 익명클래스를 만들면 --> book.ch6 폴더쪽에 가보면 ClassGubun$1파일이 생성된다.
		jbtn_search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("조회 버튼 호출 성공");
				
			}
		});

		//여기서 이렇게 익명클래스를 만들면 --> book.ch6 폴더쪽에 가보면 ClassGubun$2파일이 생성된다. 생길때마다 번호가 1씩 붙음 - 지우면 끝 번호부터 지워짐.
		jbtn_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("나가기 버튼 호출 성공");
				
			}
		});

	}
	public void initDisplay() {
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(jbtn_search);
		this.add(jbtn_exit);
		this.setSize(500, 300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new ClassGubun().initDisplay();

	}

}
