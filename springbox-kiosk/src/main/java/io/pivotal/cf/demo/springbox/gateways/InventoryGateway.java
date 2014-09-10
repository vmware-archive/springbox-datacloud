package io.pivotal.cf.demo.springbox.gateways;

import io.pivotal.cf.demo.springbox.events.DropOffEvent;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface InventoryGateway {

    @Gateway(requestChannel = "dropOffChannel")
    void sendDropOffEvent(DropOffEvent event);
}
