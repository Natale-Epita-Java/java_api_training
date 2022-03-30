package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class Server {

    private final AtomicReference<NavyPlayer> oponnent = new AtomicReference<>();
    private final AtomicReference<HttpServer> httpServer = new AtomicReference<>();
    private final String ip;
    private final int port;
    private final NavyPlayer player;

    public Server(String ip, int port, NavyPlayer player) {
        this.ip = ip;
        this.port = port;
        this.player = player;

    }


    public void clientStart() throws IOException {
        InetSocketAddress socket = new InetSocketAddress("localhost",port);
        System.out.println(port);
        HttpServer server = HttpServer.create(socket,10);


        final ExecutorService executor;
        executor = Executors.newFixedThreadPool(1);
        server.setExecutor(executor);

        HttpContext context1 = server.createContext("/ping", new OkHandler());
        HttpContext context2 = server.createContext("/api/game/start", new StartHandlerServ());


        String adversaryUrl = this.getNavyPlayer().getUrl();
        HttpRequest requetePost = HttpRequest.newBuilder()
            .uri(URI.create(adversaryUrl + "/api/game/start"))
            .setHeader("Accept", "application/json")
            .setHeader("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString("{\"id\":\"1\", \"url\":\"http://localhost:" + port + "\", \"message\":\"hello\"}"))
            .build();

        server.start();
    }



    public void servStart() throws IOException {
        InetSocketAddress socket = new InetSocketAddress("localhost", port);
        System.out.println(port);
        HttpServer server = HttpServer.create(socket, 10);


        final ExecutorService executor;
        executor = Executors.newFixedThreadPool(1);
        server.setExecutor(executor);

        HttpContext context1 = server.createContext("/ping", new OkHandler());
        HttpContext context2 = server.createContext("/api/game/start", new StartHandlerServ());

        //this.httpServer.set(server);
        server.start();
        System.out.println("Server available at http://" + socket);

    }
    public void stopHttpServer() {
        this.httpServer.get().stop(0);
    }

    public NavyPlayer getOponnent() {
        return oponnent.get();
    }

    public void setOpponnent(NavyPlayer p) {
        System.out.println("New opponent as arrived :");
        System.out.println(p);
        oponnent.set(p);
    }

    public NavyPlayer getNavyPlayer() {
        return player;
    }

}
