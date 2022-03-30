package fr.lernejo.navy_battle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NavyPlayer {
    String id;
    String url;
    String message;



    NavyPlayer(String id, String url, String message)
    {

        this.id = id;
        this.url = url;
        this.message = message;
    }

    public NavyPlayer() {
        this.id = null;
        this.url = null;
        this.message = null;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getMessage() {
        return message;
    }

    public String toJson() {
        ObjectMapper mapper = new ObjectMapper();
        String response;
        try {
            response = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    public NavyPlayer fromJson(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        NavyPlayer player = mapper.readValue(json, NavyPlayer.class);
        return player;
    }

    @Override
    public String toString() {
        return "Player{" + "id=" + id + ", url='" + url + '\'' + ", message='" + message + '\'' + '}';
    }
}
