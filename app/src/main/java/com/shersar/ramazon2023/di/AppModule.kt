package com.shersar.ramazon2023.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.hilt.lifecycle.ViewModelInject
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.shersar.ramazon2023.R
import com.shersar.ramazon2023.data.local.AppDatabase
import com.shersar.ramazon2023.data.local.dao.PrayerTimesDao
import com.shersar.ramazon2023.data.local.dao.ZikrDao
import com.shersar.ramazon2023.repository.TasbehRepository
import com.shersar.ramazon2023.repository.dateTimeRepo.DateTimeRepository
import com.shersar.ramazon2023.repository.dateTimeRepo.DateTimeRepositoryImpl
import com.shersar.ramazon2023.ui.tasbeh.FragmentAdapter
import com.shersar.ramazon2023.ui.tasbeh.viewmodel.TasbehViewmodel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }


    @Singleton
    @Provides
    fun providePrayerDao(appDatabase: AppDatabase): PrayerTimesDao {
        return appDatabase.prayerDao()
    }

    @Singleton
    @Provides
    fun provideZikrDao(appDatabase: AppDatabase): ZikrDao {
        return appDatabase.zikrDao()
    }



    @Provides
    fun provideFusedLocationProviderClient(@ApplicationContext context: Context): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(context)
    }

    @Provides
    fun provideDateTimeRepository(): DateTimeRepository {
        return DateTimeRepositoryImpl()
    }

    @Provides
    fun provideTasbehRepostory(zikrDao: ZikrDao):TasbehRepository{
        return TasbehRepository(zikrDao)
    }


    @Provides
    fun provideTasbehViewmodel(tasbehRepository: TasbehRepository): TasbehViewmodel {
        return TasbehViewmodel(tasbehRepository)
    }


    @Module
    @InstallIn(SingletonComponent::class)
    object SharedPreferencesModule {

        @Provides
        @Singleton
        fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
            return context.getSharedPreferences("MyPrefs", MODE_PRIVATE)
        }
    }

    @Provides
    @Singleton
    fun provideDrawerLayout(context: Context): DrawerLayout {
        return (context as AppCompatActivity).findViewById(R.id.drawerlayout)
    }

    @Provides
    fun provideFragmentAdapter(
        activity: AppCompatActivity,
        drawerLayout: DrawerLayout
    ): FragmentAdapter {
        return FragmentAdapter(drawerLayout,activity)
    }




}