package cre.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import cre.bo.NenreiBo;

/**
 * 年齢計算ServiceImpl
 *
 * @author inoue
 */
@Service
public class CalculationAge2ServiceImpl implements CalculationAge2Service {

	/**
	 * 基準日
	 */
	private Date baseDate;

	/**
	 * 最小年齢
	 */
	private Integer minNenrei;

	/**
	 * 最大年齢
	 */
	private Integer maxNenrei;

	@Override
	public void setBaseDate(Date baseDate) {
		this.baseDate = baseDate;
	}

	@Override
	public void setMinNenrei(Integer minNenrei) {
		this.minNenrei = minNenrei;
	}

	@Override
	public void setMaxNenrei(Integer maxNenrei) {
		this.maxNenrei = maxNenrei;
	}

	@Override
	public NenreiBo execute() {

		NenreiBo nenreiBo = new NenreiBo();

		if (minNenrei != null && maxNenrei != null) {
			Calendar calendar1 = Calendar.getInstance();
			calendar1.setTime(baseDate);
			calendar1.add(Calendar.YEAR, -minNenrei);
			nenreiBo.setEndDate(calendar1.getTime());

			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(baseDate);
			calendar2.add(Calendar.YEAR, -(maxNenrei + 1));
			calendar2.add(Calendar.DAY_OF_MONTH, 1);
			nenreiBo.setStartDate(calendar2.getTime());
		} else if (minNenrei != null && maxNenrei == null) {
			Calendar calendar1 = Calendar.getInstance();
			calendar1.setTime(baseDate);
			calendar1.add(Calendar.YEAR, -(minNenrei + 1));
			calendar1.add(Calendar.DAY_OF_MONTH, 1);
			nenreiBo.setStartDate(calendar1.getTime());
		} else if (minNenrei == null && maxNenrei != null) {
			Calendar calendar1 = Calendar.getInstance();
			calendar1.setTime(baseDate);
			calendar1.add(Calendar.YEAR, -maxNenrei);
			calendar1.add(Calendar.DAY_OF_MONTH, 1);
			nenreiBo.setEndDate(calendar1.getTime());
		}

		return nenreiBo;
	}

}
