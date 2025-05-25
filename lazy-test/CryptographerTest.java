/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 * 
 * SMELL: Teste Preguiçoso (Lazy Test)
 * 
 * ONDE ESTÁ O SMELL: Os métodos testDecrypt e testEncrypt estão testando o mesmo comportamento
 * do sistema de forma redundante. Ambos os testes verificam a funcionalidade de criptografia,
 * mas de maneiras diferentes, o que pode levar a manutenção desnecessária e duplicação de código.
 * 
 * COMO REMOVER:
 * 1. Unificar os testes em um único método parametrizado
 * 2. Usar @ParameterizedTest do JUnit 5 para testar diferentes cenários
 * 3. Eliminar a duplicação de código nos testes
 * 
 * Exemplo de correção:
 * - Criar um único teste parametrizado que cubra todos os cenários
 * - Usar @MethodSource para fornecer diferentes dados de teste
 * - Manter a cobertura de testes enquanto reduz a duplicação
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
