package com.seed.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    private static final long serialVersionUID = -5004631268273938854L;
    private String Id;
    private String Uid;
    private String Name;
    private String PassWord;
    private Integer Gender;
    private Integer Age;
    private String ImageUrl;
    private Integer EffectiveTag;
    private String CreateTime;
    private String UpdateTime;

}
