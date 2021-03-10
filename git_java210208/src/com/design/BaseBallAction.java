package com.design;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BaseBallAction extends JFrame implements ActionListener{
	//ActionListener인 나는 버튼을 눌렀을때 일어날일에 대해서 알수가 없다.
	BaseBallView bbView = null;
	public BaseBallAction(BaseBallView bbView) {
		this.bbView = bbView;
	}
	//JTexaArea에 순번 출력하기
	int cnt = 0;
	//만든이들 다이얼로그 닫기 버튼추가
	JButton jbtn_close = null;	
	//컴퓨터가 난수발생으로 얻어낸 값 저장
	int[] com = new int[3];	
	int[] my = new int[3];	
	public void nanSu(){
		com[0] = (int)(Math.random()*10);
		do{
			com[1] = (int)(Math.random()*10);
		}while(com[0]==com[1]);
		do{
			com[2] = (int)(Math.random()*10);
		}while((com[0]==com[2])||(com[1]==com[2]));
		System.out.println(com[0]+""+com[1]+""+com[2]);
	}	
	//전광판에 출력될 메시지를 작성하는 메소드 선언
	public String call(String input){
		//스트라이크를 카운트할 변수
		int strike = 0;
		//볼을 카운트할 변수
		int ball = 0;		
		int temp = 0;
		//반드시 세자리 숫자 이어야 한다.
		if(input.length()!=3){
			return "세자리 숫자만 입력하세요!!!";
		}
		temp = Integer.parseInt(input);
		my[0] = temp/100;//백자리를 받는다.
		my[1] = (temp%100)/10;//십자리를 받는다.
		my[2] = temp%10;
		for(int i=0;i<com.length;i++){
			for(int j=0;j<my.length;j++){
				//같은 숫자가 존재하는 경우(볼확보)
				//컴퓨터가 채번한 숫자가 있는지 비교
				if(com[i] == my[j]){
					//자리수까지도 일치하는 경우(스트라이크확보)
					//그 숫자가 존재하는 배열의 인덱스값을 비교
					if(i==j){
						strike++;
					}else{
						ball++;
					}
				}//  end of if          ////////////////
			}//////  end of inner for   ////////////////
		}//////////  end of outter for  ////////////////
		if(strike == 3) return "정답입니다.";
		return strike+"스트라이크" +ball+"볼";
	}/////////////  end of call ////////////////////////	
	@Override
	public void actionPerformed(ActionEvent e) {
		//인터페이스는 반드시 구현체 클래스가 필요하다
		//그래야 actionPerformed라는 추상 메소드를 구현 할 수 있으니까
		Object obj = e.getSource();
		// 라벨값으로 처리하고 싶으면
		String label = e.getActionCommand(); //새게임,지우기
		System.out.println("event label:"+label);
		if(obj == bbView.jtf_input){
			String input =  bbView.jtf_input.getText().trim();
			
			//만일 숫자가 아닌 값이 있을 때도 고려해야 한다.
			try {
				Integer.parseInt(input);//356			
			} catch (NumberFormatException nfe) {
				bbView.jop.showMessageDialog( bbView.jf, "숫자만 입력하세요", "Error", JOptionPane.ERROR_MESSAGE);
				bbView.jtf_input.setText("");
				 bbView.jtf_input.requestFocus();				
				return ;
			}
			
			if(input.length()!=3){
				return;
			}
			else{
				bbView.jta_display.append(++cnt+"."+ bbView.jtf_input.getText()+":"+call(input)+"\n");
				bbView.jtf_input.setText("");
			}
		}
		else if("지우기".equals(label)){
			bbView.jta_display.setText("");
			bbView.jtf_input.requestFocus();
		}
		else if("종료".equals(label)){
			System.exit(0);// 자바 가상머신과의 연결고리를 끊는다.
		}
		else if(obj ==  bbView.jmi_dap){
			bbView.jta_display.append("정답은 "+ com[0]+ com[1]+ com[2]+"\n");
			 nanSu();
		}
		else if(obj ==  bbView.jbtns[1]){
			bbView.jta_display.append("정답은 "+ com[0]+ com[1]+ com[2]+"\n");
			 nanSu();
		}
		//새게임
		else if(obj ==  bbView.jbtns[0]){
			cnt = 0;
			 nanSu();
			 bbView.jta_display.setText("");
			 bbView.jtf_input.setText("");
			 bbView.jtf_input.requestFocus();
		}
		
	}
	

}
