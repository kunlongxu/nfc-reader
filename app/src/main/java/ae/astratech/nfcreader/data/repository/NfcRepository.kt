package ae.astratech.nfcreader.data.repository

import ae.astratech.nfcreader.data.model.NfcOption
import ae.astratech.nfcreader.data.model.NfcTag
import ae.astratech.nfcreader.data.model.ScanRecord
import kotlinx.coroutines.flow.Flow

interface NfcRepository {
    suspend fun readNfcTag(): Flow<NfcTag>
    suspend fun saveTagScan(scanRecord: ScanRecord)
    fun getRecentScans(limit: Int=10): Flow<List<ScanRecord>>
    fun getNfcOptions(): List<NfcOption>
}

