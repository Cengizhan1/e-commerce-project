## Bu projenin geliştirmeleri devam ediyor. Aşağıdaki bütün servisler eklenecektir.
## Servisler

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
8. **Payment Service**
9. **Basket Service**
10. **Order Service** (Opsiyonel)

### Opsiyonel Geliştirmeler

- Kampanya ve indirim eklenebilir.
