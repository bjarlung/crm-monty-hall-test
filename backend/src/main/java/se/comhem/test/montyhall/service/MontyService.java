package se.comhem.test.montyhall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.comhem.test.montyhall.domain.MontyGame;

import java.util.stream.IntStream;

@Service
public class MontyService {

    @Autowired
    MontyGame montyGame;

    public int getWins(int number, boolean doSwitch) {
        return  (int) IntStream.range(0, number).filter(i -> montyGame.play(doSwitch)).count();
    }
}

