package com.yj.kedaya.scoring;

import com.yj.kedaya.model.entity.App;
import com.yj.kedaya.model.entity.UserAnswer;

import java.util.List;

/**
 * @Author 阳健
 * @Package com.yj.kedaya.scoring
 * @Date 2024/9/27 13:07
 */
public class CustomScoreScoringStrategy implements ScoringStrategy{

        @Override
        public UserAnswer doScore(List<String> choices, App app) throws Exception {
            return null;
        }
}
