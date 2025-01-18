package com.yj.kedaya.model.dto.statistic;

import lombok.Data;

/**
 * App 用户提交答案统计
 * @Author 阳健
 * @Package com.yj.kedaya.model.dto.statistic
 * @Date 2025/1/18 14:57
 */

@Data
public class AppAnswerCountDTO {

    private Long appId;

    /**
     * 用户提交答案数量
     */
    private Long answerCount;
}
