package com.yj.kedaya.model.dto.question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author 阳健
 * @Package com.yj.kedaya.model.dto.question
 * @Date 2024/9/23 13:03
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionContentDTO {

    /**
     * 题目标题
     */
    private String title;

    /**
     * 题目选项列表
     */
    private List<Option> options;

    /**
     * 题目选项
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Option{
        private String result;
        private int score;
        private String value;
        private String key;
    }


}
