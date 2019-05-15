package com.xw.ssm.domain;

/**
 * 旅客表
 * @author xw
 * @date 2019-05-14 21:58
 */
public class Traveller {
    private Integer id;
    private String name;
    private String sex;
    private String phoneNum;
    //证件类型 0 身份证 1 护照 2 军官证
    private Integer credentialsType;
    private String credentialsTypeStr;
    private String credentialsNum;
    //旅客类型0 成人 1 儿童
    private Integer travellerType;
    private String travellerTypeStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsTypeStr() {
        //证件类型 0 身份证 1 护照 2 军官证
        if (credentialsType != null){
            if (credentialsType == 0){
                credentialsTypeStr = "身份证";
            }else if (credentialsType == 1){
                credentialsTypeStr = "护照";
            }else if (credentialsType == 2){
                credentialsTypeStr = "军官证";
            }
        }
        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public Integer getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;
    }

    public String getTravellerTypeStr() {
//        旅客类型0 成人 1 儿童
        if (travellerType != null){
            if (travellerType == 0){
                travellerTypeStr = "成人";
            }else if (travellerType == 1){
                travellerTypeStr = "儿童";
            }
        }
        return travellerTypeStr;
    }

    public void setTravellerTypeStr(String travellerTypeStr) {
        this.travellerTypeStr = travellerTypeStr;
    }
}
