package com.silva.flood.prediction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class News {
    private Long id;
    private String title;
    private String content;
    private String creator;
    private LocalDateTime createTime;
    private String state;
    private String imageUrl;
    private Integer newType;
}
