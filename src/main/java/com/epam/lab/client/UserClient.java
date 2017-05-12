package com.epam.lab.client;

import com.epam.lab.model.LoginRequestModel;
import com.epam.lab.model.RemovingResponse;
import com.epam.lab.model.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by Mykola_Kliuchkovskyy on 5/12/2017.
 */
public class UserClient {

    private final static String API_URL = "http://localhost:8080/rest/UserService";

    public User getUser(String name, String surname){
        WebResource resource = createResource(String.format("%s/user?name=%s&surname=%s", API_URL, name, surname));
        return ResponseMapper.getUser(resource.get(ClientResponse.class));
    }

    public User[] getAllUsers(){
        WebResource resource = createResource(String.format("%s/users", API_URL));
        return ResponseMapper.getUsers(resource.get(ClientResponse.class));
    }

    public User[] getUsersByRole(String role){
        WebResource resource = createResource(String.format("%s/usersByRole?role=%s", API_URL, role));
        return ResponseMapper.getUsers(resource.get(ClientResponse.class));
    }

    public RemovingResponse removeAllUsers(){
        WebResource resource = createResource(String.format("%s/removeAll", API_URL));
        return ResponseMapper.removingUsers(resource.delete(ClientResponse.class));
    }

    public RemovingResponse removeUser(String name, String surname){
        WebResource resource = createResource(String.format("%s/remove?name=%s&surname=%s", API_URL, name, surname));
        return ResponseMapper.removingUsers(resource.delete(ClientResponse.class));
    }

    public User loginUser(LoginRequestModel loginRequest){
        WebResource resource = createResource(String.format("%s/login", API_URL));
        String request = RequestMapper.createRequestEntity(loginRequest);
        System.out.println(request);
        return ResponseMapper.getUser(resource.post(ClientResponse.class, request));
    }

    public WebResource createResource(String url){
        Client client = Client.create();
        return client.resource(url);
    }

}
