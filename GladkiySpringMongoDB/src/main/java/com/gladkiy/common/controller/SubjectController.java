package com.gladkiy.common.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gladkiy.common.creaters.SubjectCreator;
import com.gladkiy.common.getters.SubjectGetter;
import com.gladkiy.common.model.Subject;

@Controller
@RequestMapping("/subject")
public class SubjectController {

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public @ResponseBody
    Subject getSubjectById(@RequestParam("id") String id) {
        return SubjectGetter.getSubjectById(id);
    }

    @RequestMapping(value = "find", method = RequestMethod.GET)
    public @ResponseBody
    List<Subject> getSubjectByParameters(@RequestParam("title") String title,
            @RequestParam("year") String year,
            @RequestParam("semester") String semester,
            @RequestParam("lecturerid") String lecturerid) {
        return SubjectGetter.getSubjectByParameters(title, year, semester, lecturerid);
    }
    
    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public @ResponseBody
    Subject createSubject(@RequestParam("title") String title,
            @RequestParam("year") String year,
            @RequestParam("semester") String semester,
            @RequestParam("lecturerid") String lecturerid) {
        return SubjectCreator.createSubject(title, year, semester, lecturerid);
    }
}
