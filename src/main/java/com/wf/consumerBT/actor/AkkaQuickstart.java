package com.wf.consumerBT.actor;

import akka.actor.typed.ActorSystem;

public class AkkaQuickstart {
  final  static ActorSystem<com.wf.consumerBT.actor.GreeterMain.SayHello> greeterMain = ActorSystem.create(com.wf.consumerBT.actor.GreeterMain.create(), "helloakka");
  public static void main(String[] args) {
    //#actor-system


    //#main-send-messages
    greeterMain.tell(new com.wf.consumerBT.actor.GreeterMain.SayHello("Charles"));

    try {
      System.out.println(">>> quick start ended <<<");
    } finally {
      greeterMain.terminate();
    }
  }
}
