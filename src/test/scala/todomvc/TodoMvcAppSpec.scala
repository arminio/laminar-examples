package todomvc

import org.scalajs.dom
import org.scalajs.dom.ext.KeyCode
import org.scalajs.dom.html.Input
import org.scalajs.dom.raw.{EventInit, HTMLElement}
import org.scalajs.dom.{Event, KeyboardEvent, KeyboardEventInit}
import org.scalajs.jquery.JQueryEventObject
import typings.testingLibraryDom.queriesMod.GetByText_
//import org.scalajs.dom.raw.Event
import utils.UnitSpec
import org.scalajs.jquery._
import com.raquo.laminar.api.L._


import scala.util.Random


import org.scalajs.jquery.JQueryStatic
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

//@js.native
//@JSImport("jquery", JSImport.Namespace)
//object jquery extends JQueryStatic

class TodoMvcAppSpec extends UnitSpec {

//  val $ = jquery

  it("ak does stuff") {
    import dom.document

    val el = document.createElement("div")

    document.body.appendChild(el)
//
    val todo = TodoMvcApp()
//
    todo.ref.addEventListener[Event](
      "change",
      ev => println(s"yo ${ev.target.asInstanceOf[dom.html.Input].value}")
    )
//
    val root = render(el, todo)
//
////    app.ref.value = "hello!"
//

    val input: Input = todo.ref.querySelector("input").asInstanceOf[Input]
    input.dispatchEvent(new Event("onchange", new EventInit {
         bubbles = true
       }))

//
//    todo.ref.dispatchEvent(new Event("change", new EventInit {
//      bubbles = true
//    }))
//
    root.unmount()
  }
  it("renders") {
    val caption = "Caption_" + Random.nextString(5)
    val todo = TodoMvcApp()

    mount(todo)

    root.child.ref.getAttribute("class") shouldBe "todoapp"
    val input: Input = root.child.ref.querySelector("input").asInstanceOf[Input]


    printBody

    /*
    *
let element = document.querySelector('input');
element.onkeydown = e => alert(e.key);
element.dispatchEvent(new KeyboardEvent('keydown',{'key':'a'}));*/


    input.className shouldBe "new-todo"


    input.placeholder shouldBe "What needs to be done?"
    input.click()

    input.value = "collect the chicken eggs"


    printBody

    input.focus()
//    input.dispatchEvent(simulateKey("e", KeyCode.E))
//    input.dispatchEvent(simulateKey("e", KeyCode.E))
    println(input.value)
    input.dispatchEvent(
    new KeyboardEvent ("keydown", new KeyboardEventInit {
      key = "x"
      keyCode = KeyCode.X


            bubbles = true
            cancelable = false
    })
    )
    println(s"!!->(${input.value})")

    val x: HTMLElement = typings
      .testingLibraryDom
      .mod
      .getByPlaceholderText(root.ref.asInstanceOf[HTMLElement], "What needs to be done?", js.undefined)


    typings.testingLibraryUserEvent.testingLibraryUserEventStrings.submit

    typings.testingLibraryDom.mod.fireEvent(x, new KeyboardEvent ("keydown", new KeyboardEventInit {
      key = "x"
      keyCode = KeyCode.X


      bubbles = false
      cancelable = false
    }))




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
//    jquery("input").keyup()
//    jquery("input").keypress()
//    jquery("input").keyup()

//    println(jquery("input").keydown("keydown", Map("keyCode" -> 13 )))
//    println(jquery("input").trigger("keypress", Map("keyCode" -> 13 )))
//    println(jquery("input").trigger("keyup", Map("keyCode" -> 13 )))

//    input.value shouldBe ""

  }

  private def printBody = {
    println(dom.document.body.innerHTML)
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
