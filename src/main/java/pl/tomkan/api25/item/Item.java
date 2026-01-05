package pl.tomkan.api25.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item {

    @Id
    private Long id;

    @Column
    private String name;
}
