package cre.service;

import java.util.List;

import cre.bo.SeibetsuBo;

/**
 * 性別マスタ取得Service
 *
 * @author yamashiro
 *
 */
public interface GetSeibetsuMasterService {

	 List<SeibetsuBo> execute();
}
