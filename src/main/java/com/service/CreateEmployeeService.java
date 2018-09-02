package com.service;

import com.bo.EmployeeCreateBo;

/**
 * 社員登録Service
 *
 * @author inoue
 *
 */
public interface CreateEmployeeService {

	/**
	 * 社員登録Boを設定します.
	 *
	 * @param employeeCreateBo 社員登録Bo
	 */
	public void setEmployeeSearchBo(EmployeeCreateBo employeeCreateBo);

	void execute();
}
