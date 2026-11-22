# JavaFX MVCI Stub Project

This project is a minimal starting point for building JavaFX applications using the **MVCI (Model-View-Controller-Interactor)** architectural pattern.

It is intended to accompany the **JavaFX MVCI Guide** and provides a clean project structure that can be copied and expanded when starting a new MVCI application.

The goal of this stub is not to demonstrate a complete application. Instead, it provides the basic framework and Main MVCI needed to begin one.

---

## Requirements

- **Java 21**
- **JavaFX**
- **Gradle**
- A Java IDE such as IntelliJ IDEA

### Recommended JDK

For simplicity, this project is designed to work well with a Java 21 OpenJDK distribution that includes JavaFX.

One such distribution is **BellSoft Liberica JDK Full**.

The `Full` edition of Liberica includes JavaFX with the JDK, which significantly simplifies JavaFX development because a separate JavaFX SDK does not need to be downloaded and configured.

Other OpenJDK distributions that include JavaFX may also be used.

Using a JDK with JavaFX bundled is recommended for this project because it keeps the initial setup focused on learning and using MVCI rather than configuring JavaFX separately.

---

## Project Structure

The basic source structure is:

```text
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── mvci/
│   │               ├── framework/
│   │               │   ├── ControllerBase.java
│   │               │   ├── InteractorBase.java
│   │               │   └── ViewBase.java
│   │               │
│   │               └── main/
│   │                   ├── MainController.java
│   │                   ├── MainInteractor.java
│   │                   ├── MainModel.java
│   │                   ├── MainView.java
│   │                   └── MainMessage.java
│   │
│   └── resources/
│
└── test/
    ├── java/
    └── resources/
```

The JavaFX `Application` class serves as the entry point and launches the Main MVCI.

---

## MVCI Components

Each MVCI unit separates responsibilities into four primary components.

### Model

The **Model** contains the observable state of the MVCI.

Models generally expose JavaFX properties and collections that can be observed by the View.

The Model should not contain business logic.

### View

The **View** constructs the JavaFX user interface.

This implementation builds the interface directly in Java and **does not use FXML**.

Views implement the JavaFX `Builder` pattern and return the root `Region` representing their portion of the scene graph.

The View observes its Model and sends user actions to its Controller.

### Controller

The **Controller** coordinates the MVCI unit.

It owns the Model, Interactor, and View and establishes the relationships between them.

The Controller receives actions from the View and delegates application work to the Interactor.

Business logic should not be placed in the Controller.

### Interactor

The **Interactor** contains the application's business logic.

It performs operations requested by the Controller, communicates with repositories or services when necessary, and updates the Model with the resulting state.

The Interactor should not directly manipulate JavaFX controls.

---

## Basic MVCI Flow

A typical user action follows this path:

```text
User
  ↓
View
  ↓
Controller
  ↓
Interactor
  ↓
Model
  ↓
View
```

The important distinction is that the View is updated from observable state contained in the Model rather than being directly manipulated by the Interactor.

This separation allows each component to remain focused on a specific responsibility.

---

## Multiple MVCIs

Larger applications should be divided into multiple MVCI units.

For example:

```text
Main MVCI
Settings MVCI
Notes MVCI
Parts MVCI
```

An MVCI should not directly reach into another MVCI's Model, View, or Interactor.

Communication between MVCIs is coordinated through the application's **MainController**.

This keeps each MVCI independent while still allowing complex application workflows to be built from smaller units.

---

## Running the Stub

Open the project in IntelliJ IDEA or another Java IDE and configure the project to use a Java 21 JDK that includes JavaFX.

For example:

```text
BellSoft Liberica JDK 21 Full
```

Then run the JavaFX application entry point.

The stub should open a small JavaFX window supplied by the Main MVCI.

From there, additional MVCI units can be added as the application grows.

---

## Starting a New MVCI

When adding another feature, create a new package for that MVCI.

For example:

```text
com.example.mvci.settings
```

A typical MVCI package may contain:

```text
SettingsController.java
SettingsInteractor.java
SettingsModel.java
SettingsView.java
SettingsMessage.java
```

The new MVCI should follow the same separation of responsibilities demonstrated by the Main MVCI.

---

## What This Project Is

This project is intentionally a **stub**.

It provides:

- A working JavaFX application
- The base MVCI framework classes
- A minimal Main MVCI
- A starting package structure
- A consistent architecture for expanding the application

It intentionally does **not** provide significant application functionality.

For a working demonstration of multiple MVCIs communicating with each other, see the companion **MVCI Example Project**.

For assistance from an AI coding tool, use the companion **MVCI AI Prompt**, which explains the architectural rules the AI should follow when modifying an MVCI application.

---

## Design Philosophy

MVCI is used here to provide consistent separation of concerns while allowing application complexity to grow without allowing responsibilities to become tangled.

The architecture is intentionally explicit.

A View builds and displays the interface.

A Controller coordinates.

An Interactor performs the work.

A Model represents state.

As the application grows, those boundaries remain the same.