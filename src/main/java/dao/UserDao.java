package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.UserBean;

public class UserDao extends CommonDao {
	public List<UserBean> findAll() {
		List<UserBean> users = new ArrayList<UserBean>();

		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "SELECT * FROM user";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int userId = rs.getInt("userId");
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String createdAt = rs.getString("createdAt");
				String imagePath = rs.getString("imagePath");
				String bio = rs.getString("bio");

				UserBean user = new UserBean(userId, userName, password, email, createdAt, imagePath, bio);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public boolean insert(UserBean user) {
		if (this.isExistsUser(user.getUserId())) return false;

		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			LocalDateTime nowDate = LocalDateTime.now();
			DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String now = dtf1.format(nowDate);

			String sql = "INSERT INTO user(userName, password, email, createdAt, imagePath, bio) VALUES(?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, now);
			ps.setString(5, user.getImagePath());
			ps.setString(6, user.getBio());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	public UserBean findUser(int userId) {
		List<UserBean> users = this.findAll();
		
		for (UserBean user: users) {
			if (user.getUserId() == userId) return user;
		}

		return null;
	}
	
	public boolean isExistsUser(int userId) {
		return this.findUser(userId) != null;
	}

	public void delete(int id) {
		if (!this.isExistsUser(id)) return;

		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "DELETE FROM user WHERE userId = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
