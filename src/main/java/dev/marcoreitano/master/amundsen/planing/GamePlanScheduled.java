package dev.marcoreitano.master.amundsen.planing;

import dev.marcoreitano.master.amundsen.registration.PlayerId;
import org.jmolecules.event.types.DomainEvent;

import java.util.Set;

public record GamePlanScheduled(
        GamePlanId gamePlanId,
        Set<PlayerId> joinedPlayer
//        Set<Association<Player, PlayerId>> joinedPlayer
) implements DomainEvent {
}

