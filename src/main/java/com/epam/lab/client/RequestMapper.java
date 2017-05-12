package com.epam.lab.client;

import com.epam.lab.model.User;
import com.epam.lab.utils.CustomMapperException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by Mykola_Kliuchkovskyy on 5/12/2017.
 */
public class RequestMapper {

    public static String createRequestEntity(Object requestEntity) {
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(requestEntity);
        } catch (IOException e) {
            throw new CustomMapperException(e.getMessage());
        }
    }
}
