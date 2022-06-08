package com.seed.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: YJ
 * @createTime: 2022/06/06 22:41
 * @company: https://www.xxx.cn
 * @description: 用户详细信息
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -8560165899637638579L;
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
