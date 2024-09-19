package com.silva.flood.prediction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Shelter {
    private Long id;
    private String shelterName;
    private String call;
    private String address;
    private Float lat;
    private Float lon;
    private Integer state;
}
