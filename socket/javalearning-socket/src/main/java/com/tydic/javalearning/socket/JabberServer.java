package com.tydic.javalearning.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class JabberServer {
    public static final int PORT = 8080;
    public static void main(String[] args) throws IOException{
        ServerSocket s = new ServerSocket(PORT);
        System.out.println("Started:"+s);
        try{
            Socket socket = s.accept();
            try {
                System.out.println("Connection accepted:"+socket);
                BufferedReader in = new BufferedReader(
                                        new InputStreamReader(
                                                socket.getInputStream()
                                     ));
                PrintWriter out = new PrintWriter(
                                        new BufferedWriter(
                                                new OutputStreamWriter(
                                                        socket.getOutputStream()
                                                )
                                        ),true
                                    );
                while (true){
                    String str = in.readLine();
                    if ("END".equals(str))break;
                    System.out.println("Echoing:"+str);
                    out.println(str);
                }

            }finally {
                System.out.println("closing....");
                s.close();
            }
        }finally {
            s.close();
        }
    }
}
