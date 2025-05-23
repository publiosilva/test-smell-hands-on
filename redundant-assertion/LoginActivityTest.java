/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 * 
 * SMELL: Asserção Redundante (Redundant Assertion)
 * 
 * ONDE ESTÁ O SMELL: O teste contém uma asserção que compara true com true, o que
 * é uma verificação redundante e sem sentido. Este tipo de teste não verifica
 * nenhum comportamento real do sistema e sempre passará.
 * 
 * COMO REMOVER:
 * 1. Remover asserções que sempre serão verdadeiras
 * 2. Adicionar asserções que verificam comportamentos reais do sistema
 * 3. Garantir que o teste valida funcionalidades específicas
 * 
 * Exemplo de correção:
 * - Testar a validação real de login
 * - Verificar o comportamento com credenciais válidas e inválidas
 * - Testar o fluxo de autenticação completo
 */
class LoginActivityTest {
    @Test
    public void testTrue() {
        assertEquals(true, true);
    }
}