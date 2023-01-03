package com.WS.GetPrice;

import com.WS.Message.ReqMessage;
import com.WS.Message.ResMessage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetPriceResponse {
    public ResMessage getPriceReq(ReqMessage reqMessage) throws ParseException {
        JSONParser parser = new JSONParser();
        ResMessage resMessage = new ResMessage();
        String str = "{\"data\":\"{\\\"unitPrice\\\":120,\\\"connectorId\\\":1,\\\"currency\\\":\\\"KRW\\\"}\",\"status\":\"Accepted\"}";
        JSONObject jsonObject = (JSONObject) parser.parse(str);
        resMessage.setMessageType(3);
        resMessage.setMessageUniqueID(reqMessage.messageUniqueID);
        resMessage.setJsonObject(jsonObject);
        return  resMessage;
    }
}
