/**
 * 共通Javascript
 */
$(function() {

	// 初期表示時リストの子タイトルは非表示
	$(".subTitle").hide();

	// アコーディオン機能
	$(".acMenu a").on("click", function() {
		$(this).next().slideToggle(0);
	});
});