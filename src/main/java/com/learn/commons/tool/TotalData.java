package com.learn.commons.tool;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TotalData {

    public TotalData() {

    }


    public TotalData(String msg) {
        this.msg = msg;
    }

    private String msg;

    private Object data;

    private Integer status;






}
