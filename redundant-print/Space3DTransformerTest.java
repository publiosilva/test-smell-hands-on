/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 * 
 * SMELL: Impressão Redundante (Redundant Print)
 * 
 * ONDE ESTÁ O SMELL: O teste contém uma instrução System.out.println() que imprime
 * o resultado intermediário do teste. Esta impressão não contribui para a validação
 * do teste e pode poluir a saída do console durante a execução dos testes.
 * 
 * COMO REMOVER:
 * 1. Remover todas as instruções de impressão do código de teste
 * 2. Usar asserções apropriadas para validar os resultados
 * 3. Se necessário, usar logs de debug configuráveis
 * 
 * Exemplo de correção:
 * - Remover a linha System.out.println("result = " + result)
 * - Adicionar asserções específicas para validar o resultado intermediário
 * - Usar um logger configurável se for necessário debug
 */ 
class Space3DTransformerTest {
    @Test
    public void testTransform10mNEUAndBack() {
        Leg northEastAndUp10M = new Leg(10, 45, 45);
        Coord3D result = transformer.transform(Coord3D.ORIGIN, northEastAndUp10M);
        System.out.println("result = " + result);
        Leg reverse = new Leg(10, 225, -45);
        result = transformer.transform(result, reverse);
        assertEquals(Coord3D.ORIGIN, result);
    }
}