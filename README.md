# vpn-handler-backend

•    Backend
Компонент должен быть написан на Java или GO, 
(Для Java обязательно использовать Spring Boot)

И иметь следующее REST API:
o    POST /note/{id} - создать/обновить заметку
o    GET /note/id - получить заметку по id
o    GET /note  - получить все заметки
o    DELETE /note/{id} - удалить заметку

Компонент должен сохранять данные в DB с использование spring-repository для выбранного типа DB
