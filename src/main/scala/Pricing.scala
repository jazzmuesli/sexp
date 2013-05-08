class Rate(val l: Double, val r: Double) {
	val lhs = l
	val rhs = r
	def * (operand: Rate): Rate = {
		val l = lhs * operand.lhs
		var r = rhs * operand.rhs
		new DerivedRate(l, r, "*", this, operand)
	}
	override def toString = { "[lhs=" + lhs + ", rhs=" + rhs + "]" }
}

class DerivedRate(l: Double, r: Double, val op: String, val op1: Rate, val op2: Rate) extends Rate(l,r) {
	val operator = op
	val operand1 = op1
	val operand2 = op2
	override def toString = "[{" + operand1 + operator + operand2 + "}=" + super.toString + "]"

}

object RateExample extends App {
	System.out.println(new Rate(3.14, 2.87) * new Rate(1.0, 2.0) * new Rate(3.0, 4.0))
}
