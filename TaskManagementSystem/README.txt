1. Регистрация:
POST: localhost:8080/register/user

{
    "email": "test@gmail.com",
    "password": "1234"
}


2. Логин:
POST: localhost:8080/login

{
    "email": "test@gmail.com",
    "password": "1234"
}

3. Получение токена и выполнение запросов:
GET:  localhost:8080/user/api/notes
           localhost:8080/user/api/notes/63
           localhost:8080/user/api/tasks
           localhost:8080/user/api/notes/2
           localhost:8080/user/api/users
           localhost:8080/user/api/users/64