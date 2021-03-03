package book.ch4;

public class SwitchTest {

	public static void main(String[] args) {
		int protocol = 100;//로그인
		protocol = 200;//입장하기
		protocol = 300;//다자간 대화
		protocol = 301;//귓속말 1:1채팅
		String id = "goodlucky00";
		String input = "오늘 스터디 할까?";
		String msg = protocol+"#"+id+"#"+input;
		//제어문의 역할은 업무 순서에 대한 흐름을 바꾼다.
		//순서에 대한 정보를 바탕으로 의사를 결정할 수 있는 것은 팀장, 차장, 부장 선택자
		//선택(비즈니스로직계층-Model계층)에 따라
		//break <-> continue
		//break는 for문, while,...등에 쓰임. 무한루프를 방지하기 위해서
		//if문은 break대신에 return이다. 메소드를 탈출한다.
		//switch break는 switch문에 탈출
		switch(protocol) {//원시형 타입 + String타입
		case 0:
			//실행문
			System.out.println("0입니다.");
			break;
		case 301:
			//실행문
			System.out.println("10입니다.");
			break;
		case 100:
			//실행문
			System.out.println("100입니다.");
			break;
		default:
			System.out.println("default 입니다.");
			break;
		}
		System.out.println("여기");
	}

}
