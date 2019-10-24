package model.persistence.impl;

import java.util.concurrent.ConcurrentHashMap;

import model.model.User;
import model.persistence.UserPersistence;

public class UserPersistenceImpl implements UserPersistence{

    ConcurrentHashMap<String, User> users= new ConcurrentHashMap<>();
    

    public UserPersistenceImpl(){
        User us1= new User("yohanna","123","yohanna.toro");
        User us2= new User("admin","admin","admin");
        users.put("admin",us2);
        users.put("yohanna.toro",us1);
    }

	@Override
	public void create(User user) {
		users.put(user.getEmail(),user);
		
	}

	@Override
	public User getUserByemail(String email) {
		// TODO Auto-generated method stub
		return users.get(email);
	}

    
}