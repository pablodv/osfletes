function init_tabs(container_id,default_destination)
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
	
	if(default_destination != null){
		$('#'+container_id +' a[href="'+default_destination+'"]').parent().click();
	}
}