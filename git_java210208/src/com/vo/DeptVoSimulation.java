package com.vo;

public class DeptVoSimulation {
	void methodB() { //반환값이 전혀 역할을 못함.
		
	}
	DeptVO methodA() { //반환값이 3가지가 가능함.
		return new DeptVO();
	}
	DeptVO[] methodC() { //반환값이 3가지가 가능함.
		return new DeptVO[3];
	}
	
	public static void main(String[] args) {
		//생성자 : DeptVO dvo = new DeptVO(50, "사업부","Se");
		DeptVO dvo= new DeptVO();
		//위치 - 어디서 호출해야 할까요>
		//insert here => 1
		dvo.setDeptno(30); // (o) Question-생성자로 처리해 보시오. 1-2 API활용능력, 배운거만 쓰지 않음!!
		//int x=dvo.setDeptno(30); //(x) why? void라서 return타입이 없음.
		//dvo.setDname("영업부");
		int myDeptNo   = dvo.getDeptno(); //0출력
		//insert here - 부서번호 30을 출력하도록 코드를 추가하시오.
		String myDname = dvo.getDname(); //null
		String myLoc   = dvo.getLoc(); //null
		System.out.println(myDeptNo); //30
		//System.out.println(myDname);
		//System.out.println(myLoc);
		dvo = new DeptVO();
		dvo.setDeptno(300);
		myDeptNo = dvo.getDeptno();
		
	}

}
