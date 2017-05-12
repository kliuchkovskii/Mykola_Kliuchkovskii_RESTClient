package com.epam.lab.bo;

import com.epam.lab.client.UserClient;
import com.epam.lab.model.LoginRequestModel;
import com.epam.lab.model.User;

/**
 * Created by Mykola_Kliuchkovskyy on 5/12/2017.
 */
public class LoginBO {
    private UserClient client = new UserClient();

    public User login(String email, String password){
        return client.loginUser(new LoginRequestModel(email, password));
    }

    public User login(User user){
        return client.loginUser(new LoginRequestModel(user.getEmail(), user.getPassword()));
    }
}
