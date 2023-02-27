package com.mental_math.repository;

import com.mental_math.model.domain.Game;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.UpdateResult;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// TODO: replace raw strings with constants.
@Repository
@AllArgsConstructor
public class UserDAO {
    private final MongoTemplate mongoTemplate;
    final static Class<? extends List> gameListClass = new ArrayList<Game>().getClass();

    public UpdateResult saveGame(String username, Game game) {
        Update update = new Update();
        update.addToSet("games", game);
        Criteria criteria  = Criteria.where("username").is(username);
        return mongoTemplate.updateFirst(Query.query(criteria), update, "users");
    }

    // TODO: get rid of "GameList" hack.
    /*
    public List<Game> getAllUserGames(String username) {
        Criteria criteria = Criteria.where("username").is(username);
        MongoCollection mongoCollection = mongoTemplate.getCollection("username");
        mongoCollection.find()
        List<Game> gameList = mongoTemplate.findOne(Query.query(criteria), gameListClass, "users");
        if (gameList == null) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No games list associated with user.");
        }
        return gameList;
    }
    */
}
