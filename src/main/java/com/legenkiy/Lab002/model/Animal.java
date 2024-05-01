package com.legenkiy.Lab002.model;

import com.legenkiy.Lab002.model.enums.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "type")
    @Size(min = 2, max = 50, message = "Довжина має бути від 2 до 50 символів")
    @NotBlank(message = "Тип має бути присутнім")
    private String type;
    @Column(name = "category")
    @NotNull(message = "Категорія має бути присутня")
    @Enumerated(value = EnumType.STRING)
    private Category category;
    @Column(name = "name")
    @Size(min = 2, max = 50, message = "Довжина має бути від 2 до 50 символів")
    @NotBlank(message = "Ім'я має бути присутнє")
    private String name;
    @Column(name = "weight")
    @Min(value = 0, message = "Вага не може бути менша ніж 0")
    private int weight;
    @ManyToOne
    @JoinColumn(name = "corm_id", referencedColumnName = "id")
    private Corm corm;
    @ManyToOne
    @JoinColumn(name = "volier_id", referencedColumnName = "id")
    private Volier volier;




    public String categoryFormat() {
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
