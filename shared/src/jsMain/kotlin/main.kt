import kotlinx.browser.document
import react.dom.*

fun main() {
//    document.write("Hello, Kotlin!")
//    document.bgColor = "green"

    render( document.getElementById("root") ) {
        h1 { + "Kotlin React 2020" }
        div {
            h3 { +"Overview" }
            p {
                +"An small example using Kotlin/JS with React"
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