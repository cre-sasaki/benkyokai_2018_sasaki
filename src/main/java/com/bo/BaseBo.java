package com.bo;

/** 社員登録Bo **/
public class BaseBo {

	/** エラーフィールド **/
	private String errorField;

	/** エラーメッセージ **/
	private String errorMessage;

	/**
	 * エラーフィールドを取得します。
	 *
	 * @return shainNo
	 */
	public String getErrorField() {
		return errorField;
	}

	/**
	 * エラーフィールドを設定します。
	 *
	 * @param shainNo 社員番号
	 */
	public void setErrorField(String errorField) {
		this.errorField = errorField;
	}

	/**
	 * エラーメッセージを取得します。
	 *
	 * @return shainNo
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * エラーメッセージを設定します。
	 *
	 * @param shainNo 社員番号
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
