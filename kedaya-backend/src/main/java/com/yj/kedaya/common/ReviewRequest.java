package com.yj.kedaya.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 审核请求
 *
 * @Author 阳健
 * @Package com.yj.kedaya.common
 * @Date 2024/9/26 13:16
 */
@Data
public class ReviewRequest implements Serializable{

    /**
     * id
     */
    private Long id;

    /**
     * 状态：0-待审核，1-审核通过，2-审核不通过
     */
    private Integer reviewStatus;

    /**
     * 审核信息
     */
    private String reviewMessage;

    private static final long serialVersionUID = 1L;
}
