package laba1.model;

import laba1.model.pass_coach.PassengerCoach;
import laba1.model.train.PassengerTrain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Component
public class TrainService {
    @Autowired
    private static TrainService instance;
    @Autowired
    private static PassCoachService passCoachService = PassCoachService.getInstance();

    public static TrainService getInstance(PassCoachService passCoachService) {
        if (instance == null) {
            instance = new TrainService(PassCoachService.getInstance());
        } return instance;
    }

    public TrainService(PassCoachService passCoachService) {
        this.passCoachService = passCoachService;
    }

    private Map<Integer, PassengerTrain> trains = new HashMap<>();

    public void addTrainToList (PassengerTrain train) {
        trains.put(train.getNumberPassengerTrain(),train);
    }

    public PassengerTrain createTrain(int numberTrain) {

        return new PassengerTrain(numberTrain);
    }

    public void addCoachToTrain (PassengerTrain train, PassengerCoach coach) {
        train.getPassengerCoaches().add(coach);
    }

    public void deleteCoachToTrain (PassengerTrain train, PassengerCoach coach) {
        train.getPassengerCoaches().remove(coach);
    }

    public PassCoachService getPassCoachService() {
        return passCoachService;
    }

    public Map<Integer, PassengerTrain> getTrains() {
        return trains;
    }

    public void fillDefaultTrain() {
        PassengerTrain train1 = new PassengerTrain(100_500);
        train1.setDestinationCityPassengerTrain("ONE WAY TICKET TO RUSSIA");
        addCoachToTrain(train1, passCoachService.getCoachFromSetByLambda(1));
        addCoachToTrain(train1, passCoachService.getCoachFromSet(4));
        addCoachToTrain(train1, passCoachService.getCoachFromSet(6));
        addCoachToTrain(train1, passCoachService.getCoachFromSet(2));
        addTrainToList(train1);

        PassengerTrain train2 = new PassengerTrain(10);
        train2.setDestinationCityPassengerTrain("KYIV - PLANET MARS");
        addCoachToTrain(train2, passCoachService.getCoachFromSet(3));
        addCoachToTrain(train2, passCoachService.getCoachFromSet(5));
        addTrainToList(train2);
    }

    public int getExactNumberTrain(String s) {
        Iterator it = instance.getTrains().entrySet().iterator();
        int exactTrainNumber = -1;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            int trainNumber = (int) pair.getKey();
            if (trainNumber == Integer.parseInt(s)) {
                exactTrainNumber = trainNumber;
            }
            //it.remove();
        }
        return exactTrainNumber;
    }


}
