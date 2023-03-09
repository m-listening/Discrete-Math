fun main() {

    val repetition = mutableListOf<Int>()
    val union = mutableListOf<Int>()
    val section = mutableListOf<Int>()
    val difference1 = mutableListOf<Int>()
    val difference2 = mutableListOf<Int>()
    val unionDifference = mutableListOf<Int>()

    val array1 = Array(10) { repeating(repetition) }
    repetition.removeAll(repetition)
    val array2 = Array(10) { repeating(repetition) }

    println("\nПерша множина:").also { array1.sorted().forEach { print("$it ") } }
    println("\n\nДруга множина:").also { array2.sorted().forEach { print("$it ") } }

    union.addAll(array1).also { union.addAll(array2) }
    println("\n\nОб'єднання множин:")
    union.sorted().toSet().forEach { print("$it ") }

    array1.forEach { if (array2.contains(it)) section.add(it) }
    println("\n\nПереріз множин:")
    section.forEach { print("$it ") }

    for (i in 0 until 10) {
        if (!array2.contains(array1[i])) difference1.add(array1[i])
        if (!array1.contains(array2[i])) difference2.add(array2[i])
    }

    println("\n\nРізниця першої множини від другої:")
    difference1.sorted().forEach { print("$it ") }
    println("\n\nРізниця другої множини від першої:")
    difference2.sorted().forEach { print("$it ") }

    println("\n\nсиметрична різниця двох множин:")
    unionDifference.addAll(difference1).also { unionDifference.addAll(difference2) }
    unionDifference.sorted().forEach { print("$it ") }
}

private fun repeating(repetition: MutableList<Int>): Int {
    while (true) {
        val number = (0..15).random()
        if (!repetition.contains(number)) {
            repetition.add(number)
            return number
        }
    }
}