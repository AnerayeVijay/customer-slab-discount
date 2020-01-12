import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class PremiumDiscountTest {
    private val premiumDiscount = PremiumDiscountSlab()

    @Test
    fun `return 10% discount for purchase amount in rage onf 0 to 4,000`() {
        val purchaseAmount = 3600L
        val listOfSlabPair =premiumDiscount.splitPurchaseAmountInSlab(purchaseAmount)
        assertThat(listOfSlabPair.size,equalTo(1))
        assertThat(listOfSlabPair.first().second,equalTo(10))
    }

    @Test
    fun `get avg 15% discount on 4,000 -  8,000amount`() {
        val purchaseAmount = 6000L
        val listOfSlabPair =premiumDiscount.splitPurchaseAmountInSlab(purchaseAmount)
        assertThat(listOfSlabPair.size,equalTo(2))
        assertThat(listOfSlabPair.first().second,equalTo(10))
        assertThat(listOfSlabPair.last().second,equalTo(15))
    }

    @Test
    fun `get avg slab of 12 5% discount on 8,000 - 12,000 amount`() {
        val purchaseAmount = 9000L
        val listOfSlabPair =premiumDiscount.splitPurchaseAmountInSlab(purchaseAmount)
        assertThat(listOfSlabPair.size,equalTo(3))
        assertThat(listOfSlabPair.last().second,equalTo(20))
    }

    @Test
    fun `get avg slab of 15% discount on 12,000 & above amount`() {
        val purchaseAmount = 15000L
        val listOfSlabPair = premiumDiscount.splitPurchaseAmountInSlab(purchaseAmount)
        assertThat(listOfSlabPair.size, equalTo(4))
        assertThat(listOfSlabPair.last().second, equalTo(30))

    }
}

