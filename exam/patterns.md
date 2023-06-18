# Паттерны

## Порождающие

### Синглтон

```java
public class Singleton {
   private Singleton instance;

   public synchronized Singleton getInstance() {
      if(instance == null) {
         instance = new Singleton();
         return instance;
      }

      return instance;
   }
}
```

### Фабричный метод

```java
interface Vehicle {
   void drive();
}

class Car implements Vehicle {
   @Override
   public void drive() {}
}
class Motorcycle  implements Vehicle {
   @Override
   public void drive() {}
}

interface VehicleFactory {
   Vehicle createVehicle();
}

class CarFactory implements VehicleFactory {
   @Override
   public Vehicle createVehicle() {
      return new Car();
   }
}
class MotorcycleFactory implements VehicleFactory {
   @Override
   public Vehicle createVehicle() {
      return new Motorcycle();
   }
}
```

---

### Абстрактная фабрика

```java
interface Shape {
    void draw();
}
interface Color {
   void fill();
}

class Circle implements Shape {
   @Override
   public void draw() {}
}
class Red implements Color {
   @Override
   public void fill() {}
}

class Square implements Shape {
   @Override
   public void draw() {}
}
class Blue implements Color {
   @Override
   public void fill() {}
}

interface AbstractFactory {
   Shape createShape();
   Color createColor();
}

class Factory1 implements AbstractFactory {
   @Override
   public Shape createShape() {
      return new Circle();
   }

   @Override
   public Color createColor() {
      return new Red();
   }
}
class Factory2 implements AbstractFactory {
   @Override
   public Shape createShape() {
      return new Square();
   }

   @Override
   public Color createColor() {
      return new Blue();
   }
}
```

---

### Строитель

```java
class Product {
   private String partA;
   private String partB;

   public void setPartA(String partA) {
      this.partA = partA;
   }

   public void setPartB(String partB) {
      this.partB = partB;
   }

   public void show() {
      System.out.println("Product parts:");
      System.out.println("Part A: " + partA);
      System.out.println("Part B: " + partB);
   }
}

interface Builder {
   void buildPartA();
   void buildPartB();
   Product getResult();
}

class ConcreteBuilder implements Builder {
   private final Product product;

   public ConcreteBuilder() {
      this.product = new Product();
   }

   @Override
   public void buildPartA() {
      product.setPartA("Part A");
   }

   @Override
   public void buildPartB() {
      product.setPartB("Part B");
   }

   @Override
   public Product getResult() {
      return product;
   }
}

class Director {
   public void construct(Builder builder) {
      builder.buildPartA();
      builder.buildPartB();
   }
}

class Main {
   public static void main(String[] args) {
      Director director = new Director();

      Builder builder = new ConcreteBuilder();
      director.construct(builder);

      Product product = builder.getResult();
      product.show();
   }
}
```

---

### Прототип

```java
@Getter
@Setter
abstract class Prototype {
   public int id;

   public Prototype(int id) {
      this.id = id;
   }

   public abstract Prototype clone();
}

class ConcretePrototype1 extends Prototype {
   public ConcretePrototype1(int id) {
      super(id);
   }

   @Override
   public Prototype clone() {
      return new ConcretePrototype1(id);
   }
}
class ConcretePrototype2 extends Prototype {
   public ConcretePrototype2(int id) {
      super(id);
   }

   @Override
   public Prototype clone() {
      return new ConcretePrototype2(id);
   }
}
```

---

## Структурные

### Адаптер

```java
interface MediaPlayer {
   void play(String fileName);
}

class Mp3Player implements MediaPlayer {
   public void play(String fileName) {}
}
class Mp4Player implements MediaPlayer {
   public void play(String fileName) {}
}

class Mp3Adapter implements MediaPlayer {
   private final MediaPlayer player;

   public Mp3Adapter(String audioType) {
      if (audioType.equalsIgnoreCase("mp3")) {
         player = new Mp3Player();
      } else {
         player = new Mp4Player();
      }
   }

   @Override
   public void play(String fileName) {
      player.play(fileName);
   }
}
```

---

### Мост

