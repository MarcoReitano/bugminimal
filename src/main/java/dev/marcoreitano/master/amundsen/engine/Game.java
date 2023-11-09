package dev.marcoreitano.master.amundsen.engine;

import dev.marcoreitano.master.amundsen.registration.PlayerId;
import jakarta.persistence.ElementCollection;
import jakarta.transaction.Transactional;
import lombok.Getter;
import org.jmolecules.ddd.types.AggregateRoot;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.Set;

@Getter
@Transactional
public class Game extends AbstractAggregateRoot<Game> implements AggregateRoot<Game, GameId> {

    private final GameId id;

    @ElementCollection
    Set<PlayerId> participants;
//  Set<Association<Player, PlayerId>> participants;


    //    public Game(GameId gameId, Integer roundCount, Duration roundDuration, Set<Association<Player, PlayerId>> participants) {
    public Game(GameId gameId, Set<PlayerId> participants) {
        this.id = gameId;
        this.participants = participants;
    }
}
