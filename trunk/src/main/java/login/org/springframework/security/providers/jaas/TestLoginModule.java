/* Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package login.org.springframework.security.providers.jaas;

import java.security.Principal;

import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.security.providers.encoding.ShaPasswordEncoder;

import com.mycompany.app.dao.UserDao;

/**
 * DOCUMENT ME!
 * 
 * @author Ray Krueger
 * @version $Id: TestLoginModule.java 2217 2007-10-27 00:45:30Z luke_t $
 */
public class TestLoginModule implements LoginModule {
	// ~ Instance fields
	// ================================================================================================

	private String passwordFromLoginPage;
	private String userFromLoginPage;
	private Subject subject;
	private ApplicationContext ctx;
	private UserDao userDao;

	// ~ Methods
	// ========================================================================================================

	public boolean abort() throws LoginException {
		return true;
	}

	public boolean commit() throws LoginException {
		return true;
	}

	public void initialize(Subject subject, CallbackHandler callbackHandler, Map sharedState, Map options) {
		this.subject = subject;

		try {
			TextInputCallback textCallback = new TextInputCallback("prompt");
			NameCallback nameCallback = new NameCallback("prompt");
			PasswordCallback passwordCallback = new PasswordCallback("prompt", false);

			callbackHandler.handle(new Callback[] { textCallback, nameCallback, passwordCallback });

			passwordFromLoginPage = new String(passwordCallback.getPassword());
			userFromLoginPage = nameCallback.getName();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public boolean login() throws LoginException {

		String[] PATH = { "applicationContext-resources.xml",
				"applicationContext-dao.xml",
				"applicationContext-service.xml",
				"applicationContext.xml" };
		
		
		ctx = new ClassPathXmlApplicationContext(PATH);

		UserDao userDao = (UserDao) ctx.getBean("userDao");
		ShaPasswordEncoder sha1 =  (ShaPasswordEncoder) ctx.getBean("sha1");
		
		String passwordOnDb = userDao.getUserPassword(userFromLoginPage);
		
		
		
		// questo dovrebbe essere fatto sul client....
		String encryptedWebPassword = encryptPassword(passwordFromLoginPage);
		
		
		
		
		boolean rightPassword = isRightPassword(passwordOnDb, encryptedWebPassword);
			
		return rightPassword;
	}

	private boolean isRightPassword(String passwordOnDb, String encryptedWebPassword) {
		return encryptedWebPassword.equals(passwordOnDb);
	}

	private String encryptPassword(String passwordFromLoginPage) {
		return passwordFromLoginPage;
	}

	public boolean logout() throws LoginException {
		return true;
	}
}
