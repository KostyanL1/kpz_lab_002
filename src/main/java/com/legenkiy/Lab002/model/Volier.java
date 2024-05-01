package com.legenkiy.Lab002.model;

import com.legenkiy.Lab002.model.enums.VolierType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "volier")
public class Volier {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "volier_type")
    private VolierType volierType;
    @Column(name = "max_count_animals")
    @Max(value = 10 , message = "Максимальна кількість тварин може бути 10")
    @Min(value = 0, message = "Мінімальна кількість тварин не може бути менша 0")
    private int maxCountAnimals;
    @Column(name = "count_animals")
    @Max(value = 10 , message = "Максимальна кількість тварин може бути 10")
    @Min(value = 0, message = "Мінімальна кількість тварин не може бути менша 0")
    private int countAnimals;
    @OneToMany(mappedBy = "volier", fetch = FetchType.EAGER)
    private List<Animal> animalList;




    public String volierTypeFormat() {
        String vType = this.volierType.toString();
        switch (vType) {
            case "VIDKRITUY" -> {
                return "Відкритий";
            }
            case "ZAKRITUY" -> {
                return "Закритий";
            }
            case "VODNUY" -> {
                return "Акваріум";
            }
            default -> {
                return vType;
            }
        }
    }
}
