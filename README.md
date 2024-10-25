# Cinema Room REST Service

## Overview

This project is a **Cinema Room REST Service** built with **Java** and **Spring Boot**. The application provides RESTful APIs for managing a virtual cinema room, allowing users to view available seats, purchase tickets, refund tickets, and view overall statistics of the cinema. It is a simple yet effective demonstration of using REST principles to manage a booking system.

## Features

- **View Available Seats**: Retrieve information about all available seats in the cinema.
- **Purchase a Ticket**: Allows users to book available seats by specifying row and column numbers.
- **Refund a Ticket**: Users can refund a ticket using a unique token generated at purchase.
- **Cinema Statistics**: Provides statistics on the number of available and purchased tickets and the income generated (restricted to authorized users).

## Technologies Used

- **Java 11**: Main programming language for backend development.
- **Spring Boot**: Framework used for creating the RESTful API.
- **Gradle**: Build automation tool.

## API Endpoints

### 1. View Available Seats
- **URL**: `/seats`
- **Method**: `GET`
- **Response**: List of all available seats, including their row, column, and price.

### 2. Purchase a Ticket
- **URL**: `/purchase`
- **Method**: `POST`
- **Request Body**:
{
  "row": 3,
  "column": 4
}
- **Response**: A ticket object containing a unique token, row, column, and price.

### 3. Refund a Ticket
- **URL**: `/return`
- **Method**: `POST`
- **Request Body**:
{
  "token": "<token>"
}
- **Response**: The refunded ticket details (row, column, and price).

### 4. Get Cinema Statistics
- **URL**: `/stats`
- **Method**: `GET`
- **Request Parameters**: Requires a password (`password=super_secret`).
- **Response**: Income generated, number of available seats, and number of tickets purchased.