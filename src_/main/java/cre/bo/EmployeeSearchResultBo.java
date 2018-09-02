package cre.bo;

/** 社員検索結果Bo **/
public class EmployeeSearchResultBo {

	/** 宛名PK **/
	private int tAtenaPk;

	/** 社員PK **/
	private int tEmployeePk;

	/** 社員番号 **/
	private String employeeNo;

	/** 氏名 **/
	private String shimei;

	/** 氏名かな **/
	private String shimeiKana;

	/** 役職名 **/
	private String yakushokuNm;

	/** 生年月日 **/
	private String seinengappi;

	/** 入社日 **/
	private String nyushabi;

	/** 退職日 **/
	private String taishokubi;

	/** 性別名 **/
	private String seibetsuNm;

	/** 案件名 **/
	private String projectNm;

	/** 契約名 **/
	private String keiyakuNm;

	/**
	 * 宛名PKを取得する。
	 *
	 * @return tAtenaPk
	 */
	public int getTAtenaPk() {
		return tAtenaPk;
	}

	/**
	 * 宛名PKを設定する。
	 *
	 * @param tAtenaPk 宛名PK
	 */
	public void setTAtenaPk(int tAtenaPk) {
		this.tAtenaPk = tAtenaPk;
	}

	/**
	 * 社員PKを取得する。
	 *
	 * @return tEmployeePk
	 */
	public int getTEmployeePk() {
		return tEmployeePk;
	}

	/**
	 * 社員PKを設定する。
	 *
	 * @param tEmployeePk 社員PK
	 */
	public void setTEmployeePk(int tEmployeePk) {
		this.tEmployeePk = tEmployeePk;
	}

	/**
	 * 社員番号を取得します。
	 *
	 * @return employeeNo
	 */
	public String getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * 社員番号を設定します。
	 *
	 * @param employeeNo 社員番号
	 */
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
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
	* @param shimei 氏名かな
	*/
	public void setShimeiKana(String shimeiKana) {
		this.shimeiKana = shimeiKana;
	}

	/**
	 * 役職名を取得します。
	 *
	 * @return yakushokuNm
	 */
	public String getYakushokuNm() {
		return yakushokuNm;
	}

	/**
	 * 役職名を設定します。
	 *
	 * @param yakushokuNm 役職
	 */
	public void setYakushokuNm(String yakushokuNm) {
		this.yakushokuNm = yakushokuNm;
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
	 * 入社日を取得します。
	 *
	 * @return nyushabi
	 */
	public String getNyushabi() {
		return nyushabi;
	}

	/**
	 * 生年月日を設定します。
	 *
	 * @param seinengappi 生年月日
	 */
	public void setNyushabi(String nyushabi) {
		this.nyushabi = nyushabi;
	}

	/**
	 * 退職日を取得します。
	 *
	 * @return taishokubi
	 */
	public String getTaishokubi() {
		return taishokubi;
	}

	/**
	 * 退職日を設定します。
	 *
	 * @param taishokubi 退職日
	 */
	public void setTaishokubi(String taishokubi) {
		this.taishokubi = taishokubi;
	}

	/**
	 * 性別名を取得します。
	 *
	 * @return seibetsuNm
	 */
	public String getSeibetsuNm() {
		return seibetsuNm;
	}

	/**
	 * 性別名を設定します。
	 *
	 * @param seibetsuNm 性別
	 */
	public void setSeibetsuNm(String seibetsuNm) {
		this.seibetsuNm = seibetsuNm;
	}

	/**
	 * 案件名を取得します。
	 *
	 * @return projectNm
	 */
	public String getProjectNm() {
		return projectNm;
	}

	/**
	 * 案件名を設定します。
	 *
	 * @param projectNm 案件
	 */
	public void setProjectNm(String projectNm) {
		this.projectNm = projectNm;
	}

	/**
	 * 契約名を取得します。
	 *
	 * @return keiyakuNm
	 */
	public String getKeiyakuNm() {
		return keiyakuNm;
	}

	/**
	 * 契約名を設定します。
	 *
	 * @param keiyakuNm 契約
	 */
	public void setKeiyakuNm(String keiyakuNm) {
		this.keiyakuNm = keiyakuNm;
	}
}
