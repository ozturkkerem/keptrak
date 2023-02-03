package com.keptrak.utilities;

import com.github.dockerjava.core.dockerfile.DockerfileStatement;

public class Menu {

    public static void main(String[] args) {

        String path = System.getProperty("user.dir")+"/src/test/resources/Environments"+ConfigurationReader.getProperties("environment")+".properties";

        System.out.println(path);

        String environment = ConfigurationReader.getProperties("environment");

        String path2 = System.getProperty("user.dir")+"/src/test/resources/Environments" + environment + ".properties";

        System.out.println(path2);
        System.out.println(Environment.URL);

    }
}
