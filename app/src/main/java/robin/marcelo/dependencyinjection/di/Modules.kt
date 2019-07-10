package robin.marcelo.dependencyinjection.di

import org.koin.dsl.module
import robin.marcelo.dependencyinjection.kotlinImpl.BatteryPower

val applicationModule = module(override = true) {
    factory {  BatteryPower() }
}