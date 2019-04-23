package com.xsl.enums;

/**
 * 说明：比赛状态枚举
 *
 * @Auther: 11432_000
 * @Date: 2019/4/22 11:34
 * @Description:
 */
public enum  MatchState {
    BEFORE_SIGN_UP(0,"报名未开始"),SIGN_UP(1,"报名进行中"),SIGN_UP_END(2,"报名截止"),MATCH_START(3,"比赛进行中"),MATCH_REVIEW(4,"评审进行中"),MATCH_END(5,"比赛结束"),
    DELETE(6,"比赛禁用");

    private Integer key;
    private String message;

    MatchState(Integer key, String message) {
        this.key = key;
        this.message = message;
    }

    public Integer getKey() {
        return key;
    }

    public String getMessage() {
        return message;
    }
}
