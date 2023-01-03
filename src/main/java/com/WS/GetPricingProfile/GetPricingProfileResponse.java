package com.WS.GetPricingProfile;

import com.WS.Message.ReqMessage;
import com.WS.Message.ResMessage;
import org.json.JSONString;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetPricingProfileResponse {

    public ResMessage getPricingReq(ReqMessage reqMessage) throws ParseException {
        JSONParser parser = new JSONParser();
        String string = "{\n" +
                "\"status\":\"Accepted\",\n" +
                "\"data\":\"{\\\"connectorId\\\":1,\\\"profileVersion\\\":1,\\\"pricingProfile\\\":[{\\\"priceType\\\":\\\"Member\\\",\\\"currency\\\":\\\"KRW\\\",\\\"schedule\\\":[{\\\"startPeriod\\\":0,\\\"unitPrice\\\":150.0}]},{\\\"priceType\\\":\\\"NonMember\\\",\\\"currency\\\":\\\"KRW\\\",\\\"schedule\\\":[{\\\"startPeriod\\\":0,\\\"unitPrice\\\":180.0}]}]}\"\n" +
                "}";

        ResMessage resMessage = new ResMessage();
        JSONObject jsonObject = (JSONObject) parser.parse(string);
        resMessage.setMessageType(3);
        resMessage.setMessageUniqueID(reqMessage.messageUniqueID);
        resMessage.setJsonObject(jsonObject);
        return  resMessage;
    }

}
