/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 * 
 * SMELL: Teste Preguiçoso (Lazy Test)
 * 
 * ONDE ESTÁ O SMELL: O teste não verifica adequadamente o comportamento do sistema,
 * especialmente no método testDecrypt, onde a leitura do arquivo e a comparação
 * são feitas de forma simplificada, sem garantir que o resultado seja o esperado.
 * Isso pode levar a testes que não validam corretamente o comportamento do sistema.
 * 
 * COMO REMOVER:
 * 1. Adicionar asserções que validem o comportamento esperado do sistema
 * 2. Garantir que o teste verifique o resultado de forma adequada
 * 3. Usar dados de teste que cubram diferentes cenários
 * 
 * Exemplo de correção:
 * - Adicionar asserções para verificar o conteúdo do arquivo
 * - Garantir que o teste verifique o resultado de forma adequada
 * - Usar dados de teste que cubram diferentes cenários
 */
class CryptographerTest {
    @Test
    public void testDecrypt() throws Exception {
        FileInputStream file = new FileInputStream(ENCRYPTED_DATA_FILE_4_14);
        byte[] enfileData = new byte[file.available()];
        FileInputStream input = new FileInputStream(DECRYPTED_DATA_FILE_4_14);
        byte[] fileData = new byte[input.available()];
        input.read(fileData);
        input.close();
        file.read(enfileData);
        file.close();
        String expectedResult = new String(fileData, "UTF-8");
        assertEquals("Testing simple decrypt",expectedResult, Cryptographer.decrypt(enfileData, "test"));
    }

    @Test
    public void testEncrypt() throws Exception {
        String xml = readFileAsString(DECRYPTED_DATA_FILE_4_14);
        byte[] encrypted = Cryptographer.encrypt(xml, "test");
        String decrypt = Cryptographer.decrypt(encrypted, "test");
        assertEquals(xml, decrypt);
    }
}
