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
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
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
jQuery(function() {
    $('input[name=select]').click(function(){
        var id =  $(this).attr("id");
        $("#index").val(id);
    });
});
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
					<th class="info">氏名かな</th>
					<td>
						<div class="col-md-5">
							<f:input path="shimeiKana" class="form-control" id="text" placeholder="氏名かな" type="text" size="1"/>
						</div>
					</td>
					<th class="info">役職</th>
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
					<th class="info">生年月日</th>
					<td>
						<div class="col-md-7">
							<f:input path="seinengappi" class="form-control" id="text" placeholder="1990年11月1日なら19901101と入力" type="number" size="1"/>
						</div>
					</td>
					<th class="info">性別</th>
					<td>
						<div class="col-md-5; form-inline">
							<label class="checkbox">
								<c:forEach items="${searchEmployeeForm.seibetsuCdList}" var="item" varStatus="status">
									<f:checkbox path="seibetsuCd" data-toggle="checkbox" value="${item}" label="${searchEmployeeForm.seibetsuNmList[status.count-1]}"></f:checkbox>
								</c:forEach>
							</label>
						</div>
					</td>
				</tr>
				<tr>
					<th class="info">契約社員　</th>
					<td>
						<div class="col-md-5; form-inline">
							<div class="radio">
								<f:radiobutton path="keiyakuEmployeeKbn" value="1" label="含む" />
							</div>
							<div class="radio">
								<f:radiobutton path="keiyakuEmployeeKbn" value="0" label="含まない" />
							</div>
						</div>
					</td>
					<th class="info">並び順　<font color="red">※</font></th>
					<td>
						<div class="col-md-6">
							<f:errors path="sort" element="p" cssStyle="color:red"/>
							<f:select path="sort" class="form-control">
								<f:option value="" selected="selected"><c:out value="-" /></f:option>
								<f:option value="1"><c:out value="社員番号（昇）" /></f:option>
								<f:option value="2"><c:out value="社員番号（降）" /></f:option>
								<f:option value="3"><c:out value="氏名かな（昇）" /></f:option>
								<f:option value="4"><c:out value="氏名かな（降）" /></f:option>
							</f:select>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="container-fluid">
		<div class="col-md-10 col-md-offset-5">
				<input class="btn btn-default btn-lg" type="submit" name="create" value="新　規　登　録">
				<input class="btn btn-default btn-lg" type="submit" name="search" value="検　　　　　索">
				<input class="btn btn-default btn-lg" type="button" onclick="clearFormAll()" value="ク　　リ　　ア">
		</div>
	</div>


	<c:if test="${searchEmployeeForm.searchFlg}">
		<div class="col-md-10 col-md-offset-1">
			<b>検索結果</b>
			<table class="table table-bordered table-hover">
				<thead>
					<tr class="info">
						<td class="col-xs-2 col-sm-2 col-md-1"><div class="text-center">社員番号</div></td>
						<td class="col-xs-2 col-sm-2 col-md-3"><div class="text-center">氏名かな</div></td>
						<td class="col-xs-2 col-sm-2 col-md-3"><div class="text-center">氏名</div></td>
						<td class="col-xs-2 col-sm-2 col-md-2"><div class="text-center">生年月日</div></td>
						<td class="col-xs-2 col-sm-2 col-md-1"><div class="text-center">役職</div></td>
						<td class="col-xs-2 col-sm-2 col-md-1"><div class="text-center">性別</div></td>
						<td class="col-xs-2 col-sm-2 col-md-1"><div class="text-center">登録</div></td>
					</tr>
				</thead>
				<c:if test="${! empty searchEmployeeForm.employeeSearchResultForm.employeeSearchResultBoList}">
					<tbody>
					<c:forEach items="${searchEmployeeForm.employeeSearchResultForm.employeeSearchResultBoList}" var="item" varStatus="status">
						<tr>
							<td><div class="text-right"><c:out value="${item.employeeNo}" /></div></td>
							<td><c:out value="${item.shimeiKana}" /></td>
							<td><c:out value="${item.shimei}" /></td>
							<td><div class="text-center"><c:out value="${item.seinengappi}" /></div></td>
							<td><div class="text-center"><c:out value="${item.yakushokuNm}" /></div></td>
							<td><div class="text-center"><c:out value="${item.seibetsuNm}" /></div></td>
							<td>
								<div class="text-center">
									<div class="container-fluid">
										<div class="col-md-10 col-md-offset-1">
											<input class="btn btn-default" type="submit" name="select" value="選択" id="${status.index}">
										</div>
									</div>
								</div>
							</td>
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
	<input type="hidden" name="selectIndex" id="index" value=""/>
	</f:form>
 </body>
</html>