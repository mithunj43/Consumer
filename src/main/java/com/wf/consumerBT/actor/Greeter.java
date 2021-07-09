package com.wf.consumerBT.actor;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

public class Greeter extends AbstractBehavior<Greeter.Greet> {

  public static final class Greet {
    public final String whom;

    public Greet(String whom) {
      this.whom = whom;
    }
  }


  public ActorRef<String> stringActorRef;


  public static Behavior<Greet> create() {
    return Behaviors.setup(Greeter::new);
  }

  private Greeter(ActorContext<Greet> context) {
    super(context);
    stringActorRef = context.spawn(GreeterString.createString(),"creating");
  }

  @Override
  public Receive<Greet> createReceive() {


    return newReceiveBuilder().onMessage(Greet.class, this::onGreet).build();
  }

  private Behavior<Greet> onGreet(Greet command) {
    stringActorRef.tell("file and forget");
    return this;
  }
}