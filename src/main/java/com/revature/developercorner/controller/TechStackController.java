package com.revature.developercorner.controller;

import com.revature.developercorner.dto.TechStackDto;
import com.revature.developercorner.entity.TechStack;
import com.revature.developercorner.service.TechStackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/techstack")
public class TechStackController {
    @Autowired
    TechStackService techStackService;


    @GetMapping("/listalltechstack")
    public List listallStack(@RequestBody TechStackDto techStackDto) {
        List<TechStack> techStacks = techStackService.getAll();
        List techStackDtolist = new ArrayList();

        if (techStacks != null) {
            techStacks.forEach(techStack -> {
                TechStackDto techStackDto1 = new TechStackDto();
                techStackDto1.setId(techStack.getId());
                techStackDto1.setStack(techStack.getStack());
                techStackDtolist.add(techStackDto1);
            });
        }
        return techStackDtolist;
    }


}