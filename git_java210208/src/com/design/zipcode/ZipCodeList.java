package com.design.zipcode;

import java.util.List;
import java.util.Vector;
import java.awt.Frame; //구려서 잘 안씀.

/*
 * 자료구조의 종류
 * 1)List계열
 * 	 ArrayList - 싱글스레드 안전, 동기화 처리 생략, 속도 빠르다.
 *   vector - 멀티스레드 안전, 동기화 처리, 속도 느린편
 *   	: 경합, 다중 접속자 처리, 순서, 동기화 처리
 * 2)Map계열(해시태그)
 * 
 * 3)Set계열(빈도 낮음)
 */




public class ZipCodeList {

	public static void main(String[] args) {
		//꺽쇠<>: 제네릭이랑고 함. 생성부에는 타입이 없이 다이아몬드 <> 연산자만 붙임.
		Vector<ZipCodeVO> v  = new Vector<>();//다형성을 누릴 수 없다.
		List<ZipCodeVO>   v2 = new Vector<>();//다형성을 누린다.
		ZipCodeVO zcVO		= null;
		ZipCodeVO zcVOs[] 	= null;
		int i = 0;
		while(i<3) {
			//zcVO.setAddress("서울시 금천시 가산동"); --> NullpointException이다.
			zcVO = new ZipCodeVO();
			zcVO.setAddress("서울시 금천시 가산동");//NullpointException이 아니다. 위에 초기화 했기때문에.
			System.out.println("zcVO주소번지 바뀐다. ===>"+zcVO);
			System.out.println("zcVO주소번지 바뀐다. ===>"+zcVO.getAddress());
			v.add(zcVO);
			zcVO.setAddress("인천직할시");
			System.out.println("v주소번지랑 zcVO주소번지랑 같다.따라서 v주소도 \"인천직할시\"로 찍힌다.===>"+v.get(i).getAddress());
			v.get(i).setAddress("부산산산");
			System.out.println("zcVO주소번지 바뀐다. ===>"+zcVO.getAddress());
			i++;
		}
		for(int x=0;x<v.size();x++) {
			ZipCodeVO zVO = v.get(x);//31번에서 만들어진 VO와는 다른 것이다.
			System.out.println(zVO);//다른 주소번지가 출력된다.
		}
		zcVOs = new ZipCodeVO[v.size()];//객체배열이 3개 만들어 진다.
		System.out.println("배열의 크기는 "+zcVOs.length);//3이 출력됨.
		v.copyInto(zcVOs);//벡터에 담긴 것을 배열에 담아준다.
		for(int y=0;y<zcVOs.length;y++) {
			System.out.println(zcVOs[y]);//객체 배열의 주소번지가 3개 출력된다.
			System.out.println(zcVOs[y].getAddress());//객체 배열의 주소번지가 3개 출력된다.
			zcVOs[y].setAddress("경기도시시싯");
			System.out.println("주소번지가 같아서 다 똑같이 바뀐다.===>"+v.get(y).getAddress());
			System.out.println("zcVO주소번지는 3번째만을 가리키고 있으니까 ===>"+zcVO.getAddress());
		}
	}

}

//31번다음라인에서 vo의 address에 서울시 금천시 가산동을 초기화 하엿다.
//44번에서 객체배열의 출력햇을때 서울시 금천시 가산동일지 아닐지가 문제에요.
