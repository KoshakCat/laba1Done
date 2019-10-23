package laba1.persistence.entity;

public class Coach {
    private int id;
    private CoachType coachType;

    public Coach() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CoachType getCoachType() {
        return coachType;
    }

    public void setCoachType(CoachType coachType) {
        this.coachType = coachType;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", coachType=" + coachType +
                '}';
    }
}
