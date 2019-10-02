package laba1.controller.command;

import laba1.model.PassCoachService;
import laba1.model.TrainService;
import java.util.stream.DoubleStream;


public class TrainLuggageCommand implements Command {
    private static PassCoachService passCoachService = PassCoachService.getInstance();
    private static TrainService instance = TrainService.getInstance(passCoachService);

    @Override
    public String execute(String... arg) {
        int exactTrain = instance.getExactNumberTrain(arg[0]);
        String result;
        if (exactTrain > 0) {
            double sumTrainLuggage = instance.getTrains().get(exactTrain).getPassengerCoaches()
                    .stream()
                    .flatMapToDouble(coach -> DoubleStream.of(coach.getTypePassengerCoach()
                    .getLuggageWeight()))
                    .sum();
            result = String.valueOf(sumTrainLuggage);
        } else {
            return "Train with number " + arg[0] + " doesn't exist";
        }
        return "Train number " + arg[0] + " has total luggage - " + result + " kilograms weight";
    }
}
