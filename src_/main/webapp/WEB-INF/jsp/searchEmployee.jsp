<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-1.12.4.min.js" type="text/javascript"></script>
<script type="text/javascript" src="./WEB-INF/js/jquery/jquery-2.1.4.js"></script>
<script type="text/javascript" src="./WEB-INF/js/jquery/bootstrap.js"></script>
<script type="text/javascript" src="./WEB-INF/js/jquery/npm.js"></script>
<script type="text/javascript">
function clearFormAll() {
    for (var i=0; i<document.forms.length; ++i) {
        clearForm(document.forms[i]);
    }
}
function clearForm(form) {
    for(var i=0; i<form.elements.length; ++i) {
        clearElement(form.elements[i]);
    }
}
function clearElement(element) {
    switch(element.type) {
        case "hidden":
        case "submit":
        case "reset":
        case "button":
        case "image":
            return;
        case "file":
            return;
        case "text":
        case "password":
        case "textarea":
        case "number":
            element.value = "";
            return;
        case "checkbox":
        case "radio":
            element.checked = false;
            return;
        case "select-one":
        case "select-multiple":
            element.selectedIndex = 0;
            return;
        default:
    }
}
</script>
<link rel=stylesheet type="text/css" href="./resources/css/bootstrap.css" />
<link rel=stylesheet type="text/css" href="./resources/css/bootstrap-theme.css" />

<title>社員検索画面</title>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand">社員検索画面</a>
			</div>
			<div class="collapse navbar-collapse">
				<p class="navbar-text navbar-right">
					<a href="../メニュー.html" class="navbar-link">メニューへ戻る</a>
				</p>
			</div>
		</div>
	</div>
	<br>
	<br>
	<f:form modelAttribute="searchEmployeeForm" action="searchEmployee" method="post">
	<div class="col-md-10 col-md-offset-1">
		<b>検索条件</b>
		<table class="table table-bordered table-hover">
			<tbody>
				<tr>
					<th class="info col-md-2">氏名かな</th>
					<td>
						<div class="col-md-5">
							<f:input path="shimeiKana" class="form-control" id="text" placeholder="氏名かな" type="text" size="1"/>
						</div>
					</td>
					<th class="info">契約形態</th>
					<td>
						<div class="col-md-5; form-inline">
							<label class="checkbox" id="keiyaku">
								<label class="checkbox-inline"><input type="checkbox" data-toggle="checkbox" value="">社員</label>
								<label class="checkbox-inline"><input type="checkbox" data-toggle="checkbox" value="">契約社員</label>
								<label class="checkbox-inline"><input type="checkbox" data-toggle="checkbox" value="">パートナー</label>
							</label>
						</div>
					</td>
				</tr>
				<tr>
					<th class="info">年齢</th>
					<td>
						<div class="col-md-3">
							<input class="form-control" id="nenreimin" placeholder="最小" type="number"/>
						</div>
						<div class="col-md-3">
							<input class="form-control" id="nenreimax" placeholder="最大" type="number"/>
						</div>
					</td>
					<th class="info col-md-2">役職</th>
					<td>
						<div class="col-md-5">
