class Billing() {
    operator fun invoke(customer: Customer) :Long {
        return customer.discountSlab()
            .splitPurchaseAmountInSlab(customer.purchaseAmt)
            .map { it.first applyDiscount it.second }
            .sum()
    }
}

infix fun Long.applyDiscount(percentageRate: Int) = run { this - ((this*percentageRate)/100) }