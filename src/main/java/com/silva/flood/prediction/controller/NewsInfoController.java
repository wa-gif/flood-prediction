package com.silva.flood.prediction.controller;

import com.silva.flood.prediction.model.resp.NewsResp;
import com.silva.flood.prediction.service.NewsService;
import com.silva.flood.prediction.utils.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/news")
public class NewsInfoController {
    @Resource
    private NewsService newsService;

    @GetMapping("/list")
    public Result<List<NewsResp>> list(@RequestParam(value = "newsType", required = false) Integer newsType) {
        List<NewsResp> newsResps = newsService.list(newsType);
        return Result.ok(newsResps);
    }
}
