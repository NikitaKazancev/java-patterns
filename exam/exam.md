### 1. Понятие шаблона проектирования, составляющие шаблона. Приведите примеры употребления шаблонов в неверных контекстах

Концепция шаблона проектирования относится к повторно используемому решению общей проблемы в разработке программного обеспечения. Он предоставляет шаблон или схему решения конкретной проблемы, позволяя разработчикам использовать проверенные подходы и лучшие практики.

Компоненты шаблона проектирования обычно включают:

1. Название шаблона: описательный заголовок, отражающий суть шаблона.
2. Проблема. Конкретная проблема или проблема, которую решает шаблон.
3. Решение. Рекомендуемое решение проблемы, часто отображаемое в виде схемы или фрагмента кода.
4. Последствия: компромиссы и последствия реализации шаблона.
5. Контекст: условия, при которых шаблон наиболее эффективен и подходит.

Вот несколько примеров использования шаблонов проектирования в неправильном контексте:

1. Шаблон Singleton для управления несколькими экземплярами:
   Шаблон Singleton используется для обеспечения существования только одного экземпляра класса. Однако если вам нужно управлять несколькими экземплярами класса, попытка принудительно использовать шаблон Singleton в этом контексте приведет к неправильному поведению и сведет на нет цель шаблона.

2. Шаблон наблюдателя для простой обработки событий:
   Паттерн Наблюдатель используется для установления отношения «один ко многим» между объектами, когда изменения в одном объекте вызывают обновления в нескольких зависимых объектах. Если у вас есть простой сценарий обработки событий с несколькими прослушивателями или наблюдателями, использование шаблона Observer может привести к ненужной сложности и накладным расходам.

3. Шаблон декоратора для крупномасштабной композиции объектов:
   Шаблон Decorator используется для динамического добавления функциональности к объекту путем включения в него одного или нескольких декораторов. Однако, если у вас есть крупномасштабный сценарий композиции объектов с многочисленными декораторами и сложными взаимодействиями, сильное использование шаблона декоратора может привести к запутанной и сложной в обслуживании кодовой базе.

4. Шаблон фабричного метода для одного продукта:
   Шаблон Factory Method используется для создания объектов без указания их точного класса. Однако если у вас есть ситуация, когда вам нужно создать объект только одного типа, использование шаблона фабричного метода может привести к ненужной сложности и затруднить понимание кода.

5. Шаблон моста для простой абстракции и реализации:
   Шаблон Bridge используется для отделения абстракции от ее реализации, что позволяет им изменяться независимо друг от друга. Если у вас есть простой сценарий с одной абстракцией и реализацией, введение шаблона Bridge может добавить ненужные уровни абстракции и усложнить кодовую базу, не предоставив значительных преимуществ.

---

### 2. Классификация паттернов проектирования, приведите несколько примеров паттернов каждого класса

Порождающие:
Фабричный метод, Синглтон, Строитель.

Структурные:
Адаптер, Декоратор, Прокси.

Поведенческие:
Наблюдатель, Стратегия, Шаблонный метод.

Архитектурные шаблоны:

-  (MVC): разделяет логику представления, данных и взаимодействия с пользователем приложения на три отдельных компонента.
-  Многоуровневая архитектура: приложение организуется в разные слои, каждый из которых отвечает за определенный набор функций, что способствует модульности и разделению задач (Atomic или Featured Sliced Designs).
-  Микросервисы: разбивает большое приложение на набор небольших, слабо связанных сервисов, которые взаимодействуют друг с другом через API (вспоминаем Kubernetes).

Паттерны конкурентности:

-  Мьютекс: синхронизирует доступ к общему ресурсу, позволяя только одному потоку или процессу получить его блокировку за раз.
-  Блокировка чтения-записи: позволяет нескольким читателям одновременно обращаться к общему ресурсу, предоставляя эксклюзивный доступ одному писателю.
-  Производитель-потребитель: координирует взаимодействие между несколькими потоками-производителями и потоками-потребителями для безопасного совместного использования ограниченного буфера.

---

### 3. Функциональные интерфейсы. Понятие функционального интерфейса и использование в программах на языке Джава

В Java функциональный интерфейс — это интерфейс, который имеет ровно один абстрактный метод.

```java
@FunctionalInterface // Необязательно
interface Calculator {
	int calculate(int a, int b);
}

Calculator addition = (a, b) -> a + b;
int result = addition.calculate(3, 5); // result = 8

Calculator subtraction = (a, b) -> a - b;
result = subtraction.calculate(8, 3); // result = 5

void performOperation(Calculator calculator) {
	int result = calculator.calculate(5, 3);
}

Calculator getCalculator() {
	return (a, b) -> a * b;
}
```

