/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
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
