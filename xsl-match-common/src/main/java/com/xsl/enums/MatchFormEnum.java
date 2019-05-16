package com.xsl.enums;

/**
 * 说明：比赛形式枚举
 *
 * @Auther: 11432_000
 * @Date: 2019/4/21 14:05
 * @Description:
 */
public enum MatchFormEnum {
    PERSONAL(1,"个人"),GROUP(2,"团体"),UNLIMITED(3,"不限");

    private Integer key;
    private String value;

    MatchFormEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    /** 根据key获取相应的枚举 */
    public static MatchFormEnum getEnumByKey(Integer key){
        MatchFormEnum[] values = MatchFormEnum.values();
        for (MatchFormEnum matchForm : values){
            if (matchForm.key.equals(key)){
                return matchForm;
            }
        }
        throw new RuntimeException("不存在该枚举 key=" + key);
    }
}
