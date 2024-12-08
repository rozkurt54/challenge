package org.enoca.challenge.core.tools;

import org.springframework.http.HttpStatusCode;

import java.util.*;

public class StandardizedResponseUtil {

    public static Map<String, Object> createSuccessResponse(HttpStatusCode httpStatusCode, String message, Object data) {

        var responseMap = new HashMap<String, Object>();

        responseMap.put("code", httpStatusCode.value());
        responseMap.put("message", message);
        responseMap.put("data", data);

        return responseMap;

    }

    public static Map<String, Object> createSuccessResponse(HttpStatusCode httpStatusCode, String message) {

        var responseMap = new HashMap<String, Object>();

        responseMap.put("code", httpStatusCode.value());
        responseMap.put("message", message);

        return responseMap;

    }

    public static Map<String, Object> createErrorResponse(HttpStatusCode httpStatusCode, String message) {


        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("code", httpStatusCode.value());

        responseMap.put("message", message);

        return responseMap;

    }

    public static Map<String, Object> createErrorResponse(HttpStatusCode httpStatusCode, Map<String, String> messages) {


        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("code", httpStatusCode.value());

        responseMap.put("message", messages);

        return responseMap;

    }




}
