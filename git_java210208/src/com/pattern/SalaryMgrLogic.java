package com.pattern;

import java.util.Vector;

import com.vo.DeptVO;
import com.vo.EmpVO;

public class SalaryMgrLogic {
	SalaryMgrView smView = null;
	public SalaryMgrLogic(SalaryMgrView salaryMgrView) {
		this.smView = salaryMgrView;
	}

	public void getEmpDetail(int pempno) {
		EmpVO  eVO = new EmpVO();
		eVO.setEname("김유신");
		DeptVO dVO = new DeptVO();
		dVO.setDname("개발1팀");
		eVO.setdVO(dVO);
		Vector oneRow = new Vector();
		oneRow.addElement(eVO.getEname());
		oneRow.addElement(eVO.getdVO().getDname());//얘도 중요********
		smView.dtm_sal.addRow(oneRow);
	}
}
