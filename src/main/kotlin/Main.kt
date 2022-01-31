fun commissionPay (
    cardType: Int,//1="VkPay",2="VisaMir",3="MastercardMaestro" //тип платежной системы
    limitInMonth: Int, //лимит на перевод в месяц
    amount: Int // перевод в копейках
): Int {

    val noCommissionVkPay = amount * 0 //комиссия 0% Vk Pay
    val limitSinglePaymentVkPay = 1_500_000 //максимальная сумма перевода единовременно в копейках Vk Pay
    val limitInMonthMaxVkPay = 4_000_000 //максимальная сумма перевода в месяц в копейках Vk Pay
    val limitNull = null

    val limitInMonthOther = 60_000_000 //максимальная сумма перевода в месяц в копейках Visa/Mir
    val limitInDayOther = 15_000_000 //максимальная сумма перевода в сутки в копейках Visa/Mir/Mastercard/Maestro

    val commissionPercentageVisaMir = amount / 10000 * 75 //комиссия 0.75% от суммы перевода Visa/Mir
    val commissionMinVisaMir = 3500 //комиссия минимум 35 рублей = 3500 копеек Visa/Mir

    val limitInMonthMastercardMaestro = 7_500_000 //максимальная сумма перевода в месяц в копейках Mastercard/Maestro
    val noCommissionMastercardMaestro = amount * 0 // комиссия 0% от суммы перевода до 7_500_000 Mastercard/Maestro
    val commissionPercentageMastercardMaestro = amount / 1_000 * 6 //комиссия 0.6% от суммы перевода Mastercard/Maestro
    val commissionMinMastercardMaestro = 2_000 // минимальная комиссия 20 рублей = 2000 коп  Mastercard/Maestro
    val commissionMastercardMaestro = commissionPercentageMastercardMaestro+commissionMinMastercardMaestro //комиссия 0.6% + 20 рублей Mastercard/Maestro


    when(cardType) {
        1 -> {
            when {
                amount<=limitSinglePaymentVkPay -> noCommissionVkPay
                limitInMonth>limitInMonthMaxVkPay -> limitNull//println("Внимание! Перевод недоступен, максимальная сумма всех переводов в месяц = 40000 рублей.")
                else -> limitNull//println("Внимание! Перевод недоступен, максимальная сумма единовременного перевода = 15000 рублей.")
            }
        }
        2 -> {
            when {
                limitInMonth>limitInMonthOther -> limitNull //println("Внимание! Перевод недоступен, максимальная сумма всех переводов в месяц = 600000 рублей.")
                amount>limitInDayOther -> limitNull//println("Внимание! Перевод не доступен, максимальная сумма переводов в сутки составляет 150000 рублей")
                commissionPercentageVisaMir>commissionMinVisaMir -> commissionPercentageVisaMir
                else -> commissionMinVisaMir
            }
        }
        3 -> {
            when {
                limitInMonth>limitInMonthMastercardMaestro -> commissionMastercardMaestro
                else -> noCommissionMastercardMaestro
            }
        }
    }
    return cardType
}

//fun main() {
//    val cardType: Int = 1 //1="VkPay",2="VisaMir",3="MastercardMaestro" //тип платежной системы
//    val limitInMonth: Int = 8_000_000
//    val amount: Int = 8_320_000 //сумма перевода в копейках
//
//
//    val result: Int = commissionPay(cardType, limitInMonth, amount)
//
//}









