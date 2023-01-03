package com.WS.PayInfo;

import com.WS.Message.ReqMessage;
import com.WS.Message.ResMessage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PayInfoResponse {
    public ResMessage getPayInfoReq(ReqMessage reqMessage) throws ParseException {
        JSONParser parser = new JSONParser();
        ResMessage resMessage = new ResMessage();
        String str = "{\"status\":\"Accepted\",\"data\":\"{\\\"status\\\":\\\"Accepted\\\"}\"}";
        JSONObject jsonObject = (JSONObject)  parser.parse(str);
        resMessage.setMessageType(3);
        resMessage.setMessageUniqueID(reqMessage.messageUniqueID);
        resMessage.setJsonObject(jsonObject);
        return resMessage;
    }
}
