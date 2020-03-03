hfdp - Head First Design Patterns
---------------------------------

#### Strategy 	- Chapter 1. Welcome to Design Patterns  
The Strategy Pattern defines a family of algorithms, encapsulates each one,
and makes them interchangeable.
Strategy lets the algorithm vary independently from clients that use it.  

#### Observer    - Chapter 2. Keeping your Objects in the know.  
The Observer Pattern defines a one-to-many dependency between 
objects so that when one object changes measurements, all of its dependents
are notified and updated automatically.

#### Decorator   - Chapter 3. Decorating Objects.  
The Decorator Pattern attaches additional responsibilities to an object
dynamically. Decorators provide a flexible alternative to subclassing 
for extending functionality.

#### Factory     - Chapter 4. Baking with OO Goodness.
All Factory patterns encapsulate object creation.  
The Factory Method Pattern defines an interface for creating an object, 
but lets subclass decide which class to instantiate. Factory Method lets
a class defer instantiation to subclasses.


#### Singleton   - Chapter 5. One of a Kind Objects.

The Singleton Pattern ensures a class has only one instance, and provides 
a global point of access to it.


#### Command    - Chapter 6. Encapsulating Invocation.

The Command Pattern encapsulates a request as an object, thereby letting you
parameterize other objects with different requests, queue or log requests,
and support undoable operations.


#### Adapter and Facade     - Chapter 7. Being Adaptive.

The Adapter Pattern converts the interface of a class into another interface
the clients expect. Adapter lets classes work together that couldn't otherwise
because of incompatible interfaces.

The Facade Pattern provides a unified interface to a set of interfaces 
in a subsystem. Facade defines a higher level interface that makes 
the subsystem easier to use.

Facades and Adapters may wrap multiple classes, but a facade's intent
is to __simplify__, while an adapter's is to __convert__ the interface
to something different.


#### Template Method    - Chapter 8. Encapsulating Algorithms

The Template Method Pattern defines the skeleton of an algorithm in a method,
deferring some steps to subclasses. Template Method lets subclasses redefine
certain steps of an algorithm without changing the algorithm's structure.
