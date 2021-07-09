package com.wf.consumerBT.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "stockCallPrice")
public class CallPrice {

    @Id
    private ObjectId objectId;

    @Field("tradeId")
    public String tradeId;

    @Field("outputDataFile")
    public String outputDataFile;

    @Field("callPrice")
    public List<CallPriceDoc> callPriceDocs;

    @Field("scenariosRow")
    private Integer scenarioRow;

    @Field("scenariosCol")
    private Integer scenarioCol;

    @Field("latestVersion")
    private Integer latestVersion;



    public Integer getScenarioCol() {
        return scenarioCol;
    }

    public void setScenarioCol(Integer scenarioCol) {
        this.scenarioCol = scenarioCol;
    }

    public Integer getScenarioRow() {
        return scenarioRow;
    }

    public void setScenarioRow(Integer scenarioRow) {
        this.scenarioRow = scenarioRow;
    }

    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getOutputDataFile() {
        return outputDataFile;
    }

    public void setOutputDataFile(String outputDataFile) {
        this.outputDataFile = outputDataFile;
    }

    public List<CallPriceDoc> getCallPriceDocs() {
        return callPriceDocs;
    }

    public void setCallPriceDocs(List<CallPriceDoc> callPriceDocs) {
        this.callPriceDocs = callPriceDocs;
    }

    public CallPrice() {
    }

    public Integer getLatestVersion() {
        return latestVersion;
    }

    public void setLatestVersion(Integer latestVersion) {
        this.latestVersion = latestVersion;
    }
}
