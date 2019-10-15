package laba1;

import laba1.controller.Controller;
import laba1.view.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;

@SpringBootApplication
public class SpringBootApp implements CommandLineRunner {

    @Autowired
    private Controller controller;
    @Autowired
    private View view;


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootApp.class, args);
        Controller bean = context.getBean(Controller.class);
        bean.processUserInput();
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
