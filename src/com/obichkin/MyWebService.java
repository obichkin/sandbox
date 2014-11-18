package com.obichkin;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by mobichkin on 20/03/14.
 */
@WebService
public class MyWebService {
    @WebMethod
    public String sayHello(){
        return "Hello .";
    }
}
