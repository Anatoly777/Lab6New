package com.lab6.builders.lineBuilders;


import com.lab6.io.InputManager;
import com.lab6.io.OutputManager;
import com.lab6.lab.Coordinates;

import java.io.IOException;


public class LineCoordinatesBuilder extends LineBuilder<Coordinates>{


    public LineCoordinatesBuilder (InputManager inputManager, OutputManager outputManager){

        super(inputManager, outputManager);
    }
    public Coordinates build() throws IOException {


            outputManager.println("Ввод координат: ");
            do {

                outputManager.print("x: ");
                inputManager.nextLine();

            }
            while (!Coordinates.Params.x.parse(inputManager.getString()));
            do {
                outputManager.print("y: ");
                inputManager.nextLine();

            }
            while (!Coordinates.Params.y.parse(inputManager.getString()));

            return new Coordinates(Coordinates.Params.x.get(), Coordinates.Params.y.get());
        }





}
