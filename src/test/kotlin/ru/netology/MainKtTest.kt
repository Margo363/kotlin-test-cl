package ru.netology

import commissionPay
import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun commissionPay_test_VkPay() {
        //arrange
        val testVkPayCardType = "VkPay"
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
        assertEquals(Unit, result)
    }

    @Test
    fun commissionPay_test_Mastercard() {

        //arrange
        val testMastercardCardType = "Mastercard"
        val testMastercardLimitInMonth = 7_400_000
        val testMastercardAmount = 2000

        val limitInMonthMastercardMaestro = 7_500_000 //максимальная сумма перевода в месяц в копейках Mastercard/Maestro
        val noCommissionMastercardMaestro = testMastercardAmount * 0 // комиссия 0% от суммы перевода до 7_500_000 Mastercard/Maestro
        val commissionPercentageMastercardMaestro = testMastercardAmount / 1_000 * 6 //комиссия 0.6% от суммы перевода Mastercard/Maestro
        val commissionMinMastercardMaestro = 2_000 // минмальная комиссия 20 рублей = 2000 коп  Mastercard/Maestro
        val commissionMastercardMaestro = commissionPercentageMastercardMaestro+commissionMinMastercardMaestro //комиссия 0.6% + 20 рублей Mastercard/Maestro

        //act
        val result = commissionPay(
            cardType = testMastercardCardType,
            limitInMonth = testMastercardLimitInMonth,
            amount = testMastercardAmount
        )

        //assert
        assertEquals(Unit, result)
    }

    @Test
    fun main_test() {
        //arrange
        val testMainAmount = 8_320_000 //сумма перевода в копейках
        val testMainLimitInMonth = 8000000
        val testMainCardType = "Maestro"

        //act
        val result = commissionPay(
            amount = testMainAmount,
            limitInMonth = testMainLimitInMonth,
            cardType = testMainCardType
        )

        //assert
        assertEquals(Unit, result)
    }
}