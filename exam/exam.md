# Вопросы

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

consumer.start();
producer.start();
```

`ConcurrentLinkedQueue`, `ConcurrentHashMap` и `CopyOnWriteArrayList` позволяют обращаться к разным элементам в разных потоках одновременно

Пример работы:

```java
public class ConcurrentLinkedQueueExample {

   public static void main(String[] args) {
      ConcurrentLinkedQueue<Runnable> taskQueue = new ConcurrentLinkedQueue<>();

      taskQueue.add(() -> System.out.println("Task 1 executed"));
      taskQueue.add(() -> System.out.println("Task 2 executed"));
      taskQueue.add(() -> System.out.println("Task 3 executed"));

      Thread worker = new Thread(() -> {
         while (!taskQueue.isEmpty()) {
            Runnable task = taskQueue.poll();
            task.run();
         }
      });

      worker.start();
   }
}
```

Методы:

Map:

1. `put(key, value)`
2. `get(key)`
3. `remove(key)`
4. `size()`

List:

1. `add(e)`
2. `add(index, e)`
3. `get(index)`
4. `size()`

Queue:

1. add(e): with Exception
2. offer(e): without Exception
3. poll(): return and remove head element
4. peek(): return head element

BlockingQueue:

1. put(e): waiting for space
2. take(): waiting for element
3. remainingCapacity(): Returns the capacity of the queue.

---

### 39. Потокобезопасные коллекции пакета java.util.concurrent:

См **38**

---

### 40. Реализация асинхронного выполнения в Джава

Суть в том, что во время ожидания ввода/вывода освобождать поток.

```java
Вместо:
String text = readFromFile();
processText(text);

Пишем:
readFromFile(text -> {
   processText(text);
});
```

Пример с CompletableFuture

```java
CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
   try {
         Thread.sleep(2000);
   } catch (InterruptedException e) {
         e.printStackTrace();
   }
   return "Hello, world!";
});

CompletableFuture<Void> callback = completableFuture.thenAccept(result -> {
   System.out.println("Result1: " + result);
});

System.out.println("Waiting for result...");
String result = completableFuture.get(); // Ожидание результата
System.out.println("Result2: " + result);

System.out.println("Waiting for callback...");
callback.get();
```

---

### 41. Паттерн “Одиночка” (Singleton) и его использование в Джава программах

```java

```

---

### 42. Использование статических методов для создания экземпляра объекта вместо конструкторов

```java
public class Rectangle {

   private final int width;
   private final int height;

   private Rectangle(int width, int height) {
      this.width = width;
      this.height = height;
   }

   public static Rectangle createSquare(int size) {
      return new Rectangle(size, size);
   }

   public static Rectangle create(int width, int height) {
      return new Rectangle(width, height);
   }
}
```

---

### 43. Паттерн “Строитель” и его использование большом количестве параметров конструктора

```java

```

---

### 44. Понятие dependency injection (внедрение зависимости). Преимущества использования внедрения зависимостей при написании программ на языке Джава. Преимущества этого подхода перед паттерном Одиночка

1. Гибкость. Класс может полагаться не на реализацию, а на абстракции и интерфейсы
2. Тестируемость. Внедряя зависимости, во время тестирования какого-то модуля нет необходимости по цепочке подключать все его зависимости, можно заменить их заглушками
3. Модульность. Отдельные классы или модули можно легко использовать в других

Преимущества перед Singleton:

1. Сохраняется возможность создавать несколько объектов
2. Приложение тестируется проще, поскольку заменять зависимости заглушками гораздо проще, чем реальные объекты
3. DI позволяет слабо связывать модули, Singleton, напротив, создаёт тесную связь

Singleton же стоит, например, использовать, если у класса есть собственное состояние, которое нужно получать у разных объектов (потому получается, что это будет один и тот же объект)

```java
public class SpellChecker {
   private final Lexicon dictionary;

   public SpellChecker(Lexicon dictionary) {
      this.dictionary = dictionary;
   }

   //
}
```

---

### 45. Преимущество использования try-с-ресурсами по сравнению с использованием try-finally. Интерфейс AutoCloseable

AutoCloseable - интерфейс с методом close(), который вызывается после окончания блока try

```java
try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
   String line = reader.readLine();
} catch (IOException e) {}

////

try (
   Connection connection = DriverManager.getConnection(url, username, password);
   Statement statement = connection.createStatement()
) {
   ResultSet resultSet = statement.executeQuery("SELECT * FROM table");
} catch (SQLException e) {}

////

