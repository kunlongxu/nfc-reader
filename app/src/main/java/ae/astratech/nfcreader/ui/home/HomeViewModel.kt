package ae.astratech.nfcreader.ui.home

import ae.astratech.nfcreader.data.model.NfcTag
import ae.astratech.nfcreader.data.model.ScanRecord
import ae.astratech.nfcreader.data.repository.NfcRepository
import ae.astratech.nfcreader.domain.usecase.GetScansUseCase
import ae.astratech.nfcreader.domain.usecase.ReadNfcTagUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val readNfcTagUseCase: ReadNfcTagUseCase,
    private val getScansUserCase: GetScansUseCase,
    private val nfcRepository: NfcRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow();
    val nfcOptions = nfcRepository.getNfcOptions()

    init {
        loadRecentScans()
    }

    private fun loadRecentScans() {
        viewModelScope.launch {
            getScansUserCase()
                .catch { error ->
                    _uiState.update { it.copy(error = error.message) }
                }
                .collect { scans ->
                    _uiState.update { it.copy(recentScans = scans) }
                }
        }
    }

    fun startNfcScan() {
        viewModelScope.launch {
            _uiState.update { it.copy(isScanning = true) }
            readNfcTagUseCase()
                .catch { error ->
                    _uiState.update { it.copy(isScanning = false, error = error.message) }
                }
                .collect { tag ->
                    _uiState.update {
                        it.copy(isScanning = false, lastScannedTag = tag)
                    }
                }
        }
    }
}

data class HomeUiState(
    val isScanning: Boolean = false,
    val recentScans: List<ScanRecord> = emptyList(),
    val lastScannedTag: NfcTag? = null,
    val error: String? = null
)