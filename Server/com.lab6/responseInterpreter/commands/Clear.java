package com.lab6.responseInterpreter.commands;


import com.lab6.dataTransfer.Request;
import com.lab6.dataTransfer.Response;
import com.lab6.responseInterpreter.Interpreter;

import java.util.ArrayList;
import java.util.HashMap;

public class Clear extends Command {
    public Clear(Interpreter interpreter) {
        super(interpreter);
    }

    public Response execute(Request rq) {
        manager.clear();
        ArrayList<String> messages = new ArrayList<>();
        messages.add("Коллекция очищена");
        return new Response(Response.Status.OK, messages, new HashMap<>());


    }
}
