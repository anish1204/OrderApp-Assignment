package com.example.demo.Service;


import com.example.demo.entity.Orders;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Service

public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        super();
        this.orderRepository = orderRepository;
    }


    public Orders saveOrder(Orders order) {
        try {
            return orderRepository.save(order);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add data " + e.getMessage());
        }
    }

    public Optional<Orders> fetchOrderById(int Id) {
        try {
            return orderRepository.findById(Id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add data " + e.getMessage());
        }
    }

    public List<Orders> getAllOrder(int pageNumber,int pageSize) {

        Pageable p = PageRequest.of(pageNumber,pageSize);

        Page<Orders> orderPost = this.orderRepository.findAll(p);
        List<Orders> allorders = orderPost.getContent();
        return allorders;

    }

    public List<Orders> getOrderByNature(String NatureType) {
        return orderRepository.findByNature(NatureType);
    }

    public List<Orders> getOrderByProcess(String ProcessType) {
        return orderRepository.findByProcess(ProcessType);
    }

    public Optional<Orders> updateOrder(int id, Orders newOrder) {
        try {
            Optional<Orders> currentOptionalOrder = orderRepository.findById(id);
            if (currentOptionalOrder.isPresent()) {
                Orders currentOrder = currentOptionalOrder.get();
                currentOrder.setCompany_name(newOrder.getCompany_name());
                currentOrder.setWebsite(newOrder.getLocation());
                currentOrder.setLocation(newOrder.getLocation());
                currentOrder.setNature_of_business(newOrder.getNature_of_business());
                currentOrder.setManufacturing_processes(newOrder.getManufacturing_processes());

                Orders savedEntity = orderRepository.save(currentOrder);
                return Optional.of(currentOrder);

            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new RuntimeException("Some Error Occured" + e.getMessage());
        }
    }


    public boolean deleteOrder(int id) {
        try {
            orderRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete product: " + e.getMessage());
        }
    }


}
