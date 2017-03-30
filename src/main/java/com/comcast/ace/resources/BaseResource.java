package com.comcast.ace.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * Created by rbaker216 on 3/30/17.
 */
@Path("/base")
public class BaseResource {
    public BaseResource() {

    }

    @GET
    @Timed
    public String getBase(@QueryParam("param") String param) {
        System.out.println("Inside getBase. Query Param = " + param);

        return "getBase Response";
    }

    @POST
    @Timed
    public String setBase(@QueryParam("param1") String param1, @QueryParam("param2") String param2) {
        System.out.println("In the setBase method....");
        System.out.println("param1: " + param1);
        System.out.println("param2: " + param2);

        return "setBase Response";
    }
}
