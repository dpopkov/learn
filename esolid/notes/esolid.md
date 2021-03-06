Инкапсуляция и SOLID
====================

* Инкапсуляция
* Single Responsibility Principle
* Open/Closed Principle
* Liskov Substitution Principle
* Interface Segregation Principle
* Dependency Inversion Principle


Инкапсуляция
------------

### Reusable Components (Многоразовые Компоненты)

Вы создаете приложения используя многоразовые компоненты? Это непростой вопрос. Можно спросить иначе. Используете ли вы веб-фрейморки или ORM библиотеки и т.п.? Используете ли вы что-то, что сделали не вы? Вероятно да. В этом суть многоразовых компонентов. Вы стоите не плечах гигантов.
Теперь задайте себе другой вопрос. Смотрите ли вы регулярно в исходный код этих компонентов? Тратите ли вы значительное время на просмотр этого исходного кода? Вероятно нет. Вы их используете потому что они сделаны таким образом, что ими можно пользоваться не зная их внутреннего устройства, как в действительности работает их код. Значит это возможно - создать такие компоненты, которые можно использовать не зная деталей их реализации.
В этом и состоит инкапсуляция.


### Большинство кода отстой

К сожалению оказывается, что большинство кода представляет из себя отстой. Многие программисты чувствуют, что их код отстой. Им не нравится над ним работать. Они чуствуют, что их код не так хорош, как должен быть. Это нормально и тут нечего стыдиться, с каждым такое бывает. Не всегда знаешь, как сделать лучше.

Инкапсуляция - это одна из техник, которая помогает нам создавать код, который немного менее отстойный.

Что вам нужно, так это писать код таким образом, чтобы его могли использовать программитсты самой низкой квалификации. Считайте, что программисты, которые будут им пользоваться не знают всего, что знаете вы.

Это почти такое же правило жизни как "Люби как в последний раз, танцуй будто никто тебя не видит и пиши код так, будто следующий, кто будет над ним работать психопат, который знает где ты живешь".

Вот пример отстойного кода:

```Java
class FileStore {
    public String getWorkingDirectory() { return ""; }
    public String save(int id, String message) { return ""; }
    public void read(int id) {}
}
```
Подумайте, глядя на публичный API этого класса, и попробуйте понять что он делает, что делают эти методы. Например почему метод save возвращает строку? Что строка содержит? Может это message или id, преобразованный в строку? Или что-то совсем другое? Например код в виде строки? Неизвестно.
Придется смотреть в документацию, или, если ее нет, то в исходный код:
```Java
class FileStore {
    public String save(int id, String message) throws IOException {
        Path path = Paths.get(getWorkingDirectory(), id + ".txt");
        Files.write(path, message.getBytes());
        return path.toString();
    }
}
```
Можно увидеть что метод пишет сообщение в файл и возвращает путь. Проблема в том, что не было способа это понять, пока мы не посмотрели код метода.

Как насчет метода read? Почему он возвращает void? Посмотрим:
```Java
class FileStore {
    public void read(int id) throws IOException {
        Path path = Paths.get(getWorkingDirectory(), id + ".txt");
        String message = new String(Files.readAllBytes(path));
        messageListener.newMessage(new MessageEvent(message));
    }
}    
```
Недостаток этого кода в том, что трудно понять, что он делает, пока не прочитаешь полностью исходный код методов.


### Почему стоит беспокоиться об отстойном коде?

Если сказать менеджеру, что код стоит переписать, так как с ним трудно работать, то он скажет, что на это нет времени и нужно работать над реализацией функций приложения.

Недостаточно просто иметь смутное чувство, что код отстой. Нужно понимать, что именно с ним не так и почему об этом стоит беспокоиться. Это касается долгосрочной продуктивности. Речь идет не о годах, а о неделях. Код может ухудшаться очень быстро, если не быть к этому внимательным. И когда это происходит, то долгосрочная продуктивность страдает, потому что становится все более труднее добавлять новую функциональность. Также страдает поддерживаемость. Может быть у вас получилось выпустить версию 1, но если вы создали такой большой технический долг, что вы не можете добавлять новую функциональность после версии 1, тогда у вас проблема. Тогда вы не можете эффективно поддерживать код. Вам все труднее и труднее устранять баги и добавлять новую функциональность.

Чуство, что наш код не достаточно хорош, оно реально. Это чувство возникает потому, что вы не настолько продуктивны, как нам хотелось бы.

