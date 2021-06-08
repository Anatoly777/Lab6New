package com.lab6.builders.lineBuilders;

import com.lab6.builders.Builder;
import com.lab6.io.InputManager;
import com.lab6.io.OutputManager;

public abstract class LineBuilder<T extends Object> extends Builder<T> {
    InputManager inputManager;
    OutputManager outputManager;
    public LineBuilder(InputManager inputManager, OutputManager outputManager){
        this.inputManager = inputManager;
        this.outputManager = outputManager;
    }


}