---

### 4. Определение и использование функциональных интерфейсов. Аннотирование функциональных интерфейсов

См **3**

---

### 5. Понятие и использование лямбда -выражений в языке Джава. Примеры

Лямбда-выражения — это конструкция, которая позволяет вам кратко выражать анонимные функции

Синтаксис лямбда-выражения состоит из трех основных частей:

1. Список параметров: определяет входные параметры анонимной функции.
2. Маркер стрелки (`->`): отделяет список параметров от тела лямбда-выражения.
3. Тело: содержит реализацию анонимной функции.

Примеры:

```Java
Runnable runnable = () -> {
   System.out.println("Executing a task");
   // Additional logic
};
```

```Java
List<String> names = Arrays.asList("John", "Alice", "Bob");
Collections.sort(names, (a, b) -> a.compareTo(b));
```

```Java
button.addActionListener(event -> {
   // Handle button click event
});
```

```Java
@FunctionalInterface
interface Calculator {
   int calculate(int a, int b);
}

Calculator addition = (a, b) -> a + b;
int result = addition.calculate(3, 5); // result = 8
```

---

### 6. Паттерн Стратегия. Пример использования функций для параметризации поведения объектов

Шаблон Strategy — это поведенческий шаблон проектирования, который позволяет определить семейство алгоритмов, инкапсулировать каждый из них в виде отдельного класса и сделать их взаимозаменяемыми во время выполнения. Он позволяет параметризовать поведение объектов, определяя стратегии или алгоритмы как отдельные объекты и предоставляя способ динамического переключения между ними.

Обычный способ реализации шаблона Strategy в Java — использование функциональных интерфейсов и лямбда-выражений. Определив функциональные интерфейсы для представления стратегий и используя лямбда-выражения, вы можете легко параметризовать поведение объектов.

```java
@FunctionalInterface
interface SortingStrategy {
   void sort(int[] array);
}

class BubbleSortStrategy implements SortingStrategy {
   @Override
   public void sort(int[] array) {
      // Implementation of bubble sort algorithm
   }
}

class QuickSortStrategy implements SortingStrategy {
   @Override
   public void sort(int[] array) {
      // Implementation of quicksort algorithm
   }
}

class Sorter {
   private SortingStrategy sortingStrategy;

   public void setSortingStrategy(SortingStrategy sortingStrategy) {
      this.sortingStrategy = sortingStrategy;
   }

   public void sortArray(int[] array) {
      sortingStrategy.sort(array);
   }
}

public class Main {
   public static void main(String[] args) {
      int[] array = {5, 2, 8, 1, 9};

      Sorter sorter = new Sorter();

      sorter.setSortingStrategy(new BubbleSortStrategy());
      sorter.sortArray(array);
      // Array sorted using bubble sort strategy

      sorter.setSortingStrategy(new QuickSortStrategy());
      sorter.sortArray(array);
      // Array sorted using quicksort strategy
   }
}
```

---

### 7. Понятие чистой функции. Побочные эффекты функций. Чистота функций в ООП. Пример

Характеристики чистой функции:

1. Выдает один и тот же результат для одних и тех же входных данных, независимо от того, когда и сколько раз она вызывается
2. Отсутствие побочных эффектов. Чистая функция не изменяет и не мутирует какие-либо данные за пределами своей области.

```java
class Calculator {
   public int add(int a, int b) {
      return a + b;
   }
}

public class Main {
   public static void main(String[] args) {
      Calculator calculator = new Calculator();
      int result = calculator.add(3, 5);
      System.out.println(result); // Output: 8
   }
}
```

---

### 8. Неизменяемый класс. Преимущества использования неизменяемых классов. Пример

Неизменный класс в Java — это класс, экземпляры которого не могут быть изменены после их создания.

Преимущества:

1. Потокобезопасность. Неизменяемые объекты по своей сути являются потокобезопасными, поскольку их нельзя изменить.
2. Простота и надежность. Благодаря неизменности вам легче рассуждать об объектах, поскольку их состояние остается постоянным.
3. Непротиворечивость. Неизменяемые объекты гарантируют, что их состояние останется согласованным на протяжении всего их жизненного цикла.
4. Кэшируемость. Неизменяемые объекты можно безопасно кэшировать и использовать повторно, поскольку их состояние не меняется.
5. Неизменяемые объекты могут свободно использоваться различными компонентами приложения.

```java
public final class Point {
   private final int x;
   private final int y;

   public Point(int x, int y) {
      this.x = x;
      this.y = y;
   }

   public int getX() {
      return x;
   }

   public int getY() {
      return y;
   }
}
```

