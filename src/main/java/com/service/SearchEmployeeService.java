package com.service;

import java.util.List;

import com.bo.EmployeeSearchBo;
import com.bo.EmployeeSearchResultBo;

/**
 * 社員検索Service
 *
 * @author yamashiro
 *
 */
public interface SearchEmployeeService {

    /**
     * 社員検索Boを設定します（DI）.
     * @param employeeSearchBo 社員検索Bo
     */
    public void setEmployeeSearchBo(EmployeeSearchBo employeeSearchBo);

	List<EmployeeSearchResultBo> execute();
}
