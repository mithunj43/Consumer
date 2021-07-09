package com.wf.consumerBT.actor;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

public class GreeterString extends AbstractBehavior<String> {

    public GreeterString(ActorContext context){
        super(context);
    }

    public static Behavior<String> createString(){
        return Behaviors.setup(GreeterString::new);
    }

    public Receive<String> createReceive(){
        return newReceiveBuilder().onMessage(String.class,this::onRespond).build();
    }

    public Behavior<String> onRespond(String data){
        System.out.println(">>>>>>>>>>>>>data came "+data);
        return this;
    }
}
