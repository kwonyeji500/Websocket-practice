package com.WS.StatusNotification;

import com.WS.Message.ReqMessage;
import com.WS.Message.ResMessage;
import org.json.simple.JSONObject;

public class StatusNotificationResponse {
    public ResMessage getStatusReq(ReqMessage reqMessage) {
        JSONObject jsonobj = new JSONObject();
        ResMessage resMessage = new ResMessage();
        resMessage.setMessageType(3);
        resMessage.setMessageUniqueID(reqMessage.getMessageUniqueID());
        resMessage.setJsonObject(jsonobj);
        return resMessage;
    }
}
