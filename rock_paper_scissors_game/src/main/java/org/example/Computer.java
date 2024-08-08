package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {

    public String getComputerChoice(){
        List<String> options = new ArrayList<>();
        options.add("Rock");
        options.add("Paper");
        options.add("Scissors");

        Random random = new Random();
        int i = random.nextInt(options.size());

        return options.get(i);
    }
}
