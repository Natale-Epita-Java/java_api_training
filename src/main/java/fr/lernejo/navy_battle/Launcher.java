package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Launcher {



    public static void main(String[] args) throws IOException {
        if (args.length == 1)
        {
            final int port = Integer.parseInt(args[0]);
            NavyPlayer p = new NavyPlayer("1234", "http://" + "localhost" + ':' + port, "May the best code win");


            System.out.println("servlauch ?");

            Server server = new Server("localhost", port, p);
            //public static HttpServer serv = HttpServer create()
            //ipand port

            server.servStart();
        }
        else if (args.length == 2)
        {
            final int port = Integer.parseInt(args[0]);
            final String ip = args[1];
            NavyPlayer p = new NavyPlayer("98876", "http://" + ip + ':' + port, "May the best code win");


            System.out.println("Client ?");

            Server server = new Server(ip, port, p);
            //public static HttpServer serv = HttpServer create()
            //ipand port

            server.clientStart();
        }
    }
    void setOpponnent(NavyPlayer player)
    {
        System.out.println("Player2 connecting...");
        System.out.println(player);
    }

}
