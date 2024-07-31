package org.springframework.boot.backend.controller.jwt;

import org.springframework.boot.backend.entity.user.Bug;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bugtracking/")
@CrossOrigin(origins = "http://localhost:4200")
public class IssueController {

    private static List<Bug> bugList = new ArrayList<>();

    static {
        Bug bug = new Bug(1l, "First", "Bug");
        bugList.add(bug);
    }

    @GetMapping
    public List<Bug> getIssues() {
        return bugList;
    }

    @GetMapping("/{issueId}")
    public Bug getIssueById(@PathVariable Long issueId) {
        return bugList.stream()
                .filter(b -> b.getId().equals(issueId))
                .findFirst().get();
    }

    @PostMapping
    public void addNewIssue(@RequestBody Bug bug) {
        bug.setId(Long.valueOf(bugList.size() + 1));
        bugList.add(bug);
        System.out.println("Issue added");
    }

    @PutMapping("/{issueId}")
    public void updateIssue(@PathVariable Long issueId, @RequestBody Bug bug) {
        Bug bugToUpdate = bugList.stream()
                .filter(b -> b.getId().equals(issueId))
                .findFirst().get();
        bugToUpdate.setIssueName(bug.getIssueName());
        bugToUpdate.setIssueMessage(bug.getIssueMessage());
    }

    @DeleteMapping("/{issueId}")
    public void deleteIssueById(@PathVariable Long issueId) {
        bugList = bugList.stream().filter(b -> !b.getId().equals(issueId))
                .collect(Collectors.toList());
    }

}
