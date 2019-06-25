package com.othdev95.timeline.Ctrl;

import com.othdev95.timeline.Domain.Post;
import com.othdev95.timeline.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@Controller
public class PostCtrl {
    @Autowired
    private PostService pService;

    @GetMapping("post")
    public String showPost(Model model){
        Post post = Post.builder().build();
        model.addAttribute("post",post);
        return "post";
    }

    @GetMapping("{idx}")
    public String showPostDetail(@PathVariable long idx, Model model){
        model.addAttribute("idx",pService.findPostById(idx));
        return "hou";
    }


    @GetMapping
    public String showHou(Model model){
        model.addAttribute("posts",pService.getPosts());
        return "showPosts";
    }

    @PostMapping
    public String createPost( @RequestBody Post newPost){
        pService.saveNewPost(newPost);
        return "redirect:/"+newPost.getIdx();
    }

    @RequestMapping(value = "/post.do",method = RequestMethod.POST)
    public String formPost(@ModelAttribute(value="post") Post post){
        pService.saveNewPost(post);
        return "redirect:/";
    }
}
