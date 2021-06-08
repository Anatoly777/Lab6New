package com.lab6.responseInterpreter.commands;

import com.lab6.dataTransfer.Request;
import com.lab6.dataTransfer.Response;
import com.lab6.lab.Worker;
import com.lab6.responseInterpreter.Interpreter;

import java.util.ArrayList;
import java.util.HashMap;


public class RemoveLower extends Command {
    public RemoveLower(Interpreter interpreter) {
        super(interpreter);
    }

    public Response execute(Request rq) {
        Float salary = (Float) rq.attachments.get("salary").get();
        ArrayList<String> messages = new ArrayList<>();
        manager.removeLower(salary);
        messages.add("Выполнено");

        return new Response(Response.Status.OK, messages, new HashMap<>());


    }

}