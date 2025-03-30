# Vending Machine - Low-Level Design (LLD)

## Overview

This document provides the **Low-Level Design (LLD)** for a **Vending Machine** system that meets all functional and non-functional requirements, including concurrency handling, a state machine implementation, and support for Indian currency (both coins and notes).

## Features

- Supports multiple products with different **prices and quantities**.
- Accepts **both coins and notes** (Indian currency denominations).
- Dispenses the selected product and returns change if necessary.
- Tracks the availability of products and their quantities.
- Handles **multiple transactions concurrently** and ensures data consistency.
- Provides an interface for **restocking products** and **collecting money**.
- Implements a **State Machine** with different states.

## State Machine

The vending machine operates in **four different states**:

1. **IdleState** → Waiting for user input.
2. **ReadyState** → Money has been inserted, waiting for product selection.
3. **DispenseState** → Product is being dispensed.
4. **ReturnChangeState** → Returning the remaining change.

## Indian Currency Support

The vending machine accepts the following **coins and notes**:

- **Coins**: ₹1, ₹2
- **Notes**: ₹10, ₹20, ₹50, ₹100

## UML Diagram

The UML diagram for the vending machine is as follows:

## Class Design

### 1. **Product**

```java
class Product {
    private final String name;
    private final int code;
    private final double price;
    // Getters & Constructors
}
```

### 2. **Inventory (Thread-Safe)**

```java
class Inventory {
    private final Map<Product, Integer> stock = new HashMap<>();
    public synchronized void addProduct(Product product, int quantity);
    public synchronized boolean isAvailable(Product product);
    public synchronized void dispenseProduct(Product product);
}
```

### 3. **PaymentProcessor (Thread-Safe)**

```java
class PaymentProcessor {
    private double balance = 0.0;
    public synchronized void acceptPayment(List<Money> moneyList);
    public synchronized boolean hasSufficientFunds(double cost);
    public synchronized double returnChange(double cost);
}
```

### 4. **Vending Machine State Interface**

```java
interface VendingState {
    void insertMoney(List<Money> money);
    void selectProduct(int code);
    void dispenseProduct();
    void returnChange();
}
```

### 5. **State Implementations**

#### **IdleState**

```java
class IdleState implements VendingState {
    public void insertMoney(List<Money> money);
    public void selectProduct(int code);
    public void dispenseProduct();
    public void returnChange();
}
```

#### **ReadyState**

```java
class ReadyState implements VendingState {
    public void insertMoney(List<Money> money);
    public void selectProduct(int code);
    public void dispenseProduct();
    public void returnChange();
}
```
