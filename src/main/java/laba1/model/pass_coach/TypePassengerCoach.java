package laba1.model.pass_coach;

public enum TypePassengerCoach {
    SV (8 , 100), ADVANCE (16 , 200), MIDDLE (32 , 300), LOW (64, 400);
    private int passengerCapacity;
    private double luggageWeight;

    TypePassengerCoach(int passengerCapacity, double luggageWeight) {
        this.passengerCapacity = passengerCapacity;
        this.luggageWeight = luggageWeight;
    }

    public int getPassengerCapacity () {
        return this.passengerCapacity;
    }

    public double getLuggageWeight () {
        return luggageWeight;
    }
}
