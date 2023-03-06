package com.mental_math.repository;

import com.mental_math.model.domain.Game;
import com.mental_math.util.ApplicationConstants;
import com.mongodb.client.result.UpdateResult;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;


@Repository
@AllArgsConstructor
public class UserDAO {
    private final MongoTemplate mongoTemplate;

    public UpdateResult saveGame(String username, Game game) {
        Update update = new Update();
        update.addToSet(ApplicationConstants.GAME_NAME, game);
        Criteria criteria = Criteria.where(ApplicationConstants.COLLECTION_NAME).is(username);
        return mongoTemplate.updateFirst(Query.query(criteria), update, ApplicationConstants.COLLECTION_NAME);
    }
}
