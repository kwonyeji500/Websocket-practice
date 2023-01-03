package com.WS.WebSocket;

import com.WS.Authorize.AuthorizeRequest;
import com.WS.Authorize.AuthorizeResponse;
import com.WS.BootNotification.BootNotificationRequest;
import com.WS.BootNotification.BootNotificationResponse;
import com.WS.GetPrice.GetPriceRequest;
import com.WS.GetPrice.GetPriceResponse;
import com.WS.GetPricingProfile.GetPricingProfileRequest;
import com.WS.GetPricingProfile.GetPricingProfileResponse;
import com.WS.HeartBeat.HeartBeatResponse;
import com.WS.Message.ReqMessage;
import com.WS.Message.ResMessage;
import com.WS.MeterValues.MeterValueRequest;
import com.WS.MeterValues.MeterValueResponse;
import com.WS.PartialCancel.PartialCancelRequest;
import com.WS.PartialCancel.PartialCancelResponse;
import com.WS.PayInfo.PayInfoRequest;
import com.WS.PayInfo.PayInfoResponse;
import com.WS.StartTransaction.StartTransactionRequest;
import com.WS.StartTransaction.StartTransactionResponse;
import com.WS.StatusNotification.StatusNotificationRequest;
import com.WS.StatusNotification.StatusNotificationResponse;
import com.WS.StopTransaction.StopTransactionRequest;
import com.WS.StopTransaction.StopTransactionResponse;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.logging.Logger;

@Component
public class WebSocketChatHandler extends TextWebSocketHandler {
    private final static Logger LOG = Logger.getGlobal();


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        LOG.info(message.getPayload());
        String input = message.getPayload();
        ReqMessage reqMessage = new ReqMessage();

        //Json parser
        JSONParser jsonParser = new JSONParser();
        Object result = jsonParser.parse(input);
        JSONArray jsonArray = (JSONArray) result;


        //요청메세지 클래스에 값 저장
        reqMessage.setMessageType(Integer.parseInt(jsonArray.get(0).toString()));
        reqMessage.setMessageUniqueID(jsonArray.get(1).toString());
        reqMessage.setStatus((String) jsonArray.get(2));
        reqMessage.setJsonObject((JSONObject) jsonArray.get(3));

        ResMessage realMessage = new ResMessage();

        //상태 값에따라 클래스지정
            if (reqMessage.getStatus().equals("BootNotification")) {
                BootNotificationRequest bootNotificationRequest = new BootNotificationRequest();
                BootNotificationResponse bootNotificationResponse = new BootNotificationResponse();
                realMessage = bootNotificationResponse.getBootReq(reqMessage);
            }
            if (reqMessage.getStatus().equals("StatusNotification")) {
                StatusNotificationRequest statusNotificationRequest = new StatusNotificationRequest();
                StatusNotificationResponse statusNotificationResponse = new StatusNotificationResponse();
                realMessage = statusNotificationResponse.getStatusReq(reqMessage);
            }
            if (reqMessage.getStatus().equals("Authorize")) {
                AuthorizeRequest authorizeRequest = new AuthorizeRequest();
                AuthorizeResponse authorizeResponse = new AuthorizeResponse();
                realMessage = authorizeResponse.getAuthorizeReq(reqMessage);
            }
            if (reqMessage.getStatus().equals("StartTransaction")) {
                StartTransactionRequest startTransactionRequest = new StartTransactionRequest();
                StartTransactionResponse startTransactionResponse = new StartTransactionResponse();
                realMessage = startTransactionResponse.getStartTransactionReq(reqMessage);
            }
            if (reqMessage.getStatus().equals("MeterValues")){
                MeterValueRequest meterValueRequest = new MeterValueRequest();
                MeterValueResponse meterValueResponse = new MeterValueResponse();
                realMessage = meterValueResponse.getMeterValueReq(reqMessage);
            }
            if (reqMessage.getStatus().equals("StopTransaction")) {
                StopTransactionRequest stopTransactionRequest = new StopTransactionRequest();
                StopTransactionResponse stopTransactionResponse = new StopTransactionResponse();
                realMessage = stopTransactionResponse.getStopTransactionReq(reqMessage);
            }
            if (reqMessage.getStatus().equals("DataTransfer")&&reqMessage.getJsonObject().get("messageId").equals("GetPricingProfile")) {
                GetPricingProfileRequest getPricingProfileRequest = new GetPricingProfileRequest();
                GetPricingProfileResponse getPricingProfileResponse = new GetPricingProfileResponse();
                realMessage = getPricingProfileResponse.getPricingReq(reqMessage);
            }
            if (reqMessage.getStatus().equals("DataTransfer")&&reqMessage.getJsonObject().get("messageId").equals("GetPrice")) {
                GetPriceRequest getPriceRequest = new GetPriceRequest();
                GetPriceResponse getPriceResponse = new GetPriceResponse();
                realMessage = getPriceResponse.getPriceReq(reqMessage);
            }
            if (reqMessage.getStatus().equals("Heartbeat")) {
                HeartBeatResponse heartBeatResponse = new HeartBeatResponse();
                realMessage = heartBeatResponse.getHeartBeatReq(reqMessage);
            }

            if (reqMessage.getStatus().equals("DataTransfer") && reqMessage.getJsonObject().get("messageId").equals("PayInfo")) {
                PayInfoRequest payInfoRequest = new PayInfoRequest();
                PayInfoResponse payInfoResponse = new PayInfoResponse();
                realMessage = payInfoResponse.getPayInfoReq(reqMessage);
            }
            if (reqMessage.getStatus().equals("DataTransfer")&&reqMessage.getJsonObject().get("messageId").equals("PartialCancel")) {
                PartialCancelRequest partialCancelRequest = new PartialCancelRequest();
                PartialCancelResponse partialCancelResponse = new PartialCancelResponse();
                realMessage = partialCancelResponse.getPartialCancelReq(reqMessage);
            }
            String response = JSONArray.toJSONString(realMessage.array(realMessage));

            session.sendMessage(new TextMessage(response));
            LOG.info(response);

    }
}

