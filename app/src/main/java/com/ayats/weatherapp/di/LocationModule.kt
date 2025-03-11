package com.ayats.weatherapp.di

import com.ayats.weatherapp.data.location.LocationTrackerImpl
import com.ayats.weatherapp.domain.location.LocationTracker
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocationModule {

    @Binds
    @Singleton
    abstract fun bindLocationTracker(defaultLocationTrackerImpl: LocationTrackerImpl): LocationTracker

}