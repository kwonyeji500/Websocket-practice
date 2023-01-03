package com.WS.StatusNotification;

import com.WS.Message.ReqMessage;
import com.WS.Message.ResMessage;
import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONObject;

@Getter
@Setter
public class StatusNotificationRequest {
    private int connectorId;
    private String errorCode;
    private String status;

    StatusNotificationRequest statusNotificationRequest;
    public void statusReq(ReqMessage reqMessage) {

        JSONObject jsonObject = reqMessage.getJsonObject();
        if (jsonObject.get("connectorId") != null) {
            connectorId = Integer.parseInt(jsonObject.get("connectorId").toString());
        }
        if (jsonObject.get("errorCode") != null) {
            errorCode = jsonObject.get("errorCode").toString();
        }
        if (jsonObject.get("status") != null) {
            status = jsonObject.get("status").toString();
        }


    }
}
