package com.lab6.interpreter.commands;

import com.lab6.dataTransfer.DataTransference;
import com.lab6.dataTransfer.Request;
import com.lab6.dataTransfer.Response;
import com.lab6.dataTransfer.Utils;
import com.lab6.interpreter.Interpreter;
import com.lab6.lab.Worker;

import java.util.HashMap;


public class RemoveLast extends InterpreterCommand{
    public RemoveLast(Interpreter interpreter){
        super(interpreter);
    }
    public void execute(){
        if(inputManager.getWords().size() < 1 ){ outputManager.println("Неверное количество аргументов"); return;}
            Request rq = new Request("remove_last", new HashMap<>());
            if(client.sendRequest(rq)){
                Response resp = client.receive();
                Utils.printResponseMessages(resp);
            }
    }
    @Override
    public String info(){
        return "Удаляет последнего рабочего";
    }
}
