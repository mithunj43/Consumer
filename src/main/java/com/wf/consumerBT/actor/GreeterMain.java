package com.wf.consumerBT.actor;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

public class GreeterMain extends AbstractBehavior<GreeterMain.SayHello> {

    private Integer num = 0;

    public static class SayHello {
        public final String name;

        public SayHello(String name) {
            this.name = name;
        }
    }

    private final ActorRef<com.wf.consumerBT.actor.Greeter.Greet> greeter;

    public static Behavior<SayHello> create() {
        return Behaviors.setup(GreeterMain::new);
    }

    private GreeterMain(ActorContext<SayHello> context) {
        super(context);
        //#create-actors
        greeter = context.spawn(com.wf.consumerBT.actor.Greeter.create(), "greeter");

        //#create-actors
    }

    @Override
    public Receive<SayHello> createReceive() {
        return newReceiveBuilder().onMessage(SayHello.class, this::onSayHello).build();
    }

    private Behavior<SayHello> onSayHello(SayHello command) {
        //#create-actors

        System.out.println("incrementing   " +num ++);

        greeter.tell(new com.wf.consumerBT.actor.Greeter.Greet(command.name));
        //#create-actors
        return this;
    }
}
