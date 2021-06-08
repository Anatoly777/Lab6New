package com.lab6.responseInterpreter.commands;


import com.lab6.dataTransfer.Request;
import com.lab6.dataTransfer.Response;
import com.lab6.lab.Worker;
import com.lab6.responseInterpreter.Interpreter;

import java.util.ArrayList;
import java.util.HashMap;

public class Show extends Command {
    public String workerAsString(Worker w) {
        String s = "";

        s += "Имя: " + w.getName() + "\n";
        s += "Зарплата: " + w.getSalary() + "\n";
        s += "id: " + w.getId() + "\n";
        s += "Дата создания: " + w.getCreationDate().toString() + "\n";
        s += "Дата заключения контракта: " + w.getEndDate().toString() + "\n";
        s += "Должность: " + w.getPosition().toString() + "\n";
        s += "Статус: " + w.getStatus().toString() + "\n";
        return s;

    }

    public Show(Interpreter interpreter) {
        super(interpreter);
    }

    public Response execute(Request rq) {
        ArrayList<String> messages = new ArrayList<>();

        ArrayList<Worker> workers = manager.getWorkers();
        for (Worker w : workers) {
            messages.add(workerAsString(w));
        }
        return new Response(Response.Status.OK, messages, new HashMap<>());

    }

}
