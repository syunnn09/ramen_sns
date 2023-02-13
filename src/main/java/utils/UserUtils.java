package utils;

import dao.UserDao;
import model.UserBean;

public class UserUtils {
	public UserBean login(String email, String password) {
		UserDao userDao = new UserDao();
		return userDao.login(email, password);
	}
}
