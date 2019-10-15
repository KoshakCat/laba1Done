package laba1.controller.command;

import laba1.model.PassCoachService;
import laba1.model.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommandFactory {
    @Autowired
    private static CommandFactory instance = new CommandFactory();
    @Autowired
    private static PassCoachService passCoachService = PassCoachService.getInstance();
    @Autowired
    private static TrainService trainService = TrainService.getInstance(passCoachService);

    public static CommandFactory getInstance() {
        return instance;
    }

    private Map<String, Command> commands = new HashMap<>();

    private CommandFactory() {
        commands.put("1", new TrainCapacityCommand());
        commands.put("2", new TrainLuggageCommand());
        commands.put("3", new SortTrainCoachCommand());
        commands.put("4", new RangeTrainCoachCapacityCommand());
    }

    public Command getCommand(String command) {
        return commands.get(command);
    }
}
