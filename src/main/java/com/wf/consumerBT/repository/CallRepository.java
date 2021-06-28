package com.wf.consumerBT.repository;

import com.wf.consumerBT.entity.CallPrice;
import com.wf.consumerBT.entity.Risk;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CallRepository extends MongoRepository<CallPrice, Long> {




}
