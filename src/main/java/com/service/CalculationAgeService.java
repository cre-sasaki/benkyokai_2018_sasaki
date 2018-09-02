package com.service;

import java.util.Date;

/**
 * 年齢計算Service
 *
 * @author inoue
 */
public interface CalculationAgeService {

	/**
	 * 基準日を設定します
	 *
	 * @param baseDate 基準日
	 */
	public void setBaseDate(Date baseDate);

	/**
	 * 生年月日を設定します
	 *
	 * @param seinengappi 生年月日
	 */
	public void setSeinengappi(Date seinengappi);

	Integer execute();
}
