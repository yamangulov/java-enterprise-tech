**Задание 1**


Что нужно сделать
Реализуйте класс Service для сбора статистики из разных потоков. Класс должен содержать два приватных поля:

Поле типа Integer для подсчёта общего количества обращений с именем count.
Поле типа LinkedList<String> для логирования имени потока с именем log.
В классе необходимо реализовать два публичных метода.

Первый метод должен возвращать void. Имя метода — log().

Алгоритм при вызове должен быть следующий:

Инкрементировать поле count на единицу.
Получить имя текущего потока и записать его в конец поля log.


Важное примечание: метод должен быть потокобезопасным, так как его будут вызывать одновременно разные потоки.

Второй метод должен возвращать void. Имя метода — debug().

Алгоритм работы метода должен быть следующим:

Напечатать в консоли значение из поля count.
Напечатать в консоль список из поля log. Каждое значение списка печатать на новой строке.


Критерии оценки
Зачёт: если выполнить код следующего вида (например, в public static void main)

var counter = new HomeWork1();
counter.log();
counter.debug();
то в консоль должны распечататься следующие строки:

1
main




**Задание 2**


Что нужно сделать
Реализуйте статический метод для запуска нескольких потоков и вызова методов класса Service из задания 1. В методе нужно проделать следующие обязательные шаги:

Создать экземпляр класса из задания 1.
Создать три потока t1, t2, t3.
В каждом потоке вызвать 10 раз метод log() экземпляра класса Service.
Для каждого потока задать имена T1, T2, T3 соответственно.
Запустить все потоки и дождаться результата.
Вызвать метод debug() в конце.


Критерии оценки
Зачёт: приложение успешно запустилось, и в консоли первая строка — 30. Количество строк в консоли, начиная со второй, равняется 30.





**Задание 3**


Что нужно сделать
Модифицируйте класс Service из задания 1 и 2, так чтобы строки в поле log были добавлены по очереди. То есть сначала все строки потока 1, затем 2 и 3. Неважно, в какой последовательности потоки будут идти, главное, чтобы все 10 строк одного потока шли друг за другом и в них не попадались строки других потоков.

Реализовать это можно, используя замок типа ReentrantLock и добавив методы unlock и lock.



Критерии оценки
Зачёт: приложение успешно запустилось, и в консоли первая строка 30. Далее вывелись строки, например, в таком порядке:

T1

T1

T1

T1

T1

T1

T1

T1

T1

T1

T3

T3

T3

T3

T3

T3

T3

T3

T3

T3

T2

T2

T2

T2

T2

T2

T2

T2

T2

T2