try (
   FileInputStream input = new FileInputStream("input.txt");
   FileOutputStream output = new FileOutputStream("output.txt")
) {
   int data;
   while ((data = input.read()) != -1) {
      output.write(data);
   }
} catch (IOException e) {}
```

---

### 46. Паттерн Декоратор (Decorator) Преимущества его использовании (например композиция по сравнению с наследованием)

```java
interface Logger {
   void log(String message);
}

// Наш класс
class ConsoleLogger implements Logger {
   @Override
   public void log(String message) {
      System.out.println("Logging: " + message);
   }
}

// Абстрактный декоратор
abstract class LoggerDecorator implements Logger {
   private Logger decoratedLogger;

   public LoggerDecorator(Logger decoratedLogger) {
      this.decoratedLogger = decoratedLogger;
   }

   @Override
   public void log(String message) {
      decoratedLogger.log(message);
   }
}

// Декоратор с выводом времени
class TimestampLoggerDecorator extends LoggerDecorator {
   public TimestampLoggerDecorator(Logger decoratedLogger) {
      super(decoratedLogger);
   }

   @Override
   public void log(String message) {
      String timestamp = "[" + java.time.LocalDateTime.now() + "] ";
      super.log(timestamp + message);
   }
}

// Декоратор с дополнительным выводом
class LogLevelLoggerDecorator extends LoggerDecorator {
   private String logLevel;

   public LogLevelLoggerDecorator(Logger decoratedLogger, String logLevel) {
      super(decoratedLogger);
      this.logLevel = logLevel;
   }

   @Override
   public void log(String message) {
      String logMessage = "[" + logLevel + "] " + message;
      super.log(logMessage);
   }
}

Logger logger = new ConsoleLogger();
logger = new TimestampLoggerDecorator(logger);
logger = new LogLevelLoggerDecorator(logger, "INFO");
logger.log("This is a log message");
```

Преимущества Декоратора перед Наследованием:

1. Можно легко добавлять несколько декораторов
2. Меньше зависимостей. При наследовании создаётся простой новый класс, во время декорирования мы лишь создаём класс-обёртку для первичного
3. С помощью интерфейсов можно легко абстрагировать разные декораторы и первичные классы, что добавляет гибкости коду

Декораторы вместо зависимости используют композицию:

```java
// Наследование
class Transport {
   //
}
class Car extends Transport {
   //
}

// Композиция
class Transport {
   //
}
class Car {
   private transport;

   public Car(Transport transport) {
      this.transport = transport;
   }

   //
}
```

---

### 47. Преимущества использования списков перед массивами

1. Динамический размер. При создании списка память не выделяется сразу, а только после добавления; кроме того разработчику не нужно беспокоиться об изменении размера в будущем, всё будет сделано автоматически.
2. Функциональность. У списков просто больше функций.
3. Интеграция с Collection Framework. Списки включены в Java Collections Framework, что обеспечивает унифицированный и согласованный способ работы с коллекциями в Java. Их можно использовать взаимозаменяемо с другими типами коллекций, такими как наборы или очереди, и использовать общие интерфейсы и алгоритмы, предоставляемые языком.

---

### 48. Основные системы сборки Gradle и Maven. Использование Gradle и основная терминология. Управление зависимостями в Gradle

**Отличия:**

Maven:

1. POM на основе XML
2. Есть много предопределенных настроек, проект легче запускается

Gradle:

1. Groovy, Kotlin или XML
2. Синтаксис более лаконичный -> более читабельный
3. Можно управлять задачами и зависимостями, которые нужны конкретным задачам

**О Gradle:**

-  Сценарии сборки для Gradle хранятся в build.gradle
-  settings.gradle - информация о подпроектах (или просто rootProject.[name, ...])
-  Задачи могут выполняться отдельно, могут и зависеть друг от друга
-  Плагины Gradle могут определять новые задачи, вводить соглашения и т.п.; это как декораторы для классов
-  Зависимости указываются в dependencies, их можно скачивать из Maven Central
-  Часто используемые блоки: plugins, repositories, dependencies, sourceSets, task
-  Gradle Wrapper - скрипт, который гарантирует, что все разработчики используют одну и ту же версию Gradle (gradlew, gradlew.bat, gradle-wrapper.properties)
-  CLI: [gradle] build - для сборки, test - для тестов, run - для выполнения приложения, tasks - для вывода всех задач и т.п.

**Про зависимости:**

Виды:

-  implementation: нужны для компиляции и запуска приложения
-  testImplementation: для запуска тестов
-  compileOnly: для компиляции
-  runtimeOnly: нужны во время выполнения

Возможности:

-  Gradle может извлекать зависимости из удаленных репозиториев и из локальных, также он кеширует скачанные зависимости.
-  Если зависимости нужны другие, он их автоматически устанавливает
-  Плагины позволяют частично управлять зависимостями: java позволяет скачивать конкретный зависимости по умолчанию
-  Можно исключать установку дополнительных зависимостей с помощью exclude()
-  Задача dependencyUpdates позволяет проверить доступные обновления зависимостей

Пример:

```gradle
plugins {
   id("application")
}

