package com.WS.StopTransaction;

import com.WS.Message.ReqMessage;
import com.WS.Message.ResMessage;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class StopTransactionResponse {
    public ResMessage getStopTransactionReq(ReqMessage reqMessage) {
        JSONObject jsonobj = new JSONObject();
        JSONObject stop = new JSONObject();
        ResMessage resMessage = new ResMessage();
        stop.put("expiryDate", ZonedDateTime.now(ZoneId.of("Z")).toString());
        stop.put("parentIdTag", "PTAG");
        stop.put("status", "Accepted");
        jsonobj.put("idTagInfo", stop);
        resMessage.setMessageType(3);
        resMessage.setMessageUniqueID(reqMessage.messageUniqueID);
        resMessage.setJsonObject(jsonobj);
        return  resMessage;
    }

}
