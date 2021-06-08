package com.lab6.interpreter.commands;

import com.lab6.interpreter.Interpreter;

public class Exit extends InterpreterCommand{
    public Exit(Interpreter interpreter){
        super(interpreter);
    }
    public void execute(){
        this.interpreter.exit();

    }
    public String info(){
        return "прерывание работы интерпретатора";
    }
}
