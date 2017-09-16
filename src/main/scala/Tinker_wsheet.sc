import java.time.LocalDateTime

class Pet{
  def feed() = {
    "Pet Feeded at " + LocalDateTime.now()
  }
}

class Cat extends Pet{
  def hunt() = {
    "Cat hunts"
  }

  //In Scala we need explicit overriding!!!
  override val feed = {
    "Cat feeds"
  }
}

val p: Pet = new Cat

p.feed()

val cat  = new Cat

cat.feed

