package com.silva.flood.prediction.model.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class NewsResp {
    private Long id;
    private String title;
    private String content;
    private List<String> imageUrl;
    private Integer newType;
}
