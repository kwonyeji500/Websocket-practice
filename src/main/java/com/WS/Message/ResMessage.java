package com.WS.Message;

import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@Getter
@Setter
public class ResMessage {

    public int messageType;
    public String messageUniqueID;
    public JSONObject jsonObject;






    public JSONArray array(ResMessage realMessage) {
        JSONArray array = new JSONArray();
        array.add(realMessage.getMessageType());
        array.add(realMessage.getMessageUniqueID());
        array.add(realMessage.getJsonObject());
        return array;
    }

    }

