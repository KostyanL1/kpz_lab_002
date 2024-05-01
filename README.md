# Проект "Кабінет обліку зоопарку."




## Опис проекту
це веб-додаток для управління та відстеження даних про тварин, вольєри та робітників у зоопарку.

## Використані технології та мови програмування

1. **Мова програмування**: Java
2. **Фреймворк для веб-розробки**: Spring Boot
3. **Шаблонування**: Thymeleaf
4. **База даних**: PostgreSQL
5. **Інструмент для збірки та управління залежностями**: Maven
6. **Інші інструменти та бібліотеки**: Hibernate, Spring Data JPA

## Як запустити програму:

1. Створіть базу даних PostgreSQL за шаблоном, який я залишив у файлі `src/main/java/resources/all.sql`.

2. Створіть в папці `template` файл `application.properties` та заповніть його відповідно до вашої конфігурації:

    ```properties
    spring.application.name=Lab002
    spring.datasource.driverClassName=org.postgresql.Driver
    spring.datasource.url=YOUR_DATABASE_URL
    spring.datasource.username=YOUR_DATABASE_USERNAME
    spring.datasource.password=YOUR_DATABASE_PASSWORD
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    spring.jpa.properties.hibernate.show_sql=true
    spring.mvc.hiddenmethod.filter.enabled=true
    server.port=YOUR_SERVER_PORT
    ```

3. Запустіть програму у браузері за допомогою переходу за посиланням `localhost/`.

## Функціонал програми
![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/7496a210-d693-4845-aa35-c4ecfa37fbe8)

1. **Тварини**
   - Додавання нових тварин у систему.
    ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/bb559cf8-ab39-4d58-9808-64ff33005203)
   - Відображення списку всіх тварин у зоопарку.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/8d87e1c4-7df2-4050-a3a6-cbf79fabe650)
   - Перегляд детальної інформації про конкретну тварину.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/2d802faf-a2d5-4248-8a6d-a03d0e0ce1a1)
   - Редагування інформації про тварину.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/385ecce9-a2d5-4b50-946e-7c63f5935d69)

2. **Вольєри**
   - Додавання нових вольєрів у систему.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/af72be0c-a6e8-4323-889b-77b94cc46157)
   - Відображення списку всіх вольєрів у зоопарку.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/77735d89-29d6-418b-ba98-8ef8899a9c3e)
   - Перегляд детальної інформації про конкретний вольєр.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/9c106c2c-232f-4b7d-afd7-6ddfc8cda880)
   - Перегляд списку тварин, які проживають у вольєрі.
    ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/4a2a90b8-5770-4c0b-b9a5-0e75ef59a641)

3. **Корми**:
   - Додавання нового корму.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/0c1fb19b-8ea0-4e00-8393-868474b317d9)
   - Видалення корму.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/c53574e1-eaad-43b7-bb44-dfbe81752191)
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/34b1fa51-7f80-47f3-ba8c-cca0ab16bdfc)
   - Перегляд інформації про конкретний корм.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/34e4028a-8469-482f-93b9-5214aa11a5fc)
   - Перегляд списку всіх кормів.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/7df65923-8995-40e6-afac-9c1e45efb0e6)

     

4. **Робітники**
   - Додавання нових робітників у систему.
    ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/61d8b488-a3f8-4e4f-b5a8-a804b8891fb5)
   - Відображення списку всіх робітників у зоопарку.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/d5717b4f-91cd-4b72-abf7-ca3a659bb0d7)
   - Перегляд детальної інформації про конкретного робітника.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/39b88099-0979-4026-8e9c-1fee4cc95b52)
   - Редагування інформації про робітника.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/ef3b11b5-246d-4850-98fb-6a62968e1957)
   - Видалення робітника з системи.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/4db51503-33e8-40b5-96ac-6a65eef72509)
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/b65aed5f-61d9-4c43-8842-ca4902e04ee2)

## Застосовані принципи програмування

1. **DRY (Don't Repeat Yourself)**
   - Принцип DRY дотриманий у HTML шаблонах, таких як [animals.html](/src/main/resources/templates/animals.html) та [volier.html](/src/main/resources/templates/volier.html).

2. **Composition Over Inheritance**
   - Застосування композиції демонструється у класах [Volier.java](/src/main/java/com/example/zoo/model/Volier.java) та [Employee.java](/src/main/java/com/example/zoo/model/Employee.java).

3. **Program to Interfaces not Implementations**
   - Код програмується до інтерфейсів, як показано у використанні інтерфейсів у [Volier.java](/src/main/java/com/example/zoo/model/Volier.java) та [Employee.java](/src/main/java/com/example/zoo/model/Employee.java).

## Чому програма працює швидко
Програма працює швидко завдяки оптимізації роботи з базою даних та ефективному використанню пам'яті. Також використання адекватних алгоритмів пошуку та сортування дозволяє забезпечити швидку відповідь на запити користувачів.
