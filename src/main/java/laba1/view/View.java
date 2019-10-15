package laba1.view;

import laba1.model.train.PassengerTrain;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Map;

@Component
public class View {

    public void printLabaMenu() {
        System.out.println("============== LABA 1 ================");
        System.out.println("Choose action :");
        System.out.println("1 - Get total train capacity");
        System.out.println("2 - Get total train luggage weight");
        System.out.println("3 - Get sorted coaches by comfort type");
        System.out.println("4 - Get coach(es) correspond to range capacity");
        System.out.println("5 - Exit");
    }

    public void printResult (String result) {
        System.out.println(result);
    }

    public void printSelectTrain() {
        System.out.println("What train below the list are you interested in ?");
        System.out.println("Input the train number, please");
    }

    public void printInputIncorrectData() {
        System.out.println("Input incorrect data ! Try again, please");
    }

    public void printQuestionToContinue() {
        System.out.println("Back to menu - 1, exit - any other key");
    }


    public void printCoachCapacityIntervals(int... intervals) {
        System.out.println("Press 1 - Get coach(es) bellow average capacity : " + "[" + intervals[0] + " - " + intervals[(int)intervals.length/2] + "]");
        System.out.println("Press 2 - Get coach(es) above average capacity : " + "[" + intervals[(int) intervals.length/2] + " - " + intervals[intervals.length-1] + "]");
    }

    public void printAllExistedTrains(Map<Integer, PassengerTrain> trains) {
        Iterator it = trains.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Integer trainNumber = (Integer) pair.getKey();
            PassengerTrain train = (PassengerTrain) pair.getValue();
            System.out.println("Train number - " + trainNumber + "; Destination train : " + train.getDestinationCityPassengerTrain());
            //it.remove();
        }
            

    }
}
