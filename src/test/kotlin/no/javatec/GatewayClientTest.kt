package no.javatec

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest5.annotation.MicronautTest

@MicronautTest
class GatewayClientTest(
    gatewayClient: GatewayClient
) : BehaviorSpec({
    Given("a gateway client") {
        When("Calling getLiveness()") {
            val response = gatewayClient.getLiveness()

            Then("I should get a response") {
                response shouldBe "{\"status\":\"UP\"}"
            }
        }
    }
})