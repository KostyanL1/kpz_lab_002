package com.legenkiy.Lab002.model;


import com.legenkiy.Lab002.model.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "role")
    @Enumerated (value = EnumType.STRING)
    private Role role;
    @Column(name = "name")
    @Size(min = 2, max = 25, message = "Довжина імені має бути від 2 до 25 символів!")
    @NotBlank(message = "Ім'я має бути присутнє")
    private String name;
    @Column(name = "surname")
    @Size(min = 2, max = 50, message = "Довжина прізвища має бути віж 2 до 50 символів!")
    @NotBlank(message = "Прізвище має бути присутнє")
    private String surname;
    @Column(name = "year_of_birthday")
    @Min(value = 1940)
    @Max(value = 2008)
    private int yearOfBirthday;
    @Column(name = "salary")
    @Min(value = 6700)
    @Max(value = 15000)
    private int salary;



    public String roleFormat() {
        String vRole = this.role.toString();
        switch (vRole) {
            case "OHORONETS" -> {
                return "Охоронець";
            }
            case "NAGLYADACH" -> {
                return "Наглядач";
            }
            case "KASIR" -> {
                return "Касир";
            }
            case "PRIBIRALNIK" -> {
                return "Прибиральник";
            }
            default -> {
                return vRole;
            }
        }
    }
}
