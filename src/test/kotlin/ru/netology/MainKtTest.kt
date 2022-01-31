package ru.netology

import commissionPay
import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun commissionPay_test_VkPay() {
        //arrange
        val testVkPayCardType = 1 //1="VkPay"//тип платежной системы
        val testVkPayLimitInMonth = 0
        val testVkPayAmount = 1

        val noCommissionVkPay = testVkPayAmount * 0 //комиссия 0% Vk Pay
        val limitSinglePaymentVkPay = 1_500_000 //максимальная сумма перевода единовременно в копейках Vk Pay
        val limitInMonthMaxVkPay = 4_000_000 //максимальная сумма перевода в месяц в копейках Vk Pay

        //act
        val result = commissionPay(
            cardType = testVkPayCardType,
            limitInMonth = testVkPayLimitInMonth,
            amount = testVkPayAmount
        )

        //assert
        assertEquals(1, result)
    }
    @Test
    fun commissionPay_test_limitInMonthMaxVkPay() {
        //arrange
        val testVkPayCardType = 1 //1="VkPay"//тип платежной системы
        val testVkPayLimitInMonth = 8_600_000
        val testVkPayAmount = 1

        val noCommissionVkPay = testVkPayAmount * 0 //комиссия 0% Vk Pay
        val limitSinglePaymentVkPay = 1_500_000 //максимальная сумма перевода единовременно в копейках Vk Pay
        val limitInMonthMaxVkPay = 4_000_000 //максимальная сумма перевода в месяц в копейках Vk Pay

        //act
        val result = commissionPay(
            cardType = testVkPayCardType,
            limitInMonth = testVkPayLimitInMonth,
            amount = testVkPayAmount
        )

        //assert
        assertEquals(1, result)
    }

    @Test
    fun commissionPay_test_limitInMonthMaxVkPay__() {
        //arrange
        val testVkPayCardType = 1 //1="VkPay"//тип платежной системы
        val testVkPayLimitInMonth = 1
        val testVkPayAmount = 6_000_000

        val noCommissionVkPay = testVkPayAmount * 0 //комиссия 0% Vk Pay
        val limitSinglePaymentVkPay = 1_500_000 //максимальная сумма перевода единовременно в копейках Vk Pay
        val limitInMonthMaxVkPay = 4_000_000 //максимальная сумма перевода в месяц в копейках Vk Pay

        //act
        val result = commissionPay(
            cardType = testVkPayCardType,
            limitInMonth = testVkPayLimitInMonth,
            amount = testVkPayAmount
        )

        //assert
        assertEquals(1, result)
    }

    @Test
    fun commissionPay_test_limitInMonthMaxVkPay_() {
        //arrange
        val testVkPayCardType = 1 //1="VkPay"//тип платежной системы
        val testVkPayLimitInMonth = 6_000_000
        val testVkPayAmount = 6_000_000

        val noCommissionVkPay = testVkPayAmount * 0 //комиссия 0% Vk Pay
        val limitSinglePaymentVkPay = 1_500_000 //максимальная сумма перевода единовременно в копейках Vk Pay
        val limitInMonthMaxVkPay = 4_000_000 //максимальная сумма перевода в месяц в копейках Vk Pay

        //act
        val result = commissionPay(
            cardType = testVkPayCardType,
            limitInMonth = testVkPayLimitInMonth,
            amount = testVkPayAmount
        )

        //assert
        assertEquals(1, result)
    }

    @Test
    fun commissionPay_test_VisaMir() {

        //arrange
        val testVisaMirType = 2 //2="VisaMir" //тип платежной системы
        val testVisaMirLimitInMonth = 50_000_000
        val testVisaMirAmount = 10_000_000

        val testLimitInMonthOther = 60_000_000 //максимальная сумма перевода в месяц в копейках Visa/Mir
        val testLimitInDayOther = 15_000_000 //максимальная сумма перевода в сутки в копейках Visa/Mir/Mastercard/Maestro

        val testCommissionPercentageVisaMir = testVisaMirAmount / 10000 * 75 //комиссия 0.75% от суммы перевода Visa/Mir
        val testCommissionMinVisaMir = 3500 //комиссия минимум 35 рублей = 3500 коп Visa/Mir

        //act
        val result = commissionPay(
            cardType = testVisaMirType,
            limitInMonth = testVisaMirLimitInMonth,
            amount = testVisaMirAmount,

        )

        //assert
        assertEquals(2, result)
    }

    @Test
    fun commissionPay_test_VisaMir_() {

        //arrange
        val testVisaMirType = 2 //2="VisaMir" //тип платежной системы
        val testVisaMirLimitInMonth = 0
        val testVisaMirAmount = 10

        val testLimitInMonthOther = 60_000_000 //максимальная сумма перевода в месяц в копейках Visa/Mir
        val testLimitInDayOther = 15_000_000 //максимальная сумма перевода в сутки в копейках Visa/Mir/Mastercard/Maestro

        val testCommissionPercentageVisaMir = testVisaMirAmount / 10000 * 75 //комиссия 0.75% от суммы перевода Visa/Mir
        val testCommissionMinVisaMir = 3500 //комиссия минимум 35 рублей = 3500 коп Visa/Mir

        //act
        val result = commissionPay(
            cardType = testVisaMirType,
            limitInMonth = testVisaMirLimitInMonth,
            amount = testVisaMirAmount,

            )

        //assert
        assertEquals(2, result)
    }

    @Test
    fun commissionPay_test_VisaMir__() {

        //arrange
        val testVisaMirType = 2 //2="VisaMir" //тип платежной системы
        val testVisaMirLimitInMonth = 80_000_000
        val testVisaMirAmount = 10

        val testLimitInMonthOther = 60_000_000 //максимальная сумма перевода в месяц в копейках Visa/Mir
        val testLimitInDayOther = 15_000_000 //максимальная сумма перевода в сутки в копейках Visa/Mir/Mastercard/Maestro

        val testCommissionPercentageVisaMir = testVisaMirAmount / 10000 * 75 //комиссия 0.75% от суммы перевода Visa/Mir
        val testCommissionMinVisaMir = 3500 //комиссия минимум 35 рублей = 3500 коп Visa/Mir

        //act
        val result = commissionPay(
            cardType = testVisaMirType,
            limitInMonth = testVisaMirLimitInMonth,
            amount = testVisaMirAmount,

            )

        //assert
        assertEquals(2, result)
    }

    @Test
    fun commissionPay_test_VisaMir___() {

        //arrange
        val testVisaMirType = 2 //2="VisaMir" //тип платежной системы
        val testVisaMirLimitInMonth = 0
        val testVisaMirAmount = 1_000_000_000

        val testLimitInMonthOther = 60_000_000 //максимальная сумма перевода в месяц в копейках Visa/Mir
        val testLimitInDayOther = 15_000_000 //максимальная сумма перевода в сутки в копейках Visa/Mir/Mastercard/Maestro

        val testCommissionPercentageVisaMir = testVisaMirAmount / 10000 * 75 //комиссия 0.75% от суммы перевода Visa/Mir
        val testCommissionMinVisaMir = 3500 //комиссия минимум 35 рублей = 3500 коп Visa/Mir

        //act
        val result = commissionPay(
            cardType = testVisaMirType,
            limitInMonth = testVisaMirLimitInMonth,
            amount = testVisaMirAmount,

            )

        //assert
        assertEquals(2, result)
    }

    @Test
    fun commissionPay_test_MastercardMaestro() {

        //arrange
        val testMastercardCardType = 3 //3="MastercardMaestro" //тип платежной системы
        val testMastercardLimitInMonth = 7_400_000
        val testMastercardAmount = 2000

        val limitInMonthMastercardMaestro = 7_500_000 //максимальная сумма перевода в месяц в копейках Mastercard/Maestro
        val noCommissionMastercardMaestro = testMastercardAmount * 0 // комиссия 0% от суммы перевода до 7_500_000 Mastercard/Maestro
        val commissionPercentageMastercardMaestro = testMastercardAmount / 1_000 * 6 //комиссия 0.6% от суммы перевода Mastercard/Maestro
        val commissionMinMastercardMaestro = 2_000 // минимальная комиссия 20 рублей = 2000 коп  Mastercard/Maestro
        val commissionMastercardMaestro = commissionPercentageMastercardMaestro+commissionMinMastercardMaestro //комиссия 0.6% + 20 рублей Mastercard/Maestro

        //act
        val result = commissionPay(
            cardType = testMastercardCardType,
            limitInMonth = testMastercardLimitInMonth,
            amount = testMastercardAmount
        )

        //assert
        assertEquals(3, result)
    }

    @Test
    fun commissionPay_test_MastercardMaestro_() {

        //arrange
        val testMastercardCardType = 3 //3="MastercardMaestro" //тип платежной системы
        val testMastercardLimitInMonth = 9_000_000
        val testMastercardAmount = 10

        val limitInMonthMastercardMaestro =
            7_500_000 //максимальная сумма перевода в месяц в копейках Mastercard/Maestro
        val noCommissionMastercardMaestro =
            testMastercardAmount * 0 // комиссия 0% от суммы перевода до 7_500_000 Mastercard/Maestro
        val commissionPercentageMastercardMaestro =
            testMastercardAmount / 1_000 * 6 //комиссия 0.6% от суммы перевода Mastercard/Maestro
        val commissionMinMastercardMaestro = 2_000 // минимальная комиссия 20 рублей = 2000 коп  Mastercard/Maestro
        val commissionMastercardMaestro =
            commissionPercentageMastercardMaestro + commissionMinMastercardMaestro //комиссия 0.6% + 20 рублей Mastercard/Maestro

        //act
        val result = commissionPay(
            cardType = testMastercardCardType,
            limitInMonth = testMastercardLimitInMonth,
            amount = testMastercardAmount
        )

        //assert
        assertEquals(3, result)
    }
    @Test
    fun commissionPay_test_MastercardMaestro_2() {

        //arrange
        val testMastercardCardType = 3 //3="MastercardMaestro" //тип платежной системы
        val testMastercardLimitInMonth = 0
        val testMastercardAmount = 1000

        val limitInMonthMastercardMaestro =
            7_500_000 //максимальная сумма перевода в месяц в копейках Mastercard/Maestro
        val noCommissionMastercardMaestro =
            testMastercardAmount * 0 // комиссия 0% от суммы перевода до 7_500_000 Mastercard/Maestro
        val commissionPercentageMastercardMaestro =
            testMastercardAmount / 1_000 * 6 //комиссия 0.6% от суммы перевода Mastercard/Maestro
        val commissionMinMastercardMaestro = 2_000 // минимальная комиссия 20 рублей = 2000 коп  Mastercard/Maestro
        val commissionMastercardMaestro =
            commissionPercentageMastercardMaestro + commissionMinMastercardMaestro //комиссия 0.6% + 20 рублей Mastercard/Maestro

        //act
        val result = commissionPay(
            cardType = testMastercardCardType,
            limitInMonth = testMastercardLimitInMonth,
            amount = testMastercardAmount
        )

        //assert
        assertEquals(3, result)
    }
}