package com.design.zipcode;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import com.util.DBConnectionMgr;
/*
 * dispose에 대한 설명임
 * 이 Window, 하위 구성 요소 및 모든 소유 된 하위 구성 요소에서 사용하는 모든 기본 화면 리소스를
 * 해제합니다. 즉, 이러한 구성 요소에 대한 리소스가 파괴되고 사용하는 모든 메모리가 OS로 반환되며
 * 표시 할 수없는 것으로 표시됩니다.
Window 및 하위 구성 요소는 pack 또는 show에 대한 후속 호출로 네이티브 리소스를 다시 빌드하여
다시 표시 가능하게 만들 수 있습니다. 다시 생성 된 Window 및 해당 하위 구성 요소의 상태는 Window가
삭제 된 시점에서 이러한 개체의 상태와 동일합니다 (해당 작업 간의 추가 수정은 고려하지 않음).
 *
 * setVisiable에 대한 설명임.
 * 재정의 : 구성 요소의 setVisible (...)
매개 변수 : b true이면 Window를 표시하고 그렇지 않으면 Window를 숨 깁니다.
Window 및 / 또는 해당 소유자가 아직 표시 가능하지 않은 경우 둘 다 표시 가능하게됩니다.
창은 보이기 전에 유효성이 검사되며 창이 이미 보이는 경우에는 창을 앞으로 가져옵니다.
false이면이 Window, 하위 구성 요소 및 모든 소유 자식을 숨 깁니다. Window 및 해당 하위 구성
요소는 #setVisible (true)를 호출하여 다시 표시 할 수 있습니다.
 */
