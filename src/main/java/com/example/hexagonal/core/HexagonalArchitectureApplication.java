package com.example.hexagonal.core;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class HexagonalArchitectureApplication {

    public static void main(String... args) {
        Quarkus.run(args);
    }
}