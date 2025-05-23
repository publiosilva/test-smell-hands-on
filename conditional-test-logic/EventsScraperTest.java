/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 * 
 * SMELL: Lógica Condicional no Teste (Conditional Test Logic)
 * 
 * ONDE ESTÁ O SMELL: O teste contém lógica condicional complexa (if/for aninhados) que
 * torna o fluxo do teste difícil de entender e manter. A presença de condições dentro
 * do teste pode fazer com que partes do código de teste não sejam executadas, tornando
 * o teste menos confiável.
 * 
 * COMO REMOVER:
 * 1. Separar os casos de teste em métodos individuais
 * 2. Usar @ParameterizedTest para testar diferentes cenários
 * 3. Remover a lógica condicional e criar testes específicos para cada caso
 * 
 * Exemplo de correção:
 * - Criar um teste separado para cada fonte (source)
 * - Usar @ParameterizedTest com diferentes combinações de entrada
 * - Remover os loops e condicionais, testando um caso por vez
 */
class EventsScraperTest {
    @Test
    public void testSpinner() {
        for (Map.Entry entry : sourcesMap.entrySet()) {

            String id = entry.getKey();
            Object resultObject = resultsMap.get(id);
            if (resultObject instanceof EventsModel) {
                EventsModel result = (EventsModel) resultObject;
                if (result.testSpinner.runTest) {
                    System.out.println("Testing " + id + " (testSpinner)");
                    //System.out.println(result);
                    AnswerObject answer = new AnswerObject(entry.getValue(), "", new CookieManager(), "");
                    EventsScraper scraper = new EventsScraper(RuntimeEnvironment.application, answer);
                    SpinnerAdapter spinnerAdapter = scraper.spinnerAdapter();
                    assertEquals(spinnerAdapter.getCount(), result.testSpinner.data.size());
                    for (int i = 0; i < spinnerAdapter.getCount(); i++) {
                        assertEquals(spinnerAdapter.getItem(i), result.testSpinner.data.get(i));
                    }
                }
            }
        }
    }
}
