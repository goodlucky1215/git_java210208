package di.step1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InsaMain {

	public static void main(String[] args) {
		//ClassPathXmlApplicationContext는 ApplicationContext의 구현체 클래스임.
		//생성자의 파라미터로 xml문서를 스캔함.
		ApplicationContext context2 = new ClassPathXmlApplicationContext("di\\step1\\insaBean.xml");
		InsaList insa = (InsaList)context2.getBean("insaaaa");
		//insaBean.xml에 있는 id를 getBean안에 넣어준다.그러면  insaBean.xml에 있는 class인식하고, 그 class가 InsaList이니까.
		//내가 getBean니깐 get으로 값을 꺼내겠지. 그러면 먼저 set으로 값을 받아야하는데 그 역할을 InsaList에 있는 setInsaBean이 한다.
		//그리고 setInsaBean에 들어있는 값이 바로 이 property에서 가져가서 set을한다.
		/*
		<property name="insaBean">
		<list>
			<value>Hi!!!!</value>
			<value>Have a good time!!!!</value>
			<value>Have a nice day!!!!</value>
		</list>
		</property>
		*/
		
		//다시 정리하자면
		//getBeanㅇ
		System.out.println(insa.insaBeann);
		for(String s:insa.insaBeann) {
			System.out.println(s);
		}
		InsaList insa2= new InsaList();
		System.out.println(insa2.insaBeann);
	}


}