---

### 9. Использование неизменяемых полей класса. Преимущества неизменяемых объектов

См **8**

---

### 10. Функциональное программирование. Понятие инварианта класса. Примеры

Функциональное программирование — это парадигма программирования, которая делает упор на использование чистых функций, неизменяемых данных и декларативного стиля программирования.

Инвариант класса — это условие или свойство, которое должно быть истинным для всех экземпляров класса в любой момент времени. Он определяет ограничения или правила, управляющие допустимым состоянием объектов этого класса.

Пример, когда баланс в банке всегда неотрицательный:

```java
class BankAccount {
   private int balance;

   public BankAccount(int initialBalance) {
      if (initialBalance >= 0) {
         this.balance = initialBalance;
      } else {
         throw new IllegalArgumentException("Initial balance cannot be negative");
      }
   }

   public void deposit(int amount) {
      if (amount >= 0) {
         balance += amount;
      } else {
         throw new IllegalArgumentException("Deposit amount cannot be negative");
      }
   }

   public void withdraw(int amount) {
      if (amount >= 0 && amount <= balance) {
         balance -= amount;
      } else {
         throw new IllegalArgumentException("Invalid withdrawal amount");
      }
   }

   public int getBalance() {
      return balance;
   }
}
```

---

### 11. Особенности многопоточной работы в Джава, использование final для полей данных для обеспечения потокобезопасности

Поле с ключевым словом `final` неизменяемо, а потому есть преимущества во время многопоточности:

1. Неизменяемость: неизменяемые поля по своей сути потокобезопасны, поскольку их нельзя изменить, что устраняет необходимость в синхронизации.
2. Безопасность инициализации: все потоки будут видеть правильно инициализированное значение, предотвращая потенциальную гонку данных или несогласованное состояние.

Пример использования `final`:

```java
public final class ImmutableClass { // не может иметь наследников
   private final int value;  // не может быть изменено

   public ImmutableClass(int value) {
      this.value = value;
   }

   public int getValue() {
      return value;
   }
}
```

---

### 12. Основное назначение паттерна “Строитель” (Builder) для разработки программ на языке Джава

Шаблон Builder — это порождающий шаблон проектирования, который позволяет шаг за шагом создавать сложные объекты. Это особенно полезно, когда есть много необязательных параметров или сложный процесс построения, связанный с созданием объекта.

Основная цель шаблона Builder — позволить лего создавать различные представления или варианты объекта.

Пример:

```java
public class Pizza {
   private String crust;
   private String sauce;
   private List<String> toppings;

   private Pizza(Builder builder) {
      this.crust = builder.crust;
      this.sauce = builder.sauce;
      this.toppings = builder.toppings;
   }

   // Getters...

   public static class Builder {
      private String crust;
      private String sauce;
      private List<String> toppings;

      public Builder() {
         this.toppings = new ArrayList<>();
      }

      public Builder crust(String crust) {
         this.crust = crust;
         return this;
      }

      public Builder sauce(String sauce) {
         this.sauce = sauce;
         return this;
      }

      public Builder toppings(String... toppings) {
         this.toppings.addAll(Arrays.asList(toppings));
         return this;
      }

      public Pizza build() {
         return new Pizza(this);
      }
   }
}
```

```java
Pizza pizza = new Pizza.Builder()
                  .crust("thin")
                  .sauce("tomato")
                  .toppings("cheese", "mushrooms", "pepperoni")
                  .build();
```

---

### 13. Стандартные функциональные интерфейсы в Джава и их методы:

Находятся в пакете `java.util.function`

1. `Runnable`:

   -  `void run()`: Выполняет действие

1. `Consumer<T>`:

   -  `void accept(T t)`: Принимает аргумент

1. `BiConsumer<T, U>`:

   -  `void accept(T t, U u)`: Принимает 2 аргумента

1. `Predicate<T>`:

   -  `boolean test(T t)`: Оценивает условие и возвращает его результат

1. `BiPredicate<T, U>`:

   -  `boolean test(T t, U u)`: Оценивает условие от двух аргументов и возвращает его результат

1. `Supplier<T>`:

   -  `T get()`: Возвращает результат

1. `UnaryOperator<T>`:

   -  `T apply(T t)`: Аргумент и возвращаемое значение одного типа

1. `BinaryOperator<T>`:

   -  `T apply(T t1, T t2)`: Два аргумента и возвращаемое значение одного типа

1. `Function<T, R>`:

   -  `R apply(T t)`: Принимает аргумент и возвращает результат

1. `BiFunction<T, U, R>`:

   -  `R apply(T t, U u)`: Принимает 2 аргумента и возвращает результат

