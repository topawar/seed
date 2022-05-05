package com.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private String Id;
    private String Uid;
    private String Name;
    private String PassWord;
    private Integer Gender;
    private Integer Age;
    private Integer EffectiveTag;
    private String CreateTime;
    private String UpdateTime;

}
