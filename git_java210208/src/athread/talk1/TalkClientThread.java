package athread.talk1;

import java.util.StringTokenizer;

public class TalkClientThread extends Thread {
	TalkClient2 tc = null;
	//TalkClient tc = new TalkClient(); --쓰면 망한다.
	
	public TalkClientThread(TalkClient talkClient) {
		//this.tc = talkClient; //조립이다. 연결
	}
	
	
	public TalkClientThread(TalkClient2 talkClient2) {
		this.tc = talkClient2; //조립이다. 연결
	}


	@Override
	public void run() {//여기는 말하는 곳 이다. 듣는 곳이다. 
		System.out.println("run호출 성공");
		boolean isStop = false;
		while(!isStop) {
			try {
				String msg ="";
				msg = (String)tc.ois.readObject();
				StringTokenizer st = null;
				int protocol = 0;
				if(msg!=null) {
					st = new StringTokenizer(msg,"#");
					protocol = Integer.parseInt(st.nextToken());//100
				}
				switch(protocol) {
				case Protocol.ROOM_IN:{
					String nickName = st.nextToken();//
					tc.jta_display.append(nickName+"님이 입장하였습니다.");
				};
				//case 200:{ 이렇게 숫자로 바로바로 적어서 프로토콜을 쓰기보다는 따로 protocol 클래스 안에 변수를 만들어서 무슨 의미인지 확실하게  보여줘야함. 개발은 혼자 하는게 아니잖아?
				case Protocol.MESSAGE:{
					String nickName = st.nextToken();//
					String msg2 = st.nextToken();//오늘 스터디하라?
					tc.jta_display.append("["+nickName+"]"+msg2+"\n");
				};
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
