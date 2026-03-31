# Health Clinic Management System

## Overview
A Java-based health clinic management system implementing patient management, doctor management, appointment scheduling, and billing operations using JDBC.

## Database Setup
1. Run `schema.sql` to create database and tables
2. Update database credentials in `DatabaseConnection.java`

## Features

### Patient Management
- Register new patients with auto-generated ID
- Update patient information
- Search patients by name, phone, or ID
- View patient visit history

### Doctor Management
- Add doctor profiles with specialty
- Update doctor specialty
- View doctors by specialty
- Deactivate doctor profiles

### Appointment Scheduling
- Book appointments with availability check
- Cancel appointments
- Reschedule appointments
- View daily appointment schedule

### Billing & Payments
- Generate bills for visits
- Record payments
- View outstanding bills
- Generate revenue reports

## Key Database Concepts
- Primary/Foreign Keys with auto-increment
- INNER/LEFT JOINs for multi-table queries
- Transactions (COMMIT/ROLLBACK)
- PreparedStatements for SQL injection prevention
- Aggregate functions (COUNT, SUM)
- Indexes on frequently queried columns

## Usage
Run `HealthClinicApp.java` and follow the menu-driven interface.
