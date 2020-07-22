<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>book - insert</title>
</head>
<body>
	<form method="post" action="/book/insert">
		<table border="1">
			<tr>
				<th>도서명</th>
				<td><input type="text" name="b_title"></td>
			</tr>
			<tr>
				<th>저자</th>
				<td><input type="text" name="b_author"></td>
			<tr>
				<th>출판일</th>
				<td><input type="text" name="b_credat"></td>
			</tr>
			
			<tr>
				<th>비고</th>
				<td><input type="text" name="b_desc"></td>
			</tr>
			<tr>
				<th colspan="2"><button>도서정보입력</button>
			</tr>

		</table>
	</form>
</body>
</html>