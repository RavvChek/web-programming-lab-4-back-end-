package ru.ravvcheck.labweb4.result;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.ravvcheck.labweb4.user.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
public class HitController {
    @Autowired
    private final HitRepository hitRepository;

    @Autowired
    private final UserService userService;

    @CrossOrigin
    @PostMapping("/api/hit")
    public Hit addHit(@RequestParam("x") Float x,
                      @RequestParam("y") Float y,
                      @RequestParam("r") Float r,
                      @RequestHeader("Authorization") String authorization) {
        long timer = System.nanoTime();
        String login = userService.loginUser(authorization);
        if (!Hit.validateInput(x, y, r))
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Not valid x, y, r values");
        Hit hit = new Hit(x, y, r, login);
        hit.setExecutionTime(System.nanoTime() - timer);
        hitRepository.save(hit);
        return hit;
    }

    @CrossOrigin
    @GetMapping("/api/hit")
    public List<Hit> getHits(@RequestHeader("Authorization") String authorization) {
        return hitRepository.getHitByOwner(userService.loginUser(authorization));
    }

    @CrossOrigin
    @Transactional
    @DeleteMapping("/api/hit")
    public void deleteHits(@RequestHeader("Authorization") String authorization) {
        String login = userService.loginUser(authorization);
        hitRepository.deleteHitsByOwner(login);
    }
}