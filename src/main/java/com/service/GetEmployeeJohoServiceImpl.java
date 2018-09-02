package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bo.EmployeeCreateBo;

/**
 * 社員情報取得ServiceImpl
 *
 * @author yamashiro
 *
 */
@Service
public class GetEmployeeJohoServiceImpl implements GetEmployeeJohoService {

	/**
	 * JdbcTemplate
	 */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 社員登録Bo
     */
    private EmployeeCreateBo employeeCreateBo;

    /**
     * 社員検索Boを設定します（DI）.
     * @param employeeCreateBo 社員検索Bo
     */
    public void setEmployeeCreateBo(EmployeeCreateBo employeeCreateBo) {
        this.employeeCreateBo = employeeCreateBo;
    }

	@Override
	public EmployeeCreateBo execute(){

		List<Map<String, Object>> list = jdbcTemplate.queryForList(getSql(employeeCreateBo));

		EmployeeCreateBo employeeCreateBo = new EmployeeCreateBo();

		for (Map<String, Object> map : list) {
			employeeCreateBo.setAtenaPk((Integer) map.get("T_ATENA_PK"));
			employeeCreateBo.setAtenaVersion((Integer) map.get("ATENA_VERSION"));
			employeeCreateBo.setShainNo((String) map.get("EMPLOYEE_NO"));
			employeeCreateBo.setShimeiKana((String) map.get("SHIMEI_KANA"));
			employeeCreateBo.setShimei((String) map.get("SHIMEI"));
			employeeCreateBo.setSeinengappi((String) map.get("SEINENGAPPI"));
			employeeCreateBo.setSeibetsuCd((String) map.get("SEIBETSU_CD"));
			employeeCreateBo.setKeiyakuEmployeeKbn((String) map.get("KEIYAKU_CD"));
			employeeCreateBo.setYakushokuCd((String) map.get("YAKUSHOKU_CD"));
			employeeCreateBo.setEmployeeVersion((Integer) map.get("EMPLOYEE_VERSION"));
		}
		return employeeCreateBo;
	}

	/**
	 * SQL取得処理
	 */
	private String getSql(EmployeeCreateBo employeeCreateBo) {
		StringBuilder sb = new StringBuilder();
		String sql = null;
		sql = "select a.T_ATENA_PK AS T_ATENA_PK "
				+ ",a.VERSION AS ATENA_VERSION "
				+ ",e.EMPLOYEE_NO AS EMPLOYEE_NO "
				+ ",a.SHIMEI_KANA AS SHIMEI_KANA "
				+ ",a.SHIMEI AS SHIMEI "
				+ ",a.SEINENGAPPI AS SEINENGAPPI "
				+ ",a.SEIBETSU_CD AS SEIBETSU_CD "
				+ ",e.KEIYAKU_CD AS KEIYAKU_CD "
				+ ",e.YAKUSHOKU_CD AS YAKUSHOKU_CD "
				+ ",e.VERSION AS EMPLOYEE_VERSION "
				+ " from T_ATENA a "
				+ " INNER JOIN T_EMPLOYEE e ON a.T_ATENA_PK = e.T_ATENA_PK "
				+ "where a.T_ATENA_PK = ";
		sb.append(sql);
		sb.append(employeeCreateBo.getAtenaPk());
		sb.append(" AND a.DELETE_FLG = '0' AND " + "e.DELETE_FLG = '0'");
		return sb.toString();

	}
}
