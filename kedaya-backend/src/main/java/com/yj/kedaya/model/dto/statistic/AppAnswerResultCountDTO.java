package com.yj.kedaya.model.dto.statistic;

import lombok.Data;

/**
 * @Author 阳健
 * @Package com.yj.kedaya.model.dto.statistic
 * @Date 2025/1/18 15:11
 */

@Data
public class AppAnswerResultCountDTO {

    // 结果名称
    private String resultName;

    // 对应个数
    private String resultCount;
}
