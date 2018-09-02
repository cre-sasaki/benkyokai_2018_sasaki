package com.service;

import java.util.List;

import com.bo.YakushokuBo;

/**
 * 役職マスタ取得Service
 *
 * @author yamashiro
 *
 */
public interface GetYakushokuMasterService {

	 List<YakushokuBo> execute();
}
