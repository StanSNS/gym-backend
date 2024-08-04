# GymFit

## Description

**GymFit** is a modern e-commerce platform for selling fitness-related products. This backend service, developed using Spring Boot 3, manages product deliveries and ensures product availability through integration with multiple APIs. It uses PostgreSQL for data storage and implements JWT token security for admin access.

## Features

- **Spring Boot 3**: Utilizes the latest version for efficient and scalable backend development.
- **JWT Token Security**: Secures admin endpoints with JSON Web Tokens.
- **PostgreSQL**: Employs PostgreSQL for robust data management.
- **API Integration**: Connects with multiple APIs for data fetching and real-time product availability.
- **Product Management**: Handles product deliveries and availability checks.

## Installation and Setup

**Note:** This project contains sensitive environmental variables and configurations specific to its deployment architecture. As such, no local installation guide is provided.

## Configuration

- **Database**: The backend is configured to connect to a PostgreSQL database. Ensure that the database configuration is set up correctly in the deployment environment.
- **JWT Secret**: JWT tokens are used for securing admin endpoints. The JWT secret key must be configured in the deployment environment.

## Usage

### API Endpoints

- **Product Delivery**
    - **Create Delivery**
        - `POST /api/deliveries`
        - Request Body: `{ "productId": "string", "quantity": "integer", "deliveryAddress": "string" }`
        - Response: `200 OK` on success

    - **Fetch Deliveries**
        - `GET /api/deliveries`
        - Response: List of deliveries

- **Admin Access**
    - Admin endpoints are secured with JWT tokens. Obtain a token by logging into the admin UI and include the token in the `Authorization` header for requests.

### Open Endpoints

- All publicly accessible endpoints can be found in the `controller` folder. Use these endpoints to interact with the service and test its functionalities.

## Testing

There are no tests included with this project.

## Contributing

Contributions are not currently being accepted.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
