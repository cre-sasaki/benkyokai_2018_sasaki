package cre.form;

import java.util.List;

import cre.bo.EmployeeSearchResultBo;

/** 社員検索結果Form **/
public class EmployeeSearchResultForm {

	/** 社員検索結果Boリスト **/
	private List<EmployeeSearchResultBo> employeeSearchResultBoList;

	/**
	 * 社員検索結果Boリストを取得します。
	 *
	 * @return employeeSearchResultBoList
	 */
	public List<EmployeeSearchResultBo> getEmployeeSearchResultBoList() {
		return employeeSearchResultBoList;
	}

	/**
	 * 社員検索結果Boリストを設定します。
	 *
	 * @param employeeSearchResultBoList 社員検索結果Boリスト
	 */
	public void setEmployeeSearchResultBoList(List<EmployeeSearchResultBo> employeeSearchResultBoList) {
		this.employeeSearchResultBoList = employeeSearchResultBoList;
	}
}
