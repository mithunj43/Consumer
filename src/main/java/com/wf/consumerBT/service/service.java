package com.wf.consumerBT.service;

import com.wf.consumerBT.cache.RiskCache;
import com.wf.consumerBT.cache.SigmaCache;
import com.wf.consumerBT.entity.CallPrice;
import com.wf.consumerBT.entity.CallPriceDoc;
import com.wf.consumerBT.entity.Risk;
import com.wf.consumerBT.entity.Sigma;
import com.wf.consumerBT.model.StockPrice;
import com.wf.consumerBT.repository.CallRepository;
import com.wf.consumerBT.repository.RiskRepository;
import com.wf.publisherBT.entity.Trade;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class service {

    @Autowired
    RiskCache riskCacheGetter;

    @Autowired
    SigmaCache sigmaCacheGetter;

    @Autowired
    CallRepository callRepository;

    @Autowired
    StockPrice stockPrice;




    @KafkaListener(topics = "tradeData7", groupId = "group_id")
    public void consume(Trade message, Acknowledgment acknowledgment) throws IOException {
        acknowledgment.acknowledge();
        calculateCallPrice(message,acknowledgment);
    }


    private void calculateCallPrice(Trade trade,Acknowledgment acknowledgment){
        List<Risk> risks= riskCacheGetter.riskCache;
        int maxScenarios = risks.size();

        List<Sigma> sigmas = sigmaCacheGetter.sigmaCache;
        for (int i = 0; i < maxScenarios; i++) {

            calculateCallPriceForEachScenario(trade,risks.get(i),sigmas.get(i),i);
        }
    }

    private void calculateCallPriceForEachScenario(Trade trade,Risk risk,Sigma sigma,int index){
        String riskString = getRiskString(risk) ;
        String sigmaString = getSigmaString(sigma);

        String[] risksArray = riskString.split("~");
        int colCount = risksArray.length;

        String[] sigmaArray = sigmaString.split("~");
        DecimalFormat df = new DecimalFormat("0.00");
        for (int i = 0; i < colCount; i++) {


            double price = stockPrice.callPrice(trade.getInitialIndexLevel(),
                    trade.getStrikePrice(),
                    Double.parseDouble(df.format(new Double(risksArray[i]))),
                    Double.parseDouble(df.format(new Double(sigmaArray[i]))),
                    trade.getTimeToMaturity());


            CallPrice callPrice = new CallPrice();

            List<CallPriceDoc> callPriceDocs = new ArrayList<>();

            callPrice.setTradeId(trade.getTradeId());
            callPrice.setOutputDataFile(trade.getOutputDataFile());
            callPrice.setCallPriceDocs(callPriceDocs);
            callPrice.setScenarioRow(index);
            callPrice.setScenarioCol(i);

            CallPriceDoc callPriceDoc = new CallPriceDoc();
            callPriceDoc.setCallPrice(price);
            callPriceDoc.setVersion("1");
            callPriceDocs.add(callPriceDoc);

            callRepository.save(callPrice);


        }

    }

    private String getRiskString(Risk risk){
        String riskString = risk.getZero()+"~"+ risk.getOne()+"~"+ risk.getTwo()+"~"+
                risk.getThree()+"~"+ risk.getFour()+"~"+ risk.getFive()+"~"+
                risk.getSix()+"~"+ risk.getSeven()+"~"+ risk.getEight()+"~"+
                risk.getNine()+"~"+ risk.getTen()+"~"+

                risk.getOne1()+"~"+ risk.getTwo1()+"~"+
                risk.getThree1()+"~"+ risk.getFour1()+"~"+ risk.getFive1()+"~"+
                risk.getSix1()+"~"+ risk.getSeven1()+"~"+ risk.getEight1()+"~"+
                risk.getNine1()+"~"+ risk.getTen1()+"~"+


                risk.getOne2()+"~"+ risk.getTwo2()+"~"+
                risk.getThree2()+"~"+ risk.getFour2()+"~"+ risk.getFive2()+"~"+
                risk.getSix2()+"~"+ risk.getSeven2()+"~"+ risk.getEight2()+"~"+
                risk.getNine2()+"~"+ risk.getTen2()+"~"+


                risk.getOne3()+"~"+ risk.getTwo3()+"~"+
                risk.getThree3()+"~"+ risk.getFour3()+"~"+ risk.getFive3()+"~"+
                risk.getSix3()+"~"+ risk.getSeven3()+"~"+ risk.getEight3()+"~"+
                risk.getNine3()+"~"+ risk.getTen3()+"~"+


                risk.getOne4()+"~"+ risk.getTwo4()+"~"+
                risk.getThree4()+"~"+ risk.getFour4()+"~"+ risk.getFive4()+"~"+
                risk.getSix4()+"~"+ risk.getSeven4()+"~"+ risk.getEight4()+"~"+
                risk.getNine4()+"~"+ risk.getTen4()+"~"+

                risk.getOne5()+"~"+ risk.getTwo5()+"~"+
                risk.getThree5()+"~"+ risk.getFour5()+"~"+ risk.getFive5()+"~"+
                risk.getSix5()+"~"+ risk.getSeven5()+"~"+ risk.getEight5()+"~"+
                risk.getNine5()+"~"+ risk.getTen5()+"~"+

                risk.getOne6()+"~"+ risk.getTwo6()+"~"+
                risk.getThree6()+"~"+ risk.getFour6()+"~"+ risk.getFive6()+"~"+
                risk.getSix6()+"~"+ risk.getSeven6()+"~"+ risk.getEight6()+"~"+
                risk.getNine6()+"~"+ risk.getTen6()+"~"+

                risk.getOne7()+"~"+ risk.getTwo7()+"~"+
                risk.getThree7()+"~"+ risk.getFour7();


        return riskString;
    }


    private String getSigmaString(Sigma risk){
        String sigmaString = risk.getZero()+"~"+ risk.getOne()+"~"+ risk.getTwo()+"~"+
                risk.getThree()+"~"+ risk.getFour()+"~"+ risk.getFive()+"~"+
                risk.getSix()+"~"+ risk.getSeven()+"~"+ risk.getEight()+"~"+
                risk.getNine()+"~"+ risk.getTen()+"~"+

                risk.getOne1()+"~"+ risk.getTwo1()+"~"+
                risk.getThree1()+"~"+ risk.getFour1()+"~"+ risk.getFive1()+"~"+
                risk.getSix1()+"~"+ risk.getSeven1()+"~"+ risk.getEight1()+"~"+
                risk.getNine1()+"~"+ risk.getTen1()+"~"+


                risk.getOne2()+"~"+ risk.getTwo2()+"~"+
                risk.getThree2()+"~"+ risk.getFour2()+"~"+ risk.getFive2()+"~"+
                risk.getSix2()+"~"+ risk.getSeven2()+"~"+ risk.getEight2()+"~"+
                risk.getNine2()+"~"+ risk.getTen2()+"~"+


                risk.getOne3()+"~"+ risk.getTwo3()+"~"+
                risk.getThree3()+"~"+ risk.getFour3()+"~"+ risk.getFive3()+"~"+
                risk.getSix3()+"~"+ risk.getSeven3()+"~"+ risk.getEight3()+"~"+
                risk.getNine3()+"~"+ risk.getTen3()+"~"+


                risk.getOne4()+"~"+ risk.getTwo4()+"~"+
                risk.getThree4()+"~"+ risk.getFour4()+"~"+ risk.getFive4()+"~"+
                risk.getSix4()+"~"+ risk.getSeven4()+"~"+ risk.getEight4()+"~"+
                risk.getNine4()+"~"+ risk.getTen4()+"~"+

                risk.getOne5()+"~"+ risk.getTwo5()+"~"+
                risk.getThree5()+"~"+ risk.getFour5()+"~"+ risk.getFive5()+"~"+
                risk.getSix5()+"~"+ risk.getSeven5()+"~"+ risk.getEight5()+"~"+
                risk.getNine5()+"~"+ risk.getTen5()+"~"+

                risk.getOne6()+"~"+ risk.getTwo6()+"~"+
                risk.getThree6()+"~"+ risk.getFour6()+"~"+ risk.getFive6()+"~"+
                risk.getSix6()+"~"+ risk.getSeven6()+"~"+ risk.getEight6()+"~"+
                risk.getNine6()+"~"+ risk.getTen6()+"~"+

                risk.getOne7()+"~"+ risk.getTwo7()+"~"+
                risk.getThree7()+"~"+ risk.getFour7();


        return sigmaString;
    }






}