package com.lab6.interpreter.commands;

import com.lab6.Client;
import com.lab6.interpreter.Interpreter;
import com.lab6.io.InputManager;
import com.lab6.io.OutputManager;

public abstract class InterpreterCommand extends Command{
    Interpreter interpreter;
    InputManager inputManager;
    OutputManager outputManager;
    Client client;
    public InterpreterCommand(Interpreter interpreter){

        this.interpreter = interpreter;
        this.inputManager = interpreter.getInputManager();
        this.outputManager = interpreter.getOutputManager();
        this.client = interpreter.getClient();
    }
    public String info(){
        return "";
    };
}
