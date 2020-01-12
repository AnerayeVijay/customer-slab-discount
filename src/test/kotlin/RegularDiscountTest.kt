import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class RegularDiscountTest {
    private val regularDiscount = RegularDiscountSlab()

    @Test
    fun `return zero discount if Purchase Amount is less than and five thousand`() {
        val listOfSlabPair = regularDiscount.splitPurchaseAmountInSlab(1000)
        assertThat(listOfSlabPair.size,equalTo(1))
        assertThat(listOfSlabPair.first().second,equalTo(0))

    }

    @Test
    fun `return ten percent discount if amount is in between five and ten thousand`() {
        val listOfSlabPair = regularDiscount.splitPurchaseAmountInSlab(6000)
        assertThat(listOfSlabPair.size,equalTo(2))
        assertThat(listOfSlabPair.first().second,equalTo(0))
        assertThat(listOfSlabPair.last().second,equalTo(10))
    }

    @Test
    fun `get 20 percentage discount for above 20000`() {
        val listOfSlabPair = regularDiscount.splitPurchaseAmountInSlab(16000)
        assertThat(listOfSlabPair.size,equalTo(3))
        assertThat(listOfSlabPair.first().second,equalTo(0))
        assertThat(listOfSlabPair.last().second,equalTo(20))
    }
}

