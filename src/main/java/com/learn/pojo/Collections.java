package com.learn.pojo;

public class Collections {
    private Long id;

    private Long publishId;

    private Long userId;

    private Boolean isexpire;

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

    public Boolean getIsexpire() {
        return isexpire;
    }

    public void setIsexpire(Boolean isexpire) {
        this.isexpire = isexpire;
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
        sb.append(", isexpire=").append(isexpire);
        sb.append("]");
        return sb.toString();
    }
}