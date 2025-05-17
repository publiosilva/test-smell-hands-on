/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 */
class SolarEventCalculatorTest {
    @Test
    public void testGetLocalTimeAsCalendar() {
        Calendar localTime = calc.getLocalTimeAsCalendar(BigDecimal.valueOf(15.5D), Calendar.getInstance());
        assertEquals(15, localTime.get(Calendar.HOUR_OF_DAY));
        assertEquals(30, localTime.get(Calendar.MINUTE));
    }
}
