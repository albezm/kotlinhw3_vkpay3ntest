import org.junit.jupiter.api.Test

import org.junit.Assert.*
import org.junit.jupiter.api.Assertions

class MainKtTest {

    @Test
    fun taxCalc() {
        //arrange
        val cashTest = 100.00
        val typeTest = CardType.VKPay
        val summTest = 0.00

        //act
        val result = taxCalc(cashTest, typeTest, summTest)

        //assert
        Assertions.assertEquals(0.00, result)
    }

    @Test
    fun taxCalc2() {
        //arrange
        val cashTest = 100.00
        val typeTest = CardType.VISA
        val summTest = 0.00

        //act
        val result = taxCalc(cashTest, typeTest, summTest)

        //assert
        Assertions.assertEquals(35.00, result)
    }

    @Test
    fun taxCalc3() {
        //arrange
        val cashTest = 100000.00
        val typeTest = CardType.MasterCard
        val summTest = 0.00

        //act
        val result = taxCalc(cashTest, typeTest, summTest)

        //assert
        Assertions.assertEquals(25000.0, result)
    }

    @Test
    fun taxCalc4() {
        //arrange
        val cashTest = 30000.00
        val typeTest = CardType.MasterCard
        val summTest = 76000.00

        //act
        val result = taxCalc(cashTest, typeTest, summTest)

        //assert
        Assertions.assertEquals(200.0, result)
    }

    @Test
    fun taxCalc5() {
        //arrange
        val cashTest = 150000.00
        val typeTest = CardType.VISA
        val summTest = 300000.00

        //act
        val result = taxCalc(cashTest, typeTest, summTest)

        //assert
        Assertions.assertEquals(1125.0, result)
    }

    @Test
    fun taxCalc6() {
        //arrange
        val cashTest = 20000.00

        //act
        val result = taxCalc(cashTest)

        //assert
        Assertions.assertEquals(0.0, result)
    }

    @Test
    fun taxCalc7() {
        //arrange
        val cashTest = 100000.00
        val typeTest = CardType.VKPay
        val summTest = 70000.00

        //act
        val result = taxCalc(cashTest, typeTest, summTest)

        //assert
        Assertions.assertEquals(-0.00, result)
    }

    @Test
    fun taxCalc8() {
        //arrange
        val cashTest = 150000.00
        val typeTest = CardType.VISA
        val summTest = 560000.00

        //act
        val result = taxCalc(cashTest, typeTest, summTest)

        //assert
        Assertions.assertEquals(-0.0, result)
    }

    @Test
    fun taxCalc9() {
        //arrange
        val cashTest = 30000.00
        val typeTest = CardType.MasterCard
        val summTest = 5000.00

        //act
        val result = taxCalc(cashTest, typeTest, summTest)

        //assert
        Assertions.assertEquals(0.0, result)
    }


    @Test
    fun choiseType() {
        //arrange
        val type = 1

        //act
        val result = choiseType(type)

        //assert
        assertEquals(CardType.VISA, result)
    }

    @Test
    fun choiseType2() {
        //arrange
        val type = 2

        //act
        val result = choiseType(type)

        //assert
        assertEquals(CardType.MasterCard, result)
    }


    @Test
    fun choiseType3() {
        //arrange
        val type = 3

        //act
        val result = choiseType(type)

        //assert
        assertEquals(CardType.VKPay, result)
    }

    @Test
    fun choiseType4() {
        //arrange
        val type = 0

        //act
        val result = choiseType(type)

        //assert
        assertEquals(CardType.VKPay, result)
    }

}