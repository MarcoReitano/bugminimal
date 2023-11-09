package dev.marcoreitano.master.amundsen.engine;

import dev.marcoreitano.master.amundsen.planing.GamePlanScheduled;
import lombok.RequiredArgsConstructor;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GameEventListener {

    private final GameManagement gameManagement;

    @ApplicationModuleListener
    public void handleGameScheduled(GamePlanScheduled gamePlanScheduled) {
        GameId gameId = new GameId(UUID.randomUUID());
        gameManagement.createGame(gameId, gamePlanScheduled.joinedPlayer());
    }

}
