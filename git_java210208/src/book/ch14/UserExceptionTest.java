package book.ch14;

public class UserExceptionTest {
	public void test1() {}
	public void test(String[] a) throws Exception{
		System.out.println("test 호출 성공");
		if(a.length < 1) {
			throw new UserException("아무 값이 없습니당~숭구리당당~");
		}
		else {
			throw new UserException("최종 예선.", 7000);
		}
		//if else밑에는 아무것도 쓸 수가 없다?? 위에서 else에 exception이 떨어지므로 밑에 까지 내려올 일이 없기때문에 쓸 수 없는 거임.
		//System.out.println("여기여기");
		//test1();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserExceptionTest uet = new UserExceptionTest();
		try {
			uet.test(args);
		}
		catch (UserException ue) {
			//System.out.println(ue.printStackTrace()); 이렇게 사용이 불가능
			ue.printStackTrace();
			System.out.println(ue.toString());
			System.exit(0); //JVM연결 종료 - finally 안탐
		}
		catch (Exception e) {
			e.toString();
			e.getMessage();
			e.printStackTrace();
		}
		finally {
			System.out.println("나는 무조건 무조건이야~!!!");
		}
	}

}
