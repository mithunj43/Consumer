package com.wf.consumerBT.entity;

import org.springframework.data.mongodb.core.mapping.Field;

public class CallPriceDoc {

    @Field("version")
    public String version;

    @Field("callPrice")
    private Double callPrice;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Double getCallPrice() {
        return callPrice;
    }

    public void setCallPrice(Double callPrice) {
        this.callPrice = callPrice;
    }

    public CallPriceDoc() {
    }
}
