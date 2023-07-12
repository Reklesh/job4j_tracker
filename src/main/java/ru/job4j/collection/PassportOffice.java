package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
        }
        return rsl;
    }

    public Citizen get(String passport) {
        Citizen citizen = null;
        for (String key : citizens.keySet()) {
            if (Objects.equals(key, passport)) {
                citizen = citizens.get(key);
            }
        }
        return citizen;
    }
}
