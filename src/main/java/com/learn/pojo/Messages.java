package com.learn.pojo;

import java.util.Date;

public class Messages {
    private Long id;

    private Long ruserId;

    private Long luserId;

    private String luserName;

    private Long publishId;

    private String message;

    private Date beginDate;

    private Integer messageType;

    private Boolean isdeal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRuserId() {
        return ruserId;
    }

    public void setRuserId(Long ruserId) {
        this.ruserId = ruserId;
    }

    public Long getLuserId() {
        return luserId;
    }

    public void setLuserId(Long luserId) {
        this.luserId = luserId;
    }

    public String getLuserName() {
        return luserName;
    }

    public void setLuserName(String luserName) {
        this.luserName = luserName == null ? null : luserName.trim();
    }

    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public Boolean getIsdeal() {
        return isdeal;
    }

    public void setIsdeal(Boolean isdeal) {
        this.isdeal = isdeal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ruserId=").append(ruserId);
        sb.append(", luserId=").append(luserId);
        sb.append(", luserName=").append(luserName);
        sb.append(", publishId=").append(publishId);
        sb.append(", message=").append(message);
        sb.append(", beginDate=").append(beginDate);
        sb.append(", messageType=").append(messageType);
        sb.append(", isdeal=").append(isdeal);
        sb.append("]");
        return sb.toString();
    }
}