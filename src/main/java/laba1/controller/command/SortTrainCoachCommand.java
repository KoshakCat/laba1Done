package laba1.controller.command;

import laba1.model.PassCoachService;
import laba1.model.TrainService;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class SortTrainCoachCommand implements Command {

    private static PassCoachService passCoachService = PassCoachService.getInstance();
    private static TrainService instance = TrainService.getInstance(passCoachService);

    @Override
    public String execute(String... arg) {
        int exactTrain = instance.getExactNumberTrain(arg[0]);
        String result;
        if (exactTrain > 0) {
            List<String> sortedCoaches = instance.getTrains().get(exactTrain).getPassengerCoaches()
                    .stream()
                    .map(coach -> "coach number " + coach.getIdCoach() + " - " + coach.getTypePassengerCoach()).sorted(comparator()).collect(Collectors.toList());
            result = String.valueOf(sortedCoaches);
        } else {
            return "Train with number " + arg[0] + " doesn't exist";
        }
        return "Train number " + arg[0] + " has next sorted coaches by comfort type : \n" + result;
    }

    private static Comparator<String> comparator() {
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char symbol = '-';
                int firstCharIndex = o1.indexOf(symbol) + 1;
                int secondCharIndex = o2.indexOf(symbol) + 1;

                String firstCompareString = o1.substring(firstCharIndex).trim();
                String secondCompareString = o2.substring(secondCharIndex).trim();

                int result = secondCompareString.hashCode() - firstCompareString.hashCode();

                return result;
            }
        };
    }
}
