package se.comhem.test.montyhall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.comhem.test.montyhall.domain.MontyGame;

import java.util.stream.IntStream;

@Service
public class MontyService {

    @Autowired
    MontyGame montyGame;

    public MontyService() {}

    public MontyService(MontyGame montyGame) {
        this.montyGame = montyGame;
    }

    public int getMonty(int number, boolean doSwitch) {
        System.out.println(montyGame);

        int wins = (int) IntStream.range(0, number).filter(i -> montyGame.play(doSwitch)).count();
        System.out.println("Returning wins: " + wins);
        return wins;

    }

}

