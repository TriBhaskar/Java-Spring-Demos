# Design Patterns Project

## Overview
This project demonstrates various design patterns implemented in Java. Each pattern is implemented with a focus on clarity and adherence to best practices.

## Patterns Implemented
1. **Builder Pattern**
    - Demonstrates the step-by-step construction of complex objects.
    - Example: Building `Car` and `Manual` objects using different builders.

2. **Abstract Factory Pattern**
    - Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
    - Example: Creating furniture sets (Chair, Sofa, Coffee Table) in different styles (Modern, Victorian, Art Deco).

3. **Factory Method Pattern**
    - Defines an interface for creating an object but lets subclasses alter the type of objects that will be created.
    - Example: Creating vehicles (Car, Motorcycle, Truck) using factories.

4. **Simple Factory Pattern**
    - A simpler version of the Factory Method pattern for creating objects based on a parameter.
    - Example: Creating vehicles dynamically based on a string input.

## Learning Resource
To learn and implement these patterns, I referred to the following resource:
[Refactoring.Guru - Design Patterns](https://refactoring.guru/design-patterns)

## How to Run
1. Clone the repository.
2. Build the project using Maven:
   ```bash
   mvn clean install