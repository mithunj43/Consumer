package com.wf.consumerBT.repository;

import com.wf.consumerBT.entity.CallPrice;
import com.wf.consumerBT.entity.Risk;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CallRepository extends MongoRepository<CallPrice, Long> {

    List<CallPrice> findCallPriceByTradeId(String tradeId, Sort sort);

    CallPrice findCallPriceByTradeIdAndScenarioRow(String tradeId,Integer scenarioRow);


}
