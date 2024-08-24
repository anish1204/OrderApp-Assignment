package com.example.demo.controller;

import com.example.demo.Service.OrderService;
import com.example.demo.entity.Orders;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private OrderService orderService;
    public UserController(OrderService orderService) {
        this.orderService = orderService;
    }
    @Operation(summary = "add a order" )
    @PostMapping("/order")
    public ResponseEntity<Orders> saveOrder(@RequestBody Orders order) {
        Orders savedOrder = orderService.saveOrder(order);
        return ResponseEntity.ok(savedOrder);
    }


    @Operation(summary = "get all orders")
    @GetMapping("/orders")
    public List<Orders> getAllOrder(
            @RequestParam( value = "pageNumber",defaultValue = "0",required = false) int pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "5", required = false) int pageSize
            ) {
        System.out.println("Hello");
        return orderService.getAllOrder(pageNumber,pageSize);
    }
    @Operation(summary = "get specific order by Id")
    @GetMapping("/order/{id}")
    public Orders getOrderById(@PathVariable int id) {
        Orders order = orderService.fetchOrderById(id).get();
        return order;
    }


    @Operation(summary = "get all orders based on the nature of order   --> nature :{nature of business}")
    @GetMapping("/nature/{query}")
    public List<Orders> getOrderByNature(@PathVariable String query) {
        return orderService.getOrderByNature(query);
    }

    @Operation(summary = "get all orders based on the manufacturing process   --> process :{manufacturing_processes}")
    @GetMapping("/process/{query}")
    public List<Orders> getOrderByProcess(@PathVariable String query) {
        return orderService.getOrderByProcess(query);
    }

    @Operation(summary = "update an order")
    @PutMapping("/order/update/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable int id, @RequestBody Orders order) {
        Optional<Orders> updateOrderOptional = orderService.updateOrder(id, order);
        return updateOrderOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @Operation(summary = "delete an order")
    @DeleteMapping("/order/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        boolean deleteStatus = orderService.deleteOrder(id);
        if (deleteStatus) {
            return ResponseEntity.ok("Product with ID " + id + " has been deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete product with ID " + id);

        }
    }


}