public class ZipCodeSearchVer3 extends JFrame implements MouseListener
                                                   , ItemListener
                                                   , FocusListener
                                                   , ActionListener {
	//선언부
	String zdo = null;
	String sigu = null;
	String dong = null;	
	//물리적으로 떨어져 있는 db서버와 연결통로 만들기
	JPanel jp_north = new JPanel();
	//insert here
	String sigus[] = null;
	String dongs[] = null;
	String zdos2[] = null;
	String totals[] = {"전체"};
	Vector<String> vzdos = new Vector<>();//vzdos.size()==>0
	JComboBox jcb_zdo = null;//zdo
	JComboBox jcb_sigu = null;//West
	JComboBox jcb_dong = null;//West
	JTextField jtf_search = new JTextField("동이름을 입력하세요.");//Center
	JButton jbtn_search = new JButton("조회");//East
	String cols[] = {"우편번호","주소"};
	String data[][] = new String[0][2];
	DefaultTableModel dtm_zipcode = new DefaultTableModel(data,cols);
	JTable jtb_zipcode = new JTable(dtm_zipcode);
	//1-6은 다른 클래스의 인스턴스로 자신을 생성하기
	JTableHeader jth = jtb_zipcode.getTableHeader();
	JScrollPane jsp_zipcode = new JScrollPane(jtb_zipcode
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	String zdos3[] = null;
	MemberShip memberShip = null;
	//DB연동에 필요한 선언
	DBConnectionMgr     dbMgr   = DBConnectionMgr.getInstance();
	Connection 			con 	= null;
	PreparedStatement 	pstmt 	= null;
	ResultSet 			rs 		= null;
	//생성자
	public ZipCodeSearchVer3() {
		zdos3    = getZDOList();
		sigus	 = getSIGUList();
		dongs	 = getDONGList();
		jcb_zdo  = new JComboBox(zdos3);//West
		jcb_sigu = new JComboBox(sigus);//West
		jcb_dong = new JComboBox(totals);//West
	}
	private String[] getDONGList() {
		String dongs[]   = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT '전체' dong FROM dual				");
		sb.append("UNION ALL								");
		sb.append("SELECT dong								");
		sb.append("FROM (									");
		sb.append("			SELECT distinct(dong) dong		");
		sb.append("			FROM   zipcode_t				");
		sb.append("			WHERE  zdo = ? AND sigu = ?	AND dong IS NOT null");
		sb.append("			ORDER BY dong asc		        ");
		sb.append("		) 									");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			int i = 0;
			pstmt.setString(++i,zdo);
			pstmt.setString(++i,sigu);
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<>();
			while(rs.next()) {
				String dong = rs.getString("dong");
				v.add(dong);
			}
			dongs = new String[v.size()];
			v.copyInto(dongs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dongs;
	}
	private String[] getSIGUList() {
		String  sigus[] = null;
		StringBuilder sb = new StringBuilder(); 
		sb.append("SELECT '전체' 	sigu FROM dual			 ");
		sb.append("UNION ALL	 					     ");
		sb.append("SELECT sigu 						     ");
		sb.append("FROM  (	  					     	 ");
		sb.append("			SELECT   distinct(sigu) sigu ");
		sb.append("			FROM     zipcode_t 		     ");
		sb.append(" 		WHERE    zdo = ?			 ");
		sb.append(" 		ORDER BY sigu asc		     ");
		sb.append(" 	 )							     ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, zdo);
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<>();
			while(rs.next()) {
				String sigu = rs.getString("sigu");
				v.add(sigu);
			}
			sigus = new String[v.size()];
			v.copyInto(sigus);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sigus;
	}
	public ZipCodeSearchVer3(MemberShip memberShip) {
		this();
		this.memberShip = memberShip;
	}
	//화면처리부
	public void initDisplay() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		jth.setBackground(new Color(150,22,50));
		jth.setBackground(Color.orange);
		jth.setFont(new Font("맑은고딕",Font.BOLD,20));
		jtb_zipcode.setGridColor(Color.red);
		jtb_zipcode.getColumnModel().getColumn(0).setPreferredWidth(100);
		jtb_zipcode.getColumnModel().getColumn(1).setPreferredWidth(300);
		jtb_zipcode.requestFocus();
		jtb_zipcode.addMouseListener(this);
		jbtn_search.addActionListener(this);
		jtf_search.addFocusListener(this);
		jtf_search.addActionListener(this);
		jp_north.setLayout(new FlowLayout());
		for(String s:vzdos) {
			System.out.println("s===>"+s);
		}
/* String배열에 있는 정보를 굳이 벡터에 담아야 한다.
 * 생성자 선택을 Vector타입으로 결정했기 때문이다.
 * 벡터 자체는 값을 가지고 있지 않는 상태이다.
 * 값은 1차 배열 안에 초기화 되어 있다.
 * 이것을 벡터에 재 초기화 한다.
 * 그 후에 콤보박스를 생성하고 화면에 장착해야 리스트에서 값을 볼 수 있을 것이다.
 * 	
 */
//		
		jcb_sigu.addItemListener(this);
		jcb_dong.addItemListener(this);
		jcb_zdo.addItemListener(this);
		jp_north.add(jcb_zdo);
		jp_north.add(jcb_sigu);
		jp_north.add(jcb_dong);
		jp_north.add("West",jcb_dong);
		jp_north.add("Center",jtf_search);
		jp_north.add("East",jbtn_search);
		this.add("North",jp_north);
		this.add("Center",jsp_zipcode);
		this.setTitle("우편번호 검색");
		this.setSize(430, 400);
		this.setVisible(true);
	}
	//콤보박스에 뿌려질 ZDO컬럼의 정보를 오라클 서버에서 꺼내 오기
	public String[] getZDOList() {
		//조회 결과를 받을 1차 문자 배열 선언. 초기화는 안함.
		String zdos[] = null;
		//오라클 서버에 보낼  select문 작성하기
		//String자체는 원본이 바뀌지 않는 특성을 가진다.
		//StringBuilder는 단일 스레드 안전하고
		//StringBuffer는 다중 스레드 안전하다.
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT '전체' zdo FROM dual      ");
		sb.append("UNION ALL                        ");
		sb.append("SELECT zdo                       ");
		sb.append("  FROM (                         ");
		sb.append("        SELECT distinct(zdo) zdo ");
		sb.append("          FROM zipcode_t         ");
		sb.append("        ORDER BY zdo asc         ");
		sb.append("       )                         ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<>();
			List<String> v2 = new Vector<>();
			while(rs.next()) {
				String zdo = rs.getString("zdo");
				v.add(zdo);
			}
			zdos = new String[v.size()];
			v.copyInto(zdos);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
		}
		return zdos;
	}
	//콤보박스에 뿌려질 ZDO컬럼의 정보를 오라클 서버에서 꺼내 오기
	/*
	public String[] getZDOList() {
		//조회 결과를 받을 1차 문자 배열 선언. 초기화는 안함.
		String zdos[] = null;
		//오라클 서버에 보낼  select문 작성하기
		//String자체는 원본이 바뀌지 않는 특성을 가진다.
		//StringBuilder는 단일 스레드 안전하고
		//StringBuffer는 다중 스레드 안전하다.
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT '전체' zdo FROM dual      ");
		sb.append("UNION ALL                        ");
		sb.append("SELECT zdo                       ");
		sb.append("  FROM (                         ");
		sb.append("        SELECT distinct(zdo) zdo ");
		sb.append("          FROM zipcode_t         ");
		sb.append("        ORDER BY zdo asc         ");
		sb.append("       )                         ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<>();
			List<String> v2 = new Vector<>();
			while(rs.next()) {
				String zdo = rs.getString("zdo");
				v.add(zdo);
			}
			zdos = new String[v.size()];
			v.copyInto(zdos);
			//v2.copyInto(zdos);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
		}
		return zdos;
	}
	*/
	//메인메소드
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		ZipCodeSearchVer3 zcs = new ZipCodeSearchVer3();
		zcs.initDisplay();
	}
	@Override
	public void focusGained(FocusEvent e) {
		System.out.println("focusGained 호출 성공");
		if(e.getSource() == jtf_search) {
			jtf_search.setText("");
		}
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void refreshData(String zdo,String sigu, String dong,String mydong) {
		System.out.println("zdo:"+zdo+", sigu:"+sigu+", dong:"+dong);
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT address, zipcode");
		sql.append("  FROM zipcode_t");
		sql.append(" WHERE 1=1");
		if(zdo!=null && zdo.length()>0 && !"전체".equals(zdo)) {
			sql.append(" AND zdo=?");
		}
		if(sigu!=null && sigu.length()>0 && !"전체".equals(sigu)) {
			sql.append(" AND sigu=?");
		}
		if(dong!=null && dong.length()>0 && !"전체".equals(dong)) {
			sql.append(" AND dong=?");
		}
		if(mydong!=null && mydong.length()>0) {
			sql.append(" AND dong LIKE '%'||?||'%'");
		}
		int i=1;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			if(zdo!=null && zdo.length()>0 && !"전체".equals(zdo)) {
				pstmt.setString(i++,zdo);
			}
			if(sigu!=null && sigu.length()>0 && !"전체".equals(sigu)) {
				pstmt.setString(i++,sigu);
			}
			if(dong!=null && dong.length()>0 && !"전체".equals(dong)) {
				pstmt.setString(i++,dong);
			}
			if(mydong!=null && mydong.length()>0) {
				pstmt.setString(i++,mydong);
			}
			rs = pstmt.executeQuery();
			Vector<ZipCodeVO> v = new Vector<>();
			ZipCodeVO[] zVOS = null;
			ZipCodeVO zVO = null;
			while(rs.next()) {
				zVO = new ZipCodeVO();
				zVO.setAddress(rs.getString("address"));
				zVO.setZipcode(rs.getInt("zipcode"));
				v.add(zVO);
			}
			zVOS = new ZipCodeVO[v.size()];
			v.copyInto(zVOS);
			if(v.size()>0) {
				//조회 버튼을 연달아서 눌럿을 경우 기존에 조회 결과는 클리어 시키자
				while(dtm_zipcode.getRowCount()>0) {
					dtm_zipcode.removeRow(0);
				}
				//새로 조회된 결과를 출력하기
				for(int x=0;x<v.size();x++) {
					Vector<Object> 		oneRow 	= new Vector<>();
					//ArrayList<Object> 	oneRow2 = new ArrayList<>();
					//List<Object>		oneRow3 = new ArrayList<>();
					//List<Object>		oneRow4 = new Vector<>();
					oneRow.add(0,zVOS[x].getZipcode());
					oneRow.add(1,zVOS[x].getAddress());
					//dtm_zipcode.addRow(zVOS);
//오라클에서 조회된 결과를 담기는 부분이 바로 여기다.........					
					dtm_zipcode.addRow(oneRow);//오직 객체 배열과 벡터 뿐이다. - 너의 선택은 항상 벡터가 옳다.
				}
			}
			//v2.copyInto(zdos);
		} catch (SQLException se) {
			System.out.println("[[ query ]]"+sql.toString());
		} catch (Exception e) {
			//에러 메시지만 쌓아두는 스택이 있는데 그 스택의  history를 다 보여줌
			//게다가........라인 번호 까지도
			e.printStackTrace();//힌트를 얻는다.
		} finally {
			dbMgr.freeConnection(con, pstmt, rs);
		}
		
	}/////////////////end of refreshData
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtn_search || obj == jtf_search) {
			String myDong = jtf_search.getText();
			refreshData(zdo,sigu,dong,myDong);
		}
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		//Object obj = e.getSource().getClass();
		Object obj = e.getSource();
		//if(obj == JComboBox.class) {
		if(obj == jcb_zdo) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				zdo = zdos3[jcb_zdo.getSelectedIndex()];
				jcb_sigu.removeAllItems();
				sigus	 = getSIGUList();
				for(int i=0;i<sigus.length;i++) {
					jcb_sigu.addItem(sigus[i]);
				}
			}
		}
		if(obj == jcb_sigu) {
			if(e.getStateChange() == ItemEvent.SELECTED){
				sigu = sigus[jcb_sigu.getSelectedIndex()];
				jcb_dong.removeAllItems();
				dongs	= getDONGList();
				for(int i=0;i<dongs.length;i++) {
					jcb_dong.addItem(dongs[i]);
				}
			}
		}
		if(obj == jcb_dong) {
			if(e.getStateChange() == ItemEvent.SELECTED){
				dong = dongs[jcb_dong.getSelectedIndex()];
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getClickCount()==2) {
			System.out.println("더블 클릭 한거야");
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}