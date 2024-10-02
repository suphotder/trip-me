package com.example.server.controller;

import java.util.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.server.service.TagService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tags")
public class TagController {

    private final TagService tagService;

    @GetMapping("popular")
    public ResponseEntity<List<String>> getTagPopular() {
        List<String> popTags = tagService.getTagPopularService();
        return ResponseEntity.ok(popTags);
    }

}