group = "ru.mirea.example"
version = "0.1"
description = "Пример приложения"

java {
   sourceCompatibility = JavaVersion.VERSION_11
}

tasks.withType(JavaCompile) {
   options.encoding = "UTF-8"
}

repositories {
   mavenCentral()
}

dependencies {
   implementation("org.apache.commons:commons-lang3:3.12.0")
}

application {
   mainClass.set("ru.mirea.example.Example2")
}

tasks.register(“hello”) {
   dependsOn(“beforeHello”)
   doLast {
      println(“Hello task”)
   }
}

tasks.register(“beforeHello”) {
   doLast {
      println(“Before hello”)
   }
}

tasks.register(“copyConfig”, type: Copy) { // Предопределенный тип задачи
   from(“config”)
   into(“distr”)
   exclude(“README.md”)
}

subprojects {
   apply(plugin: "java")

   group = "ru.mirea.example"
   version = "0.1"

   java {
      sourceCompatibility = JavaVersion.VERSION_11
   }

   tasks.withType(JavaCompile) {
      options.encoding = "UTF-8"
   }

   repositories {
      mavenCentral()
   }
}
```

Дополнительно:

-  Скрипт gradle wrapper инициализирует его
-  Фазы: инициализация (setting.gradle), конфигурация (на основе build.gradle), выполнение (запуск задач)

### 49. Анатомия jar. Сканирование пакетов

-  Jar это zip архив специального вида!
-  Внутри jar находятся байт код программы, ресурсы, а также сохранена переменная classpath для данной программы.
-  Classpath это переменная в которой указаны пути до всех классов программы (в том числе и Main)

Сканирование пакетов:

Одной из ключевых особенностей JVM является динамическая загрузка классов. Достигается это благодаря сущности загрузчика классов.

Идея состоит в том что мы можем двигаться по классам переменной classpath и загружать их при помощи classloader. Загружая классы, являющиеся подттипом данного, что реализует библиотека reflections.

Структура .jar файла:

-  Манифест. Файл JAR начинается с манифеста (META-INF/MANIFEST.MF), который хранит справочные данны: версию, основной класс и т.п.
-  Структура каталогов. После манифеста хранится информация о файлах проекта
-  Байт-код. После хранятся скомпилированные Java классы с расширением .class
-  Ресурсы. Могут быть также файлы ресурсов: изображения, xml и т.п.

---

### 50. Реализация REST API с помощью Spring Framework

```java
@RestController
@RequestMapping("/users")
public class UserController {
   private final UserService userService;

   @Autowired
   public UserController(UserService userService) {
      this.userService = userService;
   }

   @GetMapping
   public List<User> getAllUsers() {
      return userService.getAllUsers();
   }

   @GetMapping("/{id}")
   public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
      User user = userService.getUserById(id);
      if (user != null) {
         return ResponseEntity.ok(user);
      } else {
         return ResponseEntity.notFound().build();
      }
   }
}

@Service
public class UserService {
   private final UserRepository userRepository;

   @Autowired
   public UserService(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   public List<User> getAllUsers() {
      return userRepository.findAll();
   }

   public User getUserById(Long id) {
      Optional<User> userOptional = userRepository.findById(id);
      return userOptional.orElse(null);
   }
}

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
```

Пути:

-  GET /users
-  GET /users/{id}
-  GET /users/{id}?tag={tagValue}
-  GET /users/{id}/someData
-  POST /users
-  PUT /users/{id}
-  PUT /users/{id}/someData
-  DELETE /users/{id}

---

### 51. Понятие Инверсии управления

По сути, речь идёт о том, чтобы передать ответственность за создание и управление зависимостями фреймворку

```java
@RestController // Spring понимает, что данный класс является контроллером и его можно использовать в DI
@RequestMapping("/users")
public class UserController {
   private final UserService userService;

