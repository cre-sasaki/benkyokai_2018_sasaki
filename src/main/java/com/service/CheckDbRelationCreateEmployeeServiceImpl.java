package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bo.EmployeeCreateBo;

/**
 * 社員登録DB関連チェックServiceImpl
 *
 * @author inoue
 *
 */
@Service
public class CheckDbRelationCreateEmployeeServiceImpl implements CheckDbRelationCreateEmployeeService {

	/**
	 * JdbcTemplate
	 */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 社員登録Bo
     */
    private EmployeeCreateBo employeeCreateBo;

	@Override
	public void setEmployeeSearchBo(EmployeeCreateBo employeeCreateBo) {
		this.employeeCreateBo = employeeCreateBo;
	}

	@Override
	public EmployeeCreateBo execute() {

		if (employeeCreateBo.isNewCreateFlg()) {
			// 遷移元画面の新規登録ボタンから遷移した場合、かつ社員番号がすでに登録されている場合、エラー
			List<Map<String, Object>> list = jdbcTemplate.queryForList(
					"select EMPLOYEE_NO from T_EMPLOYEE where DELETE_FLG = '0'");

			for (Map<String, Object> map : list) {
				if (employeeCreateBo.getShainNo().equals((String) map.get("EMPLOYEE_NO"))) {
					employeeCreateBo.setErrorMessage("入力された社員番号はすでに登録されています。");
					return employeeCreateBo;
				}
			}
		} else {
			// 引き継ぎ項目.宛名バージョンとDBの宛名バージョンが異なる場合、エラー
			int count = jdbcTemplate.queryForObject("select count(1) from T_ATENA where T_ATENA_PK = "
					+ employeeCreateBo.getAtenaPk() +
					" and VERSION = " + employeeCreateBo.getAtenaVersion() + " and DELETE_FLG = '0'", Integer.class);
			if (count == 0) {
				employeeCreateBo.setErrorMessage("楽観ロックエラーです。");
			}
		}

		return employeeCreateBo;

	}
}
