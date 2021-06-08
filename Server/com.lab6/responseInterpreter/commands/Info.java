package com.lab6.responseInterpreter.commands;


import com.lab6.dataTransfer.Request;
import com.lab6.dataTransfer.Response;
import com.lab6.responseInterpreter.Interpreter;

import java.util.ArrayList;
import java.util.HashMap;

public class Info extends Command {
    public Info(Interpreter interpreter) {
        super(interpreter);
    }

    public Response execute(Request rq) {

        ArrayList<String> messages = new ArrayList<>();

        messages.add("Дата создания: " + manager.creationTime);
        messages.add("Кол-во элементов: " + manager.getWorkers().size());
        messages.add("Тип: " + manager.getClass());
        return new Response(Response.Status.OK, messages, new HashMap<>());


    }

}
