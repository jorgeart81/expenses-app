import data.ExpenseManager
import data.ExpenseRepositoryImpl
import model.Expense
import model.ExpenseCategory
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class ExpenseRepoTest {
    private val expenseManager = ExpenseManager
    private val repo = ExpenseRepositoryImpl(expenseManager)

    @Test
    fun expenseListIsNotEmpty() {
        // Given
        val expenseList = mutableListOf<Expense>()

        // When
        expenseList.addAll(repo.getAllExpenses())

        // Then
        assertTrue(expenseList.isNotEmpty())
    }

    @Test
    fun addNewExpense() {
        // Given
        val expenseList = repo.getAllExpenses()

        // When
        val expense = Expense(
            amount = 5.5,
            category = ExpenseCategory.OTHER,
            description = "Pringles"
        )
        repo.addExpense(expense)

        // Then
        assertContains(expenseList, expenseList.find { it.id == 7L })
    }

    @Test
    fun editExpense() {
        // Given
        val expenseListBefore = repo.getAllExpenses()

        // When
        val newExpenseId = 7L
        val expense = Expense(
            amount = 5.5,
            category = ExpenseCategory.OTHER,
            description = "Pringles"
        )
        repo.addExpense(expense)
        assertNotNull(expenseListBefore.find { it.id == newExpenseId })

        val updateExpense = Expense(
            id = newExpenseId,
            amount = 10.8,
            category = ExpenseCategory.SNACKS,
            description = "Pringles"
        )
        repo.editExpense(updateExpense)

        // Then
        val expenseListAfter = repo.getAllExpenses()
        assertEquals(updateExpense, expenseListAfter.find { it.id == newExpenseId })
    }

    @Test
    fun getAllCategories() {
        // Given
        val categoryList = mutableListOf<ExpenseCategory>()

        // When
        categoryList.addAll(expenseManager.getCategories())

        // Then
        assertTrue(categoryList.isNotEmpty())
    }

    @Test
    fun checkAllCategories() {
        // Given
        val allCategories = listOf(
            ExpenseCategory.GROCERIES,
            ExpenseCategory.PARTY,
            ExpenseCategory.SNACKS,
            ExpenseCategory.COFFEE,
            ExpenseCategory.CAR,
            ExpenseCategory.HOUSE,
            ExpenseCategory.OTHER,
        )

        // Then
        assertEquals(repo.getCategories(), allCategories)
    }
}