package solution1

import common.CircularList
import java.io.FileReader

fun main(args: Array<String>) {

    val captchaList = extractCaptcha()
    var sum = 0

    println("Captcha to evaluate: ${captchaList.joinToString(separator = "", prefix = "", postfix = "")}")
    println(captchaList.size)

    captchaList.withIndex().forEach{ entry ->
        if (entry.value == captchaList[entry.index + 1]) {
            println("Matching entry: ${entry.value}")
            sum += entry.value
            println("Current sum: $sum")
        }
    }

}

fun extractCaptcha(): CircularList<Int> {
    val result = CircularList<Int>()
    val reader = FileReader("src\\main\\resources\\solution1-captcha.txt")
    reader.readText().toCharArray().forEach { result.add( Character.getNumericValue(it) ) }
    reader.close()
    return result
}