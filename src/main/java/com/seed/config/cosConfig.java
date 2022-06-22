package com.seed.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author: YJ
 * @createTime: 2022/06/17 18:09
 * @company: https://www.xxx.cn
 * @description: cos配置实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class cosConfig {
    private String status;//0表示失败 1成功
    private String message;
    private String url;
}
