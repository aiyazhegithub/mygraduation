package com.learn.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MessagesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessagesExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRuserIdIsNull() {
            addCriterion("ruser_id is null");
            return (Criteria) this;
        }

        public Criteria andRuserIdIsNotNull() {
            addCriterion("ruser_id is not null");
            return (Criteria) this;
        }

        public Criteria andRuserIdEqualTo(Long value) {
            addCriterion("ruser_id =", value, "ruserId");
            return (Criteria) this;
        }

        public Criteria andRuserIdNotEqualTo(Long value) {
            addCriterion("ruser_id <>", value, "ruserId");
            return (Criteria) this;
        }

        public Criteria andRuserIdGreaterThan(Long value) {
            addCriterion("ruser_id >", value, "ruserId");
            return (Criteria) this;
        }

        public Criteria andRuserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ruser_id >=", value, "ruserId");
            return (Criteria) this;
        }

        public Criteria andRuserIdLessThan(Long value) {
            addCriterion("ruser_id <", value, "ruserId");
            return (Criteria) this;
        }

        public Criteria andRuserIdLessThanOrEqualTo(Long value) {
            addCriterion("ruser_id <=", value, "ruserId");
            return (Criteria) this;
        }

        public Criteria andRuserIdIn(List<Long> values) {
            addCriterion("ruser_id in", values, "ruserId");
            return (Criteria) this;
        }

        public Criteria andRuserIdNotIn(List<Long> values) {
            addCriterion("ruser_id not in", values, "ruserId");
            return (Criteria) this;
        }

        public Criteria andRuserIdBetween(Long value1, Long value2) {
            addCriterion("ruser_id between", value1, value2, "ruserId");
            return (Criteria) this;
        }

        public Criteria andRuserIdNotBetween(Long value1, Long value2) {
            addCriterion("ruser_id not between", value1, value2, "ruserId");
            return (Criteria) this;
        }

        public Criteria andLuserIdIsNull() {
            addCriterion("luser_id is null");
            return (Criteria) this;
        }

        public Criteria andLuserIdIsNotNull() {
            addCriterion("luser_id is not null");
            return (Criteria) this;
        }

        public Criteria andLuserIdEqualTo(Long value) {
            addCriterion("luser_id =", value, "luserId");
            return (Criteria) this;
        }

        public Criteria andLuserIdNotEqualTo(Long value) {
            addCriterion("luser_id <>", value, "luserId");
            return (Criteria) this;
        }

        public Criteria andLuserIdGreaterThan(Long value) {
            addCriterion("luser_id >", value, "luserId");
            return (Criteria) this;
        }

        public Criteria andLuserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("luser_id >=", value, "luserId");
            return (Criteria) this;
        }

        public Criteria andLuserIdLessThan(Long value) {
            addCriterion("luser_id <", value, "luserId");
            return (Criteria) this;
        }

        public Criteria andLuserIdLessThanOrEqualTo(Long value) {
            addCriterion("luser_id <=", value, "luserId");
            return (Criteria) this;
        }

        public Criteria andLuserIdIn(List<Long> values) {
            addCriterion("luser_id in", values, "luserId");
            return (Criteria) this;
        }

        public Criteria andLuserIdNotIn(List<Long> values) {
            addCriterion("luser_id not in", values, "luserId");
            return (Criteria) this;
        }

        public Criteria andLuserIdBetween(Long value1, Long value2) {
            addCriterion("luser_id between", value1, value2, "luserId");
            return (Criteria) this;
        }

        public Criteria andLuserIdNotBetween(Long value1, Long value2) {
            addCriterion("luser_id not between", value1, value2, "luserId");
            return (Criteria) this;
        }

        public Criteria andLuserNameIsNull() {
            addCriterion("luser_name is null");
            return (Criteria) this;
        }

        public Criteria andLuserNameIsNotNull() {
            addCriterion("luser_name is not null");
            return (Criteria) this;
        }

        public Criteria andLuserNameEqualTo(String value) {
            addCriterion("luser_name =", value, "luserName");
            return (Criteria) this;
        }

        public Criteria andLuserNameNotEqualTo(String value) {
            addCriterion("luser_name <>", value, "luserName");
            return (Criteria) this;
        }

        public Criteria andLuserNameGreaterThan(String value) {
            addCriterion("luser_name >", value, "luserName");
            return (Criteria) this;
        }

        public Criteria andLuserNameGreaterThanOrEqualTo(String value) {
            addCriterion("luser_name >=", value, "luserName");
            return (Criteria) this;
        }

        public Criteria andLuserNameLessThan(String value) {
            addCriterion("luser_name <", value, "luserName");
            return (Criteria) this;
        }

        public Criteria andLuserNameLessThanOrEqualTo(String value) {
            addCriterion("luser_name <=", value, "luserName");
            return (Criteria) this;
        }

        public Criteria andLuserNameLike(String value) {
            addCriterion("luser_name like", value, "luserName");
            return (Criteria) this;
        }

        public Criteria andLuserNameNotLike(String value) {
            addCriterion("luser_name not like", value, "luserName");
            return (Criteria) this;
        }

        public Criteria andLuserNameIn(List<String> values) {
            addCriterion("luser_name in", values, "luserName");
            return (Criteria) this;
        }

        public Criteria andLuserNameNotIn(List<String> values) {
            addCriterion("luser_name not in", values, "luserName");
            return (Criteria) this;
        }

        public Criteria andLuserNameBetween(String value1, String value2) {
            addCriterion("luser_name between", value1, value2, "luserName");
            return (Criteria) this;
        }

        public Criteria andLuserNameNotBetween(String value1, String value2) {
            addCriterion("luser_name not between", value1, value2, "luserName");
            return (Criteria) this;
        }

        public Criteria andPublishIdIsNull() {
            addCriterion("publish_id is null");
            return (Criteria) this;
        }

        public Criteria andPublishIdIsNotNull() {
            addCriterion("publish_id is not null");
            return (Criteria) this;
        }

        public Criteria andPublishIdEqualTo(Long value) {
            addCriterion("publish_id =", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdNotEqualTo(Long value) {
            addCriterion("publish_id <>", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdGreaterThan(Long value) {
            addCriterion("publish_id >", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdGreaterThanOrEqualTo(Long value) {
            addCriterion("publish_id >=", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdLessThan(Long value) {
            addCriterion("publish_id <", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdLessThanOrEqualTo(Long value) {
            addCriterion("publish_id <=", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdIn(List<Long> values) {
            addCriterion("publish_id in", values, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdNotIn(List<Long> values) {
            addCriterion("publish_id not in", values, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdBetween(Long value1, Long value2) {
            addCriterion("publish_id between", value1, value2, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdNotBetween(Long value1, Long value2) {
            addCriterion("publish_id not between", value1, value2, "publishId");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNull() {
            addCriterion("begin_date is null");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNotNull() {
            addCriterion("begin_date is not null");
            return (Criteria) this;
        }

        public Criteria andBeginDateEqualTo(Date value) {
            addCriterionForJDBCDate("begin_date =", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("begin_date <>", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThan(Date value) {
            addCriterionForJDBCDate("begin_date >", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("begin_date >=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThan(Date value) {
            addCriterionForJDBCDate("begin_date <", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("begin_date <=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateIn(List<Date> values) {
            addCriterionForJDBCDate("begin_date in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("begin_date not in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("begin_date between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("begin_date not between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIsNull() {
            addCriterion("message_type is null");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIsNotNull() {
            addCriterion("message_type is not null");
            return (Criteria) this;
        }

        public Criteria andMessageTypeEqualTo(Integer value) {
            addCriterion("message_type =", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotEqualTo(Integer value) {
            addCriterion("message_type <>", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeGreaterThan(Integer value) {
            addCriterion("message_type >", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_type >=", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeLessThan(Integer value) {
            addCriterion("message_type <", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeLessThanOrEqualTo(Integer value) {
            addCriterion("message_type <=", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIn(List<Integer> values) {
            addCriterion("message_type in", values, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotIn(List<Integer> values) {
            addCriterion("message_type not in", values, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeBetween(Integer value1, Integer value2) {
            addCriterion("message_type between", value1, value2, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("message_type not between", value1, value2, "messageType");
            return (Criteria) this;
        }

        public Criteria andIsdealIsNull() {
            addCriterion("isdeal is null");
            return (Criteria) this;
        }

        public Criteria andIsdealIsNotNull() {
            addCriterion("isdeal is not null");
            return (Criteria) this;
        }

        public Criteria andIsdealEqualTo(Boolean value) {
            addCriterion("isdeal =", value, "isdeal");
            return (Criteria) this;
        }

        public Criteria andIsdealNotEqualTo(Boolean value) {
            addCriterion("isdeal <>", value, "isdeal");
            return (Criteria) this;
        }

        public Criteria andIsdealGreaterThan(Boolean value) {
            addCriterion("isdeal >", value, "isdeal");
            return (Criteria) this;
        }

        public Criteria andIsdealGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isdeal >=", value, "isdeal");
            return (Criteria) this;
        }

        public Criteria andIsdealLessThan(Boolean value) {
            addCriterion("isdeal <", value, "isdeal");
            return (Criteria) this;
        }

        public Criteria andIsdealLessThanOrEqualTo(Boolean value) {
            addCriterion("isdeal <=", value, "isdeal");
            return (Criteria) this;
        }

        public Criteria andIsdealIn(List<Boolean> values) {
            addCriterion("isdeal in", values, "isdeal");
            return (Criteria) this;
        }

        public Criteria andIsdealNotIn(List<Boolean> values) {
            addCriterion("isdeal not in", values, "isdeal");
            return (Criteria) this;
        }

        public Criteria andIsdealBetween(Boolean value1, Boolean value2) {
            addCriterion("isdeal between", value1, value2, "isdeal");
            return (Criteria) this;
        }

        public Criteria andIsdealNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isdeal not between", value1, value2, "isdeal");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}