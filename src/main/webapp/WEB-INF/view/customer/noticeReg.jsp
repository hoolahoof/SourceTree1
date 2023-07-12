<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeReg</title>
<link rel="stylesheet" href="../css/nstyle.css" />
<script>
	function cancelurl() {
		location.href = "notice.do";
	}
</script>
</head>
<body>
<form action="noticeRegProc.do" method="post" enctype="multipart/form-data">
<table class="twidth">
	<colgroup>
		<col width="15%" />
		<col width="35%" />
		<col width="15%" />
		<col width="35%" />
	</colgroup>
	<caption>write</caption>
		<tbody>
			<tr>
				<th class="left">제목</th>
				<td colspan=3>
					<input type="text" class="inp" name="title" />
				</td>
			</tr>
			<tr>
				<th class="left">내용</th>
				<td colspan=3 id="content">
					<textarea name="content" class="txt"></textarea>
				</td>
			</tr>
			<tr>
				<th class="left">첨부파일</th>
				<td colspan=3 id="addfile">
					<input type="file" name="file" size=50 class="inp" />
				</td>
			</tr>
		</tbody>
</table>
	<input type="hidden" name="id" value="${id }" />
	<input type="submit" value="save" /> 
	<input type="button" value="cancel" class="cancel" / onclick="cancelurl()">
	</form>
</body>
</html>