package com.base;

import variable.step1.A;
//public>protected>friendly>private
public class ATest {

	public static void main(String[] args) {
		A a = new A();
		//System.out.println("영어 : "+ a.eng);//에러가 남, eng가 friendly형태임
		//만약에 에러가 나기 싫다면, A.java에서 public double eng = 0;이라고 쓰면 됨.
	}

}
