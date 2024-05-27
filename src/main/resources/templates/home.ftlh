<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <style>
        body {
            background-color: #ADD8E6; /* Світло-голубий фон */
            font-family: Arial, sans-serif;
            text-align: center;
            padding: 50px;
        }
        h1 {
            color: #333;
        }
        .button-container {
            display: flex;
            justify-content: center;
            gap: 20px;
            margin-top: 30px;
        }
        .button {
            background-color: #4CAF50; /* Зелений фон кнопок */
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 8px;
        }
        .button:hover {
            background-color: #45a049; /* Темніший зелений при наведенні */
        }
    </style>
</head>
<body>
    <h1>MY Restaurant CRM</h1>
    <div class="button-container">
        <a href="/inventories" class="button">Перегляд запасів</a>
        <a href="/orders" class="button">Перехід на сторінку замовлень</a>
        <a href="/order" class="button">Перехід на сторінку створення замовлень</a>
    </div>
</body>
</html>
