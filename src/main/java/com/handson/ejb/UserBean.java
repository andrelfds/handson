package com.handson.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.handson.bd.UserBD;
import com.handson.entity.User;
import com.handson.infra.AppRN;

//@Stateful
//@StatefulTimeout(unit = TimeUnit.MINUTES, value = 30)
@Stateless
public class UserBean extends AppRN<User, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UserBD userBD;

	public UserBean() {
		setBD(userBD);
	}
	
	@Inject
	public void setBD(UserBD bd) {
		super.setBD(bd);
	}

	public User findUserByPassword(User user) throws Exception {
		return userBD.findUserByPassword(user);
	}
	
	public boolean findUserLogado(User user) throws Exception {
		return userBD.findUserLogado(user);
	}
	
	public List<User> listUsers() {
		return userBD.listUsers();
	}
	
}
