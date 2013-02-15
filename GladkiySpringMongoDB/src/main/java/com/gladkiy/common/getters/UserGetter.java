package com.gladkiy.common.getters;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.gladkiy.common.model.User;

public class UserGetter {

    public static User getUserById(String id) {

        @SuppressWarnings("resource")
        ApplicationContext ctx = new GenericXmlApplicationContext("mongo-config.xml");

        MongoOperations mongoOperation = (MongoOperations) ctx
                .getBean("mongoTemplate");

        User student = mongoOperation.findOne(new Query(Criteria.where("_id")
                .is(id)), User.class, "users");

        return student;
    }

    public static List<User> getUserByParameters(String surname, String name,
            String patronymic, String groupid) {

        @SuppressWarnings("resource")
        ApplicationContext ctx = new GenericXmlApplicationContext(
                "mongo-config.xml");

        MongoOperations mongoOperation = (MongoOperations) ctx
                .getBean("mongoTemplate");

        Criteria bigCriteara = new Criteria();

        if (!surname.equals("any")) {
            bigCriteara.and("surname").is(surname);
        }

        if (!name.equals("any")) {
            bigCriteara.and("name").is(name);
        }

        if (!patronymic.equals("any")) {
            bigCriteara.and("patronymic").is(patronymic);
        }

        if (!groupid.equals("any")) {

            bigCriteara.and("group").is(GroupGetter.getGroupById(groupid));
        }

        List<User> students = mongoOperation.find(new Query(bigCriteara),
                User.class, "users");

        return students;
    }
}
