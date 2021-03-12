package com.design.zipcode;

import java.util.ArrayList;
import java.util.Scanner;

//import design2020.book.MemberShip;
//import oracle.jdbc2.ZipCodeVO;

public class ZipCodeSearchConsole {
   //선언부
   String zdo = null;
   //생성자
   public ZipCodeSearchConsole() {

   }
   //조회된 우편번호 출력하기
   public void printZipCode(ArrayList<ZipCodeVO> zipCode) {
      for(ZipCodeVO zcVO:zipCode) {
         System.out.println(zcVO.getAddress()+", "+zcVO.getAddress());
      }
   }
   //사용자로부터 동을 입력 받는 메소드를 구현하시오 - 도스창에서 입력받는다.
   public String userInput() {
      String userDong = null;
      Scanner scan = new Scanner(System.in);
      userDong = scan.nextLine();
      return userDong;
   }
   //메인메소드
   public static void main(String[] args) {
      System.out.println("동을 입력하세요");
      String userDong = null;
      ZipCodeSearchConsole zcs = new ZipCodeSearchConsole();
      userDong = zcs.userInput();
      ZipCodeDao zcDao = new ZipCodeDao();
      ArrayList<ZipCodeVO> al = zcDao.getZipCodeList(userDong);
      zcs.printZipCode(al);
   }
   
   public void refreshData(String zdo, String dong) {
      System.out.println("zdo:"+zdo+", dong:"+dong);
      try {

         
      }  catch (Exception e) {
         System.out.println(e.toString());         
      }
      
   }
}