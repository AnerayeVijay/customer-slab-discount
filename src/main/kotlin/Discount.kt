import kotlin.Int.Companion.MAX_VALUE

typealias Slab = () -> List<DiscountSlab>

data class DiscountSlab(val range: LongRange,val discount: Int)

class PremiumDiscountSlab :Slab {
    override fun invoke ():List<DiscountSlab> = listOf(
        DiscountSlab(1..4000L,10),
        DiscountSlab(4001..8000L,15),
        DiscountSlab(8001..12000L,20),
        DiscountSlab(12001L..MAX_VALUE,30)
    )
}

class RegularDiscountSlab : Slab {
    override fun invoke ():List<DiscountSlab> = listOf(
        DiscountSlab(1..5000L,0),
        DiscountSlab(5001L..10000,10),
        DiscountSlab(10001L..MAX_VALUE,20)
    )
}

infix fun Slab.splitPurchaseAmountInSlab(purchaseAmt: Long) :List<Pair<Long,Int>> {
     var slabAmt = purchaseAmt
     return this.invoke()
         .filter { discountSlab -> (discountSlab.range.contains(purchaseAmt) ||  discountSlab.range.last< purchaseAmt) }
         .map {
         val rangeValue = it.range.last - it.range.first + 1
         if (rangeValue < slabAmt) {
             slabAmt -= rangeValue
             Pair(rangeValue, it.discount)
         } else {
             Pair(slabAmt, it.discount)
         }
     }
}
