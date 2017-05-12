package com.epam.lab;

import com.epam.lab.bo.LoginBO;
import com.epam.lab.bo.ProfileBO;
import com.epam.lab.model.RemovingResponse;
import com.epam.lab.model.User;
import com.epam.lab.model.UserRole;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/**
 * Created by Mykola_Kliuchkovskyy on 5/12/2017.
 */
public class UserServiceTest {

    @DataProvider
    public Object[][] data(){
        return new Object[][]{
                {
                    "John","Li"
                },
                {
                    "Anatoliy","Kryha"
                },
                {
                    "Andrew","Grey"
                }
        };
    }

    @DataProvider
    public Object[][] roles(){
        return new Object[][]{
                {
                        "admin"
                },
                {
                        "user"
                }
        };
    }

    @Test(dataProvider = "data")
    public void getRegisteredUser(String name,String surname){
        User user = new ProfileBO().getUser(name, surname);
        System.out.println(user);
    }

    @Test
    public void getAllRegisteredUser(){
        User[] users = new ProfileBO().getAllUsers();
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test(dataProvider = "roles")
    public void getAllRegisteredUserByRole(String role){
        User[] users = new ProfileBO().getUsersByRole(role);
        System.out.println("All " + role + "s\n");
        for(User user : users){
            System.out.println(user + "\n");
        }
    }

    @Test
    public void removingUsers(){
        RemovingResponse response = new ProfileBO().removeAllUsers();
        assert response.getMessage().equals("All users were deleted successfully");
    }

    @Test(dataProvider = "data")
    public void removeUser(String name,String surname){
        RemovingResponse response = new ProfileBO().removeUser(name, surname);
        assert response.getMessage().equals("User was deleted successfully");
    }

    @Test
    public void loginUser(){
        User user = new User("Andrew","Grey","male",
                "greygrey9919@kolya.com","helloworld","0970000000", UserRole.ADMIN);
        User responseUser = new LoginBO().login(user);
        assert user.equals(responseUser);
    }

}
