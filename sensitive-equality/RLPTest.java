/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 * 
 * SMELL: Igualdade Sensível (Sensitive Equality)
 * 
 * ONDE ESTÁ O SMELL: O teste compara a representação em string do endereço IP
 * usando assertEquals, o que pode ser sensível a mudanças na formatação ou na
 * representação do endereço. Isso pode causar falhas nos testes mesmo quando
 * o comportamento real do sistema está correto.
 * 
 * COMO REMOVER:
 * 1. Comparar os bytes do endereço IP diretamente em vez de usar a representação em string
 * 2. Usar asserções específicas para endereços IP, como verificar cada octeto individualmente
 * 3. Evitar comparações de strings para dados binários ou endereços de rede
 * 
 * Exemplo de correção:
 * - Comparar os bytes do endereço IP diretamente
 * - Usar asserções específicas para verificar cada octeto do endereço IP
 * - Evitar comparações de strings para dados binários
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