package com.WS.PartialCancel;

import com.WS.Message.ReqMessage;
import org.json.simple.JSONObject;

public class PartialCancelRequest {
    private String vendorId;
    private String messageId;
    private JSONObject data;

    public void partialCancelReq(ReqMessage reqMessage) {
        JSONObject jsonObject = reqMessage.getJsonObject();
        if (jsonObject.get("vendorId") != null) {
            vendorId = jsonObject.get("vendorId").toString();
        }
        if (jsonObject.get("messageId") != null) {
            messageId = jsonObject.get("messageId").toString();
        }
        if (jsonObject.get("data") != null) {
            data = (JSONObject) jsonObject.get("data");
        }
    }
}
