package com.gladkiy.common.getters;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.gladkiy.common.model.Group;

public class GroupGetter {

    public static Group getGroupById(String id) {

        @SuppressWarnings("resource")
        ApplicationContext ctx = new GenericXmlApplicationContext(
                "mongo-config.xml");

        MongoOperations mongoOperation = (MongoOperations) ctx
                .getBean("mongoTemplate");

        Group group = mongoOperation.findOne(new Query(Criteria.where("_id")
                .is(id)), Group.class, "groups");

        return group;
    }

    public static List<Group> getGroupByParameters(String title, String year) {

        @SuppressWarnings("resource")
        ApplicationContext ctx = new GenericXmlApplicationContext(
                "mongo-config.xml");

        MongoOperations mongoOperation = (MongoOperations) ctx
                .getBean("mongoTemplate");

        Criteria bigCriteara = new Criteria();

        if (!title.equals("any")) {
            bigCriteara.and("title").is(title);
        }

        if (!year.equals("any")) {
            bigCriteara.and("year").is(Integer.parseInt(year));
        }

        List<Group> groups = mongoOperation.find(new Query(bigCriteara),
                Group.class, "groups");

        return groups;
    }
}
