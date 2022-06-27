/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.carols_boutique_pos.IM;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonWriter;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author muaad
 */
@ServerEndpoint("/IBTchatroomEndpoint")
public class IBTChatRoom {
    static Set<Session> users = Collections.synchronizedSet(new HashSet<Session>());
    
    //when new connection is established
    @OnOpen
    public void handleOpen(Session userSession){
        users.add(userSession);
        System.out.println((String) userSession.getUserProperties().get("username") + " has connected!");
        
    }
    
    //When message is recieved
    @OnMessage
    public void handleMessage(String message, Session userSession) throws IOException{
        String username = (String) userSession.getUserProperties().get("username");
        if (username == null) {
            userSession.getUserProperties().put("username", message);
            userSession.getBasicRemote().sendText(buildJsonData("System", "you are now connected as " + message));
            
        }else{
            Iterator<Session> iterator = users.iterator();
            while(iterator.hasNext())iterator.next().getBasicRemote().sendText(buildJsonData(username, message));
            
        }
    }
    
    //when connection is closed
    @OnClose
    public void handleClose(Session userSession){
        users.remove(userSession);
    }
    
    private String buildJsonData(String username, String message){
        JsonObject jsonObject = Json.createObjectBuilder().add("message", username + ": " + message).build();
        StringWriter stringWriter = new StringWriter();
 
        try (JsonWriter jsonWriter = Json.createWriter(stringWriter)){jsonWriter.write(jsonObject);}  
        return stringWriter.toString();
    }
}
