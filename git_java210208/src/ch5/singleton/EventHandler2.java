package ch5.singleton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandler2 implements ActionListener {
	ViewApp2 viewApp = null;
	//ViewApp viewApp = new ViewApp();
	public EventHandler2(ViewApp2 viewApp) {
		//System.out.println(this.viewApp);
		this.viewApp = viewApp;
		System.out.println(this.viewApp);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==viewApp.jbtn) { //NullPointerException
			System.out.println("전송 버튼 호출 성공");
		}

	}
}

//6 21 14