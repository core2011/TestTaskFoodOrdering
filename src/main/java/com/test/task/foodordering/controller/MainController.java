package com.test.task.foodordering.controller;

import com.test.task.foodordering.repository.MainRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@RestController
@RequestMapping(value = "/main")
@RequiredArgsConstructor
@SessionScope
public class MainController {

    private final MainRepo mainRepo;
}
