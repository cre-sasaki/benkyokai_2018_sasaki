package com.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bo.EmployeeCreateBo;
import com.bo.EmployeeSearchBo;
import com.bo.EmployeeSearchResultBo;
import com.bo.SeibetsuBo;
import com.bo.YakushokuBo;
import com.form.EmployeeCreateForm;
import com.form.EmployeeSearchForm;
import com.form.EmployeeSearchResultForm;
import com.service.CheckDbRelationCreateEmployeeService;
import com.service.CheckInputRelationCreateEmployeeService;
import com.service.CreateEmployeeService;
import com.service.GetEmployeeJohoService;
import com.service.GetSeibetsuMasterService;
import com.service.GetYakushokuMasterService;
import com.service.SearchEmployeeService;

/** サンプルコントローラー **/
@Controller
@ComponentScan("com.service")
public class SampleController {

	/** 役職マスタ取得Service **/
	@Autowired
	private GetYakushokuMasterService getYakushokuMasterService;

	/** 性別マスタ取得Service **/
	@Autowired
	private GetSeibetsuMasterService getSeibetsuMasterService;

	/** 社員検索Service **/
	@Autowired
	private SearchEmployeeService searchEmployeeService;

	/** 社員登録入力関連チェックService **/
	@Autowired
	private CheckInputRelationCreateEmployeeService checkInputRelationCreateEmployeeService;

	/** 社員登録DB関連チェックService **/
	@Autowired
	private CheckDbRelationCreateEmployeeService checkDbRelationCreateEmployeeService;

	/** 社員情報取得Service **/
	@Autowired
	private GetEmployeeJohoService getEmployeeJohoService;

	/** 社員登録Service **/
	@Autowired
	private CreateEmployeeService createEmployeeService;

	/** セッション **/
	@Autowired
	HttpSession session;

	/**
	 * 社員検索画面初期表示
	 */
	@RequestMapping(value = "/", method = GET, produces="text/plain;charset=utf-8")
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

		// 性別マスタ取得サービスを実行する
		List<SeibetsuBo> seibetsuBoList = getSeibetsuMasterService.execute();

		// 性別コードリストを作成する
		ArrayList<String> seibetsuCdList = new ArrayList<String>();
		// 性別名称リストを作成する
		ArrayList<String> seibetsuNmList = new ArrayList<String>();

		// 性別マスタBoListの件数分、処理を行う
		for (SeibetsuBo seibetsuBo : seibetsuBoList) {
			// 性別コードリストに性別Bo.性別コードをセット
			seibetsuCdList.add(seibetsuBo.getSeibetsuCd());
			// 性別名称リストに性別Bo.性別名称をセット
			seibetsuNmList.add(seibetsuBo.getSeibetsuNm());
		}

		// 社員検索Formに性別コードリストをセット
		searchEmployeeForm.setSeibetsuCdList(seibetsuCdList);
		// 社員検索Formに性別名称リストをセット
		searchEmployeeForm.setSeibetsuNmList(seibetsuNmList);
		// 社員検索Form.検索ボタン押下フラグをfalse（未押下）にセット
		searchEmployeeForm.setSearchFlg(false);

		model.addAttribute("searchEmployeeForm", searchEmployeeForm);

