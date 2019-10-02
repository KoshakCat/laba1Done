package laba1.controller.command;

import laba1.controller.Controller;
import laba1.model.PassCoachService;
import laba1.model.TrainService;
import java.util.List;
import java.util.stream.Collectors;

public class RangeTrainCoachCapacityCommand implements Command {

    private static PassCoachService passCoachService = PassCoachService.getInstance();
    private static TrainService instance = TrainService.getInstance(passCoachService);

    @Override
    public String execute(String... arg) {
        int exactTrain = instance.getExactNumberTrain(arg[0]);
        int averageCapacity = (int) ((Controller.CAPACITYCOACHES[Controller.CAPACITYCOACHES.length - 1] - Controller.CAPACITYCOACHES[0]) / 2);
        String result;
        if (exactTrain > 0) {
            if (arg[1].equals("1")) {
                List<String> filteredCoachByRange = instance.getTrains().get(exactTrain).getPassengerCoaches()
                        .stream()
                        .filter(coach -> coach.getTypePassengerCoach().getPassengerCapacity() <= averageCapacity)
                        .map(coach -> "coach number " + coach.getIdCoach() + " has " + coach.getTypePassengerCoach().getPassengerCapacity() + " seats")
                        .collect(Collectors.toList());
                if (!filteredCoachByRange.isEmpty()) {
                    result = String.valueOf(filteredCoachByRange);
                } else {
                    result = "Train doesn't contain coaches with such configuration seats inside";
                }

            } else {
                List<String> filteredCoachByRange = instance.getTrains().get(exactTrain).getPassengerCoaches()
                        .stream()
                        .filter(coach -> coach.getTypePassengerCoach().getPassengerCapacity() > averageCapacity)
                        .map(coach -> "coach number " + coach.getIdCoach() + " has " + coach.getTypePassengerCoach().getPassengerCapacity() + " seats")
                        .collect(Collectors.toList());

                if (!filteredCoachByRange.isEmpty()) {
                    result = String.valueOf(filteredCoachByRange);
                } else {
                    result = "Train doesn't contain coaches with such configuration seats inside";
                }
            }
        } else {
            return "Train with number " + arg[0] + " doesn't exist";
        }
        return result;
    }
}