---

### 14. Потоки Stream API в Джава и их использование

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
Stream<Integer> stream = numbers.stream();
```

```java
List<Integer> doubledEvens = numbers.stream()
                                 .filter(n -> n % 2 == 0)
                                 .map(n -> n * 2)
                                 .collect(Collectors.toList());
```

```java
List<Integer> doubledEvens = numbers.parallelStream()
                                 .filter(n -> n % 2 == 0)
                                 .map(n -> n * 2)
                                 .collect(Collectors.toList());
```

---

### 15. Статический импорт и его использование для программирования Stream API

```java
import static java.util.stream.Collectors.*;
import static java.util.stream.Stream.*;

import java.util.List;

public class StreamExample {
   public static void main(String[] args) {
      List<Integer> numbers = List.of(1, 2, 3, 4, 5);

      List<Integer> evenSquared = numbers.stream()
                                          .filter(n -> n % 2 == 0)
                                          .map(n -> n * n)
                                          .collect(toList());

      System.out.println(evenSquared);
   }
}
```

```java
import static java.util.Arrays.*;

String[] names = {"John", "Alice", "Bob"};
stream(names).forEach(System.out::println);
```

```java
import static java.util.stream.Stream.*;

Stream<Integer> stream1 = of(1, 2, 3);
Stream<Integer> stream2 = of(4, 5, 6);
Stream<Integer> combinedStream = concat(stream1, stream2);
combinedStream.forEach(System.out::println);
```

---

### 16. Назначение метода stream() интерфейса Collection. Примеры

См **14-15**

---

### 17. Работа со Stream API. Нетерминальные операции потока Stream: назначение и использование

Нетерминальные операции (также известные как промежуточные операции) используются для преобразования, фильтрации или сортировки элементов потока.

1. `filter(Predicate<T> predicate)`: фильтрует
2. `map(Function<T, R> mapper)`: вызывает функцию
3. `sorted()`: сортирует
4. `distinct()`: удаляет дубликаты
5. `limit(long maxSize)`: устанавливает максимальное количество
6. `skip(long n)`: удаляет первые n элементов

```java
List<String> names = Arrays.asList("John", "Alice", "Bob", "Anna");
List<Integer> nameLengths = names.stream()
                                 .filter(name -> name.length > 3) // ["John", "Alice", "Anna"]
                                 .map(String::length) // [4, 5, 4]
                                 .sorted() // [4, 4, 5]
                                 .distinct() // [4, 5]
                                 .limit(2) // [4, 5]
                                 .skip(1) // [4]
                                 .collect(Collectors.toList());
```

---

### 18. Работа со Stream API. Терминальные операции, назначение и использование. Примеры

Терминальные операции в Stream API — это операции, которые приводят к конечному результату или побочному эффекту.

1. `collect(Collector<T, A, R> collector)`: Собирает stream в обычную сущность

   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   List<Integer> evenNumbers = numbers.stream()
                                    .filter(n -> n % 2 == 0)
                                    .collect(Collectors.toList());
   ```

2. `forEach(Consumer<T> action)`: Вызывает действие и останавливает поток

   ```java
   List<String> names = Arrays.asList("John", "Alice", "Bob");
   names.stream()
      .forEach(System.out::println);
   ```

3. `count()`: Возвращает количество элементов

   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   long count = numbers.stream()
                     .count();
   ```

4. `anyMatch(Predicate<T> predicate)`: Возвращает истину, если любой из элементов соответствует условию

   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   boolean hasEvenNumber = numbers.stream()
                                 .anyMatch(n -> n % 2 == 0);
   ```

5. `allMatch(Predicate<T> predicate)`: Возвращает истину, если все элементы соответствует условию

   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   boolean allPositive = numbers.stream()
                              .allMatch(n -> n > 0);
   ```

6. `noneMatch(Predicate<T> predicate)`: Возвращает истину, если все элементы не соответствует условию

   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   boolean noneNegative = numbers.stream()
                                 .noneMatch(n -> n < 0);
   ```

---

### 19. Интерфейс Splititerator и его методы

Splititerator позволяет параллельно перебирать элементы коллекции, разделяя её на части.

1. `boolean tryAdvance(Consumer<? super T> action)`: сдвигает итератор и применяет действие
2. `void forEachRemaining(Consumer<? super T> action)`: применяет действие для всех оставшихся элементов
3. `Spliterator<T> trySplit()`: пытается отделить от spliterator часть
4. `long estimateSize()`: возвращает количество элементов в spliterator
5. `int characteristics()`: возвращает маску с данными о spliterator
6. `boolean hasCharacteristics(int characteristics)`: проверяет, существуют ли характеристики

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
Spliterator<Integer> spliterator = numbers.spliterator();

