package com.example.hanghaetest1.repository;

import com.example.hanghaetest1.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}