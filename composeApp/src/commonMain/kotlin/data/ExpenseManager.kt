package data

import model.Expense
import model.ExpenseCategory

object ExpenseManager {
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
            amount = 150.889,
            category = ExpenseCategory.OTHER,
            description = "Services"
        ),
    )

    fun addNewExpense(expense: Expense) {
        fakeExpenseList.add(expense.copy(id = currentId++))
    }

    fun editExpense(expense: Expense) {
        val index = fakeExpenseList.indexOfFirst { it.id == expense.id }
        fakeExpenseList[index]

        if (index != -1) {
            fakeExpenseList[index] = fakeExpenseList[index].copy(
                amount = expense.amount,
                category = expense.category,
                description = expense.description
            )
        }
    }

    fun getCategories(): List<ExpenseCategory> {
        return ExpenseCategory.entries
    }

    fun deleteExpense(expense: Expense): List<Expense> {
        val index = fakeExpenseList.indexOfFirst { it.id == expense.id }
        fakeExpenseList.removeAt(index)

        return fakeExpenseList
    }
}