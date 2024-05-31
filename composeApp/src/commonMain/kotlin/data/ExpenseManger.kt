package data

import model.Expense
import model.ExpenseCategory

object ExpenseManger {
    private var currentId = 1L

    val fakeExpenseList = mutableListOf<Expense>(
        Expense(
            id = currentId++,
            amount = 70.0,
            category = ExpenseCategory.GROCERIES,
            description = "Weekly buy"
        ),
        Expense(
            id = currentId++,
            amount = 10.2,
            category = ExpenseCategory.SNACKS,
            description = "Burger King"
        ),
        Expense(
            id = currentId++,
            amount = 21000.0,
            category = ExpenseCategory.CAR,
            description = "Audi A4"
        ),
        Expense(
            id = currentId++,
            amount = 289.2,
            category = ExpenseCategory.PARTY,
            description = "Weekend party"
        ),
        Expense(
            id = currentId++,
            amount = 89.2,
            category = ExpenseCategory.HOUSE,
            description = "Cleaning"
        ),
        Expense(
            id = currentId++,
            amount = 150.5,
            category = ExpenseCategory.OTHER,
            description = "Services"
        ),
    )
}