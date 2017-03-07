// reference objects from class in packages
object scratch {
  abstract class Shape {
    def sides: Int
  }

  abstract class Square extends Shape {
    def Planar: Boolean
    def Movable: Boolean
  }

  def error(msg: String) = throw new Error(msg)
  error("test")
}
