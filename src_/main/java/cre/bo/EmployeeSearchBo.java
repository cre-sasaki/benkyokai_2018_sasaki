package cre.bo;

/** 社員検索Bo **/
public class EmployeeSearchBo {

	/** 氏名かな **/
	private String shimeiKana;

	/** 役職コード **/
	private String yakushokuCd;

	/** 生年月日 **/
	private String seinengappi;

	/** 入社日 **/
	private String nyushabi;

	/** 退職日 **/
	private String taishokubi;

	/** 性別コード **/
	private String seibetsuCd;

	/** 契約社員区分 **/
	private String keiyakuEmployeeKbn;

	/** ソート順 **/
	private String sort;

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
	 * 入社日を設定します。
	 *
	 * @param nyushabi 入社日
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
	 * ソート順を取得します。
	 *
	 * @return sort
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * ソート順を設定します。
	 *
	 * @param sort ソート順
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}
}
