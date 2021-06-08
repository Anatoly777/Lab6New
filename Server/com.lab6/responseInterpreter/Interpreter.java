package com.lab6.responseInterpreter;

import com.lab6.dataTransfer.Request;
import com.lab6.dataTransfer.Response;
import com.lab6.responseInterpreter.commands.*;
import com.lab6.workersManager.WorkersManager;
import com.lab6.workersManager.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;

public class Interpreter {
    private final WorkersManager manager;
    public final HashMap<String, Command> executors;

    public Interpreter(WorkersManager manager) {
        this.manager = manager;
        this.executors = new HashMap<>();
        this.executors.put("info", new Info(this));
        this.executors.put("show", new Show(this));
        this.executors.put("add", new Add(this));
        this.executors.put("update", new Update(this));
        this.executors.put("remove_by_id", new RemoveById(this));
        this.executors.put("clear", new Clear(this));
        this.executors.put("remove_greater", new RemoveGreater(this));
        this.executors.put("remove_lower", new RemoveLower(this));
        this.executors.put("remove_last", new RemoveLast(this));
        this.executors.put("min_by_status", new MinByStatus(this));
        this.executors.put("filter_by_start_date", new FilterByStartDate(this));
        this.executors.put("filter_greater_than_position", new FilterGreaterThanPosition(this));
    }

    public Response execute(Request rq) throws NotFoundException {

        String method = rq.method;
        if (this.executors.containsKey(method)) {
            return this.executors.get(method).execute(rq);
        }
        return new Response(Response.Status.ERROR, new ArrayList<>(), new HashMap<>());

    }

    public WorkersManager getManager() {
        return this.manager;
    }


}
