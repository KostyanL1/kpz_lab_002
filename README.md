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
![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/8d3628ff-4592-4a3c-9235-2a562eba44c9)


1. **Тварини**
   - Додавання нових тварин у систему.
    ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/cfc721a0-ea77-493e-b61c-d02fe1926fa0)

   - Відображення списку всіх тварин у зоопарку.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/a4c11af4-84f9-46d2-bfb3-336239951403)

   - Перегляд детальної інформації про конкретну тварину.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/d8873501-b911-4e2c-82fd-760ab886e826)

   - Редагування інформації про тварину.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/43e457bd-8db7-429e-a5a0-012f41ffba0c)


2. **Вольєри**
   - Додавання нових вольєрів у систему.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/a6aac02f-cffd-44c7-92d9-cdc1b9b15907)

   - Відображення списку всіх вольєрів у зоопарку.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/934b71dd-b613-401b-a06c-007acea54612)

   - Перегляд детальної інформації про конкретний вольєр.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/0e949ae2-5ccc-499e-b523-bc15c04e6199)

   - Перегляд списку тварин, які проживають у вольєрі.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/52387feb-0df4-49e4-aa60-d9e096ad2b02)


3. **Корми**:
   - Додавання нового корму.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/e5c3f065-a6e0-4708-bc0e-954e5f07afcd)

   - Видалення корму.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/6ed63f3d-7e33-4e81-bf07-61dbdf2f5a66)
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/bc7c826c-b2b4-4d65-8492-0ad80865b55e)
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/023fd5f7-5c05-45a2-9b21-68e430cc0ede)

   - Перегляд інформації про конкретний корм.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/4248c8b9-c457-42fa-a771-6423d0c52ebc)

   - Перегляд списку всіх кормів.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/41908374-813c-428f-94e2-6a61e48b8334)


4. **Робітники**
   - Додавання нових робітників у систему.
    ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/572ea32f-89ca-465f-9f95-1d656595d669)

   - Відображення списку всіх робітників у зоопарку.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/e03e2f8f-821d-44d0-ad39-11999c4720d2)

   - Перегляд детальної інформації про конкретного робітника.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/b4d510a3-0252-44da-ac97-b2efa36908ea)

   - Редагування інформації про робітника.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/5dec8c71-2440-4783-8d96-a7f53dfe711c)

   - Видалення робітника з системи.
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/ea7f5085-12ab-41c6-b177-2c5b1c90f587)
     ![image](https://github.com/KostyanL1/kpz_lab_002/assets/148667427/5261a740-17cd-465d-865e-02d4fbdfcae5)

## Застосовані принципи програмування

1. **DRY (Don't Repeat Yourself)**
   - Принцип DRY дотриманий у HTML шаблонах, таких як [animals.html](/src/main/resources/templates/animals.html) та [volier.html](/src/main/resources/templates/volier.html).

2. **Composition Over Inheritance**
   - Застосування композиції демонструється у класах [Volier.java](/src/main/java/com/example/zoo/model/Volier.java) та [Employee.java](/src/main/java/com/example/zoo/model/Employee.java).

3. **Program to Interfaces not Implementations**
   - Код програмується до інтерфейсів, як показано у використанні інтерфейсів у [Volier.java](/src/main/java/com/example/zoo/model/Volier.java) та [Employee.java](/src/main/java/com/example/zoo/model/Employee.java).

## Чому програма працює швидко
Програма працює швидко завдяки оптимізації роботи з базою даних та ефективному використанню пам'яті. Також використання адекватних алгоритмів пошуку та сортування дозволяє забезпечити швидку відповідь на запити користувачів.
