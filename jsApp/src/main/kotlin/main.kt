import com.loneoaktech.tests.nightdogsmp.di.ServiceLocatorImpl
import com.loneoaktech.tests.nightdogsmp.shared.Greeting
import com.loneoaktech.tests.nightdogsmp.ui.printSunRiseAndSet
import com.soywiz.klogger.Logger
import kotlinx.browser.document
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import react.RRef
import react.dom.*

fun main() {
//    document.write("Hello, Kotlin!")
//    document.bgColor = "green"
    Logger.defaultLevel = Logger.Level.DEBUG

    render( document.getElementById("root") ) {
        child( HelloComponent::class ) {
        }
    }
}