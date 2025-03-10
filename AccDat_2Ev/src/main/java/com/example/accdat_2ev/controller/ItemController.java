package com.example.accdat_2ev.controller;

import com.example.accdat_2ev.model.Item;
import com.example.accdat_2ev.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public String listItems(Model model) {
        List<Item> items = itemService.getAllItems();
        model.addAttribute("items", items);
        return "items"; // Renderiza la vista "items.html"
    }

    @GetMapping("/{id}")
    public String getItemDetails(@PathVariable String id, Model model) {
        Item item = itemService.getItemById(id).orElse(null);
        model.addAttribute("item", item);
        return "item-detail"; // Renderiza la vista "item-detail.html"
    }
}
