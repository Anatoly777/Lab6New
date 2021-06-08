package com.lab6.responseInterpreter.commands;


import com.lab6.dataTransfer.Request;
import com.lab6.dataTransfer.Response;
import com.lab6.lab.Worker;
import com.lab6.responseInterpreter.Interpreter;
import com.lab6.workersManager.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;


public class Update extends Command {
    public Update(Interpreter interpreter) {
        super(interpreter);
    }

    public Response execute(Request rq) throws NotFoundException {
        ArrayList<String> messages = new ArrayList<>();
        Long id = (Long) rq.attachments.get("id").get();
        Worker w = (Worker) rq.attachments.get("worker").get();
        manager.update(id, w);
        messages.add("Элемент [" + w + "] успешно обновлён");


        return new Response(Response.Status.OK, messages, new HashMap<>());
    }
}