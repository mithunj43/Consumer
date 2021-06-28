package com.wf.consumerBT.repository;

import com.wf.consumerBT.entity.Risk;
import com.wf.consumerBT.entity.Sigma;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SigmaRepository extends MongoRepository<Sigma, Long> {




}
