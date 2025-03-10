package com.example.accdat_2ev.repository;

import com.example.accdat_2ev.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ItemRepository extends MongoRepository<Item, String> {
    List<Item> findByCategory(String category);
}
