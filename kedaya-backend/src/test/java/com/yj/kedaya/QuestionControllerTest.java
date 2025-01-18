package com.yj.kedaya;

import com.yj.kedaya.controller.QuestionController;
import com.yj.kedaya.model.dto.question.AiGenerateQuestionRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author 阳健
 * @Package com.yj.kedaya
 * @Date 2025/1/18 14:29
 */

@SpringBootTest
public class QuestionControllerTest {

    @Resource
    private QuestionController questionController;

    @Test
    void aiGenerateQuestionSSETest() throws InterruptedException {
        // 模拟调用
        AiGenerateQuestionRequest aiGenerateQuestionRequest = new AiGenerateQuestionRequest();
        aiGenerateQuestionRequest.setAppId(3L);
        aiGenerateQuestionRequest.setQuestionNumber(10);
        aiGenerateQuestionRequest.setOptionNumber(2);

        // 模拟普通用户
        questionController.aiGenerateQuestionSSETest(aiGenerateQuestionRequest, false);
        // 模拟普通用户
        questionController.aiGenerateQuestionSSETest(aiGenerateQuestionRequest, false);
        // 模拟会员
        questionController.aiGenerateQuestionSSETest(aiGenerateQuestionRequest, true);

        // 模拟主线程一直启动
        Thread.sleep(1000000L);
    }
}
