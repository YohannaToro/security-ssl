package model.persistence;

import model.model.User;

public interface UserPersistence {
    public void create(User user);
    public User getUserByemail(String email);
    

}