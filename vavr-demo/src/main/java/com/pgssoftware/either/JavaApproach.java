package com.pgssoftware.either;

import java.util.HashMap;
import java.util.Map;

public class JavaApproach {




    public Long process(long id) {
        Map<String, Object> stringObjectMap = successOrFailure(id);

        Long defaultResult = Long.valueOf("123");

        if (stringObjectMap.get("FAILURE") != null) {
            //process failure
            //additional calls here
            return defaultResult;
        } else {
            Object success = stringObjectMap.get("SUCCESS");
            //process success
            Long success1 = (Long) success;
            return success1;
        }
    }

    private Map<String, Object> successOrFailure(long id) {

        HashMap<String, Object> result = new HashMap<>();

        if (id > 40) {
            result.put("FAILURE", "NOT_FOUND");
        } else {
            result.put("SUCCESS", id);
        }

        return result;
    }
}
