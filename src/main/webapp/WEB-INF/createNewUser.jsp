<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String[] prefs = (String[]) request.getAttribute("prefs"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/createUser.css">
	<link rel="shortcut icon" href="img/icon.png" type="image/x-icon">
	<title>新規登録</title>
</head>
<body>
	<div class="main">
		<div class="container">
			<div class="wapper">
				<form action="createUser" method="post" class="form" id="form">
					<div class="input">
						<label for="email" class="label">メールアドレス</label>
						<input type="text" name="email" class="inputText" id="email" required>
					</div>
					<div class="input">
						<label for="password" class="label">パスワード</label>
						<input type="password" name="password" class="inputText" id="password" required>
					</div>
					<div class="input">
						<label for="password" class="label">パスワード(確認用)</label>
						<input type="password" name="confirm" class="inputText" id="confirm" required>
					</div>
					<div class="input">
						<label for="userName" class="label">ニックネーム</label>
						<input type="text" name="userName" class="inputText" id="userName" required>
					</div>
					<div class="input">
						<label for="pref" class="label">都道府県</label>
						<select name="prefecture" class="select">
							<% for (int i = 0; i < prefs.length; i++) { %>
								<option value="<%= i + 1 %>"><%= prefs[i]%></option>
							<% } %>
						</select>
					</div>
					<input type="submit" value="送信" class="submitButton disable" id="submitButton">
				</form>
			</div>
		</div>
	</div>
	<script src="js/createUser.js"></script>
</body>
</html>
