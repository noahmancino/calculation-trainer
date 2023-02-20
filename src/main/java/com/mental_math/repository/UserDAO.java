package com.mental_math.repository;

import com.mental_math.model.domain.Game;
import com.mongodb.client.result.UpdateResult;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

// TODO: replace raw strings with constants.
@Repository
@AllArgsConstructor
public class UserDAO {
    private final MongoTemplate mongoTemplate;

    public UpdateResult saveGame(String username, Game game) {
        Update update = new Update();
        update.addToSet("games", game);
        Criteria criteria  = Criteria.where("username").is(username);
        return mongoTemplate.updateFirst(Query.query(criteria), update, "users");
    }
}
