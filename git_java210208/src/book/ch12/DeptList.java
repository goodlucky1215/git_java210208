package book.ch12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.vo.DeptVO;

//화면처리하기 - 출력
//데이터마이그레이션 업무
//데이터 수집 - 빅데이터, 차트를 이용한 화면 처리
public class DeptList extends JFrame implements ActionListener {
	//선언부
	JButton jbtn_search = new JButton("조회");
	String cols[] = {"부서번호","부서명","지역"};
	//데이터셋 선언
	DefaultTableModel dtm = null;
	JTable			  jtb = null;
	JScrollPane		  jsp = null;
	//생성자
	public DeptList() { //인스턴스화가 될때 화면이 즉시 그려지도록
		initDisplay();
	}
	public void tableCreate() {
		dtm = new DefaultTableModel(new Object[0][3],cols);
		jtb = new JTable(dtm);
		jsp = new JScrollPane(jtb);
		this.add("Center",jsp);
	}
	//데이터 수집하기1
	public List<Map<String,Object>> getDeptList(){
		System.out.println("getDeptList 호출 성공");
		List<Map<String,Object>> deptList = new ArrayList<>();
		Map<String,Object> r1 = new HashMap<>();
		r1.put("deptno", 10);
		r1.put("dname", "인사부");
		r1.put("loc", "서울");
		deptList.add(r1);
		 r1 = new HashMap<>();
		r1.put("deptno", 20);
		r1.put("dname", "총무부");
		r1.put("loc", "제주도");
		deptList.add(r1);
		 r1 = new HashMap<>();
		r1.put("deptno", 30);
		r1.put("dname", "개발부");
		r1.put("loc", "인천");
		deptList.add(r1);
		return deptList;
	}
	//데이터 수집하기2
	public List<DeptVO> getDeptList2(){
		System.out.println("getDeptList2 호출 성공");
		return null;
	}
	//화면처리부
	public void initDisplay() {
		jbtn_search.addActionListener(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		tableCreate(); //메소드 호출도 동기화가 필요하디. - 시점 문제
		this.setTitle("부서목록");
		this.add("North",jbtn_search);
		this.setSize(400, 300);
		this.setVisible(true);
	}
	//메인메소드
	public static void main(String[] args) {
		new DeptList();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		//너 조회버튼 누른거야?
		//dtm, jtable
		if(ae.getSource()==jbtn_search) {
			List<Map<String,Object>> deptList = getDeptList();
			Iterator<Map<String, Object>> iter = deptList.iterator();
			Object keys[] = null;
			while(iter.hasNext()) {
				Map<String, Object> data = iter.next();
				keys = data.keySet().toArray();
				Vector oneRow = new Vector();
				oneRow.add(data.get(keys[2]));
				oneRow.add(data.get(keys[1]));
				oneRow.add(data.get(keys[0]));
				dtm.addRow(oneRow);
			}
		}
	}
}
//선생님 for문으로 가져오지않고 iterator을써서 데이터를 가져오는 것에 대한 이유가 있을까요?
//성능에 차이보다는 왜냐하면 요즘은 하드웨어가 많이 발전했으니까:) 
//자료구조에 대해 제공되는 또다른 계열의 인터페이스가 있다는 걸 소개하는 시간이었고요 
//오늘 소개한 인터페이스를 활용하여 웹개발에서 반복되는 req.getParameter의 반복되는 코드를 줄여줄 공통코드 실습을 위한 사전 학습입니다.

