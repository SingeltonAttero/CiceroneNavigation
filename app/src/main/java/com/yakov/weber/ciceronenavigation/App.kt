package com.yakov.weber.ciceronenavigation

import android.app.Application
import com.yakov.weber.ciceronenavigation.toothpick.DI
import com.yakov.weber.ciceronenavigation.toothpick.module.AppModule
import toothpick.Toothpick
import toothpick.config.Module
import toothpick.configuration.Configuration
import toothpick.registries.FactoryRegistryLocator
import toothpick.registries.MemberInjectorRegistryLocator
/**
 * Created on 09.10.18
 * @author YWeber
 * project CiceroneNavigation */

class App : Application() {


    override fun onCreate() {
        super.onCreate()
        initToothpick()
        initScopes()
    }

    private fun initScopes(){
        val appScope = Toothpick.openScope(DI.APP_SCOPE)
        appScope.installModules(AppModule(this))
    }

    private fun initToothpick() {
        if (BuildConfig.DEBUG) {
            Toothpick.setConfiguration(Configuration.forDevelopment().preventMultipleRootScopes())
        } else {
            Toothpick.setConfiguration(Configuration.forProduction().disableReflection())
            FactoryRegistryLocator.setRootRegistry(com.yakov.weber.ciceronenavigation.FactoryRegistry())
            MemberInjectorRegistryLocator.setRootRegistry(com.yakov.weber.ciceronenavigation.MemberInjectorRegistry())
        }
    }

}