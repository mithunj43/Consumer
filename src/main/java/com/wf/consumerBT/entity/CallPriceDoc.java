package com.wf.consumerBT.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

public class CallPriceDoc {

    @Field("version")
    public Integer version;

    @Field("callPrice")
    private List<Double> callPrice;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<Double> getCallPrice() {
        return callPrice;
    }

    public void setCallPrice(List<Double> callPrice) {
        this.callPrice = callPrice;
    }

    public CallPriceDoc() {
    }
}
