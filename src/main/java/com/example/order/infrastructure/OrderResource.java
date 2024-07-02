package com.example.order.infrastructure;

import com.example.order.domain.model.Order;
import com.example.order.domain.model.OrderItem;
import com.example.order.domain.model.valueobjects.Status;
import com.example.order.domain.service.OrderService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    @Inject
    OrderService orderService;

    @POST
    public Response createOrder(Order order) {
    return Response.status(Response.Status.CREATED)
            .entity(orderService.createOrder(order))
            .build();
    }

    @POST
    @Path("/{orderId}/items")
    public Response addItemsToOrder(@PathParam("orderId") Long orderId, List<OrderItem> orderItems) {
        orderService.addItemsToOrder(orderId, orderItems);
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Path("/{orderId}/status")
    public Response updateOrderStatus(@PathParam("orderId") Long orderId, Status status) {
        orderService.updateOrderStatus(orderId, status);
        return Response.status(Response.Status.OK).build();
    }

    @GET
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GET
    @Path("/{orderId}")
    public Order getOrderById(@PathParam("orderId") Long orderId) {
        return orderService.getOrderById(orderId);
    }

}
