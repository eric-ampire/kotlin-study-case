package com.ericampire.kotlinstudycase

import com.ericampire.kotlinstudycase.model.flightmanager.BusinessFlight
import com.ericampire.kotlinstudycase.model.flightmanager.EconomicFlight
import com.ericampire.kotlinstudycase.model.flightmanager.Passenger
import com.ericampire.kotlinstudycase.model.flightmanager.PremiumFlight
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals


class AirportTest {

    @DisplayName("On a given economic flight")
    @Nested
    inner class EconomicTest {

        private lateinit var economyFlight: EconomicFlight
        private lateinit var vipPassenger: Passenger
        private lateinit var regularPassenger: Passenger

        @BeforeEach
        fun setup() {
            economyFlight = EconomicFlight(id = "2")
            vipPassenger = Passenger(name = "Roland", vip = true)
            regularPassenger = Passenger(name = "Roland", vip = false)
        }

        @Nested
        @DisplayName("With regular passenger")
        inner class RegularPassenger {
            @Test
            fun testEconomicFlightUsualPassenger() {
                val roland = Passenger(name = "Roland", vip = false)
                assertAll(
                    { assertEquals("2", economyFlight.id) },
                    { assertEquals(true, economyFlight.addPassenger(roland)) },
                    { assertEquals(1, economyFlight.passengerList.size) },
                    { assertEquals(true, economyFlight.removePassenger(roland)) },
                    { assertEquals(0, economyFlight.passengerList.size) },
                )
            }

            @Test
            @DisplayName("Then you cannot add him more than once")
            fun testEconomicFlightRegularPassengerAddedOnlyOnce() {
                repeat(3) {
                    economyFlight.addPassenger(regularPassenger)
                }
                assertAll(
                    { assertEquals(1, economyFlight.passengerList.size) },
                    { assertEquals(regularPassenger.name, economyFlight.passengerList.first().name) },
                )
            }
        }

        @Nested
        @DisplayName("With vip passenger")
        inner class VipPassenger {
            @Test
            fun testEconomicFlightVipPassenger() {
                assertAll(
                    { assertEquals("2", economyFlight.id) },
                    { assertEquals(true, economyFlight.addPassenger(vipPassenger)) },
                    { assertEquals(1, economyFlight.passengerList.size) },
                    { assertEquals(false, economyFlight.removePassenger(vipPassenger)) },
                    { assertEquals(1, economyFlight.passengerList.size) },
                )
            }

            @Test
            @DisplayName("Then you cannot add him more than once")
            fun testEconomicFlightRegularPassengerAddedOnlyOnce() {
                repeat(3) {
                    economyFlight.addPassenger(vipPassenger)
                }
                assertAll(
                    { assertEquals(1, economyFlight.passengerList.size) },
                    { assertEquals(vipPassenger.name, economyFlight.passengerList.first().name) },
                )
            }
        }
    }

    @DisplayName("On a given business flight")
    @Nested
    inner class BusinessFlightTest {

        private lateinit var businessFlight: BusinessFlight
        private lateinit var regularPassenger: Passenger

        @BeforeEach
        fun setup() {
            businessFlight = BusinessFlight(id = "1")
            regularPassenger = Passenger(name = "Roland", vip = true)
        }

        @Test
        fun testBusinessFlightVipPassenger() {

            assertAll(
                "Very all condition",
                { assertEquals("1", businessFlight.id) },
                { assertEquals(true, businessFlight.addPassenger(regularPassenger)) },
                { assertEquals(1, businessFlight.passengerList.size) },
                { assertEquals(false, businessFlight.removePassenger(regularPassenger)) },
                { assertEquals(1, businessFlight.passengerList.size) },
            )
        }

        @Test
        fun tesPa(test: TestReporter) {
            test.publishEntry("SAlut")
            test.publishEntry("eric", "Ampire")
            test.publishEntry(mutableMapOf("a" to "df"))
        }

        @Test
        fun testBusinessUsualPassenger(sdf: TestInfo) {
            val economyFlight = BusinessFlight(id = "1")
            val roland = Passenger(name = "Roland", vip = false)

            assertAll(
                { assertEquals("1", economyFlight.id) },
                { assertEquals(false, economyFlight.addPassenger(roland)) },
                { assertEquals(0, economyFlight.passengerList.size) },
                { assertEquals(false, economyFlight.removePassenger(roland)) },
                { assertEquals(0, economyFlight.passengerList.size) },
            )
        }
    }

    @Nested
    @DisplayName("On a given premium flight")
    inner class PremiumFlightTest {

        private lateinit var premiumFlight: PremiumFlight
        private lateinit var vipPassenger: Passenger
        private lateinit var regularPassenger: Passenger

        @BeforeEach
        fun setup() {
            premiumFlight = PremiumFlight("3")
            vipPassenger = Passenger("Eric", true)
            regularPassenger = Passenger("Roland", vip = false)
        }

        @DisplayName("When we are a VIP passenger")
        @Nested
        inner class VipPassenger {

            @Test
            @DisplayName("Then you add and remove him from the flight")
            fun testPremiumFlightForVipPassenger() {
                assertAll(
                    { assertEquals(true, premiumFlight.addPassenger(vipPassenger)) },
                    { assertEquals(1, premiumFlight.passengerList.size) },
                    { assertEquals(true, premiumFlight.removePassenger(vipPassenger)) },
                    { assertEquals(0, premiumFlight.passengerList.size) },
                )
            }
        }

        @DisplayName("When we are a regular passenger")
        @Nested
        inner class RegularPassenger {

            @Test
            @DisplayName("Then you add and remove him from the flight")
            fun testPremiumFlightForVipPassenger() {
                assertAll(
                    { assertEquals(false, premiumFlight.addPassenger(regularPassenger)) },
                    { assertEquals(0, premiumFlight.passengerList.size) },
                    { assertEquals(false, premiumFlight.removePassenger(regularPassenger)) },
                    { assertEquals(0, premiumFlight.passengerList.size) },
                )
            }
        }
    }


    @RepeatedTest(value = 5, name = "{displayName} - {currentRepetition}/{totalRepetitions}")
    @DisplayName("La repetition")
    fun repetitionTest(repetitionInfo: RepetitionInfo, testReporter: TestReporter) {

        assertEquals(1, 1 + 0)
    }
}