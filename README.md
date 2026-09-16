Airline Booking System — Builder Pattern
Project Description

This project implements an Airline Booking System using the Builder Design Pattern.

The main purpose of the project is to demonstrate how the Builder Pattern can simplify the creation of objects with many optional parameters.

The system allows the creattion of airline bookings with passenger, flight, seat, baggage, meal, insurance, priority boarding and route information.

Problem Before Builder Pattern

The initial version of the sysstem used a large constructor:

new Booking(
 bookingId,
 passenger,
 flight,
 seatClass,
 baggageWeight,
 meal,
 insurance,
 priorityBoarding,
 seatNumber,
 route
);

This approach has several problems:

-The constructor contains many parameters.
-It is difficult to remember the order of parameters.
-Optional parameters make object creation harder to read.
-Boolean parameters such as meal, insurance and priorityBoarding are difficult to understand.
-Adding another parameter would make the constructor even more complicated.


Builder Pattern Solution

The Builder Pattern separates object construction from the final Booking object.

Example:

Booking booking = new Booking.Builder("B001", assenger, flight, "Economy")
.seat("12A")
.bagage(20)
.withMeal()
.route(route)
.build();

The fluent API makes the code easier to read because every optional property is explicitly named.

Booking Properties

The booking contains 10 meaningful properties.

Required properties

1.bookingId — String
2.passenger — Passenger
3.flight — Flight
4.seatClass — String

Optional properties

5.seatNumber — String
6.baggageWeight — double
7.meal — boolean
8.insurance — boolean
9.priorityBoarding — boolean
10.route — FlightRoute

The project uses several data types, including String, double, boolean and custom object types.

Validation

The Builder validates the booking before creating the final object.

The validation rules include:

1.Booking ID cannot be empty.
2.Passenger is required.
3.Flight is required.
4S.eat class is required and must be valid.
5.Baggage weight cannot be negative.
6.Baggage weight cannot exceed 50 kg.
7.Priority boarding is not allowed for Economy class.
8.More than 20 kg of baggage requires Business or First class.

The last two rules are cross-field validation rules because they depend on more than one property.

Preset Configurations

The project provides three different booking presets:

Basic

-Economy class
-No extra baggage
-No meal
-No insurance
-No priority boarding

Business

-Business class
-30 kg baggage
-Meal included
-Insurance included
-Priority boarding

Premium

-First class
-40 kg baggage
-Meal included
-Insurance included
-Priority boarding
-Selected seat

Business Process


The BookingService interface defines the main business operations:

-create a booking
-calculate the booking price
-confirm a booking

BookingServiceImpl provides the implementation of these operations.

Automated Testing

The project contains automated JUnit tests.

The tests cover:

-valid Economy booking
-valid Business booking
-valid First Class booking
-missing booking ID
-missing passenger
-missing flight
-negative baggage
-excessive baggage
-invalid priority boarding
-invalid heavy baggage for Economy
-independent products created by the Builder
-valid boundary value of 20 kg baggage

Clean Code

The project applies several Clean Code principles:

-meaningful names
-single responsibility
-small and focused methods
-encapsulation
-avoiding long constructors
-avoiding duplicated object creation logic

Design Decision

The Builder Pattern was selected because the Booking object contains multiple required and optional properties.

A constructor with many parameters is difficult to read and maintain.

An alternative would be JavaBean-style setters, but that approach allows the object to exist in a partially configured state.

The Builder Pattern allows validation before the final Booking object is created.

Project Structure
src/
├── Main.java
├── Booking.java
├── BookingService.java
├── BookingServiceImpl.java
├── BookingPresets.java
├── Passenger.java
├── Flight.java
└── FlightRoute.java

test/
└── BookingTest.java

docs/
└── builder-uml.png

README.md
report.md
Technologies
-Java
-IntelliJ IDEA
-JUnit 5
-Git
-GitHub
-Builder Design Pattern


Author

Student: Angsar Baibossinov
Group: SE-2516