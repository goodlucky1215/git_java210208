package constructor.step4;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
//생성자 파라미터 활용 연습
//인스턴스화 이전에 반드시 생성자 확인할것. API(Application Programming Interface)
/* new JFrame();
* new JFrame("타이틀");
* new JComboBox();
* new JComboBox(String[]);
* new JComboBox(String);
* 대분류
* 중분류
* 소분류
*/
public class JComboBoxTest1 extends JFrame implements ItemListener{
	//선언부
	JPanel	  jp_north		=	null;
	JComboBox jcb_top		=	null;
	JComboBox jcb_mid		=	null;
	JComboBox jcb_bottom	=	null;
	String		totals[]		= {"전체"};
	String		top      		= null;
	String		mid      		= null;
	String		bottom      		= null;
	String    	top_item[] 		= {"전체","가전","컴퓨터","모바일"};
	String 		mid_item0[] 	= {"전체","주방가전","생활가전","계절가전"};
	String 		mid_item1[] 	= {"전체","노트북","브랜드PC","모니터"};
	String 		mid_item2[] 	= {"전체","태블릿","휴대폰","스마트워치"};
	String 		bottom_item0[] 	= {"전체","냉장고","전기밥솥","에어프라이어"};
	String 		bottom_item1[] 	= {"전체","세탁기","옷건조기","청소기"};
	String 		bottom_item2[] 	= {"전체","온수매트","선풍기","에어컨"};
	//생성자
	public JComboBoxTest1() {
		jp_north	= new JPanel();
		//super("대중소분류 실습"); //super는 항상 생성자의 가장 처음에 와야한다.
		jcb_top		= new JComboBox(top_item);
		jcb_mid		= new JComboBox(totals);
		jcb_bottom	= new JComboBox(totals);
		initDisplay();
	}
	//화면 처리부
	public void initDisplay() {
		jcb_top.addItemListener(this);
		jcb_mid.addItemListener(this);
		jcb_bottom.addItemListener(this);
		jp_north.setBackground(Color.orange);
		jp_north.add(jcb_top);
		jp_north.add(jcb_mid);
		jp_north.add(jcb_bottom);
		this.add("North",jp_north);
		this.setTitle("대중소분류 실습");
		this.setSize(500,400);
		this.setVisible(true);
	}
	//메인메소드 선언
	public static void main(String[] args) {
		new JComboBoxTest1();//생성자를 경유하고 생성자에서 화면처리 메소드 호출해 보기 - 시점 문제에 대해 같이 고민.
	}
	//ItemListener라는 인터페이스에 정의된 추상메소드이다.
	//어떤 콤포넌트에 사용될지 모르므로 구현 할 수 없다.
	//따라서 구현체 클래스에서 재정의 하여 사용한다.
	//인터페이스는 보통 공통 메소드 정의하여 재사용성과 다형성을 지원함.
	//결합도를 낮추어 단위테스트를 통합테스트로 가능하게 하고 그러면서도 재사용성은 높임.
	@Override
	public void itemStateChanged(ItemEvent ie) {//콜백메소드이다.-시스템 레벨에서 이벤트가 감지 되었을 때 호출됨.
		//이벤트 감지된 컴포넌트의 주소번지를 얻는다.
		Object obj = ie.getSource();
		if(obj == jcb_top) {
			//if(ie.getStateChange() == 0) { 이렇게 쓰면 욕먹음
			if(ie.getStateChange() == ItemEvent.SELECTED) { //타입.속성명 - 하나다.
				top	=	top_item[jcb_top.getSelectedIndex()];//0:가전 1:컴터 2:모바일
				jcb_mid.removeAllItems();//기존에 totals에 있던 전체를 삭제하고 새로운 아이템으로 변경 준비
				if("가전".equals(top)) {
				//if(top.equals("가전")) 이렇게 안씀! 위와 같이 앞에다가 상수("가전"을 쓰고 뒤에다가 top)를 쓰는게 좋다
				//위에보면 top은 전역변수에서 null의 위험성을 가지고 있다. 그런데 앞에 "가전"을 쓰면 nullpointerExecption으로부터의 위험을 벗어날 수 있다.
					for(int i=0;i<mid_item0.length;i++) {
						jcb_mid.addItem(mid_item0[i]);
					}
					
				}
				else if("컴퓨터".equals(top)) {
					for(int i=0;i<mid_item1.length;i++) {
						jcb_mid.addItem(mid_item1[i]);
					}
					
				}
				else if("모바일".equals(top)) {
					for(int i=0;i<mid_item2.length;i++) {
						jcb_mid.addItem(mid_item2[i]);
					}
					
				}
			}
		}
		if(obj == jcb_mid) {
			if(ie.getStateChange() == ItemEvent.SELECTED) {
				mid	=	mid_item0[jcb_mid.getSelectedIndex()];
				jcb_bottom.removeAllItems();
				if("주방가전".equals(mid)) {
					for(int i=0;i<bottom_item0.length;i++) {
						jcb_bottom.addItem(bottom_item0[i]);
					}
					
				}
				else if("생활가전".equals(mid)) {
					for(int i=0;i<bottom_item1.length;i++) {
						jcb_bottom.addItem(bottom_item1[i]);
					}
					
				}
				else if("계절가전".equals(mid)) {
					for(int i=0;i<bottom_item2.length;i++) {
						jcb_bottom.addItem(bottom_item2[i]);
					}
					
				}
			}
		}
		if(obj == jcb_bottom) {
			
		}
  }
	

}
//설계시 -> 효율성을 높여야한다(결합도를 낮추면서 독립성을 높이는 것)
//추상 클래스 Duck.java 결합도가 높다.
//상속(extends)을 하면 결합도가 높기 때문에, duckd에다가 implements인터페이스하고 implements 안에다가 기능을 구현 시킨다.
//그 안에는 구현체가 필요하다 - 이걸 하는게 오버라이더(implements를 해주어야한다.)
//추상 클래스 + 인터페이스는 결합도를 낮춰준다. 확장성을 높여준다. 
//예를 들자, 서로다른 오리들이 오게 된다. 이게 바로 다형성이다.
//Duck myDuck = new WoodDuck(); 
//Duck himDuck = new RubberDuck();
//Duck herDuck = new MallardDuck();
//똑같은 메소드를 호출하더라도  어떤 구조체(우드덕,러버덕,청동덕 등등)가 오는가에 따라서 처리되는 부분이 다르다.
//myDuck.sound();
//himDuck.sound();
//herDuck.sound();
