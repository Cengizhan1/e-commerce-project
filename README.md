# Project Information

This project is an ongoing development of a microservices-based application. Below, you can find information about the services used in the project and their features.

## Services

1. **Naming Server (EUREKA)**
2. **Config Server**
3. **Identity Service**
4. **Api Gateway**
5. **Product Service**
    - **Product**
        - id
        - name (string)
        - description (string)
        - description_short (string)
        - price (float)
        - stockState (StockState)
        - stockCount
        - category (ProductCategory)
        - code (string)
        - avgRating
    - **ProductCategory**
        - id
        - name (string)
        - description (string)
        - description_short (string)
    - **Review**
        - id
        - productId
        - userId
        - review (string)
        - rating (integer)
        - date (Date)

6. **User Service**
7. **Wallet Service**
    - **Wallet**
    - **Transactions**
8. **Payment Service**
9. **Basket Service**
10. **Order Service** (Optional)

## Technologies Used

- Java
- Spring Boot
- Microservice
- Spring Cloud
- Spring Security
- Layered Architecture
- Feign
- Resilience4j
- Docker
- Spring Data
- Naming Server (Eureka)
- Zipkin
- Postman
- Redis
- MySQL

## Optional Enhancements

- Campaigns and discounts can be added.