```java
interface Color {
   void applyColor();
}

class Red implements Color {
   @Override
   public void applyColor() {}
}
class Blue implements Color {
   @Override
   public void applyColor() {}
}

abstract class Shape {
   protected Color color;

   public Shape(Color color) {
      this.color = color;
   }

   public void setColor(Color color) {
      this.color = color;
   }

   public abstract void draw();
}

class Square extends Shape {
   public Square(Color color) {
      super(color);
   }

   @Override
   public void draw() {
      //
      color.applyColor();
   }
}
class Circle extends Shape {
   public Circle(Color color) {
      super(color);
   }

   @Override
   public void draw() {
      //
      color.applyColor();
   }
}
```

---

### Компоновщик

```java
interface Shape {
   void draw();
}

class Circle implements Shape {
   @Override
   public void draw() {}
}
class Square implements Shape {
   @Override
   public void draw() {}
}

class Group implements Shape {
   private final List<Shape> shapes = new ArrayList<>();

   public void addShape(Shape shape) {
      shapes.add(shape);
   }

   public void removeShape(Shape shape) {
      shapes.remove(shape);
   }

   @Override
   public void draw() {
      //
      shapes.forEach(Shape::draw);
   }
}
```

---

### Декоратор

```java
interface Pizza {
   String getDescription();
   double getCost();
}

class Margherita implements Pizza {
   @Override
   public String getDescription() {
      return "Margherita";
   }

   @Override
   public double getCost() {
      return 7.00;
   }
}

abstract class PizzaDecorator implements Pizza {
   protected Pizza pizza;

   public PizzaDecorator(Pizza pizza) {
      this.pizza = pizza;
   }

   @Override
   public String getDescription() {
      return pizza.getDescription();
   }

   @Override
   public double getCost() {
      return pizza.getCost();
   }
}

class CheeseDecorator extends PizzaDecorator {
   public CheeseDecorator(Pizza pizza) {
      super(pizza);
   }

   @Override
   public String getDescription() {
      return super.getDescription() + " with extra cheese";
   }

   @Override
   public double getCost() {
      return super.getCost() + 2
   }
}
class MushroomDecorator extends PizzaDecorator {
   public MushroomDecorator(Pizza pizza) {
      super(pizza);
   }

   @Override
   public String getDescription() {
      return super.getDescription() + " with mushrooms";
   }

   @Override
   public double getCost() {
      return super.getCost() + 1;
   }
}

class Main {
   public static void main(String[] args) {
      Pizza margherita = new Margherita();
      Pizza ultraMargherita = new CheeseDecorator(new MushroomDecorator(margherita));

      System.out.println(ultraMargherita.getDescription());
      System.out.println(ultraMargherita.getCost());
   }
}
```

---

### Фасад

```java
class SubsystemA {
   public void operationA() {}
}
class SubsystemB {
   public void operationB() {}
}
class SubsystemC {
   public void operationC() {}
}

class Facade {
   private final SubsystemA subsystemA;
   private final SubsystemB subsystemB;
   private final SubsystemC subsystemC;

   public Facade() {
      subsystemA = new SubsystemA();
      subsystemB = new SubsystemB();
      subsystemC = new SubsystemC();
   }

   public void operation1() {
      subsystemA.operationA();
      subsystemB.operationB();
   }

   public void operation2() {
      subsystemB.operationB();
      subsystemC.operationC();
   }
}
```

---

### Легковес

```java
interface Shape {
   void draw();
}

class Circle implements Shape {
   private String color;
   private int x;
   private int y;
   private int radius;

   public Circle(String color) {
      this.color = color;
   }

   public void setX(int x) {
      this.x = x;
   }

   public void setY(int y) {
      this.y = y;
   }

   public void setRadius(int radius) {
      this.radius = radius;
   }

   @Override
   public void draw() {}
}

class ShapeFactory {
   private static final Map<String, Shape> circleMap = new HashMap<>();

   public static Shape getCircle(String color) {
      Circle circle = (Circle) circleMap.get(color);

      if (circle == null) {
         circle = new Circle(color);
         circleMap.put(color, circle);
      }

      return circle;
   }
}
```

