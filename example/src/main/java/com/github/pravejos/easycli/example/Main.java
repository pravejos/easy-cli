package com.github.pravejos.easycli.example;

import com.github.pravejos.easycli.ArgumentParser;
import com.github.pravejos.easycli.ArgumentParserException;

public class Main {
    public static void main(String[] args) {
        try {
            GrepOption testOption = ArgumentParser.parse(GrepOption.class, args);
            System.out.println("Arguments parsed successfully.\n" + testOption);
        } catch (ArgumentParserException e) {
            System.out.println("Error parsing arguments. " + e.getMessage());
            ArgumentParser.printHelp();
        }
    }
}
