package com.wf.publisherBT.entity;


public class Trade {
    public String tradeId;

    public int timeToMaturity;

    public int strikePrice;

    public int initialIndexLevel;

    public String outputDataFile;

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public int getTimeToMaturity() {
        return timeToMaturity;
    }

    public void setTimeToMaturity(int timeToMaturity) {
        this.timeToMaturity = timeToMaturity;
    }

    public int getStrikePrice() {
        return strikePrice;
    }

    public void setStrikePrice(int strikePrice) {
        this.strikePrice = strikePrice;
    }

    public int getInitialIndexLevel() {
        return initialIndexLevel;
    }

    public void setInitialIndexLevel(int initialIndexLevel) {
        this.initialIndexLevel = initialIndexLevel;
    }

    public String getOutputDataFile() {
        return outputDataFile;
    }

    public void setOutputDataFile(String outputDataFile) {
        this.outputDataFile = outputDataFile;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "tradeId='" + tradeId + '\'' +
                ", timeToMaturity=" + timeToMaturity +
                ", strikePrice=" + strikePrice +
                ", initialIndexLevel=" + initialIndexLevel +
                ", outputDataFile='" + outputDataFile + '\'' +
                '}';
    }
}
