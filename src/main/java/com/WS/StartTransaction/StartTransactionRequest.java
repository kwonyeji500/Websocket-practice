package com.WS.StartTransaction;

import com.WS.Message.ReqMessage;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;

public class StartTransactionRequest {

    private int reservationId;
    private int connectorId;
    private int idTag;
    private int meterStart;
    private LocalDateTime timestamp;

    public void startTransactionReq(ReqMessage reqMessage) {
        JSONObject jsonObject = reqMessage.getJsonObject();
        if (jsonObject.get("reservationId") != null) {
            reservationId = Integer.parseInt(jsonObject.get("reservationId").toString());
        }
        if (jsonObject.get("connectorId") != null) {
            connectorId = Integer.parseInt(jsonObject.get("connectorId").toString());
        }
        if (jsonObject.get("idTag") != null) {
            idTag = Integer.parseInt(jsonObject.get("idTag").toString());
        }
        if (jsonObject.get("meterStart") != null) {
            meterStart = Integer.parseInt(jsonObject.get("meterStart").toString());
        }
        if (jsonObject.get("timestamp") != null) {
            timestamp = (LocalDateTime) jsonObject.get("timestamp");
        }
    }
}
