package ae.astratech.nfcreader.di

import ae.astratech.nfcreader.data.repository.NfcRepository
import ae.astratech.nfcreader.data.repository.NfcRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindNfcRepository(impl: NfcRepositoryImpl): NfcRepository

}