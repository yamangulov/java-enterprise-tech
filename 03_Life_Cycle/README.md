**Задание 1**
Что нужно сделать

Настройте плагин проверки стиля кода в проекте Maven. Для этого создайте новый проект Maven (название проекта не важно). Добавьте плагин checkstyle. Настройте запуск проверки до этапа компиляции проекта.

Параметры плагина:

groupId: org.apache.maven.plugins
artifactId: maven-checkstyle-plugin
version: 3.0.1-SNAPSHOT
Цель, которая запускает проверку: check.

Адрес репозитория SNAPSHOT.



Критерии оценки

Зачёт: при запуске теста проекта выполняется проверка плагином checkstyle версии 3.0.1-SNAPSHOT.

**Пояснение к решению: перед компиляцей выполняется фаза generate-sources (источник - https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html)**



**Задание 2**
Что нужно сделать

Добавьте в проект, созданный в предыдущем задании, файл docker-compose.yaml.

Настройте запуск сервиса базы данных MySQL, чтобы база была доступна по порту 9977 и подключалась под пользователем testuser и паролем testpassword.

Входные данные:

докер-образ: mysql;
версия: не важна;
порт, на котором запускается MySQL: 3306;
пароль и логин настраивается через переменные окружения: MYSQL_USER, MYSQL_PASSWORD.


Критерии оценки

Зачёт: база запускается с помощью docker-compose и доступна по порту 9977 с подключением по testuser/testpassword.

**Пояснение к решению: последний доступный образ настроен так, что нужно задать дополнительно пароль root каким-нибудь из доступных способов, иначе мы получим следующую ошибку:**

`mysql    |      You need to specify one of MYSQL_ROOT_PASSWORD, MYSQL_ALLOW_EMPTY_PASSWORD and MYSQL_RANDOM_ROOT_PASSWORD
mysql exited with code 1`


**Задание 3**
Что нужно сделать

Создайте коллекцию запросов поиска работы в Postman.

В коллекции должно быть три запроса, разделённых по языкам программирования Java, Python, Ruby. Поиск производите по адресу https://jobs.github.com/positions.json

Запросы должны делаться для двух городов:

moscow;
new+york.


Метод запроса GET.

Параметры запроса:

description: язык программирования;
location: город.


Важные условия:

Города переключаются через переменные в environment postman.
Базовая часть адреса должна быть в переменной коллекции.


Коллекцию экспортируйте и положите в репозиторий проекта из предыдущих задач.



Критерии оценки

Зачёт: запросы из коллекции выполняются, в них учтены важные условия.

**Пояснение к решению: в каталоге resources находится коллекция и два файла для environment Москвы и Нью-Йорка**