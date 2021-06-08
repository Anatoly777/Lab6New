package com.lab6;

import com.lab6.dataTransfer.Request;
import com.lab6.interpreter.Interpreter;
import com.lab6.io.CommandLineInputManager;
import com.lab6.io.CommandLineOutManager;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here


        CommandLineInputManager manager = new CommandLineInputManager();
        Request rq;
        Client client = new Client();
        client.connect(new byte[]{127,0,0,1}, 13337);
        if(!client.isConnected()){
            client.waitConnection();
        }
        Interpreter interpreter = new Interpreter(new CommandLineInputManager(), new CommandLineOutManager(), client);
        interpreter.run();



    }
}
