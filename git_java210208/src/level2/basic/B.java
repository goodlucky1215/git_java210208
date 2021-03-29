package level2.basic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class B implements ActionListener {
	A a = null;
	C c =new C();
	public B(A a) {
		System.out.println("B(A a)생성자 호출 성공");
		this.a = a;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		//System.out.println("actionPerformed호출 성공");
		Object obj = ae.getSource();
		obj = ae.getSource().getClass();
		//만일 10번의 초기화가 없다면 NullPointerException발생.
		if(a.jbtn.getClass()==obj) {
			System.out.println("헤이이이ㅣ이ㅣㅇ이ㅣ a.jbtn이라긔");
			String msg = c.methodA();
			System.out.println("메소드 처리 결과: "+msg);
		}
	}

}