---

### Заместитель

```java
interface Image {
   void display();
}

class RealImage implements Image {
   private final String filename;

   public RealImage(String filename) {
      this.filename = filename;
   }

   @Override
   public void display() {}
}

class ImageProxy implements Image {
   private final String filename;
   private Image image;

   public ImageProxy(String filename) {
      this.filename = filename;
   }

   @Override
   public void display() {
      if (image == null) {
         image = new RealImage(filename);
      }

      image.display();
   }
}
```

---

## Поведенческие

### Цепочка обязанностей

```java
class Request {
   private final String type;

   public Request(String type) {
      this.type = type;
   }

   public String getType() {
      return type;
   }
}

interface Handler {
   void setNextHandler(Handler nextHandler);
   void handleRequest(Request request);
}

class ConcreteHandler1 implements Handler {
   private Handler nextHandler;

   @Override
   public void setNextHandler(Handler nextHandler) {
      this.nextHandler = nextHandler;
   }

   @Override
   public void handleRequest(Request request) {
      if (request.getType().equals("type1")) {
         System.out.println("ConcreteHandler1");
      } else if (nextHandler != null) {
         nextHandler.handleRequest(request);
      } else {
         System.out.println("End of chain");
      }
   }
}
class ConcreteHandler2 implements Handler {
   private Handler nextHandler;

   @Override
   public void setNextHandler(Handler nextHandler) {
      this.nextHandler = nextHandler;
   }

   @Override
   public void handleRequest(Request request) {
      if (request.getType().equals("type2")) {
         System.out.println("ConcreteHandler2");
      } else if (nextHandler != null) {
         nextHandler.handleRequest(request);
      } else {
         System.out.println("End of chain");
      }
   }
}
```

---

### Команда

```java
interface Command {
   void exec();
}

class Light {
   public void turnOn() {}
   public void turnOff() {}
}

class TurnOnLightCommand implements Command {
   private final Light light;

   public TurnOnLightCommand(Light light) {
      this.light = light;
   }

   @Override
   public void exec() {
      light.turnOn();
   }
}
class TurnOffLightCommand implements Command {
   private final Light light;

   public TurnOffLightCommand(Light light) {
      this.light = light;
   }

   @Override
   public void exec() {
      light.turnOff();
   }
}

class RemoteControl {
   private Command command;

   public void setCommand(Command command) {
      this.command = command;
   }

   public void pressBtn() {
      command.exec();
   }
}
```

---

### Итератор

```java
class CustomCollection implements Iterable<String> {
   private String[] elements;
   private int size;

   public CustomCollection() {
      elements = new String[10];
      size = 0;
   }

   public void add(String element) {
      if (size < elements.length) {
         elements[size] = element;
         size++;
      }
   }

   @Override
   public Iterator<String> iterator() {
      return new CustomIterator();
   }

   private class CustomIterator implements Iterator<String> {
      private int currentIndex;
      public CustomIterator() {
         currentIndex = 0;
      }

      @Override
      public boolean hasNext() {
         return currentIndex < size && elements[currentIndex] != null;
      }

      @Override
      public String next() {
         String element = elements[currentIndex];
         currentIndex++;
         return element;
      }
   }
}
```

---

### Посредник

```java
interface Colleague {
   void sendMessage(String message);
   void receiveMessage(String message);
}

interface Mediator {
   void sendMessage(String message, Colleague colleague);
}

class ChatMediator implements Mediator {
   private final List<Colleague> colleagues;

   public ChatMediator() {
      colleagues = new ArrayList<>();
   }

   public void addColleague(Colleague colleague) {
      colleagues.add(colleague);
   }

   @Override
   public void sendMessage(String message, Colleague colleague) {
      for (Colleague c : colleagues) {
         if (c != colleague) {
               c.receiveMessage(message);
         }
      }
   }
}

class User implements Colleague {
   private final String name;
   private final Mediator mediator;

   public User(String name, Mediator mediator) {
      this.name = name;
      this.mediator = mediator;
   }

   @Override
   public void sendMessage(String message) {
      //
      mediator.sendMessage(message, this);
   }

   @Override
   public void receiveMessage(String message) {}
}
```

