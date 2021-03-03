package book.ch4;

import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwitchTest2 extends JFrame {

	public static void main(String[] args) {
		SwitchTest2 stv =new SwitchTest2();
		int protocol = 0;//로그인
		String nickName = "goodlucky00";
		String inputValue = "오늘 스터디 할까?";
		String msg = 300+"#"+nickName+"#"+inputValue;
		StringTokenizer st = new StringTokenizer(msg,"#");//#을 기준으로 나눠줌.
		protocol = Integer.parseInt(st.nextToken()); //#기준으로 나눈 것들을 순서대로 불러옴.
		String s_nickName = st.nextToken();
		String s_inputValue = st.nextToken();
		switch(protocol) {//원시형 타입 + String타입
		case 100:
			//실행문
			System.out.println("0입니다.");
			break;
		case 200:
			//실행문
			System.out.println("10입니다.");
			break;
		case 300:
			//실행문
			System.out.println("["+s_nickName+"]"+s_inputValue);
			break;
		default:
			JOptionPane.showMessageDialog(stv,"잘못된 메시지 입니다.");
			break;
		}
		System.out.println("여기");
	}

}
