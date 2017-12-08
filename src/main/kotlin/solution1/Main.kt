package solution1

import common.CircularList
import java.io.FileReader

fun main(args: Array<String>) {

    val captchaList = extractCaptcha()


    println("Captcha to evaluate: ${captchaList.joinToString(separator = "", prefix = "", postfix = "")}")
    println(captchaList.size)

    println("Finished counting the first sum, it is: ${getSum(captchaList, 1)}")

    println("Finished counting the first sum, it is: ${getSum(captchaList, captchaList.size/2)}")

}

private fun getSum(captchaList: CircularList<Int>, lookup: Int): Int {
    var sum = 0
    captchaList.withIndex().forEach { entry ->
        if (entry.value == captchaList[entry.index + lookup]) {
            println("Matching entry: ${entry.value}")
            sum += entry.value
            println("Current sum: $sum")
        }
    }
    return sum
}

fun extractCaptcha(): CircularList<Int> {
    val result = CircularList<Int>()
    val reader = FileReader("src\\main\\resources\\solution1-captcha.txt")
    reader.readText().toCharArray().forEach { result.add( Character.getNumericValue(it) ) }
    reader.close()
    return result
}