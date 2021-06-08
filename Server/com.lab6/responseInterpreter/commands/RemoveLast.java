package com.lab6.responseInterpreter.commands;

import com.lab6.dataTransfer.Request;
import com.lab6.dataTransfer.Response;
import com.lab6.lab.Worker;
import com.lab6.responseInterpreter.Interpreter;

import java.util.ArrayList;
import java.util.HashMap;


public class RemoveLast extends Command {
    public RemoveLast(Interpreter interpreter) {
        super(interpreter);
    }

    public Response execute(Request rq) {
        ArrayList<String> messages = new ArrayList<>();
        manager.removeLast();
        messages.add("Выполнено");

        return new Response(Response.Status.OK, messages, new HashMap<>());


    }

}