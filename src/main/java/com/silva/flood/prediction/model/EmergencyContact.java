package com.silva.flood.prediction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EmergencyContact {
    private Long id;
    private Long userId;
    private String friend;
    private String call;
}
