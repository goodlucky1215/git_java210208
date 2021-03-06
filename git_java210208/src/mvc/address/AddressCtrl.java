package mvc.address;
import java.io.*;
import java.util.*;

public class AddressCtrl {

	private AddressVO returnVO = new AddressVO();
	//아래와 비교되는 값들은 모두 AddressBook에서 받아오거나 또는 ModifyDialog그에서 받아와야한다.
	//ModifyDialog에서는 입력, 수정 처리만 한다.
	//INSERT INTO addrDB(컬럼명,,,...) VALUES(?,?,?,,,,...)
	//UPDATE addrDB SET address='서울시 마포구 공덕동',,,,....WHERE ano = 5;
	//삭제는 AddressBook의 JTable에서 직접 처리한다. Delete from addrDB WHERE ano=5;
	//command = delete
	//ano = 5;
	private static  String _DEL = "delete";
	private static  String _INS = "insert";
	private static  String _MOD = "update";
	private static  String _SEL = "select";
	public AddressCtrl() {
	}

	public AddressVO send(AddressVO vo) throws Exception {
		String command = vo.getCommand();
		if(_DEL.equals(command)) {
			DeleteEntity del = new DeleteEntity();
			returnVO = del.delete(vo);
		}else if(_INS.equals(command)) {
			RegisterEntity regi = new RegisterEntity();
			returnVO = regi.insert(vo);
		}else if(_MOD.equals(command)) {
			ModifyEntity modi = new ModifyEntity();
			returnVO = modi.update(vo);
		}else if(_SEL.equals(command)) {
			RetrieveEntity modi = new RetrieveEntity();
			returnVO = modi.select(vo);
		}
		return returnVO;
	}

	public AddressVO[] send() throws Exception {
		AddressVO[] returnVOs = null;
		System.out.println("send() 호출 성공 - 반환 타입이 AddressVO[]");
		return returnVOs;
	}
	public List<AddressVO> sendAll() throws Exception {
		List<AddressVO> selectAll = null;
		System.out.println("sendAll() 호출 성공 - 반환 타입이 List<AddressVO>");
		return selectAll;
	}	
}
	