spliterator.forEachRemaining(System.out::println);

//////

Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
Spliterator<Integer> spliterator = numbers.spliterator();

int sum = 0;
spliterator.forEachRemaining(num -> sum += num);

System.out.println("Sum: " + sum);

//////

int[] array = {1, 2, 3, 4, 5};

Spliterator.OfInt spliterator = Arrays.spliterator(array);

int sum = 0;
spliterator.forEachRemaining(num -> sum += num);

System.out.println("Sum: " + sum);
```

Пример разделения для параллельного выполнения:

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

Spliterator<Integer> spliterator = numbers.spliterator();
Spliterator<Integer> secondHalfSpliterator = spliterator.trySplit();

if (secondHalfSpliterator != null) {
   // Parallel processing of the spliterators
   Stream<Integer> resultStream = Stream.of(spliterator, secondHalfSpliterator)
                                       .parallel()
                                       .flatMap(Stream::of)
                                       .map(n -> n * 2);

   resultStream.forEach(System.out::println);
} else {
   // Sequential processing if splitting is not possible
   Stream<Integer> resultStream = Stream.of(spliterator)
                                       .flatMap(Stream::of)
                                       .map(n -> n * 2);

   resultStream.forEach(System.out::println);
}
```

Пример имплементации Spliterator:

```java
class CustomDataStructure<T> {
   private List<T> data;

   public Spliterator<T> spliterator() {
      return new CustomSpliterator<>(data);
   }
}

class CustomSpliterator<T> implements Spliterator<T> {
   private List<T> data;
   private int currentIndex;

   public CustomSpliterator(List<T> data) {
      this.data = data;
      this.currentIndex = 0;
   }

   @Override
   public boolean tryAdvance(Consumer<? super T> action) {
      if (currentIndex < data.size()) {
         action.accept(data.get(currentIndex++));
         return true;
      }
      return false;
   }

   @Override
   public Spliterator<T> trySplit() {
      int remainingSize = data.size() - currentIndex;
      if (remainingSize < 10) {
         return null; // Cannot split further
      }

      int splitSize = remainingSize / 2;
      CustomSpliterator<T> newSpliterator = new CustomSpliterator<>(data.subList(currentIndex, currentIndex + splitSize));
      currentIndex += splitSize;
      return newSpliterator;
   }

   @Override
   public long estimateSize() {
      return data.size() - currentIndex;
   }

   @Override
   public int characteristics() {
      return ORDERED | SIZED | SUBSIZED;
   }
}

// Usage:
CustomDataStructure<Integer> customDataStructure = new CustomDataStructure<>(Arrays.asList(1, 2, 3, 4, 5));
Spliterator<Integer> spliterator = customDataStructure.spliterator();
spliterator.forEachRemaining(System.out::println);
```

---

### 20. Понятие многопоточности и написание многопоточных программ на языке Джава

Многопоточность обычно используется для достижения параллелизма, повышения производительности и повышения скорости отклика приложений.

```java
class MyThread extends Thread {
   @Override
   public void run() {
      // Code to be executed in the thread
      for (int i = 0; i < 5; i++) {
         System.out.println("Thread: " + Thread.currentThread().getId() + " Count: " + i);
      }
   }
}

MyThread thread1 = new MyThread();
MyThread thread2 = new MyThread();
thread1.start();
thread2.start();
```

```java
class MyRunnable implements Runnable {
   @Override
   public void run() {
      // Code to be executed in the thread
      for (int i = 0; i < 5; i++) {
         System.out.println("Thread: " + Thread.currentThread().getId() + " Count: " + i);
      }
   }
}

Thread thread1 = new Thread(new MyRunnable());
Thread thread2 = new Thread(new MyRunnable());
thread1.start();
thread2.start();
```

---

### 21. Потоки (threads) в Джава. Создание потоков в Джава программах Подходы к созданию потоков: через наследование и реализацию интерфейса Runnable Thread API. Запуск потока с Runnable

См **20**

---

### 22. Потоки в Джава. Методы Thread API

1. `start()`: запускает поток через run()
2. `run()`: выполнимый код
3. `sleep(long millis)`: приостановка потока
4. `join()`: ожидает выполнение другого потока
5. `isAlive()`: проверяет, завершен ли поток
6. `interrupt()`: прерывает поток
7. `isInterrupted()`: проверка прерывания

