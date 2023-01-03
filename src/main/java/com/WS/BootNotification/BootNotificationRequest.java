package com.WS.BootNotification;


import com.WS.Message.ReqMessage;
import com.WS.Message.ResMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.socket.WebSocketSession;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;


@Getter
@Setter

public class BootNotificationRequest {


    private String chargeBoxSerialNumber;
    private String chargePointModel;
    private String chargePointSerialNumber;
    private String chargePointVendor;
    private String firmwareVersion;
    private String iccid;
    private String imsi;
    private String meterSerialNumber;
    private String meterType;


    public void bootReq(ReqMessage reqMessage) {
        BootNotificationRequest bootNotificationRequest = new BootNotificationRequest();
        JSONObject jsonObject = reqMessage.getJsonObject();
        if (jsonObject.get("chargePointModel") != null) {
            bootNotificationRequest.setChargePointModel(jsonObject.get("chargePointModel").toString());
        }
        if (jsonObject.get("chargePointVendor") != null) {
            bootNotificationRequest.setChargePointVendor(jsonObject.get("chargePointVendor").toString());
        }
        if (jsonObject.get("chargePointSerialNumber") != null) {
            bootNotificationRequest.setChargePointSerialNumber(jsonObject.get("chargePointSerialNumber").toString());
        }
        if (jsonObject.get("imsi") != null) {
            bootNotificationRequest.setImsi(jsonObject.get("imsi").toString());
        }
        if (jsonObject.get("firmwareVersion") != null) {
            bootNotificationRequest.setFirmwareVersion(jsonObject.get("firmwareVersion").toString());
        }
    }
}
