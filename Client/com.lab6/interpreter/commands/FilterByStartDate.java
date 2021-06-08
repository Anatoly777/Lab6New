package com.lab6.interpreter.commands;

import com.lab6.dataTransfer.DataTransference;
import com.lab6.dataTransfer.Request;
import com.lab6.dataTransfer.Response;
import com.lab6.dataTransfer.Utils;
import com.lab6.interpreter.Interpreter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;


public class FilterByStartDate extends InterpreterCommand {
    public FilterByStartDate (Interpreter interpreter){
        super(interpreter);
    }
    public void execute(){
        if(inputManager.getWords().size() < 2 || inputManager.getWords().get(1).isEmpty() ){ outputManager.println("Неверное количество аргументов"); return;}
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        LocalDate startDate = LocalDate.parse(inputManager.getWords().get(1), formatter);

        HashMap<String, DataTransference<?>> arguments = new HashMap<>();
        arguments.put("start_date", new DataTransference<LocalDate>(LocalDate.class, startDate));

        Request rq = new Request("filter_by_start_date", arguments);
        if(client.sendRequest(rq)){
            Response resp = client.receive();
            Utils.printResponseMessages(resp);
        }


    }
    @Override
    public String info(){
        return "Сортировка по дате. filter_by_start_date <Start date>";
    }

}
