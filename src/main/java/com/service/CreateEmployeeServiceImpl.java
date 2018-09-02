package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bo.EmployeeCreateBo;

/**
 * 社員登録ServiceImpl
 *
 * @author inoue
 *
 */
@Service
public class CreateEmployeeServiceImpl implements CreateEmployeeService {

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
	public void execute() {

		if(employeeCreateBo.isNewCreateFlg()){
			// 新規登録の場合
			jdbcTemplate.update("INSERT INTO T_ATENA VALUES(?, ?, ?, ?, ?, ?,?)",
					null,
					employeeCreateBo.getShimeiKana(),
					employeeCreateBo.getShimei(),
					employeeCreateBo.getSeibetsuCd(),
					employeeCreateBo.getSeinengappi(),
					"0",
					1);

			int maxid = jdbcTemplate.queryForObject("select max(T_ATENA_PK) from T_ATENA", Integer.class);

			jdbcTemplate.update("INSERT INTO T_EMPLOYEE VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
					null,
					maxid,
					employeeCreateBo.getShainNo(),
					null,
					null,
					employeeCreateBo.getKeiyakuEmployeeKbn(),
					employeeCreateBo.getYakushokuCd(),
					null,
					null,
					"0",
					1);
		} else {
			// 更新の場合
			jdbcTemplate.update("UPDATE T_ATENA SET SHIMEI_KANA=?, SHIMEI=?, SEIBETSU_CD=?, SEINENGAPPI=?, VERSION=? WHERE T_ATENA_PK=?" ,
					employeeCreateBo.getShimeiKana(),
					employeeCreateBo.getShimei(),
					employeeCreateBo.getSeibetsuCd(),
					employeeCreateBo.getSeinengappi(),
					employeeCreateBo.getAtenaVersion() + 1,
					employeeCreateBo.getAtenaPk()
					);

			jdbcTemplate.update("UPDATE T_EMPLOYEE SET KEIYAKU_CD=?, YAKUSHOKU_CD=?, VERSION=? WHERE T_ATENA_PK=?",
					employeeCreateBo.getKeiyakuEmployeeKbn(),
					employeeCreateBo.getYakushokuCd(),
					employeeCreateBo.getEmployeeVersion() + 1,
					employeeCreateBo.getAtenaPk()
					);
		}


	}
}