   @Autowired // Spring сам понимает, что сюда нужно подключить зависимость
   public UserController(UserService userService) {
      this.userService = userService;
   }
}
```

**Более умными словами:**

Инверсия управления (IoC) — это принцип проектирования программного обеспечения, который относится к обращению традиционного потока управления между компонентами в системе. В типичном потоке управления компонент явно создает и управляет жизненным циклом своих зависимых компонентов. Однако в IoC ответственность за создание зависимостей и управление ими переносится на отдельный контейнер или фреймворк.

В IoC поток управления инвертируется, поскольку управление созданием, инициализацией и управлением жизненным циклом объектов передается контейнеру, также известному как контейнер IoC или контейнер внедрения зависимостей (DI). Контейнер отвечает за разрешение зависимостей и их внедрение в компоненты, которым они требуются.

---

### 52. Spring Boot и его использование

Spring Boot создан на основе Spring. Особенности:

1. Простая установка и конфигурация. Установка в пару кликов, а начальная конфигурация предлагается рабочей из коробки
2. Встроенные веб-серверы (Tomcat, Jetty, Undertow). Благодаря этому можно запускать всё приложение с помощью только одного .jar файла
3. Работа через аннотации. Spring Boot предоставляет огромное количество аннотаций, которые позволяют сосредоточиться только на написании бизнес-логики.
4. Большой выбор зависимостей. Предлагаются проверенные пакеты для решения популярных задач, такие как Data JPA, Security, Lombok и т.п.
5. Работа со Spring Boot может вестись напрямую из командной строки

Примеры, когда удобно использовать Spring:

-  Веб-приложения
-  Веб-приложения с двунаправленной связью (благодаря удобному Spring WebSockets)
-  Обработка данных
-  Создание микросервиса
-  В целом интеграция с внешними системами

---

### 53. Работа с базами данных в джава приложениях. Встроенные СУБД для Джава приложений.

Встроенные СУБД:

-  H2
-  Apache Derby

Клиент-серверные СУБД:

-  PostgreSQL
-  Oracle
-  MySQL
-  Microsoft SQL Server

Виды подключений к БД:

-  обычный JDBC
-  Spring JDBC
-  Spring Data JPA

Пример с обычным JDBC:

```java
@Bean
public Connection connection() throws SQLException {
   try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "pass");
   } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
   }
}

@Repository
public class UserDao {
   private final Connection connection;

   public UserDao(Connection connection) {
      this.connection = connection;
   }

   public List<User> findAll() throws SQLException {
      List<User> users = new ArrayList<>();
      String sql = "SELECT * FROM users";

      try (
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(sql)
      ) {

         while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));

            users.add(user);
         }
      }

      return users;
   }
}

@RestController
@RequestMapping("/users")
public class UserController {
   private final UserDao userDao;

   @Autowired
   public UserController(UserDao userDao) {
      this.userDao = userDao;
   }

   @GetMapping
   public List<User> getAllUsers() throws SQLException {
      return userDao.findAll();
   }
}
```

Пример со Spring JDBC:

```java
@Bean
DataSource dataSource() {
   HikariDataSource dataSource = new HikariDataSource();
   dataSource.setJdbcUrl(dataSourceUrl);
   dataSource.setUsername(dataSourceUsername);
   dataSource.setPassword(dataSourcePassword);
   dataSource.setDriverClassName(driverClassName);

   return dataSource;
}

@Repository
public class UserRepo {

	private final JdbcTemplate jdbcTemplate;

