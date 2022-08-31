@file:Suppress("NAME_SHADOWING", "UNREACHABLE_CODE")

enum class CardType {
    VKPay, VISA, MasterCard
}

fun main() {
    println("Введи сумму перевода: ")
    val cash = readLine()?.toDouble() ?: 0.00
    println("Выберите какой у вас счёт (1 - VISA, 2 - MasterCard или 3 - VKPay. Стандарт VKPay")
    val type = readLine()?.toInt() ?: 3
    println("Сумма перевода за месяц. Дефолт - 0")
    val summTrans = readLine()?.toDouble() ?: 0.00
    println(taxCalc(cash, choiseType(type), summTrans))
}

fun choiseType(number: Int): CardType {
    return when (number) {
        1 -> return CardType.VISA
        2 -> return CardType.MasterCard
        3 -> return CardType.VKPay
        else -> {return CardType.VKPay}
    }
}

fun taxCalc(cash: Double, cardType: CardType = CardType.VKPay, summTrans: Double = 0.00): Double {
    if (cardType == CardType.VKPay) {
        if (cash >= 40000.00 || cash + summTrans >= 40000.00) {
            val over = 40000.00 - summTrans
            println("Со счёта VK Pay за месяц можно перевести не более 40.000р 00 коп." + System.lineSeparator() +
                    "В этом месяце вы перевели: $summTrans" + System.lineSeparator() +
                    "Максимум в этом месяце вы можете перевести: $over")
        } else if (cash > 0) {
            return 0.00
        }
    } else if (cardType == CardType.VISA || cardType == CardType.MasterCard) {
        if (cash >= 600000.00 || cash + summTrans >= 600000.00) {
            val over = 600000.00 - summTrans
            println("С карт VISA, МИР и MasterCard за месяц можно перевести не более 600.000 р 00 коп." + System.lineSeparator() +
                    "В этом месяце вы перевели: $summTrans" + System.lineSeparator() +
                    "Максимум в этом месяце вы можете перевести: $over")
        } else if (cash > 0 && cardType == CardType.VISA) {
            val taxVisa = cash * 0.0075
            if (taxVisa < 35.00) {
                val taxFix = 35.00;
                return taxFix
            } else if (taxVisa > 35.00) {
                return taxVisa
            }

        } else if (cash > 0 && cardType == CardType.MasterCard) {
            val taxMaster = cash * 0.006 + 20
            if (summTrans > 75000) {
                return taxMaster

            } else if (summTrans < 75000 && (cash - summTrans) < 75000) {
                return 0.00
            } else if (summTrans < 75000 && (cash - summTrans) > 75000){
                val difference = cash - (75000 - summTrans)
                val newTax = difference * 0.006 + 20
                return difference
            }
        }
    }
    return -0.00
}