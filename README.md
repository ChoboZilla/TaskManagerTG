# Task Management

Практически полностью реализован функционал сервера (все нужные операции). Использованы r2dbc, webflux, MySQL.
Для тестирования использовался 
**Postman**

## Telegram bot
Ссылка на телеграмм бота - [Task Manager Bot](http://t.me/HSAI23_TaskManager_bot)

## User:
1. Возможность get по id (GET /getUser/{id} )
2. Возможность Sign Up (POST /addUser и тело)
3. Возможность Sign In (POST /signIn и тело)

## Task:
1. Для определения рекурентности задачи в БД поле type (0 - одноразовая, 1 - почасовая, 2 - ежедневная, 3 - еженедельная, 4 - ежемесячная)
2. Возможность get (GET /getTaskI/{id} )
3. Возможность add (POST /addTask + тело)
4. Возможность delete по id (DELETE /deleteTask/{id} )
5. Возможность update по id (POST /updateTask/{id} + тело)
6. Возможность выводить все задачи опр.типа рекурентности (GET /getTasksT/{type})
7. Возможность выводить все задачи по дедлайну (GET /getTasksD/{deadline})
8. Возможность выводить все задачи на следующие 24 часа/168 часов (GET /getDay, GET /getWeek)

## Идеи на будущее:
1. В клиенте реализовать шедулер (каждую минуту), чтобы проверять задачи на конец дедлайна.
2. Когда у задачи подходит дедлайн: одноразовая (с type=0) удаляется, у рекурентных происходит инкримент поля deadline на соотв.величину