	public UserRepo(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<User> findAll() {
		String sql = "SELECT * FROM users";
		return jdbcTemplate.query(
			sql,
			new BeanPropertyRowMapper<>(User.class)
		);
	}
}
```

Spring Data Jpa - обычный вариант доступа к БД

---

### 54. Реляционные СУБД для работы с джава приложениями. Пакет java.sql и его классы

См **53**

Классы java.sql:

-  `DriverManager`: нужен для установки соединения с базой данных
-  `Connection`: является объект соединения, позволяет создавать объект Statement
-  `Statement`: позволяет выполнять SQL запросы
-  `ResultSet`: результат запроса к БД, next() сдвигает курсор, методы get...() получают данные из столбцов
-  `PreparedStatement`: можно писать SQL с параметрами
-  `ResultSetMetaData`: в нём есть методы для работы со столбцами ResultSet
-  `SQLException`: исключение при попытке подключения к БД

---

### 55. Роль интерфейса JDBC для работы с джава приложениями

Проще говоря, JDBC позволяет делать в Java-приложении следующие вещи: предоставление общего API, установление соединения с базой данных, выполнение sql-запросов, обработка результатов и управление транзакциями

ПО JDBC API - См **54**

Про Spring JDBC:

`HikariDataSource` позволяет подключиться к БД. А `JdbcTemplate` отправлять запросы к БД

Существует также класс NamedParameterJdbcTemplate, который позволяет писать запросы с параметрами:

```java
@Autowired
private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

public void executeQuery() {
   String sql = "SELECT * FROM users WHERE age > :age";
   Map<String, Object> params = new HashMap<>();
   params.put("age", 18);
   List<User> users = namedParameterJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(User.class));
}
```

---

### 56. Основные компоненты JDBC API

См 54

---

### 57. JDBC URL и его использование

JDBC URL - путь до БД; составляющие:

1. Протокол: например, jdbc:mysql:// или jdbc:postgresql://
2. Хост и порт: например, для локальной БД - "localhost" и 3306
3. Имя БД
4. Доп. параметры, например как: пользователь или пароль

Пример - jdbc:mysql://localhost:3306/mydatabase?user=myuser&password=mypassword

---

### 58. Работа JDBC драйвера

JDBC-драйвер – библиотека для выполнения SQL-запросов для конкретной БД.
Он действует как мост между приложением Java и базой данных, позволяя приложению отправлять операторы SQL в базу данных, извлекать результаты и управлять соединениями с базой данных.

JDBC-драйвер подключается через конфигурацию runtimeOnly. Это значит, что его классы недоступны на этапе компиляции.

Во время подключения `DriverManager` перебирает все зарегистрированные драйверы и вызывает у них метод acceptsURL. Если он возвращает true, то вызывается метод connect. Потому нам необязательно указывать драйвер при подключении.

---

### 59. В чем заключается роль DI в Spring. Использования ServiceLoader

DI - подход для простого подключения классов

Service Loader - реализация такого похода

Вариант от Spring - @Service, @Component, @Autowired и т.п.

Вариант от Google:

```java
import com.google.auto.service.AutoService;

@AutoService(SimpleService.class)
public class SimpleServiceProvider implements SimpleService {
   @Override
   public void doSomething() {
      System.out.println("Doing something in SimpleServiceProvider");
   }
}

public class ServiceLoaderExample {
   public static void main(String[] args) {
      ServiceLoader<SimpleService> serviceLoader = ServiceLoader.load(SimpleService.class);

      for (SimpleService service : serviceLoader) {
         service.doSomething();
      }
   }
}
```

---

### 60. Интерфейс Connection. Пулы соединений

Пул соединений с базой данных это набор заранее открытых соединений с базой данных используемый для предоставления соединения в тот момент, когда оно требуется.

-  соединение нет необходимости открывать заново при каждом запросе, его можно переиспользовать
-  пулы гарантируют, что БД не будет перегружена, поскольку часто есть ограничения на количество одновременно отправленных запросов
-  пул обычно включает в себя управление соединением: проверку на работоспособность, получение информации о его работе

```java
# DataSource configuration
spring.datasource.url=jdbc:mysql://localhost:3306/mydatabase
spring.datasource.username=dbuser
spring.datasource.password=dbpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# HikariCP specific configuration
spring.datasource.hikari.connection-timeout=30000
spring.datasource.hikari.maximum-pool-size=10
```

---

### 61. Принципы SOLID и их использование на Джава

-  Single responsibility: каждая сущность имеет свою зону ответственности и не более
-  Open-closed: расширять можно, изменять старый код не желательно
-  Liskov substitution: наследуемые классы должны дополнять, а не замещать поведение базового класса
-  Interface segregation: при изменении одного дочернего класса на другой логика работы тех же методов должна быть интуитивно понятна, т.е. интерфейсы нужно разделять
-  Dependency inversion: модули высокого уровня не должны зависеть от модулей низкого уровня; используя стратегию проблема решается сама собой

Примеры:

S - вместо огромного репозитория используем разные для каждой сущности \
O - вместо передачи параметров в какой-то метод и проверки через условия, лучше создать новый класс \
L - например, toString(): пример не очень хороший, но понятный; такой метод лучше не изменять у обычных сущностей, у которых он и так хорошо отрабатывает \
I - не должно быть такого, что есть какой-то интерфейс IService с кучей методов, часть из которых не используется в тех или иных реализациях; методы нужно разделять в соответствии со своими обязанностями \
D - если у нас есть класс логирования в консоль и класс логирования на почту, мы должны не напрямую создавать объекты таких классов, а использовать переходный класс, в который мы передаём объект нам нужного класса; это позволяет отделить логику работы с классом от внешнего компонента
