package com.dms.beiam.restapi.config;

public class RestApiRoutes {
    public static final String API_V1 = "/api/v1";
    public static final String SYSTEM_V1 = "/system" + API_V1;

    //identity
    public static final String REGISTER_IDENTITY = API_V1 + "/register";

    //realm
    public static final String REALM = SYSTEM_V1 + "/realm";
    public static final String REGISTER_REALM = REALM + "/register";
}
