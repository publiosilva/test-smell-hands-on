/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 */
class NmeaSentenceTest {
    @Test
    public void NmeaSentence_GPGSA_ReadValidValues(){
        NmeaSentence nmeaSentence = new NmeaSentence("$GPGSA,A,3,04,05,,09,12,,,24,,,,,2.5,1.3,2.1*39");
        assertThat("GPGSA - read PDOP", nmeaSentence.getLatestPdop(), is("2.5"));
        assertThat("GPGSA - read HDOP", nmeaSentence.getLatestHdop(), is("1.3"));
        assertThat("GPGSA - read VDOP", nmeaSentence.getLatestVdop(), is("2.1"));
    }
}
