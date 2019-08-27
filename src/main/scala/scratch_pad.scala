
object DriverCct extends App {

  trait NotificationProcessor[T] {
    def notify(content: T)
    def sendDownStream(content: T)
  }
  object NotificationProcessor {
    def notify[T](content: T)(implicit processor: NotificationProcessor[T]) = processor.notify(content)
    def apply[T](implicit processor: NotificationProcessor[T]) = processor
  }

  implicit object StringNotificationProcessor extends NotificationProcessor[String] {
    override def notify(content: String): Unit = println("String notification " +  content)

    override def sendDownStream(content: String): Unit = println("Sending String content downstream...")
  }
  implicit object IntNotificationProcessor extends NotificationProcessor[Int] {
    override def notify(content: Int): Unit = println("Int notification " +  content)

    override def sendDownStream(content: Int): Unit = println("Sending Int content downstream...")

  }

  val strNotificationProcessor = NotificationProcessor[String]
  strNotificationProcessor.notify("Sury")
  strNotificationProcessor.sendDownStream("Sury")

  val intNotificationProcessor = NotificationProcessor[Int]
  intNotificationProcessor.notify(22)
  intNotificationProcessor.sendDownStream(22)
}
