/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 * 
 * SMELL: Números Mágicos (Magic Number Test)
 * 
 * ONDE ESTÁ O SMELL: O teste contém valores numéricos literais (15.5D, 15, 30) sem explicação
 * clara do seu significado ou origem. Estes números "mágicos" dificultam a compreensão
 * do propósito do teste e podem tornar a manutenção mais difícil.
 * 
 * COMO REMOVER:
 * 1. Extrair os números mágicos para constantes com nomes significativos
 * 2. Adicionar documentação explicando o significado dos valores
 * 3. Usar constantes do sistema quando apropriado (ex: Calendar.HOUR_OF_DAY)
 * 
 * Exemplo de correção:
 * - Criar constantes como HORA_ESPERADA = 15
 * - Criar constantes como MINUTO_ESPERADO = 30
 * - Documentar o significado do valor 15.5D (longitude)
 */
class SolarEventCalculatorTest {
    @Test
    public void testGetLocalTimeAsCalendar() {
        Calendar localTime = calc.getLocalTimeAsCalendar(BigDecimal.valueOf(15.5D), Calendar.getInstance());
        assertEquals(15, localTime.get(Calendar.HOUR_OF_DAY));
        assertEquals(30, localTime.get(Calendar.MINUTE));
    }
}
