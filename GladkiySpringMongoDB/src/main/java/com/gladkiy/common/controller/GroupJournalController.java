package com.gladkiy.common.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gladkiy.common.creaters.GroupJournalCreator;
import com.gladkiy.common.getters.GroupJournalGetter;
import com.gladkiy.common.getters.SubjectJournalGetter;
import com.gladkiy.common.model.GroupJournal;
import com.gladkiy.common.model.SubjectJournal;
import com.gladkiy.common.updaters.GroupJournalUpdater;

@Controller
@RequestMapping("/groupJournal")
public class GroupJournalController {

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public @ResponseBody
    GroupJournal getGroupJournalById(@RequestParam("id") String id) {
        return GroupJournalGetter.getGroupJournalById(id);
    }

    @RequestMapping(value = "find", method = RequestMethod.GET)
    public @ResponseBody
    List<GroupJournal> getGroupJournalByParameters(
            @RequestParam("groupid") String groupid,
            @RequestParam("years") String years) {
        return GroupJournalGetter.getGroupJournalByParameters(groupid, years);
    }

    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public @ResponseBody
    GroupJournal createGroupJournal(@RequestParam("groupid") String groupid,
            @RequestParam("years") String years) {
        return GroupJournalCreator.createGroupJournal(groupid, years);
    }

    @RequestMapping(value = "getSubjectJournal", method = RequestMethod.GET)
    public @ResponseBody
    SubjectJournal getSubjectJournalById(@RequestParam("id") String id) {
        return SubjectJournalGetter.getSubjectJournalById(id);
    }

    @RequestMapping(value = "findSubjectJournal", method = RequestMethod.GET)
    public @ResponseBody
    List<SubjectJournal> getSubjectJournalByParameters(
            @RequestParam("subjectid") String subjectid) {
        return SubjectJournalGetter.getSubjectJournalByParameters(subjectid);
    }

    @RequestMapping(value = "insertSubjectJournal", method = RequestMethod.GET)
    public @ResponseBody
    SubjectJournal createSubjectJournal(
            @RequestParam("groupJournalid") String groupJournalid,
            @RequestParam("subjectid") String subjectid) {
        GroupJournal temp = GroupJournalUpdater.createSubjectJournal(
                groupJournalid, subjectid);
        return temp.getSubjectJournals().get(
                temp.getSubjectJournals().size() - 1);
    }

}
