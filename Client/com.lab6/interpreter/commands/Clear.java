package com.lab6.interpreter.commands;


import com.lab6.dataTransfer.Request;
import com.lab6.dataTransfer.Response;
import com.lab6.interpreter.Interpreter;
import com.lab6.dataTransfer.Utils;
import java.util.HashMap;

public class Clear extends InterpreterCommand{
    public Clear(Interpreter interpreter){
        super(interpreter);
    }
    public void execute(){
        Request rq = new Request("clear", new HashMap<>());
        if(client.sendRequest(rq)){
            Response resp = client.receive();
            Utils.printResponseMessages(resp);
        }

    }
}
