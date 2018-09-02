package cre.service;

import java.util.Date;

import cre.bo.NenreiBo;

/**
 * 年齢計算Service
 *
 * @author inoue
 */
public interface CalculationAge2Service {

	/**
	 * 基準日を設定します
	 *
	 * @param baseDate 基準日
	 */
	public void setBaseDate(Date baseDate);

	/**
	 * 最小年齢を設定します
	 *
	 * @param minNenrei 最小年齢
	 */
	public void setMinNenrei(Integer minNenrei);

	/**
	 * 最大年齢を設定します
	 *
	 * @param maxNenrei 最大年齢
	 */
	public void setMaxNenrei(Integer maxNenrei);

	NenreiBo execute();
}
