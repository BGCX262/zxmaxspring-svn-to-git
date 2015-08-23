package example;

import org.springframework.security.providers.dao.salt.ReflectionSaltSource;
import org.springframework.security.providers.encoding.ShaPasswordEncoder;

import com.mycompany.app.dao.UserDao;
import com.mycompany.app.model.User;

public class UserDetailsServiceImpl {

	private UserDao userDao;
	private ShaPasswordEncoder passwordEncoder;
	private ReflectionSaltSource saltSource;

	public void registerAccount1(User account) {
		userDao.save(account); // 1
		String encPassword = passwordEncoder.encodePassword(account.getPassword(), null); // 2
		account.setPassword(encPassword); // 3
		userDao.save(account); // 4
	}

	public void registerAccount(User account) {
		userDao.save(account);
//		UserDetailsAdapter userDetails = new UserDetailsAdapter(account); // 1
//		String password = userDetails.getPassword();
		Object salt = saltSource.getSalt(account); // 2
		String password = account.getPassword();
		account.setPassword(passwordEncoder.encodePassword(password , salt)); // 3
		userDao.save(account);
	}

	// --- getters and setters ------------------------------------------
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public ShaPasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(ShaPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
}
