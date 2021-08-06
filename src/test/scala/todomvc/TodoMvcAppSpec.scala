package todomvc

import org.scalajs.dom
import org.scalajs.dom.ext.KeyCode
import org.scalajs.dom.html.Input
import org.scalajs.dom.{Event, KeyboardEvent, KeyboardEventInit}
import org.scalajs.jquery.JQueryEventObject
//import org.scalajs.dom.raw.Event
import utils.UnitSpec
import org.scalajs.jquery._

import scala.util.Random


import org.scalajs.jquery.JQueryStatic
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("jquery", JSImport.Namespace)
object jquery extends JQueryStatic

class TodoMvcAppSpec extends UnitSpec {

  val $ = jquery

  it("renders") {
    val caption = "Caption_" + Random.nextString(5)
    val todo = TodoMvcApp()

    mount(todo)

    root.child.ref.getAttribute("class") shouldBe "todoapp"
    val input: Input = root.child.ref.querySelector("input").asInstanceOf[dom.html.Input]


    /*
    *
let element = document.querySelector('input');
element.onkeydown = e => alert(e.key);
element.dispatchEvent(new KeyboardEvent('keydown',{'key':'a'}));*/


    input.className shouldBe "new-todo"


    input.placeholder shouldBe "What needs to be done?"
    input.click()

    input.value = "collect the chicken eggs"


    input.focus()
//    input.dispatchEvent(simulateKey("e", KeyCode.E))
//    input.dispatchEvent(simulateKey("e", KeyCode.E))
    println(input.value)
    input.dispatchEvent(
    new KeyboardEvent ("keydown", new KeyboardEventInit {
      key = "e"
      keyCode = KeyCode.E


      //      bubbles = true
      //      cancelable = false
    })
    )
    println(input.value)
    //    input.dispatchEvent(simulateKey("Enter", KeyCode.Enter))

    //$('#myInputId').trigger(jQuery.Event('keypress', { keycode: 13 }));

//    val jqueryEventObject = new JQueryEventObject() {
//      var typeArg: String = "keypress"
//      override var keyCode: js.UndefOr[Int] = 13
//    }
//
//    val jqueryEventObject2 = new Event("keypress") {
//      var typeArg: String = "keypress"
//      override var keyCode: js.UndefOr[Int] = 13
//    }


//    println(jquery("input").value())
//    jquery("input").focus()
//    jquery("input").keyup()
//    jquery("input").keypress()
//    jquery("input").keyup()

//    println(jquery("input").keydown("keydown", Map("keyCode" -> 13 )))
//    println(jquery("input").trigger("keypress", Map("keyCode" -> 13 )))
//    println(jquery("input").trigger("keyup", Map("keyCode" -> 13 )))

//    input.value shouldBe ""

  }

  def simulateKey(_key: String, _keyCode: Int) = {

    new KeyboardEvent ("keydown", new KeyboardEventInit {
      key = _key
      keyCode = _keyCode
//      bubbles = true
//      cancelable = false
    })

  }

}
