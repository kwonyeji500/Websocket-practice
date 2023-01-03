package com.WS.Authorize;

import com.WS.Message.ReqMessage;
import com.WS.Message.ResMessage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.time.LocalDateTime;

public class AuthorizeResponse {

    public ResMessage getAuthorizeReq(ReqMessage reqMessage) throws ParseException {
        JSONParser parser = new JSONParser();
        String str = "{\"idTagInfo\":{\"expiryDate\":\"2022-12-03T02:08:34.564Z\",\"parentIdTag\":\"P_TAG\",\"status\":\"Accepted\"}}";
        JSONObject jsonobj = (JSONObject) parser.parse(str);
        ResMessage resMessage = new ResMessage();
        resMessage.setMessageType(3);
        resMessage.setMessageUniqueID(reqMessage.messageUniqueID);
        resMessage.setJsonObject(jsonobj);
        return  resMessage;
    }
}
