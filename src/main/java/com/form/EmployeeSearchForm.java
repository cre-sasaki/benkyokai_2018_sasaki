package com.form;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

/** 社員検索Form **/
public class EmployeeSearchForm {

	/** 氏名かな **/
	private String shimeiKana;

	/** 生年月日 **/
	private String seinengappi;

	/** 契約社員区分 **/
	private String keiyakuEmployeeKbn;

	/** ソート順 **/
	@NotEmpty(message = "並び順は必ず選択してください。")
	private String sort;

	/** 役職コード **/
	private String yakushokuCd;

	/** 役職コードリスト **/
	private List<String> yakushokuCdList;

	/** 役職名称リスト **/
	private List<String> yakushokuNmList;

	/** 性別コード **/
	private String seibetsuCd;

	/** 性別コードリスト **/
	private List<String> seibetsuCdList;

	/** 性別名称リスト **/
	private List<String> seibetsuNmList;

	/** 社員検索結果Form **/
	private EmployeeSearchResultForm employeeSearchResultForm;

	/** 検索ボタン押下フラグ **/
	private boolean searchFlg;

	/** 選択ボタンインデックス **/
	private String selectIndex;

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
	 * 社員検索結果Formを取得します。
	 *
	 * @return employeeSearchResultForm
	 */
	public EmployeeSearchResultForm getEmployeeSearchResultForm() {
		return employeeSearchResultForm;
	}

	/**
	 * 社員検索結果Formを設定します。
	 *
	 * @param employeeSearchResultForm 社員検索結果Form
	 */
	public void setEmployeeSearchResultForm(EmployeeSearchResultForm employeeSearchResultForm) {
		this.employeeSearchResultForm = employeeSearchResultForm;
	}

	/**
	 * 検索ボタン押下フラグを取得します。
	 *
	 * @return searchFlg
	 */
	public boolean isSearchFlg() {
		return searchFlg;
	}

	/**
	 * 検索ボタン押下フラグを設定します。
	 *
	 * @param searchFlg 検索ボタン押下フラグ
	 */
	public void setSearchFlg(boolean searchFlg) {
		this.searchFlg = searchFlg;
	}


	/**
	 * 選択ボタンインデックスを取得します。
	 *
	 * @return selectIndex
	 */
	public String getSelectIndex() {
		return selectIndex;
	}

	/**
	 * 選択ボタンインデックスを設定します。
	 *
	 * @param selectIndex 選択ボタンインデックス
	 */
	public void setSelectIndex(String selectIndex) {
		this.selectIndex = selectIndex;
	}
}
