package com.WS.BootNotification;

import com.WS.Message.ReqMessage;
import com.WS.Message.ResMessage;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class BootNotificationResponse {

    public ResMessage getBootReq(ReqMessage reqMessage) {
        JSONObject jsonobj = new JSONObject();
        ResMessage resMessage = new ResMessage();
        jsonobj.put("currentTime", ZonedDateTime.now(ZoneId.of("Z")).toString());
        jsonobj.put("interval", 120);
        jsonobj.put("status", "Accepted");
        resMessage.setMessageType(3);
        resMessage.setMessageUniqueID(reqMessage.getMessageUniqueID());
        resMessage.setJsonObject(jsonobj);
        return resMessage;
    }
}
