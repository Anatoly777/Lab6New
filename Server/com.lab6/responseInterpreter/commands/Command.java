package com.lab6.responseInterpreter.commands;

import com.lab6.dataTransfer.Request;
import com.lab6.dataTransfer.Response;
import com.lab6.responseInterpreter.Interpreter;
import com.lab6.workersManager.WorkersManager;
import com.lab6.workersManager.exceptions.NotFoundException;

public abstract class Command {
    Interpreter interpreter;
    WorkersManager manager;

    public Command(Interpreter interpreter) {
        this.interpreter = interpreter;
        this.manager = this.interpreter.getManager();
    }

    public abstract Response execute(Request rq) throws NotFoundException;

}
