package com.form;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

/** 社員登録Form **/
public class EmployeeCreateForm {

	/** 宛名PK **/
	private int atenaPk;

	/** 宛名バージョン **/
	private int atenaVersion;

	/** 社員番号 **/
	@NotEmpty(message = "社員番号は必ず選択してください。")
	private String shainNo;

	/** 氏名かな **/
	@NotEmpty(message = "氏名かなは必ず選択してください。")
	private String shimeiKana;

	/** 氏名 **/
	@NotEmpty(message = "氏名は必ず選択してください。")
	private String shimei;

	/** 生年月日 **/
	private String seinengappi;

	/** 性別コード **/
	private String seibetsuCd;

	/** 性別コードリスト **/
	private List<String> seibetsuCdList;

	/** 性別名称リスト **/
	private List<String> seibetsuNmList;

	/** 契約社員区分 **/
	private String keiyakuEmployeeKbn;

	/** 社員バージョン **/
	private Integer employeeVersion;

	/** 役職コード **/
	private String yakushokuCd;

	/** 役職コードリスト **/
	private List<String> yakushokuCdList;

	/** 役職名称リスト **/
	private List<String> yakushokuNmList;

	/** エラーメッセージ **/
	private String errorMessage;

	/** 新規登録フラグ **/
	private boolean newCreateFlg;

	/**
	 * 宛名PKを取得します。
	 *
	 * @return atenaPk
	 */
	public int getAtenaPk() {
		return atenaPk;
	}

	/**
	 * 宛名PKを設定します。
	 *
	 * @param atenaPk 宛名PK
	 */
	public void setAtenaPk(int atenaPk) {
		this.atenaPk = atenaPk;
	}

	/**
	 * 宛名バージョンを取得します。
	 *
	 * @return atenaVersion
	 */
	public int getAtenaVersion() {
		return atenaVersion;
	}

	/**
	 * 宛名バージョンを設定します。
	 *
	 * @param atenaVersion 宛名バージョン
	 */
	public void setAtenaVersion(Integer atenaVersion) {
		this.atenaVersion = atenaVersion;
	}

	/**
	 * 社員番号を取得します。
	 *
	 * @return shainNo
	 */
	public String getShainNo() {
		return shainNo;
	}

	/**
	 * 社員番号を設定します。
	 *
	 * @param shainNo 社員番号
	 */
	public void setShainNo(String shainNo) {
		this.shainNo = shainNo;
	}

	/**
	 * 氏名かなを取得します。
	 *
	 * @return shimeiKana
	 */
	public String getShimeiKana() {
		return shimeiKana;
	}

	/**
	 * 氏名かなを設定します。
	 *
	 * @param shimeiKana 氏名かな
	 */
	public void setShimeiKana(String shimeiKana) {
		this.shimeiKana = shimeiKana;
	}

	/**
	 * 氏名を取得します。
	 *
	 * @return shimei
	 */
	public String getShimei() {
		return shimei;
	}

	/**
	 * 氏名を設定します。
	 *
	 * @param shimei 氏名
	 */
	public void setShimei(String shimei) {
		this.shimei = shimei;
	}

	/**
	 * 生年月日を取得します。
	 *
	 * @return seinengappi
	 */
	public String getSeinengappi() {
		return seinengappi;
	}

	/**
	 * 生年月日を設定します。
	 *
	 * @param seinengappi 生年月日
	 */
	public void setSeinengappi(String seinengappi) {
		this.seinengappi = seinengappi;
	}

	/**
	 * 性別コードを取得します。
	 *
	 * @return seibetsuCd
	 */
	public String getSeibetsuCd() {
		return seibetsuCd;
	}

	/**
	 * 性別コードを設定します。
	 *
	 * @param seibetsuCd 役職コード
	 */
	public void setSeibetsuCd(String seibetsuCd) {
		this.seibetsuCd = seibetsuCd;
	}

	/**
	 * 性別コードリストを取得します。
	 *
	 * @return seibetsuCdList
	 */
	public List<String> getSeibetsuCdList() {
		return seibetsuCdList;
	}

	/**
	 * 性別コードリストを設定します。
	 *
	 * @param seibetsuCdList 性別コードリスト
	 */
	public void setSeibetsuCdList(List<String> seibetsuCdList) {
		this.seibetsuCdList = seibetsuCdList;
	}

	/**
	 * 性別名称リストを取得します。
	 *
	 * @return seibetsuNmList
	 */
	public List<String> getSeibetsuNmList() {
		return seibetsuNmList;
	}

	/**
	 * 性別名称リストを設定します。
	 *
	 * @param seibetsuNmList 性別名称リスト
	 */
	public void setSeibetsuNmList(List<String> seibetsuNmList) {
		this.seibetsuNmList = seibetsuNmList;
	}

	/**
	 * 契約社員区分を取得します。
	 *
	 * @return keiyakuEmployeeKbn
	 */
	public String getKeiyakuEmployeeKbn() {
		return keiyakuEmployeeKbn;
	}

	/**
	 * 契約社員区分を設定します。
	 *
	 * @param keiyakuEmployeeKbn 契約社員区分
	 */
	public void setKeiyakuEmployeeKbn(String keiyakuEmployeeKbn) {
		this.keiyakuEmployeeKbn = keiyakuEmployeeKbn;
	}

	/**
	 * 社員バージョンを取得します。
	 *
	 * @return employeeVersion
	 */
	public Integer getEmployeeVersion() {
		return employeeVersion;
	}

	/**
	 * 社員バージョンを設定します。
	 *
	 * @param employeeVersion 社員バージョン
	 */
	public void setEmployeeVersion(Integer employeeVersion) {
		this.employeeVersion = employeeVersion;
	}

	/**
	 * 役職コードを取得します。
	 *
	 * @return yakushokuCd
	 */
	public String getYakushokuCd() {
		return yakushokuCd;
	}

	/**
	 * 役職コードを設定します。
	 *
	 * @param yakushokuCd 役職コード
	 */
	public void setYakushokuCd(String yakushokuCd) {
		this.yakushokuCd = yakushokuCd;
	}

	/**
	 * 役職コードリストを取得します。
	 *
	 * @return yakushokuCdList
	 */
	public List<String> getYakushokuCdList() {
		return yakushokuCdList;
	}

	/**
	 * 役職コードリストを設定します。
	 *
	 * @param yakushokuCdList 役職Boリスト
	 */
	public void setYakushokuCdList(List<String> yakushokuCdList) {
		this.yakushokuCdList = yakushokuCdList;
	}

	/**
	 * 役職名称リストを取得します。
	 *
	 * @return yakushokuNmList
	 */
	public List<String> getYakushokuNmList() {
		return yakushokuNmList;
	}

	/**
	 * 役職名称リストを設定します。
	 *
	 * @param yakushokuNmList 役職Boリスト
	 */
	public void setYakushokuNmList(List<String> yakushokuNmList) {
		this.yakushokuNmList = yakushokuNmList;
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

	/**
	 * 新規登録フラグを取得します。
	 *
	 * @return newCreateFlg
	 */
	public boolean isNewCreateFlg() {
		return newCreateFlg;
	}

	/**
	 * 新規登録フラグを設定します。
	 *
	 * @param newCreateFlg 新規登録フラグ
	 */
	public void setNewCreateFlg(boolean newCreateFlg) {
		this.newCreateFlg = newCreateFlg;
	}

}
