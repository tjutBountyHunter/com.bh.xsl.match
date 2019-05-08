package com.xsl.enums;

/**
 * 说明：比赛状态枚举
 *
 * @Auther: 11432_000
 * @Date: 2019/4/22 11:34
 * @Description:
 */
public enum  MatchState {
    BEFORE_SIGN_UP(1,"报名未开始"),SIGN_UP(2,"报名进行中"),SIGN_UP_END(3,"报名截止"),MATCH_START(4,"比赛进行中"),MATCH_REVIEW(5,"评审进行中"),MATCH_END(6,"比赛结束"),
    DELETE(0,"比赛禁用");

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

    /** 根据key获取相应的枚举 */
    public static MatchState getEnumByKey(Integer key){
        MatchState[] values = MatchState.values();
        for (MatchState matchState : values){
            if (matchState.key.equals(key)){
                return matchState;
            }
        }
        throw new RuntimeException("不存在该枚举 key=" + key);
    }
}
