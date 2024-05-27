<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Inventories</title>
    <style>
        body {
            background-color: #F0F8FF; /* Світло-голубий фон */
            font-family: Arial, sans-serif;
            padding: 20px;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        .button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 4px;
        }
        .button:hover {
            background-color: #45a049;
        }
        .form-container {
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 8px;
            background-color: #f9f9f9;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h1>Inventories</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Ingredient</th>
                <th>Quantity</th>
                <th>Unit</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <#list inventories as inventory>
                <tr>
                    <td>${inventory.inventoryId}</td>
                    <td>${inventory.ingredient}</td>
                    <td>${inventory.quantity}</td>
                    <td>${inventory.unit}</td>
                    <td>
                        <a href="/inventories/edit/${inventory.inventoryId}" class="button">Edit</a>
                        <form action="/inventories/delete/${inventory.inventoryId}" method="post" style="display:inline;">
                            <button type="submit" class="button">Delete</button>
                        </form>
                    </td>
                </tr>
            </#list>
        </tbody>
    </table>

    <div class="form-container">
        <h2>Add New Inventory</h2>
        <form action="/inventories/create" method="post">
            <label for="ingredient">Ingredient:</label>
            <input type="text" id="ingredient" name="ingredient" required>
            <br><br>
            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" required>
            <br><br>
            <label for="unit">Unit:</label>
            <input type="text" id="unit" name="unit" required>
            <br><br>
            <button type="submit" class="button">Add Inventory</button>
        </form>
    </div>

    <#if inventory??>
        <div class="form-container">
            <h2>Edit Inventory</h2>
            <form action="/inventories/edit/${inventory.inventoryId}" method="post">
                <label for="ingredient">Ingredient:</label>
                <input type="text" id="ingredient" name="ingredient" value="${inventory.ingredient}" required>
                <br><br>
                <label for="quantity">Quantity:</label>
                <input type="number" id="quantity" name="quantity" value="${inventory.quantity}" required>
                <br><br>
                <label for="unit">Unit:</label>
                <input type="text" id="unit" name="unit" value="${inventory.unit}" required>
                <br><br>
                <button type="submit" class="button">Save Changes</button>
            </form>
        </div>
    </#if>
</body>
</html>
