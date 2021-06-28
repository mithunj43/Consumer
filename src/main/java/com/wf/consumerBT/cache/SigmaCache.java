package com.wf.consumerBT.cache;


import com.wf.consumerBT.entity.Risk;
import com.wf.consumerBT.entity.Sigma;
import com.wf.consumerBT.repository.RiskRepository;
import com.wf.consumerBT.repository.SigmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SigmaCache {
    public final List<Sigma> sigmaCache;

    @Autowired
    public SigmaCache(SigmaRepository sigmaRepository) {
        this.sigmaCache = sigmaRepository.findAll(Sort.by(Sort.Order.asc("scenarios")));
    }
}

