package fr.lernejo.navy_battle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

public class StartHandlerServ implements HttpHandler {
    Server serv;
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        System.out.println("req");
        if (httpExchange.getRequestMethod().equals("POST")) {
            try {
                String json = new String(httpExchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
                NavyPlayer p = new NavyPlayer().fromJson(json);
                this.getServ().setOpponnent(p);
                String response = this.getServ().getNavyPlayer().toJson();
                sendResponse(httpExchange, response);
                httpExchange.close();
            } catch (IOException e) {
                httpExchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);
            }
        }
        else
        {
            httpExchange.sendResponseHeaders(HttpURLConnection.HTTP_NOT_FOUND, 0);
            return;
        }
    }

    Server getServ()
    {
        return this.serv;
    }
    public void sendResponse(HttpExchange httpExchange, String response) throws IOException {
        httpExchange.sendResponseHeaders(HttpURLConnection.HTTP_ACCEPTED, response.getBytes().length);
        httpExchange.getResponseBody().write(response.getBytes());
    }
}
