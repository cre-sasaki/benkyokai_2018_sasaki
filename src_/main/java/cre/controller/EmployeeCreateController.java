package cre.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cre.bo.EmployeeSearchBo;
import cre.bo.EmployeeSearchResultBo;
import cre.bo.YakushokuBo;
import cre.form.EmployeeSearchForm;
import cre.form.EmployeeSearchResultForm;
import cre.service.GetSeibetsuMasterService;
import cre.service.GetYakushokuMasterService;
import cre.service.SearchEmployeeService;

@Controller
@ComponentScan("cre.service")
public class EmployeeCreateController {

	/** 役職マスタ取得Service **/
	@Autowired
	private GetYakushokuMasterService getYakushokuMasterService;

	/** 性別マスタ取得Service **/
	@Autowired
	private GetSeibetsuMasterService getSeibetsuMasterService;

	/** 社員検索Service **/
	@Autowired
	private SearchEmployeeService searchEmployeeService;

	/**
	 * 社員検索画面初期表示
	 */
	@RequestMapping(value = "/", method = GET)
	public String showEmployeeSearch(Model model,
			@ModelAttribute("searchEmployeeForm") EmployeeSearchForm searchEmployeeForm) throws SQLException {

		// 役職マスタ取得サービスを実行する
		List<YakushokuBo> yakushokuBoList = getYakushokuMasterService.execute();

		// 役職コードリストを作成する
		ArrayList<String> yakushokuCdList = new ArrayList<String>();
		// 役職名称リストを作成する
		ArrayList<String> yakushokuNmList = new ArrayList<String>();

		// 役職マスタBoListの件数分、処理を行う
		for (YakushokuBo yakushokuBo : yakushokuBoList) {
			// 役職コードリストに役職Bo.役職コードをセット
			yakushokuCdList.add(yakushokuBo.getYakushokuCd());
			// 役職名称リストに役職Bo.役職名称をセット
			yakushokuNmList.add(yakushokuBo.getYakushokuNm());
		}
		// 社員検索Formに役職コードリストをセット
		searchEmployeeForm.setYakushokuCdList(yakushokuCdList);
		// 社員検索Formに役職名称リストをセット
		searchEmployeeForm.setYakushokuNmList(yakushokuNmList);

		// 社員検索Form.検索ボタン押下フラグをfalse（未押下）にセット
		searchEmployeeForm.setSearchFlg(false);

		model.addAttribute("searchEmployeeForm", searchEmployeeForm);

		// jspのファイル名
		return "searchEmployee";
	}

	/**
	 * 検索ボタン押下処理
	 */
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.POST)
	public String searchEmployee(HttpServletRequest request, Model model,
			@Valid @ModelAttribute("searchEmployeeForm") EmployeeSearchForm employeeSearchForm,BindingResult result) throws SQLException {

		// バリデーションエラーは発生していない場合
		if (!result.hasErrors()) {
			// セッションが設定されている場合
			if (request.getSession().getAttribute("searchEmployeeForm") != null) {
				// セッションから検索条件を取得
				employeeSearchForm = (EmployeeSearchForm) request.getSession().getAttribute("searchEmployeeForm");
			}
			// 社員検索Boに社員検索Formの値をコピーする
			EmployeeSearchBo employeeSearchBo = copyObject(employeeSearchForm);
			// 社員検索サービスに社員検索Boをセット
			searchEmployeeService.setEmployeeSearchBo(employeeSearchBo);
			// 社員検索サービスを実行する
			List<EmployeeSearchResultBo> employeeSearchResultBoList = searchEmployeeService.execute();
			// 社員検索結果Formを作成する
			EmployeeSearchResultForm employeeSearchResultForm = new EmployeeSearchResultForm();
			// 社員検索結果Formに社員検索結果Boをセット
			employeeSearchResultForm.setEmployeeSearchResultBoList(employeeSearchResultBoList);
			// 社員検索Formに社員検索結果Formをセット
			employeeSearchForm.setEmployeeSearchResultForm(employeeSearchResultForm);
			// 社員検索Form.検索ボタン押下フラグをtrue（押下）にセット
			employeeSearchForm.setSearchFlg(true);

			model.addAttribute("searchEmployeeForm", employeeSearchForm);
			// セッションをクリア
			request.getSession().invalidate();
		}
		// jspのファイル名
		return "searchEmployee";
	}

	/**
	 * オブジェクトコピー
	 */
	private EmployeeSearchBo copyObject(EmployeeSearchForm employeeSearchForm) {
		// 社員検索Boを作成する
		EmployeeSearchBo searchEmployeeBo = new EmployeeSearchBo();
		// 以下、社員検索Boに社員検索Formの値をセット
		// 氏名カナをセット
		searchEmployeeBo.setShimeiKana(employeeSearchForm.getShimeiKana());
		// 役職コードが"00"（未選択）以外の場合
		if (!employeeSearchForm.getYakushokuCd().equals("00")) {
			// 役職コードをセット
			searchEmployeeBo.setYakushokuCd(employeeSearchForm.getYakushokuCd());
		}
		// 生年月日をセット
		searchEmployeeBo.setSeinengappi(employeeSearchForm.getSeinengappi());
		// 入社日をセット
		searchEmployeeBo.setNyushabi(employeeSearchForm.getNyushabi());
		// 性別が未選択以外の場合
		if (employeeSearchForm.getSeibetsuCd() != null && !employeeSearchForm.getSeibetsuCd().isEmpty()) {
			// 性別コードをカンマで区切り、配列に格納
			String[] seibetsu = employeeSearchForm.getSeibetsuCd().split(",", 0);
			// 性別コード配列の要素数が1の場合
			if (seibetsu.length == 1) {
				// 性別コードをセット
				searchEmployeeBo.setSeibetsuCd(employeeSearchForm.getSeibetsuCd());
			}
		}
		// 契約社員区分をセット
		searchEmployeeBo.setKeiyakuEmployeeKbn(employeeSearchForm.getKeiyakuEmployeeKbn());
		// 並び順をセット
		searchEmployeeBo.setSort(employeeSearchForm.getSort());
		// 社員検索Boを返却する
		return searchEmployeeBo;
	}

}
