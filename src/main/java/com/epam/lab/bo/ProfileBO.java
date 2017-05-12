package com.epam.lab.bo;

import com.epam.lab.client.UserClient;
import com.epam.lab.model.RemovingResponse;
import com.epam.lab.model.User;

import java.io.IOException;

/**
 * Created by Mykola_Kliuchkovskyy on 5/12/2017.
 */
public class ProfileBO {
    private UserClient client = new UserClient();

    public User getUser(String name, String surname){
        return client.getUser(name, surname);
    }

    public User[] getAllUsers(){
        return client.getAllUsers();
    }

    public User[] getUsersByRole(String role){
        return client.getUsersByRole(role.toLowerCase());
    }

    public RemovingResponse removeAllUsers(){
        return client.removeAllUsers();
    }

    public RemovingResponse removeUser(String name, String surname){
        return client.removeUser(name, surname);
    }
}
