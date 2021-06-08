package com.lab6;

import com.lab6.responseInterpreter.Interpreter;
import com.lab6.workersManager.WorkersManager;

import java.io.IOException;
import java.net.BindException;

public class Main {

    public static void main(String[] args) throws IOException {
        int port;
        if(args.length == 0){
            port = 13337;
        }
        else{
            port = Integer.parseInt(args[1]);
        }
        WorkersManager manager = new WorkersManager();
        try {
            manager.load();
        } catch (Exception ex) {

            manager.dump();

        }

        Interpreter interpreter = new Interpreter(manager);

        Server server = new Server(interpreter);


        try {
            server.bind(port);
            server.run();
        } catch (BindException ex) {
            System.out.println("Порт занят");
        }


    }
}
