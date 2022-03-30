package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class OkHandler  implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        final String body = "OK";
        httpExchange.sendResponseHeaders(200, body.length());
        try(OutputStream os = httpExchange.getResponseBody()) {
            os.write(body.getBytes());
        }
    }
}
