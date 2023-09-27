# **План тестирования мобильного приложения fmh-android**
**Описание приложения**
Android-приложение "Мобильный хоспис".
Приложение даёт функционал по работе с претензиями хосписа и включает в себя:
- авторизацию;
- информацию о претензиях и функционал для работы с ними;
- новостную сводку хосписа;
- тематические цитаты;
- информацию о приложении;
- выхода из приложения


## **Перечень автоматизируемых сценариев**

**Позитивные сценарии**

1. Работа ссылки "Политика конфиденциальности".
2. Работа ссылки "Пользовательское соглашение".
3. Авторизация в мобильном приложении "Мобильный хоспис".
4. Фильтрация заявок по критерию "Открыта".
5. Фильтрация заявок по критерию "В работе".
6. Фильтрация заявок по критерию "Выполнена".
7. Фильтрация заявок по критерию "Отмененные".
8. Создание заявки.
9. Ввод в Поле "Дата" даты из будущего года при создании заявки.
10. Редактирование заявки, находящейся в статусе "Открыта".
11. Добавление комментария к заявке.
12. Редактирование комментария к заявке.
13. Смена статуса заявки, находящейся в статусе "Открыта" на статус "В работе".
14. Смена статуса заявки с истекшим сроком  исполнения, находящейся в статусе "Открыта" на статус "В работе".
15. Переход во вкладку "News" через главное меню.
16. Переход во вкладку "Claims" через главное меню.
17. Сортировка новостей.
18. Просмотр новостей.
19. Удаление активной новости.
20. Редактирование новости.
21. Смена статуса новости, находящейся в статусе "Активна", на статус "Не активна".
22. Фильтрация новостей по критерию "Активна".
23. Фильтрация новостей по критерию "Не активна".
24. Создание новости.
25. Ввод в поле "Дата публикации" даты из будущего года при создании новости.
26. Просмотр новостей во вкладке "Новости".
27. Сортировка новостей во вкладке "Новости".
28. Фильтрация новостей без указания категории.
29. Фильтрация новостей, без указания категории, в определенный период времени.
30. Развернуть/свернуть вкладку с тематическими цитатами.

**Негативные сценарии**

1. Авторизация с пустым полем "Login".
2. Авторизация с полем "Login", заполненным данными незарегистрированного пользователя.
3. Авторизация при заполнении поля "Login" символами.
4. Поле "Логин" состоит из одного символа.
5. Поле "Логин" состоит из букв разного регистра.
6. Авторизация с пустым полем "Password".
7. Поле "Password" заполнено данными незарегистрированного пользователя.
8. Ввод символов в поле "Password".
9. Поле "Password" состоит из одного символа.
10. Поле "Password" состоит из букв разного регистра.
11. При создании заявки поле "Тема" остается пустым.
12. При создании заявки поле "Тема" состоит из одного символа.
13. При создании заявки поле "Тема" состоит из максимально-допустимого количества символов.
14. При создании завки поле "Исполнитель" остается пустым.
15. Ввод в поле "Исполнитель" русских букв и цифр при создании заявки.
16. Ввод в поле "Исполнитель" других данных при создании заявки.
17. Ввод в поле "Исполнитель" символов при создании заявки.
18. При создании заявки поле "Описание" остается пустым.
19. При создании новости поле "Категория" остается пустым.
20. При создании новости поле "Заголовок" остается пустым.
21. При создании новости поле "Дата публикации" остается пустым.
22. При создании новости поле "Время" остается пустым.
23. При создании новости поле "Описание" остается пустым.
24. Ввод в поле "Категория" собственного названия категории при создании новости.
25. Ввод в поле "Категория" цифр при создании новости.
26. Ввод в поле "Категория" символов при создании новости.


## **Перечень используемых инструментов с обоснованием выбора**

**Эмуляторы для проведения тестирования** (Pixel 7 (API 29, 30, 31, 32))

**Android studio** (для проверки функционирования приложения, написания тестов и проверки работы тестов)

**Gradle** (наиболее современный фреймворк, более простая интеграция с другими инструментами)

**Espresso** (фреймворк для проведения тестирования)

**Allure** для составления отчетов (более наглядно и систематизировано представлены результаты тестирования)

**Github** (для хранения актуальных версий файлов, отслеживания их изменения, возможности копирования проекта)

**CI: Java for Gradle** простая интеграция с git-hub

## **Перечень и описание возможных рисков при автоматизации**

- Риск того, что автоматизация такого небольшого проекта не окупится. Гораздо проще провести мануальное тестирование.
- Сложно поддерживать автотесты: возможно изменение названия полей, изменение текста предупреждений об ошибке

## **Перечень необходимых разрешений/данных/доступов**

1. Тестовый режим сервиса (желательно)

## **Перечень необходимых специалистов для автоматизации**

Инженер по автоматизации тестирования - 1

## **Интервальная оценка с учётом рисков (в часах)**

Подготовка проекта (настойка окружения) - 3 часа

Подготовка мануальных тестов (10 часов)

Автоматизация мануальных тестов (16 часов)

Проведение тестирования (2 часа)

Формирование отчета о тестировании (2 часа)

## **План сдачи работ (когда будут автотесты, результаты их прогона и отчёт по автоматизации)**

Подготовка проекта и настройка окружения (14.08.2023- 18.08.2023)

Составление плана тестирования (19.08.2023-20.08.23)

Подготовка мануальных тестов (21.08.2023-22.08.2023)

Автоматизация мануальных тестов (23.08.2023-23.09.2023)

Проведение тестирования (23.09.2023-25.09.2023)

Формирование отчета о тестировании (26.09.2023)