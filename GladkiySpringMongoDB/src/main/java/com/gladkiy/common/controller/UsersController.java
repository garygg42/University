package com.gladkiy.common.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gladkiy.common.creaters.UserCreator;
import com.gladkiy.common.getters.UserGetter;
import com.gladkiy.common.model.User;

@Controller
@RequestMapping("/user")
public class UsersController {

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public @ResponseBody
    User getUser(@RequestParam("id") String id) {
        return UserGetter.getUserById(id);
    }

    @RequestMapping(value = "find", method = RequestMethod.GET)
    public @ResponseBody
    List<User> getUserByParameters(@RequestParam("surname") String surname,
            @RequestParam("name") String name,
            @RequestParam("patronymic") String patronymic,
            @RequestParam("groupid") String groupid) {
        return UserGetter.getUserByParameters(surname, name, patronymic,
                groupid);
    }

    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public @ResponseBody
    User createUser(@RequestParam("surname") String surname,
            @RequestParam("name") String name,
            @RequestParam("patronymic") String patronymic,
            @RequestParam("groupid") String groupid) {
        return UserCreator.createUser(surname, name, patronymic, groupid);
    }

}