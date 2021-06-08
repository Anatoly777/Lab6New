package com.lab6.responseInterpreter.commands;

import com.lab6.dataTransfer.Request;
import com.lab6.dataTransfer.Response;
import com.lab6.lab.Position;
import com.lab6.responseInterpreter.Interpreter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class FilterGreaterThanPosition extends Command{
    public FilterGreaterThanPosition(Interpreter interpreter) {
        super(interpreter);
    }

    public Response execute(Request rq) {
        ArrayList<String> messages = new ArrayList<>();
        Position pos = (Position) rq.attachments.get("position").get();
        messages.add(manager.filterGreaterThanPosition(pos));

        return new Response(Response.Status.OK, messages, new HashMap<>());


    }
}