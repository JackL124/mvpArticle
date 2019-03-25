package com.jackl.mvparticle.entity.Register;

public class LoginBean {

    private String buildChannelId;
    private String buildChannelName;
    private String name;
    private String partnerChannelId;
    private String partnerName;
    private String roleSign;
    private String t;
    private String classUrl;
    private String shareUrl;
    private String phone;
    public String getClassUrl() {
        return classUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setClassUrl(String classUrl) {
        this.classUrl = classUrl;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getBuildChannelId() {
        return buildChannelId;
    }

    public void setBuildChannelId(String buildChannelId) {
        this.buildChannelId = buildChannelId;
    }

    public String getBuildChannelName() {
        return buildChannelName;
    }

    public void setBuildChannelName(String buildChannelName) {
        this.buildChannelName = buildChannelName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartnerChannelId() {
        return partnerChannelId;
    }

    public void setPartnerChannelId(String partnerChannelId) {
        this.partnerChannelId = partnerChannelId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getRoleSign() {
        return roleSign;
    }

    public void setRoleSign(String roleSign) {
        this.roleSign = roleSign;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }


    @Override
    public String toString() {
        return "UserBean{" +
                "buildChannelId='" + buildChannelId + '\'' +
                ", buildChannelName='" + buildChannelName + '\'' +
                ", name='" + name + '\'' +
                ", partnerChannelId='" + partnerChannelId + '\'' +
                ", partnerName='" + partnerName + '\'' +
                ", roleSign='" + roleSign + '\'' +
                ", t='" + t + '\'' +
                ", classUrl='" + classUrl + '\'' +
                ", shareUrl='" + shareUrl + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
