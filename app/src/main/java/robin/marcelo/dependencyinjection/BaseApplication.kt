package robin.marcelo.dependencyinjection

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import robin.marcelo.dependencyinjection.di.applicationModule

class BaseApplication :Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidLogger()

            // use the Android context given there
            androidContext(this@BaseApplication)

            // load properties from assets/koin.properties file
            androidFileProperties()

            // module list
            modules(applicationModule)
        }
    }
}