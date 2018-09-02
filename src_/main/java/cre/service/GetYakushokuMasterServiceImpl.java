package cre.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cre.bo.YakushokuBo;

/**
 * 役職マスタ取得ServiceImpl
 *
 * @author yamashiro
 *
 */
@Service
public class GetYakushokuMasterServiceImpl implements GetYakushokuMasterService {

	/**
	 * JdbcTemplate
	 */
    @Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public List<YakushokuBo> execute(){

		List<Map<String, Object>> list = jdbcTemplate.queryForList(
				"select YAKUSHOKU_CD, YAKUSHOKU_NM from M_YAKUSHOKU where DELETE_FLG = '0'");

		List<YakushokuBo> yakushokuBoList = new ArrayList<YakushokuBo>();

		for (Map<String, Object> map : list) {
			YakushokuBo yakushokuBo = new YakushokuBo();
			yakushokuBo.setYakushokuCd((String) map.get("YAKUSHOKU_CD"));
			yakushokuBo.setYakushokuNm((String) map.get("YAKUSHOKU_NM"));
			yakushokuBoList.add(yakushokuBo);
		}

		return yakushokuBoList;
	}
}
