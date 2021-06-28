package com.wf.consumerBT.cache;

import com.wf.consumerBT.entity.Risk;
import com.wf.consumerBT.repository.RiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RiskCache {

    public final List<Risk> riskCache;

    @Autowired
    public RiskCache(RiskRepository riskRepository) {
        this.riskCache = riskRepository.findAll(Sort.by(Sort.Order.asc("scenarios")));
        System.out.println(riskCache);
    }
}
