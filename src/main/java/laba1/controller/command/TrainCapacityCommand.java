package laba1.controller.command;

import laba1.model.PassCoachService;
import laba1.model.TrainService;
import java.util.stream.IntStream;

public class TrainCapacityCommand implements Command {

    private static PassCoachService passCoachService = PassCoachService.getInstance();
    private static TrainService instance = TrainService.getInstance(passCoachService);

    @Override
    public String execute(String... arg) {
        int exactTrain = instance.getExactNumberTrain(arg[0]);
        String result;
        if (exactTrain > 0) {
            int sumTrainCapacity = instance.getTrains().get(exactTrain).getPassengerCoaches()
                            .stream()
                            .flatMapToInt(coach -> IntStream.of(coach.getTypePassengerCoach()
                            .getPassengerCapacity()))
                            .sum();
            result = String.valueOf(sumTrainCapacity);
        } else {
            return "Train with number " + arg[0] + " doesn't exist";
        }
        return "Train number " + arg[0] + " has total capacity - " + result + " seats";
    }
}
