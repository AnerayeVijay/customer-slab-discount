import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class BillingTest {

    val billing= Billing()

    //Regular Customer
    @Test
    fun `bill amount on purchase of 5,000 is 5,000 for regular customer`() {
        val regularCustomer = Customer("Regular Customer", CustomerType.REGULAR,5000L)
        assertThat(billing(regularCustomer), equalTo(5000L))
    }

    @Test
    fun `bill amount on purchase of 10,000 is 9,5000 for regular customer`() {
        val regularCustomer = Customer("Regular Customer", CustomerType.REGULAR,10000L)
        assertThat(billing(regularCustomer), equalTo(9500L))
    }

    @Test
    fun `bill amount on purchase of 15,000 is 13500`() {
        val regularCustomer = Customer("Regular Customer", CustomerType.REGULAR,15000L)
        assertThat(billing(regularCustomer), equalTo(13500L))    }

    @Test
    fun `bill amount on purchase of 20,000 is 17500`() {
        val regularCustomer = Customer("Regular Customer", CustomerType.REGULAR,20000L)
        assertThat(billing(regularCustomer), equalTo(17500L))    }



    //premium Customer

    @Test
    fun `billing amount for premium customer on  4,000 is 3600`() {
        val premiumCustomer = Customer("premium Customer", CustomerType.PREMIUM,4000L)
        assertThat(billing(premiumCustomer), equalTo(3600L))
    }

    @Test
    fun `billing amount for premium customer on  8,000 is 3600`() {
        val premiumCustomer = Customer("premium Customer", CustomerType.PREMIUM,8000L)
        assertThat(billing(premiumCustomer), equalTo(7000L))
    }

    @Test
    fun `billing amount for premium customer on  12,000 is 10,200`() {
        val premiumCustomer = Customer("premium Customer", CustomerType.PREMIUM,12000L)
        assertThat(billing(premiumCustomer), equalTo(10200L))
    }

    @Test
    fun `billing amount for premium customer on $20,000 is $15,800`() {
        val premiumCustomer = Customer("premium Customer", CustomerType.PREMIUM,20000L)
        assertThat(billing(premiumCustomer), equalTo(15800L))    }

    @Test
    fun `calculate proper discount`() {
        assertThat(100L.applyDiscount(10), equalTo(90L))
        assertThat(1000L.applyDiscount(15), equalTo(850L))
        assertThat(10000L.applyDiscount(12), equalTo(8800L))
        assertThat(900L.applyDiscount(15), equalTo(765L))

    }
}

