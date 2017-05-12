package com.epam.lab.client;

import com.epam.lab.model.RemovingResponse;
import com.epam.lab.model.User;
import com.epam.lab.utils.CustomMapperException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse;

import java.io.IOException;

/**
 * Created by Mykola_Kliuchkovskyy on 5/12/2017.
 */
public class ResponseMapper {

    public static User getUser(ClientResponse response){
        String jsonResponse = response.getEntity(String.class);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(jsonResponse);
        try{
            return mapper.readValue(jsonResponse, User.class);
        }catch (IOException e){
            throw new CustomMapperException("Cannot map response to class : " + User.class.getName() + "\n" + e);
        }
    }

    public static User[] getUsers(ClientResponse response){
        String jsonResponse = response.getEntity(String.class);
        ObjectMapper mapper = new ObjectMapper();
        try{
            return mapper.readValue(jsonResponse, User[].class);
        }catch (IOException e){
            throw new CustomMapperException("Cannot map response to class : " + User[].class.getName() + "\n" + e);
        }
    }

    public static RemovingResponse removingUsers(ClientResponse response){
        String jsonResponse = response.getEntity(String.class);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(jsonResponse);
        try{
            return mapper.readValue(jsonResponse, RemovingResponse.class);
        }catch (IOException e){
            throw new CustomMapperException("Cannot map response to class : " + RemovingResponse.class.getName() + "\n" + e);
        }
    }

}
