## Bu projenin geliştirmeleri devam ediyor. Aşağıdaki bütün servisler eklenecektir.
## Servisler

1. **Naming Server (EUREKA)**
2. **Config Server**
3. **Api Gateway**
4. **Product Service**
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
  
5. **User Service**
6. **Payment Service**
7. **Basket Service**
8. **Order Service** (Opsiyonel)

### Opsiyonel Geliştirmeler

- Kampanya ve indirim eklenebilir.
