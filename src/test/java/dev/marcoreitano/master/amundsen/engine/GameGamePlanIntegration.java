package dev.marcoreitano.master.amundsen.engine;

import dev.marcoreitano.master.amundsen.planing.GamePlan;
import dev.marcoreitano.master.amundsen.planing.GamePlanManagement;
import dev.marcoreitano.master.amundsen.planing.GamePlans;
import dev.marcoreitano.master.amundsen.registration.PlayerId;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

import java.time.Duration;
import java.util.UUID;

@ApplicationModuleTest(extraIncludes = "planing")
@RequiredArgsConstructor
public class GameGamePlanIntegration {

    private final GamePlanManagement gamePlanManagement;
    private final GamePlans gamePlans;

    @Test
    public void scheduleGamePlanCreatesGame(Scenario scenario) {
        //Given
        PlayerId playerId = new PlayerId(UUID.randomUUID());
        GamePlan gamePlan = gamePlanManagement.planGame(1, 2, Duration.ofMillis(1000));
        gamePlan.join(playerId);
        gamePlans.save(gamePlan);

        //When / Then
        scenario.stimulate(() -> {
                    gamePlan.schedule();
                    gamePlans.save(gamePlan);
                }).andWaitForEventOfType(GameCreated.class)
                .toArrive();
    }
}
