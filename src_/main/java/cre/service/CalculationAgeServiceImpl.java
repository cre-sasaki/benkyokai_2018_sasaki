package cre.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

/**
 * 年齢計算ServiceImpl
 *
 * @author inoue
 */
@Service
public class CalculationAgeServiceImpl implements CalculationAgeService {

	/**
	 * 基準日
	 */
	private Date baseDate;

	/**
	 * 生年月日
	 */
	private Date seinengappi;

	@Override
	public void setBaseDate(Date baseDate) {
		this.baseDate = baseDate;
	}

	@Override
	public void setSeinengappi(Date seinengappi) {
		this.seinengappi = seinengappi;
	}

	@Override
	public Integer execute() {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	    return (Integer.parseInt(sdf.format(baseDate)) - Integer.parseInt(sdf.format(seinengappi))) / 10000;
	}

}
