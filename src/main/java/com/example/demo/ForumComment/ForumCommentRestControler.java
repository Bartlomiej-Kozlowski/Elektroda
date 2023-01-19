package com.example.demo.ForumComment;

import com.example.demo.AuthToken.JwtTokenUtil;
import com.example.demo.ForumComment.ForumComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/forumComment")
public class ForumCommentRestControler {
    private ForumCommentService forumCommentService;

    @Autowired
    public ForumCommentRestControler(ForumCommentService forumCommentService) {
        this.forumCommentService = forumCommentService;
    }
    @PostMapping("/list")
    public List<ForumCommentWithUserData> getForumComment(@CookieValue(name = "authenticationToken", required=false) String token,
                                              @RequestBody ForumCommentListRequestDTO forumComment) {
        return forumCommentService.getForumComments(token, forumComment);
    }
    @PostMapping("/create")
    public void addForumComment(@CookieValue("authenticationToken") String token, @RequestBody ForumCommentAddRequestDTO forumComment) {
        forumCommentService.addForumComment(token, forumComment);
    }
    @PutMapping("/edit")
    public void updateForumComment(@CookieValue("authenticationToken") String token, @RequestBody ForumCommentUpdateRequestDTO forumComment) {
        forumCommentService.updateForumComment(token, forumComment);
    }
    @DeleteMapping("/delete")
    public void updateForumComment(@CookieValue("authenticationToken") String token, @RequestBody ForumCommentDeleteRequestDTO forumComment) {
        forumCommentService.deleteForumComment(token, forumComment);
    }

}

