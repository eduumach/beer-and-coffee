package com.thaynarasilvapinto.beerandcoffee.respository;

import com.thaynarasilvapinto.beerandcoffee.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {
}
