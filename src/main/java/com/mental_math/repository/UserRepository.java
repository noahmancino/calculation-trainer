package com.mental_math.repository;

import com.mental_math.model.domain.Game;
import com.mental_math.model.domain.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);

    Game insertGame(String username, Game game);

}
