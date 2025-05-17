/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
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