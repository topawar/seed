package com.seed.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: YJ
 * @createTime: 2022/06/22 23:56
 * @company: https://www.xxx.cn
 * @description: 文章分类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleKind implements Serializable {
    private static final long serialVersionUID = -5459477095746577470L;
    private String Kind;
    private String IsEffective;
}
