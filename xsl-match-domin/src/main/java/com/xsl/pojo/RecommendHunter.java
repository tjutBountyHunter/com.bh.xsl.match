package com.xsl.pojo;

import java.util.TreeSet;

public class RecommendHunter {
    //标签集
    private TreeSet<Integer> tagSet;
    //标签向量
    private byte[] tagVector;
    //相似度
    private double simDu;
    //任务集中有关的任务数量
    private int taskCount;
    //特征值
    private double eigenValue;
    //推荐值
    private double recomValue;

    public byte[] getTagVector() {
        return tagVector;
    }

    public double getSimDu() {
        return simDu;
    }


    public TreeSet<Integer> getTagSet() {
        return tagSet;
    }

    public void setSimDu(double simDu) {
        this.simDu = simDu;
    }


    public double getEigenValue() {
        return eigenValue;
    }

    public int getTaskCount() {
        return taskCount;
    }

    public void setTagSet(TreeSet<Integer> tagSet) {
        this.tagSet = tagSet;
    }

    public void setEigenValue(double eigenValue) {
        this.eigenValue = eigenValue;
    }

    public double getRecomValue() {
        return recomValue;
    }

    public void setTagVector(byte[] tagVector) {
        this.tagVector = tagVector;
    }

    public void setRecomValue(double recomValue) {
        this.recomValue = recomValue;
    }

    public void setTaskCount(int taskCount) {
        this.taskCount = taskCount;
    }

}

