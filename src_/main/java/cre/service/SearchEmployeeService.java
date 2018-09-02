package cre.service;

import java.util.List;

import cre.bo.EmployeeSearchBo;
import cre.bo.EmployeeSearchResultBo;

/**
 * 社員検索Service
 *
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