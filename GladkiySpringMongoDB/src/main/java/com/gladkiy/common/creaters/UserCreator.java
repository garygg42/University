package com.gladkiy.common.creaters;

import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.gladkiy.common.getters.GroupGetter;
import com.gladkiy.common.model.User;

public class UserCreator {

    public static User createUser(String surname, String name,
            String patronymic, String groupid) {
        @SuppressWarnings("resource")
        ApplicationContext ctx = new GenericXmlApplicationContext(
                "mongo-config.xml");

        MongoOperations mongoOperation = (MongoOperations) ctx
                .getBean("mongoTemplate");

        User user = new User();
        user.set_id(ObjectId.get().toString());
        user.setName(name);
        user.setPatronymic(patronymic);
        user.setSurname(surname);
        user.setGroup(GroupGetter.getGroupById(groupid));
        
        mongoOperation.insert(user);
        
        return user;
    }

}
