package com.test.task.foodordering.controller;

import com.test.task.foodordering.repository.MainRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/main")
@RequiredArgsConstructor
public class MainController {

    private final MainRepo mainRepo;
}
