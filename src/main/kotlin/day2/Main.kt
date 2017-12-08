package day2

import java.io.BufferedReader
import java.io.FileReader

fun main(args: Array<String>) {

    loadSpreadsheet()

}

private fun loadSpreadsheet(): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    val reader = BufferedReader(FileReader("src/main/resources/day2-spreadsheet.txt"))

    reader.lines().forEach{
        val rowToAdd = it.split("\\s".toRegex()).map { it.toInt() }
        result.add(rowToAdd)
    }

    println("Loaded spreadsheet:\n ${result.joinToString(separator = "\n")}")

    return result
}