package com.lab6.interpreter.commands;


import com.lab6.builders.lineBuilders.LineWorkerBuilder;
import com.lab6.dataTransfer.DataTransference;
import com.lab6.dataTransfer.Request;
import com.lab6.dataTransfer.Response;
import com.lab6.dataTransfer.Utils;
import com.lab6.interpreter.Interpreter;
import com.lab6.lab.Worker;

import java.io.IOException;
import java.util.HashMap;


public class Add extends InterpreterCommand{
    public Add(Interpreter interpreter){
        super(interpreter);
    }
    public void execute(){
        if(inputManager.getWords().size() < 1){ outputManager.println("Неверное количество аргументов"); return;}

        LineWorkerBuilder builder = new LineWorkerBuilder(inputManager, outputManager);
        try {
            Worker worker = builder.build();
            HashMap<String, DataTransference<?>> arguments = new HashMap<>();
            arguments.put("worker", new DataTransference<Worker>(Worker.class, worker));

            Request rq = new Request("add", arguments);
            if(client.sendRequest(rq)){
                Response resp = client.receive();
                Utils.printResponseMessages(resp);
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }



    }
    @Override
    public String info(){
        return "создать новый элемент коллекции. add";
    }
}