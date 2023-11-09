package dev.marcoreitano.master.amundsen.engine;

import dev.marcoreitano.master.amundsen.registration.PlayerId;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.annotation.Service;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class GameManagement {

    private final ApplicationEventPublisher events;
    private final Games games;

    //    public GameId createGame(GameId gameId, Integer roundCount, Duration roundDuration, Set<Association<Player, PlayerId>> participants) {
    public GameId createGame(GameId gameId, Set<PlayerId> participants) {
        Game game = new Game(gameId, participants);

        games.save(game);

        events.publishEvent(new GameCreated(gameId, participants));

        return game.getId();
    }
}
