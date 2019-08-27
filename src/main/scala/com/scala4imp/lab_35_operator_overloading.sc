class Time(val hours: Int, val minutes: Int = 0){
  if (hours <0 || hours > 24 || minutes < 0 || minutes > 60)
    throw new IllegalArgumentException(s"Invalid time Hour = ${hours}, minute = ${minutes}")

  def <(otherTime: Time) = this.hours < otherTime.hours || this.minutes < otherTime.minutes

  def -(otherTime: Time): String = {
    import scala.math._
    val min = abs((hours * 60 + minutes) - (otherTime.hours * 60 + otherTime.minutes))

    f"${min}%02d minutes"
  }

  override def toString: String = f"Time: ${hours}:${minutes}%02d hrs"
}

object Time {
  def apply(hours: Int, minutes: Int): Time = new Time(hours, minutes)

}

val afternoon = Time(11,50)

val morning = Time(12, 50)

morning < afternoon
afternoon - morning