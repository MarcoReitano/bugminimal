package dev.marcoreitano.master.amundsen.planing;

import org.jmolecules.event.types.DomainEvent;

public record GamePlanned(GamePlanId gamePlanId) implements DomainEvent {

    public GamePlanned(GamePlan gamePlan) {
        this(gamePlan.getId());
    }
}
