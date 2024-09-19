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
public class UserInfo {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDateTime birthday;
    private Integer bloodType;
    private Integer wheelchair;
    private String userName;
    private String phone;
    private String email;
    private Integer state;
}
