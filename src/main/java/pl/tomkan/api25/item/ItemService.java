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

    public List<ItemDTO> listAll() {
        return itemRepository.findAll().stream().map(
                item -> new ItemDTO(item.getId(), item.getName())
        ).toList();
    }

    public ItemDTO findById(Long id) {
        return itemRepository.findById(id)
                .map(item -> new ItemDTO(item.getId(), item.getName()))
                .orElseThrow(() -> new EntityNotFoundException("Item not found with id: " + id));
    }

    public ItemDTO create(ItemDTO itemDTO) {
        Item item = new Item();
        item.setId(itemDTO.id());
        item.setName(itemDTO.name());
        Item savedItem = itemRepository.save(item);
        return new ItemDTO(savedItem.getId(), savedItem.getName());
    }

    public ItemDTO update(Long id, ItemDTO itemDTO) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Item not found with id: " + id));
        item.setName(itemDTO.name());
        Item updatedItem = itemRepository.save(item);
        return new ItemDTO(updatedItem.getId(), updatedItem.getName());
    }

    public void delete(Long id) {
        if (!itemRepository.existsById(id)) {
            throw new EntityNotFoundException("Item not found with id: " + id);
        }
        itemRepository.deleteById(id);
    }
}
