package pl.tomkan.api25.item;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/items")
@Tag(name = "Items", description = "Item management API")
@CrossOrigin
public class ItemControlller {

    private final ItemService itemService;

    @Operation(summary = "Get all items", description = "Returns a list of all items")
    @GetMapping
    public List<ItemResponse> getItems() {
        return itemService.listAll();
    }

    @Operation(summary = "Get item by ID", description = "Returns a single item by its ID")
    @GetMapping("/{id}")
    public ItemResponse getItem(@PathVariable Long id) {
        return itemService.findById(id);
    }

    @Operation(summary = "Create a new item", description = "Creates a new item and returns it")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemResponse createItem(@RequestBody ItemRequest itemRequest) {
        return itemService.create(itemRequest);
    }

    @Operation(summary = "Update an existing item", description = "Updates an item by its ID")
    @PutMapping("/{id}")
    public ItemResponse updateItem(@PathVariable Long id, @RequestBody ItemRequest itemRequest) {
        return itemService.update(id, itemRequest);
    }

    @Operation(summary = "Delete an item", description = "Deletes an item by its ID")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable Long id) {
        itemService.delete(id);
    }
}
