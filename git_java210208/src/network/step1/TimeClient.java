package network.step1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JLabel;

public class TimeClient extends Thread {
	String timeStr = null;
	JLabel jlb_time = null;
	TimeClient(){
		
	}
	public TimeClient(JLabel jlb_time){
		this.jlb_time = jlb_time;
	}
	@Override
	public void run() {//콜백메소드 - 사용자가 아니라 시스템 레벨에서 자동 호출되는 메소드임.
		Socket socket = null;
		
		PrintWriter out = null;
		BufferedReader br = null;
		boolean isFlag = false;
		try {
			socket = new Socket("192.168.0.50",3000);//local port가 3000
			out = new PrintWriter(socket.getOutputStream(),true);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//내 소켓에 대한 포트번호는 따로 할당
			while(!isFlag) {
				while((timeStr=br.readLine())!=null) {
					System.out.println(timeStr);
					//jlb_time.setText(timeStr);//디폴트 생성자를 경유하므로 jlb_time은 null이다.
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("너는 ㄴ구야ㅑㅑㅑㅑㅑ");
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//단위테스트를 하기위해 잠깐 생성
	public static void main(String[] args) {
		TimeClient tc = new TimeClient();
		tc.start();//run메소드 호출 해줌.
	}

}
