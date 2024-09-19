package com.silva.flood.prediction.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.silva.flood.prediction.enums.StateEnum;
import com.silva.flood.prediction.mapper.NewsMapper;
import com.silva.flood.prediction.model.News;
import com.silva.flood.prediction.model.resp.NewsResp;
import com.silva.flood.prediction.service.NewsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class NewsServiceImpl extends MPJBaseServiceImpl<NewsMapper, News> implements NewsService {
    @Resource
    private NewsMapper newsMapper;

    @Override
    public List<NewsResp> list(Integer newsType) {
        LambdaQueryWrapper<News> wrapper = new LambdaQueryWrapper<News>()
                .eq(!ObjectUtils.isEmpty(newsType), News::getNewType, newsType)
                .eq(News::getState, StateEnum.STATE_NORMAL.getCode());
        List<News> newsList = newsMapper.selectList(wrapper);
        List<NewsResp> newsResps = newsList.stream().map(news -> new NewsResp().setId(news.getId())
                .setTitle(news.getTitle())
                .setContent(news.getContent())
                .setImageUrl(Arrays.asList(news.getImageUrl().split(",\\s*")))
                .setNewType(news.getNewType())).toList();
        return newsResps;
    }
}
