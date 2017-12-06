package solution1

import common.CircularList
import java.io.FileReader

fun main(args: Array<String>) {
    val captchaList = extractCaptcha()
}

fun extractCaptcha(): CircularList<Int> {
    val result = CircularList<Int>(ArrayList())
    val reader = FileReader("src\\main\\resources\\solution1-captcha.txt")
    reader.readText().toCharArray().forEach { result.add( Character.getNumericValue(it) ) }
    reader.close()
    return result
}