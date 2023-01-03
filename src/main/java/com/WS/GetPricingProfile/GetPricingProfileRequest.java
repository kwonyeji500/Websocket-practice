package com.WS.GetPricingProfile;

import com.WS.Message.ReqMessage;
import org.json.simple.JSONObject;

public class GetPricingProfileRequest {
    private JSONObject data;
    private String vendorId;
    private String messageId;

    public void getPricingReq(ReqMessage reqMessage) {
        JSONObject jsonObject = reqMessage.getJsonObject();
        if (jsonObject.get("data") != null) {
            data = (JSONObject) jsonObject.get("data");
        }
        if (jsonObject.get("vendorId") != null) {
            vendorId = jsonObject.get("vendorId").toString();
        }
        if (jsonObject.get("messageId") != null) {
            messageId = jsonObject.get("messageId").toString();
        }
    }
}
