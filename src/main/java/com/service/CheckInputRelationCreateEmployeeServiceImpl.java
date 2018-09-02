package com.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bo.EmployeeCreateBo;

/**
 * 社員登録入力関連チェックServiceImpl
 *
 * @author inoue
 *
 */
@Service
public class CheckInputRelationCreateEmployeeServiceImpl implements CheckInputRelationCreateEmployeeService {

    /**
     * 社員登録Bo
     */
    private EmployeeCreateBo employeeCreateBo;

	@Override
	public void setEmployeeSearchBo(EmployeeCreateBo employeeCreateBo) {
		this.employeeCreateBo = employeeCreateBo;
	}

	@Override
	public EmployeeCreateBo execute() {

		// 生年月日が実在しない年月日の場合、エラー
		if (!StringUtils.isEmpty(employeeCreateBo.getSeinengappi())) {
			DateFormat format=new SimpleDateFormat("yyyyMMdd");
			try {
			    format.setLenient(false);
			    format.parse(employeeCreateBo.getSeinengappi());
			} catch (ParseException e) {
				employeeCreateBo.setErrorMessage("生年月日は実在する年月日を入力してください。");
			}
		}

		return employeeCreateBo;
	}
}
