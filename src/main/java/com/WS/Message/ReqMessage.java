package com.WS.Message;

import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONObject;

@Getter
@Setter
public class ReqMessage {
    public Integer messageType;
    public String messageUniqueID;
    public String status;
    public JSONObject jsonObject;

    }


