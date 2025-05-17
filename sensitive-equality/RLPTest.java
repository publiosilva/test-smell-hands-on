/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 */
class RLPTest {
    @Test
    public void test1() throws UnknownHostException {

        String peersPacket = "F8 4E 11 F8 4B C5 36 81 " +
            "CC 0A 29 82 76 5F B8 40 D8 D6 0C 25 80 FA 79 5C " +
            "FC 03 13 EF DE BA 86 9D 21 94 E7 9E 7C B2 B5 22 " +
            "F7 82 FF A0 39 2C BB AB 8D 1B AC 30 12 08 B1 37 " +
            "E0 DE 49 98 33 4F 3B CF 73 FA 11 7E F2 13 F8 74 " +
            "17 08 9F EA F8 4C 21 B0";

        byte[] payload = Hex.decode(peersPacket);

        byte[] ip = decodeIP4Bytes(payload, 5);

        assertEquals(InetAddress.getByAddress(ip).toString(), ("/54.204.10.41"));
    }
}