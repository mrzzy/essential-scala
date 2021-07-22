/*
 * essential-scala
 * testing utilities
 */

package test

import java.io.ByteArrayOutputStream

object TestUtil {
  def runCaptureOut(f: () => Unit): String = {
    val out = new ByteArrayOutputStream()
    Console.withOut(out) { f() }
    out.toString
  }
}
