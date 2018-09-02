package cre.service;

import java.util.List;

import cre.bo.YakushokuBo;

/**
 * 役職マスタ取得Service
 *
 * @author yamashiro
 *
 */
public interface GetYakushokuMasterService {

	 List<YakushokuBo> execute();
}
