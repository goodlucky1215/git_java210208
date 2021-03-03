package com.pattern;

import java.util.Vector;

import com.vo.DeptVO;
import com.vo.EmpVO;

public class SalaryMgrLogic1 {
	SalaryMgrHandler1 handle = null;
	public SalaryMgrLogic1(SalaryMgrHandler1 handle) {
		this.handle = handle ;
	}

	public void getEmpDetail(int pempno) {
		EmpVO  eVO = new EmpVO();
		eVO.setEname("김유신");
		DeptVO dVO = new DeptVO();
		dVO.setDname("개발10팀");
		eVO.setdVO(dVO);
		Vector oneRow = new Vector();
		oneRow.addElement(eVO.getEname());
		oneRow.addElement(eVO.getdVO().getDname());//얘도 중요********
		handle.smView.dtm_sal.addRow(oneRow);
	}
}
