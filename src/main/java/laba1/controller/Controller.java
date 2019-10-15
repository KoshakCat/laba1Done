package laba1.controller;

import laba1.controller.command.Command;
import laba1.controller.command.CommandFactory;
import laba1.model.PassCoachService;
import laba1.model.TrainService;
import laba1.view.View;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Controller {
    private static final Logger LOG = Logger.getLogger(Controller.class);
    @Autowired
    private View view;
    private InputStream in = System.in;
    @Autowired
    private static CommandFactory commandFactory = CommandFactory.getInstance();
    @Autowired
    private static PassCoachService passCoachService = PassCoachService.getInstance();
    @Autowired
    private static TrainService trainService = TrainService.getInstance(passCoachService);

    private final Pattern menuCodePattern = Pattern.compile("[1-5]");
    private final Pattern exitCodePattern = Pattern.compile("[1]");
    private final Pattern trainNumberCodePattern = Pattern.compile("[0-9]+");
    private final Pattern rangeNumberCodePattern = Pattern.compile("[1-2]");
    public static final int[] CAPACITYCOACHES = {8, 16, 32, 64};

    public Controller(View view) {
        this.view = view;
        //this.in = in;
        passCoachService.fillDefaultListOfCoaches();
        trainService.fillDefaultTrain();
    }

    private boolean isNumberMenuValid (String userString) {
        LOG.debug("User input string " + userString);
        Matcher menuNumberCodeMatcher = menuCodePattern.matcher(userString);
        return menuNumberCodeMatcher.matches();
    }

    private boolean isExitCheck(String isContinue) {
        Matcher exitCodeMatcher = exitCodePattern.matcher(isContinue);
        return exitCodeMatcher.matches();
    }

    private boolean isTrainNumberValid(String userString) {
        Matcher trainNumberCodeMatcher = trainNumberCodePattern.matcher(userString);
        return trainNumberCodeMatcher.matches();
    }

    private boolean isRangeNumberValid(String userString) {
        Matcher rangeNumberCodeMatcher = rangeNumberCodePattern.matcher(userString);
        return rangeNumberCodeMatcher.matches();
    }

    private String checkTrainNumberDigit(Scanner scanner) {
        String userMenuCommand;
        do {
            userMenuCommand = scanner.nextLine();
            if (!isTrainNumberValid(userMenuCommand)) {
                LOG.info("Validation train number ..." + userMenuCommand);
                view.printInputIncorrectData();
            }
        } while (!isTrainNumberValid(userMenuCommand));

        return userMenuCommand;
    }

    private String checkRangeNumberDigit(Scanner scanner) {
        String userMenuCommand;
        do {
            userMenuCommand = scanner.nextLine();
            if (!isRangeNumberValid(userMenuCommand)) {
                LOG.error("block validation number, user input wrong value - " + userMenuCommand);
                view.printInputIncorrectData();
            }
        } while (!isRangeNumberValid(userMenuCommand));

        return userMenuCommand;
    }

    public void processUserInput() {
        boolean isExit = false;
        while (!isExit) {
            view.printLabaMenu();
            Scanner scanner = new Scanner(in);
            String userMenuCommand = scanner.nextLine();

            if (! isNumberMenuValid(userMenuCommand)) {
                view.printInputIncorrectData();
                continue;
            }

            switch (userMenuCommand) {
                case "1":
                    view.printSelectTrain();
                    view.printAllExistedTrains(trainService.getTrains());

                    String userTrainNumber = checkTrainNumberDigit(scanner);
                    Command command = commandFactory.getCommand(userMenuCommand);

                    String result = command.execute(userTrainNumber);
                    view.printResult(result);

                    view.printQuestionToContinue();
                    String isContinue = scanner.nextLine().trim();

                    isExit = !isExitCheck(isContinue);
                    break;

                case "2":
                    view.printSelectTrain();
                    view.printAllExistedTrains(trainService.getTrains());

                    userTrainNumber = checkTrainNumberDigit(scanner);
                    command = commandFactory.getCommand(userMenuCommand);

                    result = command.execute(userTrainNumber);
                    view.printResult(result);

                    view.printQuestionToContinue();
                    isContinue = scanner.nextLine().trim();

                    isExit = !isExitCheck(isContinue);
                    break;

                case "3":
                    view.printSelectTrain();
                    view.printAllExistedTrains(trainService.getTrains());

                    userTrainNumber = checkTrainNumberDigit(scanner);
                    command = commandFactory.getCommand(userMenuCommand);

                    result = command.execute(userTrainNumber);
                    view.printResult(result);

                    view.printQuestionToContinue();
                    isContinue = scanner.nextLine().trim();

                    isExit = !isExitCheck(isContinue);
                    break;

                case "4":
                    view.printSelectTrain();
                    view.printAllExistedTrains(trainService.getTrains());

                    userTrainNumber = checkTrainNumberDigit(scanner);
                    view.printCoachCapacityIntervals(CAPACITYCOACHES);

                    String userRangeCapacity = checkRangeNumberDigit(scanner);
                    command = commandFactory.getCommand(userMenuCommand);

                    result = command.execute(userTrainNumber, userRangeCapacity);
                    view.printResult(result);

                    view.printQuestionToContinue();
                    isContinue = scanner.nextLine().trim();

                    isExit = !isExitCheck(isContinue);
                    break;

                case "5":
                    isExit = true;
                    view.printResult("See you soon !");
                    break;
            }
        }

    }

}
