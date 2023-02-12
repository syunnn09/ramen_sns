package model;

import java.io.Serializable;

public class UserBean implements Serializable {
	private int userId, prefecture;
	private String userName, password, email, createdAt, imagePath, bio;

	public UserBean() { }

	public UserBean(int userId, String userName, String password, String email, String createdAt, String imagePath, String bio, int prefecture) {
		this.setUserId(userId);
		this.setUserName(userName);
		this.setPassword(password);
		this.setEmail(email);
		this.setCreatedAt(createdAt);
		this.setImagePath(imagePath);
		this.setBio(bio);
		this.setPrefecture(prefecture);
	}

	public UserBean(String userName, String password, String email, String imagePath, String bio, int prefecture) {
		this.setUserName(userName);
		this.setPassword(password);
		this.setEmail(email);
		this.setImagePath(imagePath);
		this.setBio(bio);
		this.setPrefecture(prefecture);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public int getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(int prefecture) {
		this.prefecture = prefecture;
	}

	
}
