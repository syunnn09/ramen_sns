<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String[] prefs = (String[]) request.getAttribute("prefs"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
</head>
<body>
	<form action="createUser" method="post">
		<label for="userName">ニックネーム</label>
		<input type="text" name="userName"><br>
		<label for="password">パスワード</label>
		<input type="text" name="password"><br>
		<label for="email">メールアドレス</label>
		<input type="text" name="email">
		<label for="pref"></label>
		<select name="prefecture" id="">
			<% for (int i = 0; i < prefs.length; i++) { %>
				<option value="<%= i %>"><%= prefs[i]%></option>
			<% } %>
		</select>
	</form>
</body>
</html>