package com.keptrak.utilities;

import com.github.dockerjava.core.dockerfile.DockerfileStatement;

public class Menu {

    public static void main(String[] args) {

        Driver2.get().get("https://www.google.com");
        Driver2.closeDriver();
        Driver.get().get("https://www.bbc.com");
        Driver.closeDriver();


    }
}