Одна из причин этого в том, что __мы тратим больше времени на чтение кода, чем на написание кода.__ Мы можем тратить на чтение в 10-20 раз больше времени, чем на его написание. Поэтому желательно сделать затраты на чтение меньше.

И это возвращает нас к написанию кода для "тупых" программистов. Или не "тупых", а просто несведующих. Это трудно из-за проклятия знания. Проблема в том, что когда вы пишете код, реализующую какую-то функциональность, вы знаете много о том, что эта функциональность должна делать, и вы знаете много о том что вы знали, и том что вы думали, что знали точно в тот момент, когда вы писали этот код. И очень трудно представить себе каково это не знать того, что вы знаете в этот момент.

Но если мой код должен делать моих коллег более продуктивными или должен делать меня в будующем через 6 месяцев более продуктивным, когда я уже не буду помнить обо всем, что помню сейчас, то я обязан сделать код более читаемым и понятным. Я обязан сделать мои API более понятными и сократить количество чтения которое необходимо чтобы использовать этот код, который я пишу сейчас.

Нужно что-то более конкретное, какие-то правила, которые помогут оценить код, который вы пишете в настоящий момент, сможет ли человек, не знающий то, что знаете вы сейчас, быть способным использовать этот код не прибегая к времязатратным исследованиям.

И снова, это то, ради чего используется инкапсуляция.


### Классическое ОО определение Инкапсуляции

Первое - это сокрытие информации. Сокрытие информации это одна из чаще всего неправильно понимаемых черт инкапсуляции или даже ОО дизайна. Это стало синонимом для многих людей идеи что вы не можете делать поля класса открытыми (public). Но что если вместо "сокрытия информации" мы назовем это "сокрытием реализации"? Это будет более правильно. Скрывается не информация, а способ хранения информации, то есть это деталь реализации, которая не всегда должна быть открыта внешнему потребителю.

Второе - это защита инвариантов. Большинство людей не понимают на самом деле, что такое инвариант. На самом деле мы пытаемся обеспечить невозможность невалидного состояния или хотя бы сделать возможность достижения невалидного состояния объекта как можно более трудной.


### Альтернативные техники Инкапсуляции

Определение Инкапсуляции недостаточно четко определены для практического применения. Они нуждаются в более конкретных принципах. 

Первый из них:
#### Разделение Команды и Запроса (Command Query Separation - CQS)
Второй:
#### Закон Постела (Postel's law)

#### Разделение Команды и Запроса (Command Query Separation)

Операция должна быть или командой или запросом, но не тем и другим одновременно.

Команда - это операция, которая имеет наблюдаемый сторонних эффект (side effect).

Запрос - это операция, которая возвращает данные. Запросы естесственно являются идемпотентными (idempotent) операциями. Идемпотентные операции это такие операции многократное исполнение которых не приводят к изменению состояния по сравнению с однократным исполнением. Последовательные запросы должны возвращать одни и те же данные.


### Запросы

Метод приведенный ниже очевидно является запросом:
```Java
class FileStore {
    public void read(int id) throws IOException {
        Path path = Paths.get(getWorkingDirectory(), id + ".txt");
        String message = new String(Files.readAllBytes(path));
        messageListener.newMessage(new MessageEvent(message));
    }
}
```
Однако он возвращает void. То есть, если смотреть на его сигнатуру, то он выглядит как Команда, а не как Запрос. Одна из причин, почему вышеприведенный код является отстойным, это то, что по сигнатурам не ясно, какой метод является Командой, а какой Запросом.

Мы можем просто вернуть message:
```Java
class FileStore {
    public String read(int id) throws IOException {
        Path path = Paths.get(getWorkingDirectory(), id + ".txt");
        String message = new String(Files.readAllBytes(path));
        messageListener.newMessage(new MessageEvent(message));
        return message;
    }
}
```
Остается передача события, которая является сторонним эффектом. Если вы хотите отправить событие, то вам нужен метод возвращающий void, то есть Команда. Если мы хотим соблюсти CQS принцип, то уберем отправку события:
```Java
class FileStore {
    public String read(int id) throws IOException {
        Path path = Paths.get(getWorkingDirectory(), id + ".txt");
        String message = new String(Files.readAllBytes(path));
        return message;
    }
}
```
Теперь сигнатура дает примерное представление о том, что делает этот метод, а именно читает и возвращает строку ассоциированную с id. Даже без деталей реализации этого уже достаточно для понимания общей картины.


