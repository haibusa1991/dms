package com.dms.beiam.restapi.errorhandler;

public class BeaimErrorCodes {
    public static String BEIAM_ERROR_CODE_LABEL = "beiamErrorCode";
    public static String INTERNAL_SERVER_ERROR = "ISE";
    public static String SERVICE_UNAVAILABLE = "SU";
    public static String BAD_REQUEST = "BR";

    // realm related error codes
    public static String REALM_ALREADY_EXISTS = BAD_REQUEST + "R001";

    // validation error codes
    public static String INPUT_CONSTRAINT_VIOLATION = BAD_REQUEST + "V001";
}
