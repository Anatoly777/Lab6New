package com.lab6.interpreter.commands;


import com.lab6.dataTransfer.Request;
import com.lab6.dataTransfer.Response;
import com.lab6.dataTransfer.Utils;
import com.lab6.interpreter.Interpreter;

import java.util.HashMap;

public class Info extends InterpreterCommand{
    public Info(Interpreter interpreter){
        super(interpreter);
    }
    public void execute(){
        Request rq = new Request("info", new HashMap<>());
        if(client.sendRequest(rq)){
            Response resp = client.receive();
            Utils.printResponseMessages(resp);
        }


    }
    @Override
    public String info(){
        return "Вывести информацию о коллекции";
    }
}
