package com.thaynarasilvapinto.beerandcoffee.repository;

import com.thaynarasilvapinto.beerandcoffee.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
