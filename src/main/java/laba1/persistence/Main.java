package laba1.persistence;

import laba1.persistence.dao.TypeCoachDao;
import laba1.persistence.entity.CoachType;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TypeCoachDao typeCoachDao = new TypeCoachDao();
        List<CoachType> typeCoachAll = typeCoachDao.read();
        System.out.println(typeCoachAll);

        CoachType updateObject = new CoachType(6,1,"UPDATE", 1);
        if (typeCoachDao.update(updateObject) == 0) {
            System.out.println("Object hasn't update");
        } else {
            System.out.println("Object update in table");
        }

        System.out.println(typeCoachDao.delete(5));
    }
}