```java
public class SleepExample extends Thread {
   @Override
   public void run() {
      try {
         System.out.println("Thread started.");
         Thread.sleep(2000); // Pausing the thread for 2 seconds
         System.out.println("Thread resumed after sleep.");
      } catch (InterruptedException e) {
         System.out.println("Thread interrupted.");
      }
   }

   public static void main(String[] args) {
      SleepExample thread = new SleepExample();
      thread.start();

      // Thread started.
      // [waits for 2 seconds]
      // Thread resumed after sleep.
   }
}
```

```java
public class JoinExample extends Thread {
   @Override
   public void run() {
      try {
         System.out.println("Thread started.");
         Thread.sleep(2000);
         System.out.println("Thread completed.");
      } catch (InterruptedException e) {
         System.out.println("Thread interrupted.");
      }
   }

   public static void main(String[] args) throws InterruptedException {
      JoinExample thread = new JoinExample();
      thread.start();
      thread.join(); // Main thread waits for 'thread' to complete
      System.out.println("Main thread completed.");

      // Thread started.
      // [waits for 2 seconds]
      // Thread completed.
      // Main thread completed.
   }
}
```

```java
public class InterruptExample extends Thread {
   @Override
   public void run() {
      while (!isInterrupted()) {
         System.out.println("Thread is running.");
      }
      System.out.println("Thread interrupted. Exiting...");
   }

   public static void main(String[] args) {
      InterruptExample thread = new InterruptExample();
      thread.start();
      try {
         Thread.sleep(2000);
         thread.interrupt(); // Interrupting the thread
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

      // Thread is running.
      // Thread is running.
      // Thread is running.
      // [waits for 2 seconds]
      // Thread interrupted. Exiting...
   }
}
```

Ещё методы класса Thread:

1. `getId()`
2. `getName()`
3. `setName(String name)`
4. `getPriority()`: returns the priority of the thread from 1 (lowest) to 10 (highest).
5. `setPriority(int priority)`
6. `isDaemon()`
7. `setDaemon(boolean daemon)`: потоки-демоны автоматически завершаются после остальных

---

### 23. Синхронизация потоков. Понятие синхронизации. Блок синхронизации

Синхронизация потоков — это концепция координации выполнения нескольких потоков, чтобы гарантировать, что они получают доступ к общим ресурсам или критическим разделам кода взаимоисключающим образом.

Блок синхронизации, также известный как синхронизированный блок, представляет собой блок кода, который одновременно выполняется только одним потоком.

```java
public class SynchronizedList {
   List<Integer> list = new ArrayList<>();

   public void add(Integer num) {
      synchronized (this) {
         list.add(num);
      }
   }

   public synchronized void push() {
      list.add(num);
   }

   public int size() {
      return list.size();
   }
}

public class SynchronizedBlockExample {
   public static void main(String[] args) throws InterruptedException {
      SynchronizedList list = new SynchronizedList();

      Runnable runnable = () -> {
         for (int i = 0; i < 5000; i++) {
            list.add(i);
         }
      };

      Thread thread1 = new Thread(runnable);
      Thread thread2 = new Thread(runnable);

      thread1.start();
      thread2.start();

      Thread.sleep(1000);

      System.out.println("Count: " + list.size()); // 10000
   }
}
```

---

### 24. Использование синхронизации потоков для пары процессов producer/reader( производители/потребители)

```java
private static int result = 0;
private static boolean ready = false;

public static void main(String[] args) {
   Object lock = new Object();
   Runnable producer = () -> {
      sleep(100);
      synchronized (lock) {
         result = 42; ready = true;
      }
   };

   Runnable reader = () -> {
      while (true) {
         synchronized (lock) {
            if (ready) {
               System.out.println(result);
               break;
            }
         }
      }
   };

   new Thread(reader).start();
   new Thread(producer).start();
}
```

---

### 25. Реализация блока synchronized на основе мониторов

См **24**

Если у нас несколько потоков, то перед входом в synchronized(lock){} они ждут окончания работы там предыдущего потока

---

### 26. Метод synchronized (lock), особенности его использования для потоков

См **24-25**

---

### 27. Синхронизация потоков . Правила happens-before (hb)

См **24-26**

Правила happens-before (hb):

1. В рамках одного потока любая операция happens-before любой операции, следующей за ней в исходном коде
2. Выход из synhronized блока happens-before входа в synhronized блок на том же мониторе
3. Запись volatile поля happens-before чтения того же самого volatile поля
4. Завершение метода run() экземпляра класса Thread happens-before выхода из метода join()
5. Вызов метода start() экземпляра класса Thread happens-before начала метода run() экземпляра того же потока

Связь happens-before транзитивна, т.е. если X happens-before Y, а Y happens-before Z, то X happens-before Z.

Если X happens-before Y, то все изменения, внесенные до операции X, будут видны в коде, следующем за операцией Y.

