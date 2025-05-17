package ae.astratech.nfcreader.data.repository

import ae.astratech.nfcreader.data.model.NfcOption
import ae.astratech.nfcreader.data.model.NfcTag
import ae.astratech.nfcreader.data.model.NfcTagType
import ae.astratech.nfcreader.data.model.ScanRecord
import ae.astratech.nfcreader.util.NfcHelper
import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NfcRepositoryImpl @Inject constructor(private val nfcHelper: NfcHelper) : NfcRepository {

    private val scanRecord = mutableListOf<ScanRecord>()

    override suspend fun readNfcTag(): Flow<NfcTag> {
        return nfcHelper.readTag()
    }

    override fun getNfcOptions(): List<NfcOption> {
        return listOf(
            NfcOption(
                id = 1,
                iconResId = android.R.drawable.ic_dialog_info,
                titleResId = android.R.string.ok,
                type = NfcTagType.CARD_BALANCE
            ),
            NfcOption(
                id = 2,
                iconResId = android.R.drawable.ic_dialog_info,
                titleResId = android.R.string.ok,
                type = NfcTagType.ACCESS_CONTROL
            ),
            NfcOption(
                id = 3,
                iconResId = android.R.drawable.ic_dialog_info,
                titleResId = android.R.string.ok,
                type = NfcTagType.TRANSIT_CARD
            ),
            NfcOption(
                id = 4,
                iconResId = android.R.drawable.ic_dialog_info,
                titleResId = android.R.string.ok,
                type = NfcTagType.STUDENT_ID
            )
        )
    }

    override suspend fun saveTagScan(scanRecord: ScanRecord) {

    }

    override fun getRecentScans(limit: Int): Flow<List<ScanRecord>> = flow {
        Log.d("NfcRepositoryImpl", "Returning recent scans$limit")
        if (scanRecord.isNotEmpty()) {
            emit(scanRecord.take(limit))
        }
    }
}