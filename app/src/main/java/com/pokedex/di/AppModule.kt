package com.pokedex.di

import android.content.Context
import androidx.room.Room
import com.pokedex.data.repository.PokemonRepositoryImpl
import com.pokedex.data.source.local.dao.PokemonDao
import com.pokedex.data.source.local.database.PokemonDatabase
import com.pokedex.data.source.remote.network.ApiService
import com.pokedex.data.utils.Constants.POKEMON_DB
import com.pokedex.domain.repository.PokemonRepository
import com.pokedex.domain.usecase.PokemonInteractor
import com.pokedex.domain.usecase.PokemonUseCase
import com.pokedex.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        PokemonDatabase::class.java,
        POKEMON_DB
    ).build()

    @Singleton
    @Provides
    fun pokemonDao(database: PokemonDatabase) = database.pokemonDao()

    @Singleton
    @Provides
    fun providesRepository(apiService: ApiService, pokemonDao: PokemonDao): PokemonRepository = PokemonRepositoryImpl(apiService, pokemonDao)

    @Singleton
    @Provides
    fun provideUseCase(pokemonRepository: PokemonRepository): PokemonUseCase = PokemonInteractor(pokemonRepository)
}