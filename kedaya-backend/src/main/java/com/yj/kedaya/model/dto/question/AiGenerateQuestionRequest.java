package com.yj.kedaya.model.dto.question;

import lombok.Data;

/**
 * AI 生成题目请求
 * @Author 阳健
 * @Package com.yj.kedaya.model.dto.question
 * @Date 2025/1/16 20:44
 */

@Data
public class AiGenerateQuestionRequest {

    /**
     * 应用id
     */
    private Long appId;

    /**
     * 题目数量
     */
    int questionNumber = 10;

    /**
     * 选项数量
     */
    int optionNumber = 4;

    private  static final long serialVersionUID = 1L;
}