---

### 28. Синхронизация потоков. Модификатор полей volatile и его использование

```java
private static int result = 0;
private static volatile boolean ready = false;

public static void main(String[] args) {
   Runnable reader = () -> {
      while (!ready); // 3
      System.out.println(result); // 4
   };

   Runnable producer = () -> {
      sleep(100);
      result = 42; // 1
      ready = true; // 2
   };

   new Thread(reader).start();
   new Thread(producer).start();
}
```

---

### 29. Синхронизация потоков. Атомарные операции. Механизм Wait/notify

```java
Для некоторых случаев удобно использовать классы
AtomicInteger counter = new AtomicInteger(0);

// И его аналоги AtomicLong, AtomicBoolean

Это аналоги volatile полей, но кроме того они добавляют методы, которые выполняются атомарно:

int newValue = counter.addAndGet(delta); // Аналог “counter += delta”
int oldValue = counter.getAndAdd(delta); // Аналог “counter += delta”
int newValue = counter.incrementAndGet(); // Аналог “++counter”
int oldValue = counter.getAndIncrement(); // Аналог “counter++”
```

Wait позволяет усыплять потоки, а notify пробуждать их:

```java
Object lock = new Object();

Runnable producer = () -> {
   try {
         Thread.sleep(100);
         synchronized (lock) {
            result = 42;
            ready = true;
            lock.notifyAll(); // Пробуждает другие потоки
         }
   } catch (InterruptedException ex) {
         // завершение потока
   }
};

Runnable reader = () -> {
   try {
         synchronized (lock) {
            while (!ready) {
               lock.wait(); // Усыпляет поток
            }
            System.out.println(result);
         }
   } catch (InterruptedException ex) {
         // завершение потока
   }
};

new Thread(reader).start();
new Thread(producer).start();
```

---

### 30. Синхронизация потоков с использованием классов пакета java.util.concurrent.locks

Классы ReentrantLock, Condition

```java
ReentrantLock lock = new ReentrantLock();
Condition isReady = lock.newCondition();

Runnable producer = () -> {
   try {
         Thread.sleep(100);
         lock.lock();
         try {
            result = 42;
            ready = true;
            isReady.signalAll();
         } finally {
            lock.unlock();
         }
   } catch (InterruptedException ex) {
         // завершение потока
   }
};

Runnable reader = () -> {
   try {
         lock.lock();
         try {
            while (!ready) {
               isReady.await();
            }
            System.out.println(result);
         } finally {
            lock.unlock();
         }
   } catch (InterruptedException ex) {
         // завершение потока
   }
};

new Thread(reader).start();
new Thread(producer).start();
```

Класс ReentrantReadWriteLock позволяет блокировать потоки только в случае, когда идет изменение данных, а в случае чтения данных блокировки потоков не происходит.

---

### 31. Запуск и прерывание потоков. Приостановка и прерывание выполнения нити

```java
public class Main {
   public static void main(String[] args) {
      Thread myThread = new Thread(() -> {
         try {
            for (int i = 1; i <= 5; i++) {
               System.out.println("Thread: " + i);
               Thread.sleep(1000);
            }


         } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Лучше всегда вызывать, что дальше по цепочке можно было понять, что поток прерван
            System.out.println("Thread interrupted");
         }
      });

      myThread.start();

      try {
         Thread.sleep(3000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

      myThread.interrupt();
   }
}
```

Также можно делать проверку через Thread.currentThread().isInterrupted()

---

### 32. Обработка операции прерывания потока

См **31**

---

### 33. Ожидание и присоединение запущенной нити основным потоком управления

С помощью thread.join() можно заставить ждать этот поток

---

### 34. Жизненный цикл потока на языке Джава. Состояние потока

Состояния потока:

1. `NEW`: запущен (start)
2. `WAITING` в отключке (wait)
3. `TIMED_WAITING`: обычное ожидание (как sleep)
4. `BLOCKED`: заблокирован (lock)
5. `TERMINATED`: закончен (выход из run)

Проверка на состояние:

```java
myThread.getState() == Thread.State.TERMINATED
```

---

### 35. Многопоточные примитивы и их использование

Виды:

-  Класс Thread с методами start/join
-  Блоки synchronized
-  Методы wait/notify/notifyAll
-  Поля с модификатором volatile
-  Классы java.util.concurrent.atomic.\*
-  Классы java.util.concurrent.locks.\*
-  Метод interrupt(), InterruptedException и interrupted state

---

### 36. Интерфейс Executor в Джава и его использование. ExecutorService

Пример с submit():

