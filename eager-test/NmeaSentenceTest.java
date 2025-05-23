/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 * 
 * SMELL: Teste Ansioso (Eager Test)
 * 
 * ONDE ESTÁ O SMELL: O teste verifica múltiplos comportamentos diferentes em um único
 * método de teste (getLatestPdop, getLatestHdop, getLatestVdop). Isso viola o princípio
 * de que cada teste deve verificar apenas um comportamento específico.
 * 
 * COMO REMOVER:
 * 1. Separar cada verificação em um método de teste individual
 * 2. Dar nomes descritivos para cada teste que indiquem exatamente o que está sendo testado
 * 3. Manter a configuração comum em um método @Before se necessário
 * 
 * Exemplo de correção:
 * - Criar testGetLatestPdop()
 * - Criar testGetLatestHdop()
 * - Criar testGetLatestVdop()
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
