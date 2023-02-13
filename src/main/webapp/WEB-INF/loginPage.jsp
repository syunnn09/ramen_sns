<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/loginPage.css">
<link rel="shortcut icon" href="../img/icon.png" type="image/x-icon">
<title>ログイン</title>
</head>
<body>
	<div class="main">
		<div class="container">
			<div class="wapper">
				<form action="login" method="POST" id="form">
					<div class="input">
						<label for="email">メールアドレス</label> <input type="email"
							name="email" id="email">
					</div>
					<div class="input">
						<label for="password">パスワード</label> <input type="password"
							name="password" id="password">
					</div>
					<input type="submit" class="submitButton" value="ログイン">
				</form>
			</div>
		</div>
	</div>
</body>
</html>
