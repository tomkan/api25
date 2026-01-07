package pl.tomkan.api25.item;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    public List<ItemResponse> listAll() {
        return itemRepository.findAll().stream().map(
                item -> new ItemResponse(item.getId(), item.getName(), true)
        ).toList();
    }

    public ItemResponse findById(Long id) {
        return itemRepository.findById(id)
                .map(item -> new ItemResponse(item.getId(), item.getName(), true))
                .orElseThrow(() -> new EntityNotFoundException("Item not found with id: " + id));
    }

    public ItemResponse create(ItemRequest itemResponse) {
        Item item = new Item();
        item.setName(itemResponse.name());
        Item savedItem = itemRepository.save(item);
        return new ItemResponse(savedItem.getId(), savedItem.getName(), true);
    }

    public ItemResponse update(Long id, ItemRequest itemResponse) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Item not found with id: " + id));
        item.setName(itemResponse.name());
        Item updatedItem = itemRepository.save(item);
        return new ItemResponse(updatedItem.getId(), updatedItem.getName(), true);
    }

    public void delete(Long id) {
        if (!itemRepository.existsById(id)) {
            throw new EntityNotFoundException("Item not found with id: " + id);
        }
        itemRepository.deleteById(id);
    }
}
