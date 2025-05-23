/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 * 
 * SMELL: Otimismo de Recursos (Resource Optimism)
 * 
 * ONDE ESTÁ O SMELL: O teste assume que o arquivo temporário será criado com sucesso
 * e que o diretório /tmp está disponível e acessível. Não há verificação ou tratamento
 * de erro caso o recurso não esteja disponível, o que pode causar falhas intermitentes
 * nos testes em diferentes ambientes.
 * 
 * COMO REMOVER:
 * 1. Adicionar verificações para garantir que o recurso está disponível
 * 2. Tratar possíveis exceções e falhas de criação de arquivos
 * 3. Usar diretórios temporários fornecidos pela API do sistema ou frameworks de teste
 * 
 * Exemplo de correção:
 * - Usar Files.createTempDirectory() para garantir um diretório temporário válido
 * - Adicionar asserções para verificar se o arquivo foi criado com sucesso
 * - Tratar IOException de forma adequada
 */
class LoggingTest {
    @Test
    public void saveImage_noImageFile_ko() throws IOException {
    File outputFile = File.createTempFile("prefix", "png", new File("/tmp"));
    ProductImage image = new ProductImage("01010101010101", ProductImageField.FRONT, outputFile);
    Response response = serviceWrite.saveImage(image.getCode(), image.getField(), image.getImguploadFront(), image.getImguploadIngredients(), image.getImguploadNutrition()).execute();
    assertTrue(response.isSuccess());
    assertThatJson(response.body())
        .node("status")
            .isEqualTo("status not ok");
    }
}