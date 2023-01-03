package com.WS.MeterValues;

import com.WS.Message.ReqMessage;
import com.WS.Message.ResMessage;
import org.json.simple.JSONObject;

public class MeterValueResponse {

    public ResMessage getMeterValueReq(ReqMessage reqMessage) {
        JSONObject jsonobj = new JSONObject();
        ResMessage resMessage = new ResMessage();
        resMessage.setMessageType(3);
        resMessage.setMessageUniqueID(reqMessage.messageUniqueID);
        resMessage.setJsonObject(jsonobj);
        return resMessage;
    }
}
