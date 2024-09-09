package com.example.hanghaetest1.service;

import com.example.hanghaetest1.dto.ItemRequestDto;
import com.example.hanghaetest1.dto.ItemResponseDto;
import com.example.hanghaetest1.entity.Item;
import com.example.hanghaetest1.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemResponseDto createItem(ItemRequestDto requestDto) {
        Item item = new Item(requestDto.getUsername(), requestDto.getTitle(), requestDto.getContent(), requestDto.getPrice());

        Item savedItem = itemRepository.save(item);
        return new ItemResponseDto(savedItem.getId(), savedItem.getUsername(), savedItem.getTitle(), savedItem.getContent(), savedItem.getPrice());
    }

    public List<ItemResponseDto> getItems() {
        return itemRepository.findAll().stream()
                .map(item -> new ItemResponseDto(item.getId(), item.getUsername(), item.getTitle(), item.getContent(), item.getPrice()))
                .collect(Collectors.toList());
    }

    public ItemResponseDto updateItem(Long id, ItemRequestDto requestDto) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        item.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getPrice());

        Item updatedItem = itemRepository.save(item);
        return new ItemResponseDto(updatedItem.getId(), updatedItem.getUsername(), updatedItem.getTitle(), updatedItem.getContent(), updatedItem.getPrice());
    }

    public void deleteItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        itemRepository.delete(item);
    }
}
