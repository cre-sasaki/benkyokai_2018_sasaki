package com.service;

import java.util.List;

import com.bo.SeibetsuBo;

/**
 * 性別マスタ取得Service
 *
 * @author yamashiro
 *
 */
public interface GetSeibetsuMasterService {

	 List<SeibetsuBo> execute();
}
