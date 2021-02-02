package se.comhem.test.montyhall.service;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.stream.IntStream;

@Service
public class MontyService {

    public int getMonty(int number, boolean doSwitch) {

        int hits;
        if(doSwitch) {
            hits = getMontyWithSwitch(number);
        } else {
            hits = getMontyNoSwitch(number);
        }
        return hits;

    }

    private int getMontyNoSwitch(int number) {
        return (int) IntStream.range(0, number).filter(i -> getRandomDoor() == getRandomDoor()).count();
    }

    private int getMontyWithSwitch(int number) {
        return (int) IntStream.range(0, number).filter(i -> getRandomDoor() != getRandomDoor()).count();
    }


    public int getRandomDoor() {
        Random random = new Random();
        return random.nextInt(3);
    }

}

