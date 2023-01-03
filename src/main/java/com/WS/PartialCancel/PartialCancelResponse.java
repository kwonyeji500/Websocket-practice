package com.WS.PartialCancel;

import com.WS.Message.ReqMessage;
import com.WS.Message.ResMessage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PartialCancelResponse {
    public ResMessage getPartialCancelReq(ReqMessage reqMessage) throws ParseException {
        ResMessage resMessage = new ResMessage();
        JSONParser parser = new JSONParser();
        String str = "{\"status\":\"Accepted\",\"data\":\"{\\\"status\\\":\\\"Accepted\\\"}\"}";
        JSONObject jsonObject = (JSONObject) parser.parse(str);
        resMessage.setMessageType(3);
        resMessage.setMessageUniqueID(reqMessage.messageUniqueID);
        resMessage.setJsonObject(jsonObject);
        return  resMessage;
    }
}
