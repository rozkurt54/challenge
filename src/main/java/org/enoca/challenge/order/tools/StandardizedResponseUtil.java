package org.enoca.challenge.order.tools;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    public static Map<String, Object> createErrorResponse(HttpStatusCode httpStatusCode, String... messages) {


        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("code", httpStatusCode.value());

        if (messages.length > 1) {
            var messageList = new ArrayList<String>(Arrays.asList(messages));
            responseMap.put("messages", messageList);

            return responseMap;
        }

        responseMap.put("message", messages[0]);

        return responseMap;

    }


}
