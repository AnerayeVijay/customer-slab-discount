import CustomerType.PREMIUM
import CustomerType.REGULAR

data class Customer(val name: String, val customerType : CustomerType, val purchaseAmt : Long)

enum class CustomerType {
    REGULAR,PREMIUM
}
fun Customer.discountSlab()  = when(customerType) {
    REGULAR -> RegularDiscountSlab()
    PREMIUM -> PremiumDiscountSlab()
}