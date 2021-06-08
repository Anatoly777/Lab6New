package com.lab6.responseInterpreter.commands;


import com.lab6.dataTransfer.Request;
import com.lab6.dataTransfer.Response;
import com.lab6.responseInterpreter.Interpreter;

import java.util.ArrayList;
import java.util.HashMap;

public class MinByStatus extends Command {
    public MinByStatus(Interpreter interpreter) {
        super(interpreter);
    }

    public Response execute(Request rq) {
        ArrayList<String> messages = new ArrayList<>();

        messages.add("Элемент с id [" + manager.minByStatus() + "] имеет макс. salary");
        return new Response(Response.Status.OK, messages, new HashMap<>());

    }

}
