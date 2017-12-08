package day2

import java.io.BufferedReader
import java.io.FileReader

fun main(args: Array<String>) {

    val spreadsheet = loadSpreadsheet()

    val checkSum = calculateChecksum(spreadsheet)
    println("Final checksum: $checkSum")

    var result = 0
    spreadsheet.forEach{result += getRowResult(it)}
    println("Final second result: $result")
}

private fun getRowResult(row: List<Int>): Int {

    for(number in row) {
        var rowResult = -1
        row.find {
            if(number % it == 0 && number != it) {
                rowResult = number / it
                println("Found a pair: $number and $it. Result is: $rowResult")
            }
            number % it == 0 && number != it
        }
        return rowResult
    }
    return -2
}

private fun calculateChecksum(spreadsheet: List<List<Int>>): Int {
    var checkSum = 0
    spreadsheet.forEach {
        println("Max in the row: ${it.max()}, min in the row: ${it.min()}")
        println("Adding: ${(it.max() ?: 0) - (it.min() ?: 0)} to checksum")
        checkSum += (it.max() ?: 0) - (it.min() ?: 0)
        println("Current checksum: $checkSum \n")
    }
    return checkSum
}

private fun loadSpreadsheet(): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    val reader = BufferedReader(FileReader("src/main/resources/day2-spreadsheet.txt"))

    reader.lines().forEach{
        val rowToAdd = it.split("\\s".toRegex()).map { it.toInt() }
        result.add(rowToAdd)
    }

    println("Loaded spreadsheet:\n ${result.joinToString(separator = "\n")} \n")

    return result
}