package se.comhem.test.montyhall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import se.comhem.test.montyhall.service.MontyService;

@RestController
public class MontyController {

    @Autowired
    public MontyService montyService;

    @GetMapping("/monty/{numberOfGames}/{doSwitch}")
    public int getMontyHall(@PathVariable int numberOfGames, @PathVariable boolean doSwitch) {
        return montyService.getMonty(numberOfGames, doSwitch);
    }

}
