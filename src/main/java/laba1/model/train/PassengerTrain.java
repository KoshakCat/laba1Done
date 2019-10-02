package laba1.model.train;

import laba1.model.pass_coach.PassengerCoach;

import java.util.HashSet;
import java.util.Set;

public class PassengerTrain {
    private int numberPassengerTrain;
    private String destinationCityPassengerTrain;
    private Set<PassengerCoach> passengerCoaches = new HashSet<>();

    public PassengerTrain(int numberPassengerTrain) {
        this.numberPassengerTrain = numberPassengerTrain;
    }

    public int getNumberPassengerTrain() {
        return numberPassengerTrain;
    }

    public String getDestinationCityPassengerTrain() {
        return destinationCityPassengerTrain;
    }

    public Set<PassengerCoach> getPassengerCoaches() {
        return passengerCoaches;
    }

    public void setDestinationCityPassengerTrain(String destinationCityPassengerTrain) {
        this.destinationCityPassengerTrain = destinationCityPassengerTrain;
    }



    @Override
    public String toString() {
        return "PassengerTrain{" +
                "numberPassengerTrain=" + numberPassengerTrain +
                ", destinationCityPassengerTrain='" + destinationCityPassengerTrain + '\'' +
                ", passengerTrain=" + passengerCoaches +
                '}';
    }
}
