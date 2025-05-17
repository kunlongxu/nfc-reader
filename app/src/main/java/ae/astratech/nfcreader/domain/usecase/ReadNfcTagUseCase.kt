package ae.astratech.nfcreader.domain.usecase

import ae.astratech.nfcreader.data.model.NfcTag
import ae.astratech.nfcreader.data.repository.NfcRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class ReadNfcTagUseCase @Inject constructor(private  val nfcRepository: NfcRepository) {
    suspend operator fun invoke(): Flow<NfcTag> {
        return nfcRepository.readNfcTag()
    }
}