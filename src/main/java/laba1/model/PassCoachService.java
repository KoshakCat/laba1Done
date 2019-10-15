package laba1.model;

import laba1.model.pass_coach.PassengerCoach;
import laba1.model.pass_coach.TypePassengerCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class PassCoachService {

    @Autowired
    private static PassCoachService instance;

    public static PassCoachService getInstance() {
        if (instance == null) {
            instance = new PassCoachService();
        }
        return instance;
    }

    private Set<PassengerCoach> passengerCoaches = new HashSet<>();

    public Set<PassengerCoach> getAllCoaches() {
        return passengerCoaches;
    }

    public void addCoachToSet(PassengerCoach coach) {
        passengerCoaches.add(coach);
    }

    public void deleteCoachFromSet(PassengerCoach coach) {
        passengerCoaches.remove(coach);
    }

    public TypePassengerCoach getTypePassengerCoach(PassengerCoach coach) {
        return coach.getTypePassengerCoach();
    }

    public int getCoachCapacity(PassengerCoach coach) {
        return coach.getTypePassengerCoach().getPassengerCapacity();
    }

    public double getCoachLuggageWeight(PassengerCoach coach) {
        return coach.getTypePassengerCoach().getLuggageWeight();
    }

    public void fillDefaultListOfCoaches() {
        addCoachToSet(new PassengerCoach(TypePassengerCoach.ADVANCE, 1));
        addCoachToSet(new PassengerCoach(TypePassengerCoach.SV, 2));
        addCoachToSet(new PassengerCoach(TypePassengerCoach.LOW, 3));
        addCoachToSet(new PassengerCoach(TypePassengerCoach.MIDDLE, 4));
        addCoachToSet(new PassengerCoach(TypePassengerCoach.LOW, 5));
        addCoachToSet(new PassengerCoach(TypePassengerCoach.SV, 6));
    }

    public PassengerCoach getCoachFromSet (int coachID) {
        for (PassengerCoach pc : passengerCoaches) {
               if (pc.getIdCoach() == coachID) {
                   return pc;
               }
        }
        return null;
    }
}