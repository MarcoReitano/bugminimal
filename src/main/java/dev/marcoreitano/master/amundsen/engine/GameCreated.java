package dev.marcoreitano.master.amundsen.engine;

import dev.marcoreitano.master.amundsen.registration.PlayerId;
import org.jmolecules.event.types.DomainEvent;

import java.util.Set;

public record GameCreated(GameId gameId,

                          Set<PlayerId> participants
)
        implements DomainEvent {
}
