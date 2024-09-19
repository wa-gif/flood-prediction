package com.silva.flood.prediction.service;

import com.github.yulichang.base.MPJBaseService;
import com.silva.flood.prediction.model.News;
import com.silva.flood.prediction.model.resp.NewsResp;

import java.util.List;

public interface NewsService extends MPJBaseService<News> {
    List<NewsResp> list(Integer newsType);
}
