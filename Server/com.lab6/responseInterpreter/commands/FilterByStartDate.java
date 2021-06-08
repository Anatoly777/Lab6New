package com.lab6.responseInterpreter.commands;

import com.lab6.dataTransfer.Request;
import com.lab6.dataTransfer.Response;
import com.lab6.responseInterpreter.Interpreter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class FilterByStartDate extends Command{
    public FilterByStartDate(Interpreter interpreter) {
        super(interpreter);
    }

    public Response execute(Request rq) {
        ArrayList<String> messages = new ArrayList<>();
        LocalDate sd = (LocalDate) rq.attachments.get("start_date").get();
        messages.add(manager.filterByStartDate(sd));

        return new Response(Response.Status.OK, messages, new HashMap<>());


    }
}
