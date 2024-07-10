import model.Expense
import model.ExpenseCategory
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals


class ExampleTest {
    @Test
    fun sumMustSucceed() {
//        Given
        val x = 5
        val i = 10

//        When
        val result = x + i

//        Then
        assertEquals(15, result)
    }

    @Test
    fun expenseModelListTest() {
//        Given
        val expenseList = mutableListOf<Expense>()
        val expense = Expense(
            id = 1,
            amount = 5.5,
            category = ExpenseCategory.SNACKS,
            description = "Pringles"
        )

//        When
        expenseList.add(expense)

//        Then
        assertContains(expenseList, expense)
    }

    @Test
    fun expenseModelParamTest() {
        val expenseList = mutableListOf<Expense>()
        val expense = Expense(
            id = 1,
            amount = 5.5,
            category = ExpenseCategory.OTHER,
            description = "Pringles"
        )
        val expense2 = Expense(
            id = 2,
            amount = 15.4,
            category = ExpenseCategory.OTHER,
            description = "Clean Products"
        )

        expenseList.add(expense)
        expenseList.add(expense2)

        assertEquals(expenseList[0].category, expenseList[1].category)
    }

    @Test
    fun expenseModelParamTestFail() {
        val expenseList = mutableListOf<Expense>()
        val expense = Expense(
            id = 1,
            amount = 5.5,
            category = ExpenseCategory.SNACKS,
            description = "Pringles"
        )
        val expense2 = Expense(
            id = 2,
            amount = 15.4,
            category = ExpenseCategory.OTHER,
            description = "Clean Products"
        )

        expenseList.add(expense)
        expenseList.add(expense2)

        assertNotEquals(expenseList[0].category, expenseList[1].category)
    }
}