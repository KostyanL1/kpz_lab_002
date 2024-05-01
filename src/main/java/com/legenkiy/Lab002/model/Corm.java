package com.legenkiy.Lab002.model;

import com.legenkiy.Lab002.model.enums.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "corm")
public class Corm {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @NotBlank(message = "Ім'я має бути пристунє.")
    @Size(min = 2, max = 50, message = "Довжина має бути від 2 до 50 символів")
    private String name;
    @Column(name = "category")
    @Enumerated(value = EnumType.STRING)
    private Category category;
    @OneToMany(mappedBy = "corm", fetch = FetchType.EAGER)
    private List<Animal> animalsList;




    public String cormCategoryFormat() {
        String categoryString = this.category.toString();
        switch (categoryString) {
            case "RYBA" -> {
                return "Риба";
            }
            case "SAVETS" -> {
                return "Савець";
            }
            case "GRIZUN" -> {
                return "Гризун";
            }
            case "PTAH" -> {
                return "Птах";
            }
            default -> {
                return categoryString;
            }
        }
    }
}
