package cre.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cre.bo.EmployeeSearchBo;
import cre.bo.EmployeeSearchResultBo;

/**
 * 社員検索ServiceImpl
 *
 *
 */
@Service
public class SearchEmployeeServiceImpl implements SearchEmployeeService {

	/**
	 * JdbcTemplate
	 */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 社員検索Bo
     */
    private EmployeeSearchBo employeeSearchBo;

    /**
     * 社員検索Boを設定します（DI）.
     * @param employeeSearchBo 社員検索Bo
     */
    public void setEmployeeSearchBo(EmployeeSearchBo employeeSearchBo) {
        this.employeeSearchBo = employeeSearchBo;
    }

	@Override
	public List<EmployeeSearchResultBo> execute(){

		List<Map<String, Object>> list = jdbcTemplate.queryForList(getSql(employeeSearchBo));

		List<EmployeeSearchResultBo> employeeSearchResultBoList = new ArrayList<EmployeeSearchResultBo>();

		for (Map<String, Object> map : list) {
			EmployeeSearchResultBo employeeSearchResultBo = new EmployeeSearchResultBo();
			employeeSearchResultBo.setTAtenaPk((Integer) map.get("T_ATENA_PK"));
			employeeSearchResultBo.setTEmployeePk((Integer) map.get("T_EMPLOYEE_PK"));
			employeeSearchResultBo.setEmployeeNo((String) map.get("EMPLOYEE_NO"));
			employeeSearchResultBo.setShimei((String) map.get("SHIMEI"));
			employeeSearchResultBo.setShimeiKana((String) map.get("SHIMEI_KANA"));
			employeeSearchResultBo.setYakushokuNm((String) map.get("YAKUSHOKU_NM"));
			employeeSearchResultBo.setSeibetsuNm((String) map.get("SEIBETSU_NM"));
			employeeSearchResultBo.setSeinengappi((String) map.get("SEINENGAPPI"));
			employeeSearchResultBo.setNyushabi((String) map.get("NYUSHA_DT"));
			employeeSearchResultBo.setTaishokubi((String) map.get("TAISHOKU_DT"));
			employeeSearchResultBo.setProjectNm((String) map.get("PROJECT_NM"));
			employeeSearchResultBo.setKeiyakuNm((String) map.get("KEIYAKU_NM"));
			employeeSearchResultBoList.add(employeeSearchResultBo);
		}

		return employeeSearchResultBoList;
	}

	/**
	 * SQL取得処理
	 */
	private String getSql(EmployeeSearchBo employeeSearchBo) {
		StringBuilder sb = new StringBuilder();
		String sql = null;
		sql = "select a.T_ATENA_PK AS T_ATENA_PK "
				+ ",e.T_EMPLOYEE_PK AS T_EMPLOYEE_PK "
				+ ",e.EMPLOYEE_NO AS EMPLOYEE_NO "
				+ ",a.SHIMEI AS SHIMEI "
				+ ",a.SHIMEI_KANA AS SHIMEI_KANA "
				+ ",my.YAKUSHOKU_NM AS YAKUSHOKU_NM "
				+ ",ms.SEIBETSU_NM AS SEIBETSU_NM "
				+ ",mk.KEIYAKU_NM AS KEIYAKU_NM "
				+ ",a.SEINENGAPPI AS SEINENGAPPI "
				+ ",e.NYUSHA_DT AS NYUSHA_DT "
				+ ",e.TAISHOKU_DT AS TAISHOKU_DT "
				+ ",e.PROJECT_NM AS PROJECT_NM "
				+ " from T_ATENA a "
				+ " INNER JOIN T_EMPLOYEE e ON a.T_ATENA_PK = e.T_ATENA_PK "
				+ " INNER JOIN M_YAKUSHOKU my ON e.YAKUSHOKU_CD = my.YAKUSHOKU_CD "
				+ " INNER JOIN M_SEIBETSU ms ON a.SEIBETSU_CD = ms.SEIBETSU_CD "
				+ " INNER JOIN M_KEIYAKU mk ON e.KEIYAKU_CD = mk.KEIYAKU_CD "
				+ "where ";
		sb.append(sql);

		// 社員検索Boに氏名かなが設定されている場合
		if(employeeSearchBo.getShimeiKana() != null && !employeeSearchBo.getShimeiKana().isEmpty()){
			// 氏名かなをSQLの検索条件に追加
			sb.append("a.SHIMEI_KANA = '" + employeeSearchBo.getShimeiKana() + "' AND ");
		}

		// 社員検索Boに役職が設定されている場合
		if (employeeSearchBo.getYakushokuCd() != null && !employeeSearchBo.getYakushokuCd().isEmpty()) {
			// 役職をSQLの検索条件に追加
			sb.append("e.YAKUSHOKU_CD = '" + employeeSearchBo.getYakushokuCd() + "' AND ");
		}

		// 社員検索Boに生年月日が設定されている場合
		if (employeeSearchBo.getSeinengappi() != null && !employeeSearchBo.getSeinengappi().isEmpty()) {
			// 生年月日をSQLの検索条件に追加
			sb.append("a.SEINENGAPPI = '" + employeeSearchBo.getSeinengappi() + "' AND ");
		}

		// 社員検索Boに性別が設定されている場合
		if(employeeSearchBo.getSeibetsuCd() != null && !employeeSearchBo.getSeibetsuCd().isEmpty()){
			// 性別をSQLの検索条件に追加
			sb.append("a.SEIBETSU_CD = '" + employeeSearchBo.getSeibetsuCd() + "' AND ");
		}

		// 社員検索Boに契約社員フラグが設定されている場合
		if(employeeSearchBo.getKeiyakuEmployeeKbn() != null && !employeeSearchBo.getKeiyakuEmployeeKbn().isEmpty()){
			if(employeeSearchBo.getKeiyakuEmployeeKbn().equals("0")){
				// 契約社員フラグをSQLの検索条件に追加
				sb.append("e.KEIYAKU_CD in ('1', '3') AND ");
			}

		}

		// 削除フラグの条件を追加
		sb.append("a.DELETE_FLG = '0' AND "
				+ "e.DELETE_FLG = '0' AND "
				+ "my.DELETE_FLG = '0' AND "
				+ "ms.DELETE_FLG = '0'"
				+ "order by ");
		switch(employeeSearchBo.getSort()){
		case "1":
			sb.append("e.EMPLOYEE_NO asc");
			break;
		case "2":
			sb.append("e.EMPLOYEE_NO desc");
			break;
		case "3":
			sb.append("a.SHIMEI_KANA asc");
			break;
		case "4":
			sb.append("a.SHIMEI_KANA desc");
			break;
		}

		return sb.toString();

	}
}

