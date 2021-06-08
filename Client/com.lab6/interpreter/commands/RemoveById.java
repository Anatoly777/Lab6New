package com.lab6.interpreter.commands;

import com.lab6.dataTransfer.DataTransference;
import com.lab6.dataTransfer.Request;
import com.lab6.dataTransfer.Response;
import com.lab6.dataTransfer.Utils;
import com.lab6.interpreter.Interpreter;

import java.util.HashMap;


public class RemoveById extends InterpreterCommand {
    public RemoveById (Interpreter interpreter){
        super(interpreter);
    }
    public void execute(){
        if(inputManager.getWords().size() < 2 || inputManager.getWords().get(1).isEmpty() ){ outputManager.println("Неверное количество аргументов"); return;}
        String id = inputManager.getWords().get(1);


        HashMap<String, DataTransference<?>> arguments = new HashMap<>();
        arguments.put("id", new DataTransference<String>(String.class, id));

        Request rq = new Request("remove_key", arguments);
        if(client.sendRequest(rq)){
            Response resp = client.receive();
            Utils.printResponseMessages(resp);
        }


    }
    @Override
    public String info(){
        return "Удаляя объект по id. remove <id>";
    }

}
