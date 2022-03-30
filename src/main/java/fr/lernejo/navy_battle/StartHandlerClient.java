package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class StartHandlerClient implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        if (httpExchange.getRequestMethod().equals("POST"))
        {

        }
        else
        {
            final String body = "Not Found";
            httpExchange.sendResponseHeaders(404, body.length());
            try(OutputStream os = httpExchange.getResponseBody()) {
                os.write(body.getBytes());
            }

        }


        final String body = "OK";
        httpExchange.sendResponseHeaders(200, body.length());
        try(OutputStream os = httpExchange.getResponseBody()) {
            os.write(body.getBytes());
        }
    }
}
