package com.service;

import com.bo.EmployeeCreateBo;

/**
 * 社員登録DB関連チェックService
 *
 * @author inoue
 *
 */
public interface CheckDbRelationCreateEmployeeService {

	/**
	 * 社員登録Boを設定します.
	 *
	 * @param employeeCreateBo 社員登録Bo
	 */
	public void setEmployeeSearchBo(EmployeeCreateBo employeeCreateBo);

	EmployeeCreateBo execute();
}
