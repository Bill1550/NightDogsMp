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
        h1 { + "Kotlin React 2020" }
        div {
            h3 { +"Overview" }
            p {
                +"An small example using Kotlin/JS with React"
            }
            p{
                +"MP greeting: ${Greeting().greeting()}"
            }
        }
        div {
            h3 { + "Rise and Set Times"}
            p {
                span {

                    + "R&S placeholder"
                }
                 GlobalScope.launch{ Logger("main").info { printSunRiseAndSet( ServiceLocatorImpl )} }
            }
        }
        div {
            h3 { + "An embedded image:"}
            img {
                attrs {
                    src = "https://via.placeholder.com/640x360.png?text=Sample+Image"
                }
            }
        }
    }
}