import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequestWithBody;

import java.io.IOException;
import java.util.List;

public class YouAreEll {


    YouAreEll() {
    }

    public static void main(String[] args) throws JsonProcessingException {

        YouAreEll urlhandler = new YouAreEll();
        System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
        System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
        urlhandler.postId("Kay", "kfennimore");
        urlhandler.postMsg("kfennimore", "bell7692", "hey Bo!");
    }


    public String postId(String name, String github) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        id id = new id(name, github);
        String payload = objectMapper.writeValueAsString((id));
        MakeURLCall("/ids", "POST", payload);


        return objectMapper.writeValueAsString(id);
    }

    public String get_ids() {

        return MakeURLCall("/ids", "GET", "");
    }

    public void postMsg(String fromId, String toId, String message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Message msg = new Message(fromId, toId, message);
        String payload = objectMapper.writeValueAsString((msg));
        String url = "/ids/" + toId + "/messages";
        MakeURLCall(url, "POST", payload);

    }

    public String msgParse() throws IOException {
        String string = MakeURLCall("/messages","GET" ,"" );
        ObjectMapper objectMapper = new ObjectMapper();
        List<Message> message = objectMapper.readValue(string, new TypeReference<List<Message>>(){});

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < message.size(); i++) {
            sb.append("From Id: " + message.get(i).getFromId() + "\n");
            sb.append("To Id: " + message.get(i).getToId() + "\n");
            sb.append("Message: " + message.get(i).getMessage() + "\n");
            sb.append("Timestamp: " + message.get(i).getTimestamp() + "\n");
        }
        return sb.toString();
    }

    public String get_messages() {

        return MakeURLCall("/messages", "GET", "");
    }



    public String MakeURLCall(String mainurl, String method, String jpayload) {

        String url ="http://zipcode.rocks:8085" + mainurl;
        GetRequest request = Unirest.get(url);
        HttpRequestWithBody request1 = Unirest.post(url);
        HttpRequestWithBody request2 = Unirest.post(url);


        if(method.equals("GET")) {
            try {
                return request.asJson().getBody().toString();
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        } else if(method.equals("POST")) {
            try {
                return request1.body(jpayload).asJson().getBody().toString();
            } catch (UnirestException e) {
                e.printStackTrace();
            }
//        } else if(method.equals("PUT")) {
//            try {
//                return request2.asJson().getBody().toString();
//            } catch (UnirestException e) {
//                e.printStackTrace();
//            }
        }
        return "nada";
    }
}
