package com.gladkiy.common.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gladkiy.common.getters.StudentMarkGetter;
import com.gladkiy.common.model.StudentMark;
import com.gladkiy.common.model.SubjectJournal;
import com.gladkiy.common.updaters.SubjectJournalUpdater;

@Controller
@RequestMapping("/studentJournal")
public class SubjectJournalController {

    @RequestMapping(value = "getStudentMark", method = RequestMethod.GET)
    public @ResponseBody
    StudentMark getStudentMarkById(@RequestParam("id") String id) {
        return StudentMarkGetter.getStudentMarkById(id);
    }

    @RequestMapping(value = "findStudentMark", method = RequestMethod.GET)
    public @ResponseBody
    List<StudentMark> getStudentMarkByParameters(
            @RequestParam("studentid") String studentid,
            @RequestParam("mark") String mark,
            @RequestParam("dateFrom") String dateFrom,
            @RequestParam("dateTo") String dateTo) {
        return StudentMarkGetter.getStudentMarkByParameters(studentid, mark,
                dateFrom, dateTo);
    }

    @RequestMapping(value = "insertStudentMark", method = RequestMethod.GET)
    public @ResponseBody
    StudentMark createStudentMark(@RequestParam("subjectJournalid") String subjectJournalid,
            @RequestParam("studentid") String studentid,
            @RequestParam("mark") String mark, @RequestParam("date") String date) {
        SubjectJournal temp = SubjectJournalUpdater.createStudentMark(subjectJournalid, studentid, mark, date);
        return temp.getStudentMarks().get(temp.getStudentMarks().size()-1);
    }
}
