https://developer.android.com/codelabs/basic-android-kotlin-compose-kotlin-fundamentals-practice-problems?hl=zh_cn

### 3. 电影票价格 ###

```kotlin
//请在以下代码段提供的初始代码中，编写相应程序来根据年龄计算电影票价格：
//
//对于 12 岁及以下的观众，按儿童票计算，价格为 15 美元。
//对于年龄介于 13-60 岁的观众，按标准票计算，价格为 30 美元。每逢周一，针对这个年龄段，将标准票的价格打折至 25 美元。
//对于年龄在 61 岁及以上的观众，按老年票计算，价格为 20 美元。假设电影观众的最高年龄为 100 岁。
//如果用户输入的年龄超出规定的年龄范围，使用 -1 值来指明价格无效。
fun main() {
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is  \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
//     var price = 0
//     when(age) {
//         in 0..12 ->  price =15
//         in 13..60 ->  if(isMonday) price = 25;else  price = 30
//         in 61..100 ->  price =20
//         else -> price = -1
//     }
     
//      return price
    
    return when(age) {
        in 0..12 ->  15
        in 13..60 ->  if(isMonday)  25;else   30
        in 61..100 ->  20
        else ->  -1
    }
}
```

### 4. 温度转换器 ###

```kotlin
// 请在以下代码段提供的初始代码中，编写相应程序来按照下列公式在不同的温标之间转换温度：

// 摄氏度转换为华氏度：° F = 9/5 (° C) + 32
// 开尔文转换为摄氏度：° C = K - 273.15
// 华氏度转换为开尔文：K = 5/9 (° F - 32) + 273.15
// 请完成 main() 函数，使其调用 printFinalTemperature() 函数并输出以下代码行。您需要传递温度和转换公式的实参。

// 27.0 degrees Celsius is 80.60 degrees Fahrenheit.
// 350.0 degrees Kelvin is 76.85 degrees Celsius.
// 10.0 degrees Fahrenheit is 260.93 degrees Kelvin.
fun main() {
    printFinalTemperature(27.0, "Celsius", "Fahrenheit") { c -> c * 9 / 5 + 32 }
    printFinalTemperature(350.0, "Kelvin", "Celsius") { c -> c - 273.15 }
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin") { c -> (c - 32) * 5 / 9 + 273.15 }
}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement =
        String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}
```

### 5. 歌曲目录 ###
```kotlin

//请创建一个可代表歌曲结构的类。Song 类必须包含以下代码元素：
//
//歌名、音乐人、发行年份和播放次数的属性
//用于指明歌曲是否流行的属性。如果播放次数少于 1,000，则将相应歌曲视为不流行。
//一个按照以下格式输出歌曲介绍的方法：
//"[歌名], performed by [音乐人], was released in [发行年份]."
data clas Song {
    val name: String
    val artist: String
    val releaseYear: java.time.Year
    val replay: Long
    val hit: Boolean = replay >= 1000
    fun description() {
        println("$name, performed by $artist, was released in $releaseYear.")
    }
    
    
}
```

### 6. 互联网个人资料 ###

```kotlin
//请完成 showProfile() 函数，让程序输出以下代码行：
//Name: Amanda
//Age: 33
//Likes to play tennis. Doesn't have a referrer.
//
//Name: Atiqah
//Age: 28
//Likes to climb. Has a referrer named Amanda, who likes to play tennis.
fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}

class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println(
            """Name: $name
       |Age: $age
       |Likes to ${hobby ?: "Nothing"}. ${if (referrer == null) "Doesn't have a referrer" else "Has a referrer named ${referrer.name}, who likes to ${referrer.hobby ?: "Nothing"}"}.
       """.trimMargin())
    }
}
```
### 7. 可折叠手机 ###
```kotlin
//请在以下代码段提供的初始代码中，编写一个继承自 Phone 类的 FoldablePhone 类。该类应包含以下元素：
//
//用于指明手机是否处于折叠状态的属性。
//在行为上与 Phone 类不同的 switchOn() 函数，以便让手机只有在处于展开状态时才开启相应屏幕。
//几个可更改折叠状态的方法。
open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if(isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }

}
class FoldablePhone: Phone() {
    var fold: Boolean = true
    override fun switchOn() {
        isScreenLightOn = true && !fold
    }

    fun switchFold() {
        fold != fold
    }
}

fun main() {
    val phone = FoldablePhone()
    phone.checkPhoneScreenLight()
    phone.isScreenLightOn = true
    phone.switchFold()
    phone.checkPhoneScreenLight()
    phone.switchFold()
    phone.checkPhoneScreenLight()
}
```
### 8. 特别拍卖 ###
```kotlin
//请完成 auctionPrice() 函数，让程序输出以下代码行：
//        
//Item A is sold at 5000.
//Item B is sold at 3000.
fun main() {
    val winningBid = Bid(5000, "Private Collector")

    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}

class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    return if(bid == null) minimumPrice else bid.amount.takeIf { it >= minimumPrice } ?: minimumPrice
}
```
###  ###
```kotlin
readLine()
```
###  ###
```kotlin

```
###  ###
```kotlin

```