---

### Снимок

```java
package com.example.tests.patterns.behavior;

class Memento {
   private String state;

   public Memento(String state) {
      this.state = state;
   }

   public String getState() {
      return state;
   }
}

class Originator {
   private String state;

   public String getState() {
      return state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public Memento saveStateToMemento() {
      return new Memento(state);
   }

   public void restoreStateFromMemento(Memento memento) {
      state = memento.getState();
   }
}

class Caretaker {
   private Memento memento;

   public void setMemento(Memento memento) {
      this.memento = memento;
   }

   public Memento getMemento() {
      return memento;
   }
}

class Main {
   public static void main(String[] args) {
      Originator originator = new Originator();
      Caretaker caretaker = new Caretaker();

      originator.setState("State 1");
      //

      caretaker.setMemento(originator.saveStateToMemento());
      originator.setState("State 2");
      //

      originator.restoreStateFromMemento(caretaker.getMemento());
      //
   }
}
```

---

### Наблюдатель

```java
interface Observer {
	void update();
}

interface Subject {
	void registerObserver(Observer observer);
	void unregisterObserver(Observer observer);
	void notifyObservers();
}

class ConcreteSubject implements Subject {
	private final List<Observer> observers = new ArrayList<>();
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyObservers();
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void unregisterObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		observers.forEach(Observer::update);
	}
}

class ConcreteObserver1 implements Observer {
	private final ConcreteSubject subject;

	public ConcreteObserver1(ConcreteSubject subject) {
		this.subject = subject;
		this.subject.registerObserver(this);
	}

	@Override
	public void update() {
		System.out.println(subject.getState());
	}
}
class ConcreteObserver2 implements Observer {
	private final ConcreteSubject subject;

	public ConcreteObserver2(ConcreteSubject subject) {
		this.subject = subject;
		this.subject.registerObserver(this);
	}

	@Override
	public void update() {
		System.out.println(subject.getState());
	}
}
```

---

### Состояние

```java
interface State {
	void handle(Context context);
}

class Context {
	private State state;

	public Context() {
		state = new ConcreteStateA();
	}

	public void setState(State state) {
		this.state = state;
	}

	public void request() {
		state.handle(this);
	}
}

class ConcreteStateA implements State {
	@Override
	public void handle(Context context) {
		System.out.println("ConcreteStateA");
		context.setState(new ConcreteStateB());
	}
}
class ConcreteStateB implements State {
	@Override
	public void handle(Context context) {
		System.out.println("ConcreteStateB");
		context.setState(new ConcreteStateA());
	}
}
```

---

### Стратегия

```java
interface SortingStrategy {
	void sort(int[] array);
}

class BubbleSortStrategy implements SortingStrategy {
	@Override
	public void sort(int[] array) {}
}
class QuickSortStrategy implements SortingStrategy {
	@Override
	public void sort(int[] array) {}
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
```

---

### Шаблонный метод

```java
abstract class Game {
	abstract void initialize();
	abstract void start();
	abstract void end();

	public final void play() {
		initialize();
		start();
		end();
	}
}

class Football extends Game {
	@Override
	void initialize() {}

	@Override
	void start() {}

	@Override
	void end() {}
}
class Cricket extends Game {
	@Override
	void initialize() {}

	@Override
	void start() {}

	@Override
	void end() {}
}
```

---

### Посетитель

```java
interface Element {
	void accept(Visitor visitor);
}

class ElementA implements Element {
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public void operationA() {}
}
class ElementB implements Element {
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public void operationB() {}
}

interface Visitor {
	void visit(ElementA element);
	void visit(ElementB element);
}

class ConcreteVisitor implements Visitor {
	@Override
	public void visit(ElementA element) {
		element.operationA();
		//
	}

	@Override
	public void visit(ElementB element) {
		element.operationB();
		//
	}
}

class Main {
	public static void main(String[] args) {
		Element[] elements = {new ElementA(), new ElementB()};
		Visitor visitor = new ConcreteVisitor();

		for (Element element : elements) {
			element.accept(visitor);
		}
	}
}
```
