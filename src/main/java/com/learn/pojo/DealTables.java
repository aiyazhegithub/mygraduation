package com.learn.pojo;

import java.util.Date;

public class DealTables {
    private Long id;

    private Long publishId;

    private Long userId;

    private String message;

    private Date beginDate;

    private Date endDate;

    private PublishGoods publishGoods;

    public PublishGoods getPublishGoods() {
        return publishGoods;
    }

    public void setPublishGoods(PublishGoods publishGoods) {
        this.publishGoods = publishGoods;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", publishId=").append(publishId);
        sb.append(", userId=").append(userId);
        sb.append(", message=").append(message);
        sb.append(", beginDate=").append(beginDate);
        sb.append(", endDate=").append(endDate);
        sb.append("]");
        return sb.toString();
    }
}