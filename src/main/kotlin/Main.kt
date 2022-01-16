fun commissionPay (
    cardType: String = "VkPay", //тип платежной системы
    limitInMonth: Int = 0, //лимит на перевод в месяц
    amount: Int = 1 // перевод в копейках
): Unit {
    val noCommissionVkPay = amount * 0 //комиссия 0% Vk Pay
    val limitSinglePaymentVkPay = 1_500_000 //максимальная сумма перевода единовременно в копейках Vk Pay
    val limitInMonthMaxVkPay = 4_000_000 //максимальная сумма перевода в месяц в копейках Vk Pay

    val limitInMonthOther = 60_000_000 //максимальная сумма перевода в месяц в копейках Visa/Mir
    val limitInDayOther = 15_000_000 //максимальная сумма перевода в сутки в копейках Visa/Mir/Mastercard/Maestro

    val commissionPercentageVisaMir = amount / 10000 * 75 //комиссия 0.75% от суммы перевода Visa/Mir
    val commissionMinVisaMir = 3500 //комиссия минимум 35 рублей = 3500 коп Visa/Mir

    val limitInMonthMastercardMaestro = 7_500_000 //максимальная сумма перевода в месяц в копейках Mastercard/Maestro
    val noCommissionMastercardMaestro = amount * 0 // комиссия 0% от суммы перевода до 7_500_000 Mastercard/Maestro
    val commissionPercentageMastercardMaestro = amount / 1_000 * 6 //комиссия 0.6% от суммы перевода Mastercard/Maestro
    val commissionMinMastercardMaestro = 2_000 // минмальная комиссия 20 рублей = 2000 коп  Mastercard/Maestro
    val commissionMastercardMaestro = commissionPercentageMastercardMaestro+commissionMinMastercardMaestro //комиссия 0.6% + 20 рублей Mastercard/Maestro

    when(cardType) {
        "VkPay" -> {
            when {
                amount<=limitSinglePaymentVkPay -> println("комиссия с перевода составила $noCommissionVkPay копеек")
                limitInMonth>limitInMonthMaxVkPay -> println("Внимание! Перевод недоступен, максимальная сумма всех переводов в месяц = 40000 рублей.")
                else -> println("Внимание! Перевод недоступен, максимальная сумма единовременного перевода = 15000 рублей.")
            }
        }
        "Visa","Mir" -> {
            when {
                limitInMonth>limitInMonthOther -> println("Внимание! Перевод недоступен, максимальная сумма всех переводов в месяц = 600000 рублей.")
                amount>limitInDayOther -> println("Внимание! Перевод не доступен, максимальная сумма переводов в сутки составляет 150000 рублей")
                commissionPercentageVisaMir>commissionMinVisaMir -> println("Комиссия за перевод составила $commissionPercentageVisaMir копеек")
                else -> println("Комиссия за перевод составила $commissionMinVisaMir копеек")
            }
        }
        else -> {
            when {
                limitInMonth>limitInMonthMastercardMaestro -> println("Комиссия за перевод составила $commissionMastercardMaestro копеек")
                else -> println("Комиссия за перевод составила $noCommissionMastercardMaestro копеек")
            }
        }
    }
}

fun main() {
    val amount = 8_320_000 //сумма перевода в копейках
    val limitInMonth = 8000000
    val cardType = "Maestro"

    val commission = commissionPay(cardType, limitInMonth, amount)
}









