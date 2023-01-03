package com.WS.StartTransaction;

import com.WS.Message.ReqMessage;
import com.WS.Message.ResMessage;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class StartTransactionResponse {

    public ResMessage getStartTransactionReq(ReqMessage reqMessage) {
        JSONObject jsonobj = new JSONObject();
        JSONObject start = new JSONObject();
        ResMessage resMessage = new ResMessage();
        start.put("expiryDate", ZonedDateTime.now(ZoneId.of("Z")).toString());
        start.put("paredtIdTag", "PTAG");
        start.put("status","Accepted");
        jsonobj.put("idTagInfo",start);
        jsonobj.put("transactionId", 123);
        resMessage.setMessageType(3);
        resMessage.setMessageUniqueID(reqMessage.messageUniqueID);
        resMessage.setJsonObject(jsonobj);
        return resMessage;
    }
}
