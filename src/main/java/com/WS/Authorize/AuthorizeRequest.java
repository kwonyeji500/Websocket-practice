package com.WS.Authorize;

import com.WS.Message.ReqMessage;
import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONObject;

@Getter
@Setter
public class AuthorizeRequest {

    private String idTag;

    public void authorizeReq(ReqMessage reqMessage) {
        JSONObject jsonObject = reqMessage.getJsonObject();
        if (jsonObject.get("idTag") != null) {
            idTag = jsonObject.get("idTag").toString();
        }
    }
}
