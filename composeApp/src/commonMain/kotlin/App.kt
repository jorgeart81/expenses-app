import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import data.ExpenseManger
import data.ExpenseRepositoryImpl
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.viewmodel.viewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.ExpensesUiState
import presentation.ExpensesViewModel
import ui.ExpensesScreen

@Composable
@Preview
fun App() {
    PreComposeApp {
        val colors = getColorsTheme()
        val viewModel = viewModel(ExpensesViewModel::class) {
            ExpensesViewModel(ExpenseRepositoryImpl(ExpenseManger))
        }
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        AppTheme {
            ExpensesScreen(uiState) {
            }
        }
    }
}