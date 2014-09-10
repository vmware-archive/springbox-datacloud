package io.pivotal.cf.demo.springbox.gateways;

import io.pivotal.cf.demo.springbox.events.DropOffEvent;
import io.pivotal.cf.demo.springbox.events.PickUpEvent;
import io.pivotal.cf.demo.springbox.events.RentEvent;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface InventoryGateway {

    @Gateway(requestChannel = "dropOffChannel")
    void sendDropOffEvent(DropOffEvent event);

    @Gateway(requestChannel = "pickUpChannel")
    void sendPickUpEvent(PickUpEvent event);

    @Gateway(requestChannel = "rentChannel")
    void sendRentEvent(RentEvent rentEvent);
}
