function init_tabs(container_id)
{
	$("#"+container_id+" > ul.tabs li:first").addClass("active").show();
	$("#"+container_id+" > .tab_content:first").show();

	$("#"+container_id+" > ul.tabs li").click(function()
       {
		$("#"+container_id+" > ul.tabs li").removeClass("active");
		$(this).addClass("active");
		$("#"+container_id+" > .tab_container").hide();

		var activeTab = $(this).find("a").attr("href");
		$("#"+container_id+' >.tab_container').load(activeTab);
		$("#"+container_id+' >.tab_container').fadeIn();
		return false;
	});
}