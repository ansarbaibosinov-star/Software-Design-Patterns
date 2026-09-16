Design Patterns Assignment 1 Report
1.Project Overview

The project is an Airline Booking System implemented in Java.

The main design pattern used in the project is the Builder Pattern. It is used to create airline bookings that contain both required and optional information.

A booking contains information about the passenger, flight, seat class, seat number, baggage, meal, insurance, priority boarding, and flight route.

2.Initial Constructor-Based Approach

At the beginning of the project, the booking was created using a large constructor.

For example:

new Booking(
"B001",
passenger,
flight,
"Economy",
20,
true,
false,
false,
"12A",
route
);

This approach works, but it becomes harder to understand when there are many optional parameters.

For example, it is not immedioately clear what the values true, false, false mean. The developer has to remember which parameter represents the meal, insurance, and priority boarding.

If more optional properties are added, the constructor becomes even longer and harder to use.

3.Problems with the Initial Approach

The constructor-based approach has several problems:

It has too many parameters.
The parameter order must be remembered.
Boolean values are not very clear.
Adding new properties requires changing the constructor.
The code is harder to read and maintain.
4.Builder Pattern Implementation

To solve these problems, the Builder Pattern was introduced.

The required properties are passed to the Builder constructor:

new Booking.Builder(
"B001",
passenger,
flight,
"Economy"
)

Optional properties are added using fluent methods:

.seat("12A")
.baggage(20)
.withMeal()
.route(route)
.build();

The build() method creates the final Booking object.

5.Properties

The Booking class contains 10 meaningful properties.

Required properties:

bookingId — String
passenger — Passenger
flight — Flight
seatClass — String

Optional properties:

seatNumber — String
baggageWeight — double
meal — boolean
insurance — boolean
priorityBoarding — boolean
route — FlightRoute

The project uses diofferent data types and custom objects.

6.Fluent API

The Builder uses method chaining to configure optional properties.

For example:

Booking booking = new Booking.Builder(
"B001",
passenger,
flight,
"Economy"
)
.seat("12A")
.baggage(20)
.withMeal()
.route(route)
.build();

Each method returns the Builder, which allows the methods to be chained together.

7.Validation

Validation is performed before the Booking object is created.

The main validation rules are:

Booking ID cannot be empty.
Passenger cannot be null.
Flight cannot be null.
Baggage cannot be negative.
Baggage cannot exceed 50 kg.
Seat class must be valid.
Priority boarding is not allowed for Economy.
More than 20 kg of baggage requires Business or First class.

The last two rules are cross-fiedld validation rules.

8.Preset Configurations

The project contains three preset configurations.

Basic: Economy class with 20 kg baggage.

Business: Business class with 30 kg baggage, meal, insurance, priority boarding and seat selection.

Premium: First class with 40 kg baggage, meal, insurance, priority boarding and seat selection.

The presets provide different ready-to-use Builder configurations.

9.Business Process

The project contains a BookingService interface and a BookingServiceImpl class.

The service provides three operations:

createBooking()
calculatePrice()
confirmBooking()

This separates business operations from the construction of the Booking object.

10.Automated Tests

JUnit 5 is used for automated testing.

The project contains 12 tests covering valid bookings, invalid required fields, invalid baggage values, cross-field validation and Builder behavior.

One test also checks that changing a Builder and creating another booking does not change an already created booking.

11.Clean Code

Several Clean Code principles were applied:

meaningful names;
encapsulation;
avoiding long constructors;
single responsibility;
avoiding duplicated construction logic.

The Builder makes the object creation code easier to understand.

12.Design Decision

The Builder Pattern was selected because the Booking object has several required and optional properties.

Setters were also considered, but setters allow an object to exist before it is completely configured.

With the Builder, the properties are configured first and the final object is created using build().

13.UML

The UML diagram represents the main classes used in the project:

Booking
Booking.Builder
Passenger
Flight
FlightRoute
BookingService
BookingServiceImpl
BookingPresets

The UML diagram is stored in:

docs/builder-uml.png

14.Git Development Process

The project was developed using meaningful Git commits.

Examples include:

Add initial airlinee booking domain model
Add constructor-based booking implementation
Refactor booking creation using Builder Pattern
Add booking validation rules
Add booking service and preset configurations
Add automated tests
Add UML and project documentation

Each commit represents a separate development step.

15.Conclusion

The project demonstrates how the Builder Pattern can simplify the creation of an airline booking with many optional properties.

The final implementation includes 10 properties, a fluent Builder API, validation rules, cross-field validation, three presets, a business service, automated tests, Clean Code improvements and UML documentation.

The Builder makes the booking creation code easier to read, maintain and extend.