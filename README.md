Фінальний проєкт. ВАРІАНТ 5: Сервіс доставки їжі

Автентифікація:

![image](https://github.com/user-attachments/assets/92e4dc03-e925-40cf-b07b-8ef7de990eab)

Головна сторінка:

![image](https://github.com/user-attachments/assets/53794d14-b7f7-416f-965d-bec771d15865)

Сутності:

Restaurant (id, name, city, rating)

MenuItem (id, restaurantId, name, price)

DeliveryOrder (id, customerName, address, restaurantId, totalPrice)

Приклади запитів:

🔹 RestaurantController

GET /restaurants — всі ресторани

![image](https://github.com/user-attachments/assets/532b8aec-9afe-440c-8c62-6cc7e86ee07c)

POST /restaurants — додати ресторан

![image](https://github.com/user-attachments/assets/4e011279-2907-4573-bbda-b68846499fa0)

GET /restaurants/{id} — ресторан за ID

![image](https://github.com/user-attachments/assets/e6d53b30-fa2d-4e4a-8fc8-083014d2033d)

🔹 MenuItemController

GET /menu/{restaurantId} — меню ресторану

![image](https://github.com/user-attachments/assets/c5dc7e90-0a67-47d3-9e4d-38cc0735bd2c)

POST /menu — додати позицію в меню

![image](https://github.com/user-attachments/assets/056aded2-d2c9-41e5-b66d-d4f98f813e98)


🔹 DeliveryOrderController

POST /orders — оформити замовлення

![image](https://github.com/user-attachments/assets/5ec1e8c5-195d-46b4-82d1-c8fe816bbabe)

GET /orders/by-customer — перегляд замовлень по імені

![image](https://github.com/user-attachments/assets/1f251db5-fd3f-4e6b-83d7-3d9b768eecaa)
