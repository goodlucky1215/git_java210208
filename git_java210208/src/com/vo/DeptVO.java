package com.vo;
//오라클과 자바의 만남
//이것을 이어야 됨. - 둘의 연결고리
//VO패턴 - 데이터의 영속성을 유지해주는 오라클 서버 제품과 연결하기
//Data관리 목적 - 모든 집합의 이름 뒤에 접미어로 VO붙임 - VO를 붙이면 무조건 데이터를 의미한다는 것임.
//메인메소드는 필요없다. 단독으로 실행하지 않기때문임.
/*
 * Number(2) - 정수형, 담을 수 있는 최대 크기는 99까지 임계값 
 * 			 - 자바에서는 int(4byte), long(8byte)으로 받음
 * 
 * varchar2(4000) - string
 * VO패턴을 사용하면 한꺼번에 3가지 종류[부서번호, 부서명, 지역]의 값을 관리 가능함.
 * VO패턴이 여러 종류의 테이블을 관리하는 게 맞으나, 로우(가로방향)는 한번에 한개 로우만 가능하다.
 * 서버 자체는 항상 동시에 여러사람이 접속할 수 있다.
 * 이 여러사람을 따로 관리할 수 있어야 하겠다. - Thread공부 - 너가 직접 서버를 운영할 수 있는 코딩 보여줌.
 * <인스턴스화 하는 이유>
 * DeptVO dvo = new DeptVO();
 * dvo = new DeptVO();
 * 이것은 합법인가?
 * 어떻게 다른걸까?
 * 어떤 방법이 더 좋은걸까?
 * 언제 저렇게 써야 하나?
 */
public class DeptVO {
	//생성자
	//public DeptVO(int deptno,String dname,String loc) {
	//	this.setDeptno(deptno);
	//	this.setDname(dname);
	//	this.setLoc(loc);
	//}
	
	private int     deptno = 0; //원시형 타입 - 부르면 값이 나온다. 4byte이니까 229540 229544 229548 ....
	private String  dname  = null;//레퍼런스 타입 - 클래스 급이다. - 값이 아니라 주소번지가 나옴. 영업부 출력되지 않나요? 네 예외죠. 돌연변이
	private String  loc    = null;
	
	//getter메소드 - Read : 반환값이 있다.
	public int getDeptno() {
		return deptno;
	}
	//setter메소드 - Write, Save : 반환값이 없다. 대신 parameter가 존재함.
	public void setDeptno(int deptno) {
		//deptno = 30; // 상수, 재사용성이 떨어짐.
		//this는 나 자신을 가리키는 수정자 이다. 여기서는 지변과 식별을 위해 사용하였다. 생략할 수 있다. 그런데 헷갈린다.
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) { //지변
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
}
