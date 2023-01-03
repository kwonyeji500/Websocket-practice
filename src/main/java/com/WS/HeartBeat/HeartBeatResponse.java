package com.WS.HeartBeat;

import com.WS.Message.ReqMessage;
import com.WS.Message.ResMessage;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class HeartBeatResponse {
    public ResMessage getHeartBeatReq(ReqMessage reqMessage) {
        ResMessage resMessage = new ResMessage();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("currentTime", ZonedDateTime.now(ZoneId.of("Z")).toString());
        resMessage.setMessageType(3);
        resMessage.setMessageUniqueID(reqMessage.messageUniqueID);
        resMessage.setJsonObject(jsonObject);
        return resMessage;
    }
}
