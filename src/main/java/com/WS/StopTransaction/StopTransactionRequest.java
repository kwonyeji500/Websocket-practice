package com.WS.StopTransaction;

import com.WS.Message.ReqMessage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;

public class StopTransactionRequest {
    private String reason;
    private JSONArray transactionData;
    private String idTag;
    private int transactionId;
    private int meterStop;
    private LocalDateTime timestamp;

    public void stopTransactionReq(ReqMessage reqMessage) {
        JSONObject jsonObject = reqMessage.getJsonObject();
        if (jsonObject.get("reason") != null) {
            reason = jsonObject.get("reason").toString();
        }
        if (jsonObject.get("transactionData") != null) {
            transactionData = (JSONArray) jsonObject.get("transactionData");
        }
        if (jsonObject.get("idTag") != null) {
            idTag = jsonObject.get("idTag").toString();
        }
        if (jsonObject.get("transactionId") != null) {
            transactionId = Integer.parseInt(jsonObject.get("transactionId").toString());
        }
        if (jsonObject.get("meterStop") != null) {
            meterStop = Integer.parseInt(jsonObject.get("meterStop").toString());
        }
        if (jsonObject.get("timestamp") != null) {
            timestamp = (LocalDateTime) jsonObject.get("timestamp");
        }

    }
}
