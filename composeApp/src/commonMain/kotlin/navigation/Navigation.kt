package navigation

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import data.ExpenseManger
import data.ExpenseRepositoryImpl
import getColorsTheme
import model.Routes
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.viewmodel.viewModel
import presentation.ExpensesViewModel
import ui.ExpenseDetailScreen
import ui.ExpensesScreen

@Composable
fun Navigation(navigator: Navigator, modifier: Modifier = Modifier) {
    val colors = getColorsTheme()
    val viewModel = viewModel(ExpensesViewModel::class) {
        ExpensesViewModel(ExpenseRepositoryImpl(ExpenseManger))
    }

    NavHost(
        modifier = modifier.background(colors.backgroundColor),
        navigator = navigator,
        initialRoute = Routes.Home.route
    ) {
        scene(route = Routes.Home.route) {
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            ExpensesScreen(uiState) { expense ->
                navigator.navigate(Routes.EditExpenses.createRoute(expense.id))
            }
        }
        scene(route = Routes.AddExpense.route) { backStackEntry ->
            ExpenseDetailScreen() { expense ->
                viewModel.addExpense(expense)
                navigator.popBackStack()
            }
        }
        scene(route = Routes.EditExpenses.route) { backStackEntry ->
            val idFromPath = backStackEntry.path<Long>("id")
            val expenseToEdit = idFromPath?.let { id -> viewModel.getExpenseById(id) }
            ExpenseDetailScreen(expenseToEdit) { expense ->
                viewModel.editExpense(expense)
                navigator.popBackStack()
            }
        }
    }
}