package dev.marcoreitano.master.amundsen.planing;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.annotation.Service;
import org.springframework.context.ApplicationEventPublisher;

import java.time.Duration;


@Transactional
@Service
@RequiredArgsConstructor
public class GamePlanManagement {

    private final ApplicationEventPublisher events;
    private final GamePlans gamePlans;

    public GamePlan planGame(Integer maxPlayer, Integer rounds, Duration roundDuration) {
        var game = new GamePlan(maxPlayer, rounds, roundDuration);

        events.publishEvent(new GamePlanned(game));

        return gamePlans.save(game);
    }

}
