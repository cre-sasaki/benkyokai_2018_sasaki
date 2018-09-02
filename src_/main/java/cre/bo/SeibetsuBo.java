package cre.bo;

/** 性別Bo **/
public class SeibetsuBo {

	/** 性別コード **/
	private String seibetsuCd;

	/** 性別名称 **/
	private String seibetsuNm;

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
	 * 性別名称を取得します。
	 *
	 * @return seibetsuNm
	 */
	public String getSeibetsuNm() {
		return seibetsuNm;
	}

	/**
	 * 性別名称を設定します。
	 *
	 * @param seibetsuNm 性別名称
	 */
	public void setSeibetsuNm(String seibetsuNm) {
		this.seibetsuNm = seibetsuNm;
	}
}
