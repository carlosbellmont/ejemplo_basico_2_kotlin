import java.lang.Exception
import java.lang.NullPointerException

fun main(args: Array<String>) {
    val variable1 = 1
    print("Variable1 ")
    if (variable1 is Int) println("es un Int") else println("no es un Int")

    var variable2 : Long = 10
    // Kotlin no te deja realizar la comprobación ya que variable2 no tiene la posibilidad de ser un Int
    // if (variable2 is Int) println("es un Int") else println("no es un Int")

    // Kotlin no deja asignar un Int a un Long
    // variable2 = variable1
    // Tienes que utilizar las funciones apropiadas para transformar un Int a un Long
    variable2 = variable1.toLong()
    println("Variable2 vale $variable2")

    println("La suma de variable1 y variable2 es... ${variable1 + variable2}")

    // Kotlin no deja asignar un null a una variable
    // val variable3 : Int = null // No compila

    // Kotlin exige el operador ? para que una variable pueda tomar el valor null
    val variable3 : Int? = null
    // variable3.toLong() // No compila ya que toLong requiere que variable3 sea no null.
    avoidNullExceptionIfNumeroIsNull(variable3)
    forceNullExceptionIfNumeroIsNull(variable3)

    // variable 4 es de tipo Int
    val variable4 = getInt(variable3)

}

/**
 * @return 0 if numero == null
 */
fun getInt(numero : Int?) : Int{
    return numero?: 0
}

fun avoidNullExceptionIfNumeroIsNull(numero : Int?){
    println("Es numero recibido es... ${numero?.toLong()}")
    // toLong() no se ejecuta si numero es null que
}

fun forceNullExceptionIfNumeroIsNull(numero : Int?){
    try {
        print("Es numero recibido es... ${numero!!.toLong()}")
    } catch (exception : NullPointerException) {
        println("Excepción capturada")
    }
}