		// jspのファイル名
		return "searchEmployee";
	}

	/**
	 * 検索ボタン押下処理
	 */
	@RequestMapping(value = "/searchEmployee", params = "search", method = RequestMethod.POST, produces="text/plain;charset=utf-8")
	public String searchEmployee(HttpServletRequest request, Model model,
			@Valid @ModelAttribute("searchEmployeeForm") EmployeeSearchForm employeeSearchForm,BindingResult result) throws SQLException {

		// バリデーションエラーは発生していない場合
		if (!result.hasErrors()) {
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
			session.invalidate();

			session.setAttribute("employeeSearchResultForm", employeeSearchResultForm);
		}

		// jspのファイル名
		return "searchEmployee";
	}

	/**
	 * 新規登録ボタン押下処理
	 */
	@RequestMapping(value = "/searchEmployee", params = "create", method = RequestMethod.POST, produces="text/plain;charset=utf-8")
	public String showEmployeeCreate(HttpServletRequest request, Model model, EmployeeSearchForm employeeSearchForm, BindingResult result) throws SQLException {

		// 登録フォーム作成
		EmployeeCreateForm form = new EmployeeCreateForm();

		// プルダウンリスト設定
		form.setSeibetsuCdList(employeeSearchForm.getSeibetsuCdList());
		form.setSeibetsuNmList(employeeSearchForm.getSeibetsuNmList());
		form.setYakushokuCdList(employeeSearchForm.getYakushokuCdList());
		form.setYakushokuNmList(employeeSearchForm.getYakushokuNmList());
		form.setNewCreateFlg(true);

		// modelにフォームを設定
		model.addAttribute("createEmployeeForm", form);

		// jspのファイル名
		return "inputEmployee";
	}

	/**
	 * 選択ボタン押下処理
	 */
	@RequestMapping(value = "/searchEmployee", params = "select", method = RequestMethod.POST, produces="text/plain;charset=utf-8")
	public String showEmployeeUpdate(HttpServletRequest request, Model model, EmployeeSearchForm employeeSearchForm, BindingResult result) throws SQLException {

	    // セッションから社員検索結果Formを取得する
		EmployeeSearchResultForm employeeSearchResultForm = (EmployeeSearchResultForm) session.getAttribute("employeeSearchResultForm");
		// 社員検索結果Formから社員検索結果BoListを取得する
		List<EmployeeSearchResultBo> employeeSearchResultBoList = employeeSearchResultForm.getEmployeeSearchResultBoList();
		// 選択ボタンが押下された行のインデックスを取得する
		int selectIndex = Integer.parseInt(employeeSearchForm.getSelectIndex());
		// 社員検索結果BoListからインデックスに該当する対象者の宛名PKを取得する
		int tAtenaPk = employeeSearchResultBoList.get(selectIndex).getTAtenaPk();

		// 社員登録Boを作成する
		EmployeeCreateBo employeeCreateBo = new EmployeeCreateBo();
		employeeCreateBo.setAtenaPk(tAtenaPk);

		// 社員情報取得サービスに社員登録Boをセット
		getEmployeeJohoService.setEmployeeCreateBo(employeeCreateBo);
		// 社員情報取得サービスを実行し、社員登録Boを取得する
		employeeCreateBo = getEmployeeJohoService.execute();

		// 登録フォーム作成
		EmployeeCreateForm form = new EmployeeCreateForm();
		// 社員登録Boの値を社員登録Formに設定する
		form = copyObjectBoToForm(employeeCreateBo);

		// プルダウンリスト設定
		form.setSeibetsuCdList(employeeSearchForm.getSeibetsuCdList());
		form.setSeibetsuNmList(employeeSearchForm.getSeibetsuNmList());
		form.setYakushokuCdList(employeeSearchForm.getYakushokuCdList());
		form.setYakushokuNmList(employeeSearchForm.getYakushokuNmList());
		form.setNewCreateFlg(false);

		// modelにフォームを設定
		model.addAttribute("createEmployeeForm", form);

		// jspのファイル名
		return "inputEmployee";
	}

	/**
	 * 登録ボタン押下処理
	 */
	@RequestMapping(value = "/createEmployee", method = RequestMethod.POST, produces="text/plain;charset=utf-8")
	@Transactional
	public String createEmployee(HttpServletRequest request, Model model,
			@Valid @ModelAttribute("createEmployeeForm") EmployeeCreateForm employeeCreateForm,
			BindingResult result, RedirectAttributes redirectAttributes) throws SQLException {

		// バリデーションエラーの場合
		if (result.hasErrors()) {
			// jspのファイル名
			return "inputEmployee";
		}

		EmployeeCreateBo employeeCreateBo = new EmployeeCreateBo();
		employeeCreateBo.setNewCreateFlg(employeeCreateForm.isNewCreateFlg());
		employeeCreateBo.setShainNo(employeeCreateForm.getShainNo());
		employeeCreateBo.setShimeiKana(employeeCreateForm.getShimeiKana());
		employeeCreateBo.setShimei(employeeCreateForm.getShimei());
		employeeCreateBo.setSeinengappi(employeeCreateForm.getSeinengappi());
		employeeCreateBo.setSeibetsuCd(employeeCreateForm.getSeibetsuCd());
		// 契約社員区分にチェックがある場合
		if (employeeCreateForm.getKeiyakuEmployeeKbn() != null
				&& !employeeCreateForm.getKeiyakuEmployeeKbn().isEmpty()) {
			// 契約社員区分に"2"（契約社員）をセット
			employeeCreateBo.setKeiyakuEmployeeKbn(employeeCreateForm.getKeiyakuEmployeeKbn());
		} else {
			// 契約社員区分にチェックがない場合
			// 契約社員区分に"1"（社員）をセット
			employeeCreateBo.setKeiyakuEmployeeKbn("1");
		}
		employeeCreateBo.setYakushokuCd(employeeCreateForm.getYakushokuCd());
		employeeCreateBo.setAtenaPk(employeeCreateForm.getAtenaPk());
		employeeCreateBo.setAtenaVersion(employeeCreateForm.getAtenaVersion());
		employeeCreateBo.setEmployeeVersion(employeeCreateForm.getEmployeeVersion());

		// 入力関連チェック
		checkInputRelationCreateEmployeeService.setEmployeeSearchBo(employeeCreateBo);
		EmployeeCreateBo inputResultBo = checkInputRelationCreateEmployeeService.execute();
		if (!StringUtils.isEmpty(inputResultBo.getErrorMessage())) {
			employeeCreateForm.setErrorMessage(inputResultBo.getErrorMessage());
			// modelにフォームを設定
			model.addAttribute("createEmployeeForm", employeeCreateForm);
			// jspのファイル名
			return "inputEmployee";
		}

		// DB関連チェック
		checkDbRelationCreateEmployeeService.setEmployeeSearchBo(employeeCreateBo);
		EmployeeCreateBo dbResultBo = checkDbRelationCreateEmployeeService.execute();
		if (!StringUtils.isEmpty(dbResultBo.getErrorMessage())) {
			employeeCreateForm.setErrorMessage(dbResultBo.getErrorMessage());
			// modelにフォームを設定
			model.addAttribute("createEmployeeForm", employeeCreateForm);
			// jspのファイル名
			return "inputEmployee";
		}

		// DB登録
		createEmployeeService.setEmployeeSearchBo(employeeCreateBo);
		createEmployeeService.execute();

		// セッションからの復元処理
		return "redirect:/";
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

	/**
	 * オブジェクトコピー
	 */
	private EmployeeCreateForm copyObjectBoToForm(EmployeeCreateBo employeeCreateBo) {
		// 登録フォーム作成
		EmployeeCreateForm form = new EmployeeCreateForm();
		// 値のコピー
		BeanUtils.copyProperties(employeeCreateBo, form);
		// 社員検索Boを返却する
		return form;
	}
}
