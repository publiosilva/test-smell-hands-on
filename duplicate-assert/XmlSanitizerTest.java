/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 * 
 * SMELL: Asserção Duplicada (Duplicate Assert)
 * 
 * ONDE ESTÁ O SMELL: O teste contém múltiplas asserções para o mesmo comportamento ou valor,
 * especialmente a linha 'assertEquals("Minus is valid", true, valid);' que aparece duas vezes
 * para a mesma entrada. Isso pode indicar código de teste redundante e dificulta a manutenção.
 * 
 * COMO REMOVER:
 * 1. Remover asserções duplicadas para o mesmo caso de teste
 * 2. Garantir que cada cenário de teste seja verificado apenas uma vez
 * 3. Usar métodos auxiliares ou parametrização para evitar repetição
 * 
 * Exemplo de correção:
 * - Remover a segunda asserção e impressão para o caso 'Fritz-box'
 * - Usar um teste parametrizado para diferentes entradas
 * - Garantir que cada entrada seja testada apenas uma vez
 */
class XmlSanitizerTest {
    @Test
    public void testXmlSanitizer() {
        boolean valid = XmlSanitizer.isValid("Fritzbox");
        assertEquals("Fritzbox is valid", true, valid);
        System.out.println("Pure ASCII test - passed");

        valid = XmlSanitizer.isValid("Fritz Box");
        assertEquals("Spaces are valid", true, valid);
        System.out.println("Spaces test - passed");

        valid = XmlSanitizer.isValid("Frützbüx");
        assertEquals("Frützbüx is invalid", false, valid);
        System.out.println("No ASCII test - passed");

        valid = XmlSanitizer.isValid("Fritz!box");
        assertEquals("Exclamation mark is valid", true, valid);
        System.out.println("Exclamation mark test - passed");

        valid = XmlSanitizer.isValid("Fritz.box");
        assertEquals("Exclamation mark is valid", true, valid);
        System.out.println("Dot test - passed");

        valid = XmlSanitizer.isValid("Fritz-box");
        assertEquals("Minus is valid", true, valid);
        System.out.println("Minus test - passed");
    }
}
