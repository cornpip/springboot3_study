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
public class ManyToOneTest {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    FoodRepository foodRepository;

    @Test
    @Rollback(value = false)
    @DisplayName("N대1 양방향 테스트 : 외래 키 저장 실패")
    void test2() {

        Food food = new Food();
        food.setName("후라이드 치킨");
        food.setPrice(15000);

        Food food2 = new Food();
        food2.setName("양념 치킨");
        food2.setPrice(20000);

        // 외래 키의 주인이 아닌 User 에서 Food 를 저장해보겠습니다.
        Customer customer = new Customer();
        customer.setName("Robbie");
        customer.getFoodList().add(food);
        customer.getFoodList().add(food2);

        customerRepository.save(customer);
        foodRepository.save(food);
        foodRepository.save(food2);

        // 확인해 보시면 user_id 값이 들어가 있지 않은 것을 확인하실 수 있습니다.
    }

    @Test
    @Rollback(value = false)
    @DisplayName("N대1 양방향 테스트 : 외래 키 저장 실패 -> 성공")
    void test3() {

        Food food = new Food();
        food.setName("후라이드 치킨");
        food.setPrice(15000);

        Food food2 = new Food();
        food2.setName("양념 치킨");
        food2.setPrice(20000);

        // 외래 키의 주인이 아닌 User 에서 Food 를 쉽게 저장하기 위해 addFoodList() 메서드 생성하고
        // 해당 메서드에 외래 키(연관 관계) 설정 food.setUser(this); 추가
        Customer customer = new Customer();
        customer.setName("Robbie");
        customer.addFoodList(food);
        customer.addFoodList(food2);

        customerRepository.save(customer);
        foodRepository.save(food);
        foodRepository.save(food2);
    }

    @Test
    @Rollback(value = false)
    @DisplayName("N대1 양방향 테스트")
    void test4() {
        Customer customer = new Customer();
        customer.setName("Robbert");

        Food food = new Food();
        food.setName("고구마 피자");
        food.setPrice(30000);
        food.setUser(customer); // 외래 키(연관 관계) 설정

        Food food2 = new Food();
        food2.setName("아보카도 피자");
        food2.setPrice(50000);
        food2.setUser(customer); // 외래 키(연관 관계) 설정

        customerRepository.save(customer);
        foodRepository.save(food);
        foodRepository.save(food2);
    }

}