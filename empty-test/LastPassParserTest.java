/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 * 
 * SMELL: Teste Vazio (Empty Test)
 * 
 * ONDE ESTÁ O SMELL: Este teste está completamente vazio, sem nenhuma asserção ou lógica de teste.
 * O método testCredGetFullSampleV1() não contém nenhum código de teste, apenas comentários de código
 * que deveria estar lá.
 * 
 * COMO REMOVER: 
 * 1. Implementar o teste adequadamente com as asserções necessárias
 * 2. Remover os comentários e adicionar o código real de teste
 * 3. Garantir que o teste verifica o comportamento esperado do método
 * 
 * Exemplo de correção:
 * - Descomentar e implementar as asserções
 * - Adicionar a lógica necessária para testar o parser de credenciais
 */
class LastPassParserTest {
    public void testCredGetFullSampleV1() throws Throwable{
    //        ScrapedCredentials credentials =  innerCredTest(FULL_SAMPLE_v1);
    //        assertEquals("p4ssw0rd", credentials.pass);
    //        assertEquals("user@example.com",credentials.user);
    }
}