```java
@RestController
@RequestMapping("/users")
public class UserController {

   @Autowired
   private final UserRepository userRepository;

   private final ExecutorService executorService = Executors.newFixedThreadPool(10);

   @GetMapping
   public void getUsers() {
      executorService.submit(() -> {
         userRepository.findAll().forEach(System.out::println); // Выполняется асинхронно
      });
   }
}
```

Пример с invokes:

```java
ExecutorService executorService = Executors.newFixedThreadPool(5);

List<Callable<Integer>> tasks = new ArrayList<>();
tasks.add(() -> {
   Thread.sleep(3000);
   return 1;
});
tasks.add(() -> {
   Thread.sleep(2000);
   return 2;
});
tasks.add(() -> {
   Thread.sleep(1000);
   return 3;
});

try {
   List<Future<Integer>> results = executorService.invokeAll(tasks); // если all - [1, 2, 3]; иначе - 3
   for (Future<Integer> result : results) {
         System.out.println(result.get());
   }
} catch (InterruptedException | ExecutionException e) {}

executorService.shutdown();
```

---

### 37. Интерфейс Future в Джава. Основное назначение использования его в программах

См **36**

Методы submit() и invokeAll() возвращают Future и List\<Future\>

1. `cancel(boolean mayInterruptIfRunning)`: пытается отменить задачу
2. `isCancelled()`
3. `isDone()`: завершена ли задача
4. `get()`: пытается получить результат; выбрасывает `InterruptedException` и `ExecutionException`
5. `get(long timeout, TimeUnit unit)`: ждет, потом пытается получить результат

```java
ExecutorService executorService = Executors.newSingleThreadExecutor();
Future<Integer> future = executorService.submit(() -> {
   return 42;
});

while (!future.isDone()) {
   System.out.println("Task is still running...");
}

try {
   Integer result = future.get();
   System.out.println("Result: " + result);
} catch (InterruptedException | ExecutionException e) {}

executorService.shutdown();
```

---

### 38. Коллекции java.util.concurrent. Состав коллекции. Основные методы

BlockingQueue - ждет, чтобы можно было достать или добавить элемент:

```java
BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

Thread producer = new Thread(() -> {
   for (int i = 0; i < 20; i++) {
         try {
            queue.put(i);
            System.out.println("Produced: " + i);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
   }
});

Thread consumer = new Thread(() -> {
   int count = 0;
   while (count < 20) {
      try {
         int item = queue.take();
         count++;

         System.out.println("Consumed: " + item);
      } catch (InterruptedException e) {
         break;
      }
   }
});

producer.start();
consumer.start();
```

---

### 39. Потокобезопасные коллекции пакета java.util.concurrent:

```java

```

---

### 40. Реализация асинхронного выполнения в Джава

```java

```

---

### 41. Паттерн “Одиночка” (Singleton) и его использование в Джава программах

```java

```

---

### 42. Использование статических методов для создания экземпляра объекта вместо конструкторов

```java

```

---

### 43. Паттерн “Строитель” и его использование большом количестве параметров конструктора

```java

```

---

### 44. Понятие dependency injection (внедрение зависимости). Преимущества использования внедрения зависимостей при написании программ на языке Джава. Преимущества этого подхода перед паттерном Одиночка

```java

```

---

### 45. Преимущество использования try-с-ресурсами по сравнению с использованием try-finally. Интерфейс интерфейса AutoCloseable

```java

```

---

### 46. Паттерн Декоратор (Decorator) Преимущества его использовании (например композиция по сравнению с наследованием)

```java

```

---

### 47. Преимущества использования списков перед массивами

```java

```

---

### 48. Основные системы сборки Gradle и Maven. Использование Gradle и основная терминология. Управление зависимостями в Gradle

```java

```

---

### 49. Анатомия jar. Сканирование пакетов

```java

```

---

### 50. Реализация REST API с помощью Spring Framework

```java

```

---

### 51. Понятие Инверсии управления

```java

```

---

### 52. Spring Boot и его использование

```java

```

---

### 53. Работа с базами данных в джава приложениях. Встроенные СУБД для Джава приложений.

```java

```

---

### 54. Реляционные СУБД для работы с джава приложениями. Пакет Пакет java.sql и его классы

```java

```

---

### 55. Роль интерфейса JDBC для работы с джава приложениями

```java

```

---

### 56. Основные компоненты JDBC API

```java

```

---

### 57. JDBC URL и его использование

```java

```

---

### 58. Работа JDBC драйвера

```java

```

---

### 59. В чем заключается роль DI в Spring. Использования ServiceLoader

```java

```

---

### 60. Интерфейс Connection. Пулы соединений

```java

```

---

### 61. Принципы SOLID и их использование на Джава

```java

```
