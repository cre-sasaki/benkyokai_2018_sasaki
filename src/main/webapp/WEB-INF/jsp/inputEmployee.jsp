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
<link rel=stylesheet type="text/css" href="./resources/css/bootstrap.css" />
<link rel=stylesheet type="text/css" href="./resources/css/bootstrap-theme.css" />

 <title>社員登録画面</title>
 </head>
 <body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand">社員登録画面</a>
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
	<f:form modelAttribute="createEmployeeForm" action="createEmployee" method="post">
	<div class="col-md-10 col-md-offset-1">
		<c:if test="${!empty createEmployeeForm.errorMessage}">
			<div class="alert alert-danger" role="alert"><c:out value="${createEmployeeForm.errorMessage}" /></div>
		</c:if>
		<table class="table table-bordered table-hover">
			<tbody>
				<tr>
					<th class="info col-md-2">社員番号　<font color="red">※</font></th>
					<td>
						<div class="col-md-4">
							<f:errors path="shainNo" element="p" cssStyle="color:red"/>
							<c:if test="${createEmployeeForm.newCreateFlg}" >
								<f:input path="shainNo" class="form-control" id="text" placeholder="社員番号" type="number" size="1"/>
							</c:if>
							<c:if test="${!createEmployeeForm.newCreateFlg}" >
								<f:input path="shainNo" class="form-control" id="text" placeholder="社員番号" type="number" size="1" disabled="true"/>
								<input type="hidden" name="shainNo" value="${createEmployeeForm.shainNo}"/>
							</c:if>
						</div>
					</td>
				</tr>
				<tr>
					<th class="info">氏名かな　<font color="red">※</font></th>
					<td>
						<div class="col-md-5">
							<f:errors path="shimeiKana" element="p" cssStyle="color:red"/>
							<f:input path="shimeiKana" class="form-control" id="text" placeholder="氏名かな" type="text" />
						</div>
					</td>
				</tr>
				<tr>
					<th class="info">氏名　<font color="red">※</font></th>
					<td>
						<div class="col-md-5">
							<f:errors path="shimei" element="p" cssStyle="color:red"/>
							<f:input path="shimei" class="form-control" id="text" placeholder="氏名" type="text" />
						</div>
					</td>
				</tr>
				<tr>
					<th class="info">生年月日</th>
					<td>
						<div class="col-md-3">
							<f:input path="seinengappi" class="form-control" id="text" placeholder="1990年11月1日なら19901101と入力" type="number" size="1"/>
						</div>
					</td>
				</tr>
				<tr>
					<th class="info">性別</th>
					<td>
						<div class="col-md-2">
							<f:select path="seibetsuCd" class="form-control">
								<f:option value="00" selected="selected"><c:out value="-" /></f:option>
								<c:forEach items="${createEmployeeForm.seibetsuCdList}" var="item" varStatus="status">
									<f:option value="${item}"><c:out value="${item}:${createEmployeeForm.seibetsuNmList[status.count-1]}" /></f:option>
								</c:forEach>
							</f:select>
						</div>
					</td>
				</tr>
				<tr>
					<th class="info">契約社員</th>
					<td>
						<div class="col-md-5; form-inline">
							<label class="checkbox">
								<label class="checkbox-inline">
									<f:checkbox path="keiyakuEmployeeKbn" data-toggle="checkbox" value="2"/>契約社員
								</label>
							</label>
						</div>
					</td>
				</tr>
				<tr>
					<th class="info">役職</th>
					<td>
						<div class="col-md-2">
							<f:select path="yakushokuCd" class="form-control">
								<f:option value="00" selected="selected"><c:out value="-" /></f:option>
								<c:forEach items="${createEmployeeForm.yakushokuCdList}" var="item" varStatus="status">
									<f:option value="${item}"><c:out value="${item}:${createEmployeeForm.yakushokuNmList[status.count-1]}" /></f:option>
								</c:forEach>
							</f:select>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>

	<div class="container">
		<div class="col-md-10 col-md-offset-5 ">
			<input class="btn btn-default btn-lg" type="submit" value="登　　　　　録">
		</div>
	</div>

	<c:forEach items="${createEmployeeForm.yakushokuCdList}" var="item" varStatus="status">
		<input type="hidden" name="yakushokuCdList" value="${item}"/>
		<input type="hidden" name="yakushokuNmList" value="${createEmployeeForm.yakushokuNmList[status.count-1]}"/>
	</c:forEach>
	<c:forEach items="${createEmployeeForm.seibetsuCdList}" var="item" varStatus="status">
		<input type="hidden" name="seibetsuCdList" value="${item}"/>
		<input type="hidden" name="seibetsuNmList" value="${createEmployeeForm.seibetsuNmList[status.count-1]}"/>
	</c:forEach>
	<input type="hidden" name="newCreateFlg" value="${createEmployeeForm.newCreateFlg}"/>
	<input type="hidden" name="atenaPk" value="${createEmployeeForm.atenaPk}"/>
	<input type="hidden" name="atenaVersion" value="${createEmployeeForm.atenaVersion}"/>

	<input type="hidden" name="employeeVersion" value="${createEmployeeForm.employeeVersion}"/>
<!-- 	<input type="hidden" name="keiyakuEmployeeKbn" value="${createEmployeeForm.keiyakuEmployeeKbn}"/>
 -->
	</f:form>
 </body>
</html>