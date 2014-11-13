<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="page" value="${pageContext.request.contextPath}" />
<span class="menu"><a href="${page}/team">Home</a></span>
<span class="menu"><a href="${page}/team/list">Team</a></span>
<span class="menu"><a href="${page}/user/list">User</a></span>

<script type="text/javascript">
	$(function() {
		$("#menu").menu();
	});
</script>

<style>
.ui-menu {
	width: 120px;
}

a.ui-corner-all {
	color: #345DED;
}

span.menu {
	margin: 3px 3px 1px 1px;
	padding: 2px 5px;
	vertical-align: middle;
	width: 150px;
	text-align: center;
	font-size: .8em;
	text-decoration: none;
	border-color: #FFFFFF;
	-moz-box-shadow: 0 0 5px 5px #888;
	-webkit-box-shadow: 0 0 5px 5px #888;
	-khtml-box-shadow: 0 0 5px 5px #888;
	box-shadow: 0 0 1px 1px #888;
}

span#search {
	margin: 3px 5px;
	padding: 2px 5px;
	vertical-align: middle;
	text-align: left;
	font-size: 1em;
	color: #0000EE;
	float: right;
}
</style>
