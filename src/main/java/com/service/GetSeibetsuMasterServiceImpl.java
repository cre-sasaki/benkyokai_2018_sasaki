package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bo.SeibetsuBo;

/**
 * 性別マスタ取得ServiceImpl
 *
 * @author yamashiro
 *
 */
@Service
public class GetSeibetsuMasterServiceImpl implements GetSeibetsuMasterService {

	/**
	 * JdbcTemplate
	 */
    @Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public List<SeibetsuBo> execute(){

		List<Map<String, Object>> list = jdbcTemplate.queryForList(
				"select SEIBETSU_CD, SEIBETSU_NM from M_SEIBETSU where DELETE_FLG = '0'");

		List<SeibetsuBo> seibetsuBoList = new ArrayList<SeibetsuBo>();

		for (Map<String, Object> map : list) {
			SeibetsuBo seibetsuBo = new SeibetsuBo();
			seibetsuBo.setSeibetsuCd((String) map.get("SEIBETSU_CD"));
			seibetsuBo.setSeibetsuNm((String) map.get("SEIBETSU_NM"));
			seibetsuBoList.add(seibetsuBo);
		}

		return seibetsuBoList;

	}
}
