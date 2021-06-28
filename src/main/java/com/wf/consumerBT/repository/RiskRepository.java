package com.wf.consumerBT.repository;

import com.wf.consumerBT.entity.Risk;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface RiskRepository extends MongoRepository<Risk, Long> {




}
