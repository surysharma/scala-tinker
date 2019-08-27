import java.time.LocalDate

trait Logger{
  val medium: String
  def log(message: String) = {
    println(message)
  }
}

trait ConsoleLogger extends Logger {
  override val medium = "Console"
  println("ConsoleLogger2")
//  override def log(message: String): Unit = super.log(s"Logging to ${medium} mediumCCCConsole:- " + message)
  override def log(message: String): Unit = super.log(s"Logging to Console:- " + message)
}

trait FileLogger extends Logger {
  override val medium = "File"
  println("Filelogger1")
//  override def log(message: String): Unit = super.log(s"Logging to ${medium} mediumFFFile:- " + message)
  override def log(message: String): Unit = super.log(s"Logging to File:- " + message)
}


trait PrinterLogger extends Logger {
  val medium = "File"
  println("printlogger3")
//  override def log(message: String): Unit = super.log(s"Logging to ${medium} mediumFFFile:- " + message)
  override def log(message: String): Unit = super.log(s"Logging to printer:- " + message)
}

trait TimestampLogger extends Logger{
  override def log(message: String): Unit = super.log(LocalDate.now() +  " " + message)

}

class EventHandler extends Logger {

  override val medium = ""
  def printEvent(message: String = "") {
    log("Event handled, now logging " + message)}

}

val eventH1 = new EventHandler() with PrinterLogger{ override val medium ="Papu"}

eventH1.printEvent()