package com.gladkiy.common.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gladkiy.common.creaters.GroupCreator;
import com.gladkiy.common.getters.GroupGetter;
import com.gladkiy.common.model.Group;

@Controller
@RequestMapping("/group")
public class GroupController {

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public @ResponseBody
    Group getGroupById(@RequestParam("id") String id) {
        return GroupGetter.getGroupById(id);
    }

    @RequestMapping(value = "find", method = RequestMethod.GET)
    public @ResponseBody
    List<Group> getGroupByParameters(@RequestParam("title") String title,
            @RequestParam("year") String year) {
        return GroupGetter.getGroupByParameters(title, year);

    }

    /*
     * RequestMethod.PUT не работает
     */
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public @ResponseBody
    Group createGroup(@RequestParam("title") String title,
            @RequestParam("year") String year) {
        return GroupCreator.createGroup(title, year);
    }
}