### Команды

Посмотрим на знакомый метод, который по сути является Командой:
```Java
class FileStore {
    public String save(int id, String message) throws IOException {
        Path path = Paths.get(getWorkingDirectory(), id + ".txt");
        Files.write(path, message.getBytes());
        return path.toString();
    }
}
```
Но он возвращает строку. А мы только что усвоили, что Команда должна возвращать void. Данный же метод является одновременно и Командой и Запросом, то есть он нарушает CQS принцип. Превратим его в Запрос:
```Java
class FileStore {
    public void save(int id, String message) throws IOException {
        Path path = Paths.get(getWorkingDirectory(), id + ".txt");
        Files.write(path, message.getBytes());
    }
}
```
Мы можете поспорить, что был выброшен важный кусок информации - path, который может быть нужен вызывающему. Поэтому добавим новый метод:
```Java
class FileStore {
    public String getFileName(int id) {
        return Paths.get(getWorkingDirectory(), id + ".txt").toString();
    }
}
```
Это нормальный Запрос, без сторонних эффектов, то есть его можно вызывать много раз, не боясь нарушить состояние системы.

Можно заметить, что появилась возможность для рефакторинга - замены повторяющихся строк на вызов метода:
```Java
class FileStore {
    public void save(int id, String message) throws IOException {
        Path path = getFileName(id);
        Files.write(path, message.getBytes());
    }
    public String read(int id) throws IOException {
        Path path = getFileName(id);
        String message = new String(Files.readAllBytes(path));
        return message;
    }
}
```
Это иллюстрирует, что делать Запрос внутри Команды безопасно, так как Запрос не изменяет состояние системы.

Мы таким образом заменили метод, который одновременно был и Командой и Запросом, на метод-Команду и метод-Запрос.


### Закон Постела

Как вы можете быть уверены в том, что Команда принимает ваш ввод?  
Как вы можете быть уверены в том, что Запрос возвращает полезный результат?

Для большей конкретики посмотрим на закон Постела, который также известен как принцип Прочности (Robustenss principle). Он был сформулирован во времена создания сетевых протоколов.

__Вы должны быть очень консервативны в том, что вы посылаете, но вы должны быть очень либеральны в том, что вы принимаете.__
 

### Ввод

Что может пойти не так в данном коде, учитывая возможные варианты ввода?
```Java
class FileStore {
    private String workingDirectory;
    public String getWorkingDirectory() {
        return workingDirectory;
    }
    public void save(int id, String message) throws IOException {
        Path path = getFileName(id);
        Files.write(path, message.getBytes());
    }
    public String read(int id) throws IOException {
        Path path = getFileName(id);
        String message = new String(Files.readAllBytes(path));
        return message;
    }
    public String getFileName(int id) {
        return Paths.get(getWorkingDirectory(), id + ".txt").toString();
    }
}
```
Если workingDirectory не проинициализирована, то ее место в пути к файлу займет "null", что не является директорией. Это иллюстрация того, как легко написать код, который не защищает свои инварианты. Очень легко написать код, который будет в невалидном состоянии. Легко создать экземпляр объекта, который не является полностью проинициализированным, с большой вероятностью возникновения ошибки. Необходимо сделать ошибки использования более труднодостижимыми. Должно быть предусловием, что workingDirectory не является null, потому что если она null, то ничего не будет работать.
 
Добавим конструктор:
```Java
class FileStore {
    public FileStore(String workingDirectory) {
        this.workingDirectory = workingDirectory;
    }
}
```
Но это только полдела, так как переданный аргумент тоже может быть null. Добавим защитную проверку:

```Java
class FileStore {
    public FileStore(String workingDirectory) {
        this.workingDirectory = Objects.requireNonNull(workingDirectory);
    }
}
```
Теперь конструктор fails fast если аргумент null.


### Fail Fast

Посмотрим еще раз на конструктор FileStore. Что если workingDirectory указывает на невалидный путь? Это невозможно проверить во время компиляции, то можно в рантайме:
```Java
class FileStore {
    public FileStore(String workingDirectory) {
        this.workingDirectory = Objects.requireNonNull(workingDirectory);
        if (!new File(workingDirectory).exists()) {
            throw new IllegalArgumentException("Working directory does not exist");
        }
    }
}
```

### Output

