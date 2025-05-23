/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 * 
 * SMELL: Convidado Misterioso (Mystery Guest)
 * 
 * ONDE ESTÁ O SMELL: O teste depende de um estado externo (arquivo temporário) que
 * não é claramente visível no teste. As variáveis 'then' e 'bootTimestamp' são
 * usadas sem serem definidas no teste, tornando difícil entender o contexto
 * completo do teste.
 * 
 * COMO REMOVER:
 * 1. Definir claramente todas as dependências externas no início do teste
 * 2. Usar constantes ou variáveis com nomes significativos
 * 3. Documentar a origem e o propósito de cada dependência
 * 
 * Exemplo de correção:
 * - Definir as constantes THEN e BOOT_TIMESTAMP no início do teste
 * - Usar um diretório de teste específico em vez de arquivo temporário
 * - Adicionar comentários explicando o propósito de cada dependência
 */
class SystemStateTest {
    public void testPersistence() throws Exception {
        File tempFile = File.createTempFile("systemstate-", ".txt");
        try {
            SystemState a = new SystemState(then, 27, false, bootTimestamp);
            a.addInstalledApp("a.b.c", "ABC", "1.2.3");

            a.writeToFile(tempFile);
            SystemState b = SystemState.readFromFile(tempFile);

            assertEquals(a, b);
        } finally {
            //noinspection ConstantConditions
            if (tempFile != null) {
                //noinspection ResultOfMethodCallIgnored
                tempFile.delete();
            }
        }
    }
}
