package com.WS.MeterValues;

import com.WS.Message.ReqMessage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;

public class MeterValueRequest {
    private int connectorId;
    private JSONArray meterValue;
    private int transactionId;

    public void MeterValueReq(ReqMessage reqMessage) {
        JSONObject jsonObject = reqMessage.getJsonObject();
        if (jsonObject.get("connectorId") != null) {
            connectorId = Integer.parseInt(jsonObject.get("connectorId").toString());
        }
        if (jsonObject.get("meterValue") != null) {
            meterValue = (JSONArray) jsonObject.get("meterValue");
        }
        if (jsonObject.get("transactionId") != null) {
            transactionId = Integer.parseInt(jsonObject.get("transactionId").toString());
        }
    }
}
