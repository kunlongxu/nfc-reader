package ae.astratech.nfcreader.domain.usecase

import ae.astratech.nfcreader.data.model.ScanRecord
import ae.astratech.nfcreader.data.repository.NfcRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetScansUseCase @Inject constructor(private val nfcRepository: NfcRepository) {
    operator fun invoke(limit: Int = 10): Flow<List<ScanRecord>> {
        return nfcRepository.getRecentScans(limit)
    }
}