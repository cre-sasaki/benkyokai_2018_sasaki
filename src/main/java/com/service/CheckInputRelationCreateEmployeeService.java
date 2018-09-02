package com.service;

import com.bo.EmployeeCreateBo;

/**
 * 社員登録入力関連チェックService
 *
 * @author inoue
 *
 */
public interface CheckInputRelationCreateEmployeeService {

	/**
	 * 社員登録Boを設定します.
	 *
	 * @param employeeCreateBo 社員登録Bo
	 */
	public void setEmployeeSearchBo(EmployeeCreateBo employeeCreateBo);

	EmployeeCreateBo execute();
}
