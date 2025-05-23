/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 * 
 * SMELL: Teste Desconhecido (Unknown Test)
 * 
 * ONDE ESTÁ O SMELL: O teste não possui nenhuma asserção para verificar o comportamento
 * do sistema. Ele apenas executa código e imprime resultados, sem validar se o resultado
 * está correto ou não.
 * 
 * COMO REMOVER:
 * 1. Adicionar asserções que validem o comportamento esperado
 * 2. Remover instruções de impressão desnecessárias
 * 3. Garantir que o teste falhe caso o comportamento não seja o esperado
 * 
 * Exemplo de correção:
 * - Adicionar assertEquals, assertNotNull ou outras asserções relevantes
 * - Verificar se a lista de categorias não está vazia
 * - Validar propriedades específicas dos objetos retornados
 */
class RetrofitApiClientIntegrationTest {
    @Test
    public void hitGetPOICategoriesApi() throws Exception {
        POICategories poiCategories = apiClient.getPOICategories(16);
        for (POICategory category : poiCategories) {
        System.out.println(category.name() + ": " + category);
        }
    }
}