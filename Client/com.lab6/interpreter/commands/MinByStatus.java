package com.lab6.interpreter.commands;


import com.lab6.dataTransfer.Request;
import com.lab6.dataTransfer.Response;
import com.lab6.dataTransfer.Utils;
import com.lab6.interpreter.Interpreter;


import java.util.HashMap;

public class MinByStatus extends InterpreterCommand {
    public MinByStatus(Interpreter interpreter){
        super(interpreter);
    }
    public void execute(){
        Request rq = new Request("min_by_status", new HashMap<>());
        if(client.sendRequest(rq)){
            Response resp = client.receive();
            Utils.printResponseMessages(resp);
        }


    }
    @Override
    public String info(){
        return "Показывает рабочего с минимальным статусом";
    }

}
