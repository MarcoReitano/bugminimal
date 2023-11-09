package dev.marcoreitano.master.amundsen.engine;

import org.jmolecules.ddd.types.Repository;

import java.util.Optional;

public interface Games extends Repository<Game, GameId> {
    void save(Game game);

    Optional<Game> findById(GameId gameId);
}
