package com.revature.developercorner.controller;

import com.revature.developercorner.dto.BlogDto;
import com.revature.developercorner.dto.MessageDto;
import com.revature.developercorner.dto.QuestionDto;
import com.revature.developercorner.entity.Blog;
import com.revature.developercorner.entity.Message;
import com.revature.developercorner.entity.Question;
import com.revature.developercorner.service.BlogService;
import com.revature.developercorner.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @PostMapping("/addblog")
    public BlogDto addblog(@RequestBody BlogDto blogDto) {
        System.out.println(blogDto);
        Blog blog = new Blog();
        blog.setTitle(blogDto.getTitle());
        blog.setContent(blogDto.getContent());
        blog.setUpVotes(blogDto.getUpVotes());
        blog.setDownVotes(blogDto.getDownVotes());
        blog.setCreated_at(blogDto.getCreated_at());
        blog.setUpdated_at(blogDto.getUpdated_at());

        blog = blogService.addBlog(blog);

        blogDto.setId(blog.getId());
        blogDto.setError_or_success("SUCCESS");
        System.out.println(blogDto);

        return blogDto;
    }

    @PostMapping("/updateblog")
    public BlogDto updateblog(@RequestBody BlogDto blogDto) {
        System.out.println(blogDto);
        Blog blog = new Blog();
        blog.setId(blogDto.getId());
        blog.setTitle(blogDto.getTitle());
        blog.setContent(blogDto.getContent());
        blog.setUpVotes(blogDto.getUpVotes());
        blog.setDownVotes(blogDto.getDownVotes());
        blog.setCreated_at(blogDto.getCreated_at());
        blog.setUpdated_at(blogDto.getUpdated_at());
        blogService.update_blog(blog, blog.getUser_id());

        System.out.println(blog);
        blogDto.setError_or_success("SUCCESS");
        return blogDto;
    }
    @PostMapping("/deleteblog")
    public BlogDto deleteBlog(@RequestBody BlogDto blogDto) {
        System.out.println(blogDto);
        blogService.delete(blogDto.getId());
        blogDto.setError_or_success("SUCCESS");
        return blogDto;

    }

    @GetMapping("/listblog")
    public List listblog(@RequestBody BlogDto blogDto) {
        List<Blog> blogs = blogService.getAll();
        List blogDtolist = new ArrayList();

        if (blogs != null) {
            blogs.forEach(blog -> {
                BlogDto blogDto1 = new BlogDto();
                blogDto1.setId(blog.getId());
                blogDto1.setTitle(blog.getTitle());
                blogDto1.setContent(blog.getContent());
                blogDto1.setUpVotes(blog.getUpVotes());
                blogDto1.setDownVotes(blog.getDownVotes());
                blogDto1.setCreated_at(blog.getCreated_at());
                blogDto1.setUpdated_at(blog.getUpdated_at());
                blogDto.setUpdated_at(blog.getUpdated_at());

                blogDtolist.add(blogDto1);
            });
        }
        return blogDtolist;
    }
}