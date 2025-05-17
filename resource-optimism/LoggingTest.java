/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
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