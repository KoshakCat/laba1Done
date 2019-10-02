package laba1.model.pass_coach;

import laba1.model.coach.TrainCoach;

public class PassengerCoach extends TrainCoach{

    private TypePassengerCoach typePassengerCoach;
    private int idCoach;

    public PassengerCoach(TypePassengerCoach typePassengerCoach, int idCoach) {
        this.typePassengerCoach = typePassengerCoach;
        this.idCoach = idCoach;
    }

    public PassengerCoach() {
    }

    public TypePassengerCoach getTypePassengerCoach() {
        return typePassengerCoach;
    }

    public int getIdCoach() {
        return idCoach;
    }

    @Override
    public String toString() {
        return "PassengerCoach{" +
                "typePassengerCoach=" + typePassengerCoach +
                ", idCoach=" + idCoach +
                '}';
    }
}