​							<f:select path="yakushokuCd" class="form-control">
								<f:option value="00" selected="selected"><c:out value="-" /></f:option>
								<c:forEach items="${searchEmployeeForm.yakushokuCdList}" var="item" varStatus="status">
									<f:option value="${item}"><c:out value="${item}:${searchEmployeeForm.yakushokuNmList[status.count-1]}" /></f:option>
								</c:forEach>
							</f:select>
						</div>
					</td>
				</tr>
				<tr>
					<th class="info">性別</th>
					<td>
						<div class="col-md-5; form-inline">
							<div class="radio">
							<input type="radio"  name="seibetu"  value="1" id="manwoman"  checked >
							<label for="manwoman">男女</label>
							</div>
							<div class="radio">
								<input type="radio"  name="seibetu" value="2" id="man" >
								<label for="man">男</label>
							</div>
							<div class="radio">
								<input type="radio"  name="seibetu" value="3" id="woman">
								<label for="woman">女</label>
							</div>
						</div>
					</td>
					<th class="info">入社日</th>
					<td>
						<div class="col-md-4">
							<input class="form-control" id="nyushamin" placeholder="最小" type="number"/>
						</div>
						<div class="col-md-4">
							<input class="form-control" id="nyushamax" placeholder="最大" type="number"/>
						</div>
					</td>
				</tr>
				<tr>
					<th class="info">並び順　<font color="red">※</font></th>
					<td colspan="3">
						<div class="col-md-2">
							<f:errors path="sort" element="p" cssStyle="color:red"/>
							<f:select path="sort" class="form-control" id="sort1">
								<f:option value="" selected="selected"><c:out value="-" /></f:option>
								<f:option value="1"><c:out value="社員番号（昇）" /></f:option>
								<f:option value="2"><c:out value="社員番号（降）" /></f:option>
								<f:option value="3"><c:out value="氏名かな（昇）" /></f:option>
								<f:option value="4"><c:out value="氏名かな（降）" /></f:option>
								<f:option value="5"><c:out value="年齢（昇）"/></f:option>
								<f:option value="6"><c:out value="年齢（降）"/></f:option>
							</f:select>
						</div>
						<div class="col-md-2">
							<f:errors path="sort2" element="p" cssStyle="color:red"/>
							<f:select path="sort2" class="form-control" id="sort2">
								<f:option value="" selected="selected"><c:out value="-" /></f:option>
								<f:option value="1"><c:out value="社員番号（昇）" /></f:option>
								<f:option value="2"><c:out value="社員番号（降）" /></f:option>
								<f:option value="3"><c:out value="氏名かな（昇）" /></f:option>
								<f:option value="4"><c:out value="氏名かな（降）" /></f:option>
								<f:option value="5"><c:out value="年齢（昇）"/></f:option>
								<f:option value="6"><c:out value="年齢（降）"/></f:option>
							</f:select>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>

	<div class="container-fluid">
		<div class="col-md-5 col-md-offset-4">
			<input class="btn btn-default btn-lg" type="submit" value="新　規　登　録">
				<input class="btn btn-default btn-lg" type="submit" value="検　　　　　索">
				<input class="btn btn-default btn-lg" type="button" onclick="clearFormAll()" value="ク　　リ　　ア">
		</div>
	</div>
	</br>
	<c:if test="${searchEmployeeForm.searchFlg}">
	<div class="col-md-10 col-md-offset-1">
		<b>検索結果</b>
		<table class="table table-bordered table-hover">
			<thead>
				<tr class="info">
					<td class="col-xs-2 col-sm-2 col-md-1" rowspan="2"><div class="text-center">No</div></td>
					<td class="col-xs-2 col-sm-2 col-md-1" rowspan="2"><div class="text-center">社員</br>番号</div></td>
					<td class="col-xs-2 col-sm-2 col-md-3" rowspan="2"><div class="text-center">氏名</div></td>
					<td class="col-xs-2 col-sm-2 col-md-1"><div class="text-center">性別</div></td>
					<td class="col-xs-2 col-sm-2 col-md-2"><div class="text-center">入社日</div></td>
					<td class="col-xs-2 col-sm-2 col-md-1"><div class="text-center">役職</div></td>
					<td class="col-xs-2 col-sm-2 col-md-1"><div class="text-center">契約</div></td>
					<td class="col-xs-2 col-sm-2 col-md-1" rowspan="2"><div class="text-center">登録</div></td>
				</tr>
				<tr class="info">
					<td class="col-xs-2 col-sm-2 col-md-1"><div class="text-center">年齢</div></td>
					<td class="col-xs-2 col-sm-2 col-md-2"><div class="text-center">退職日</div></td>
					<td class="col-xs-2 col-sm-2 col-md-2" colspan="2	"><div class="text-center">案件</div></td>
				</tr>
			</thead>
			<c:if test="${! empty searchEmployeeForm.employeeSearchResultForm.employeeSearchResultBoList}">
			<tbody>
			<c:forEach items="${searchEmployeeForm.employeeSearchResultForm.employeeSearchResultBoList}" var="item"  varStatus="status">
				<tr>
					<td rowspan="2"><div class="text-right"><c:out value="${status.count}"/></td>
					<td rowspan="2"><div class="text-right"><c:out value="${item.employeeNo}" /></td>
					<td><c:out value="${item.shimeiKana}" /></td>
					<td><c:out value="${item.seibetsuNm}" /></td>
					<td><div class="text-center"><c:out value="${item.nyushabi}" /></div></td>
					<td><div class="text-center"><c:out value="${item.yakushokuNm}" /></div></td>
					<td><div class="text-center"><c:out value="${item.keiyakuNm}" /></div></td>
					<td rowspan="2"><div class="text-center">
						<div class="container-fluid">
							<div class="col-md-10 col-md-offset-1">
								<button class="btn btn-default" onClick="location.href='登録画面.html'">選択</button>
							</div>
						</div>
					</div></td>
				</tr>
				<tr>
					<td><c:out value="${item.shimei}" /></td>
					<td>38歳</td>
					<td><div class="text-center"><c:out value="${item.taishokubi}" /></div></td>
					<td colspan="2"><div class="text-center"><c:out value="${item.projectNm}" /></div></td>
				</tr>
			</c:forEach>
			</tbody>
			</c:if>
		</table>
	</div>
	</c:if>
		<c:forEach items="${searchEmployeeForm.yakushokuCdList}" var="item" varStatus="status">
		<input type="hidden" name="yakushokuCdList" value="${item}"/>
		<input type="hidden" name="yakushokuNmList" value="${searchEmployeeForm.yakushokuNmList[status.count-1]}"/>
	</c:forEach>
	<c:forEach items="${searchEmployeeForm.seibetsuCdList}" var="item" varStatus="status">
		<input type="hidden" name="seibetsuCdList" value="${item}"/>
		<input type="hidden" name="seibetsuNmList" value="${searchEmployeeForm.seibetsuNmList[status.count-1]}"/>
	</c:forEach>
	</f:form>
</body>
</html>
