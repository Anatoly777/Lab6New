package com.lab6.responseInterpreter.commands;

import com.lab6.dataTransfer.Request;
import com.lab6.dataTransfer.Response;
import com.lab6.responseInterpreter.Interpreter;
import com.lab6.workersManager.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;


public class RemoveById extends Command {
    public RemoveById(Interpreter interpreter) {
        super(interpreter);
    }

    public Response execute(Request rq) {
        Long id = (Long) rq.attachments.get("id").get();
        ArrayList<String> messages = new ArrayList<>();
        manager.removeById(id);
        messages.add("Элемент [" + id + "] удалён");


        return new Response(Response.Status.OK, messages, new HashMap<>());

    }


}
