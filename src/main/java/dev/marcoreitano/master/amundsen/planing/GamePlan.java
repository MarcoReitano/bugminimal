package dev.marcoreitano.master.amundsen.planing;

import dev.marcoreitano.master.amundsen.registration.PlayerId;
import jakarta.persistence.ElementCollection;
import jakarta.transaction.Transactional;
import lombok.Getter;
import org.jmolecules.ddd.types.AggregateRoot;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Transactional
public class GamePlan extends AbstractAggregateRoot<GamePlan> implements AggregateRoot<GamePlan, GamePlanId> {

    private final GamePlanId id;

    @ElementCollection
    Set<PlayerId> joinedPlayer;
//  Set<Association<Player, PlayerId>> joinedPlayer;

    protected GamePlan() {
        this(6, 58, Duration.of(20, ChronoUnit.SECONDS));
    }

    protected GamePlan(Integer maxPlayer, Integer roundCount, Duration roundDuration) {
        this.id = new GamePlanId(UUID.randomUUID());
        this.joinedPlayer = new HashSet<>();
    }

    public void join(PlayerId playerId) {
        joinedPlayer.add(playerId);
//        joinedPlayer.add(Association.forId(playerId));

        registerEvent(new PlayerJoined(this, playerId));
    }

    public void schedule() {

        registerEvent(new GamePlanScheduled(id, joinedPlayer));
    }

}
