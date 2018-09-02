package com.bo;

/** 社員登録Bo **/
public class EmployeeCreateBo extends BaseBo {

	/** 宛名PK **/
	private int atenaPk;

	/** 宛名バージョン **/
	private Integer atenaVersion;

	/** 社員番号 **/
	private String shainNo;

	/** 氏名かな **/
	private String shimeiKana;

	/** 氏名 **/
	private String shimei;

	/** 生年月日 **/
	private String seinengappi;

	/** 性別コード **/
	private String seibetsuCd;

	/** 契約社員区分 **/
	private String keiyakuEmployeeKbn;

	/** 役職コード **/
	private String yakushokuCd;

	/** 社員バージョン **/
	private Integer employeeVersion;

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
	public Integer getAtenaVersion() {
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
	 * @param seibetsuCd 性別
	 */
	public void setSeibetsuCd(String seibetsuCd) {
		this.seibetsuCd = seibetsuCd;
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
	 * @param yakushokuCd 役職
	 */
	public void setYakushokuCd(String yakushokuCd) {
		this.yakushokuCd = yakushokuCd;
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
