package com.example.w1.study;

import com.example.w1.study.entity.Customer;
import com.example.w1.study.entity.Food;
import com.example.w1.study.repository.CustomerRepository;
import com.example.w1.study.repository.FoodRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
public class OneToManyTest {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    FoodRepository foodRepository;

    @Test
    @Rollback(value = false)
    @DisplayName("1대N 단방향 테스트")
    void test1(){
        Customer customer = new Customer();
        customer.setName("cc");

        Customer customer1 = new Customer();
        customer1.setName("cc1");

        Food food = new Food();
        food.setName("후라이드 치킨");
        food.setPrice(15000);
        food.getCustomerList().add(customer); // 외래 키(연관 관계) 설정
        food.getCustomerList().add(customer1); // 외래 키(연관 관계) 설정

        customerRepository.save(customer);
        customerRepository.save(customer1);
        foodRepository.save(food);
    }

    @Test
    @Rollback(value = false)
    @DisplayName("find test")
    void test2(){
        Customer customer = customerRepository.findById(1L).orElseThrow(IllegalArgumentException::new);
        customer.setName("cc_re2");

        Food food = foodRepository.findById(2L).orElseThrow(IllegalArgumentException::new);
        food.getCustomerList().add(customer);
        System.out.println(food.getCustomerList());
    }
}
