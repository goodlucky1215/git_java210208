package com.pattern;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalaryMgrHandler implements ActionListener{
	SalaryMgrView smView = null;
	public SalaryMgrHandler(SalaryMgrView smView) {
		this.smView = smView;
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();//버튼의 주소번지 출력 예)@abcd1234
		String command = ae.getActionCommand(); //버튼의 라벨값을 출력함
		//너 종류 버튼 누른거야? 네
		//if("종료".contentEquals(command)){ //이것도 되고 밑에것도 되지민 "종료"라는 표현이 적혀있는 이것이 더 직관적이라서 추천
		if(smView.jbtns[4]==obj){
			System.out.println("종료버튼 이벤트 감지");
			//자바 가상머신과의 연결고리 끊어줌. - 가비지컬렉터에 의해서 candidate상태로 빠짐
			System.exit(0);
			//System.gc();//쓰레기값 청소해주세요. 호출하더라도 스레드에 의해 순서대로 처리됨. 즉시 처리안됨/
		}else if("조회".equals(command)) {
			System.out.println("조회버튼 이벤트 감지");
			smView.smLogic.getEmpDetail(7566);
		}
	}

}
