package com.service;

import com.bo.EmployeeCreateBo;

/**
 * 社員情報取得Service
 *
 * @author yamashiro
 *
 */
public interface GetEmployeeJohoService {

    /**
     * 社員検索Boを設定します（DI）.
     * @param employeeSearchBo 社員検索Bo
     */
    public void setEmployeeCreateBo(EmployeeCreateBo employeeCreateBo);

	EmployeeCreateBo execute();
}
