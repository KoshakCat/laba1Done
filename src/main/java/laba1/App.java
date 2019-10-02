package laba1;

import laba1.controller.Controller;
import laba1.model.PassCoachService;
import laba1.model.TrainService;
import laba1.view.View;

import java.io.InputStream;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args )
    {
        View view = new View();
        Controller controller = new Controller(view, System.in);
        controller.processUserInput();

    }
}
