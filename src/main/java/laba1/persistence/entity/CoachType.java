package laba1.persistence.entity;

public class CoachType {
    private int id;
    private int capacity;
    private String type;
    private int luggage;

    public CoachType() {
    }

    public CoachType(int id, int capacity, String type, int luggage) {
        this.id = id;
        this.capacity = capacity;
        this.type = type;
        this.luggage = luggage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLuggage(int luggage) {
        this.luggage = luggage;
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    public int getLuggage() {
        return luggage;
    }

    @Override
    public String toString() {
        return "CoachType{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", type='" + type + '\'' +
                ", luggage=" + luggage +
                '}';
    }
}
