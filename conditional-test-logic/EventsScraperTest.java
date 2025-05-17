/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
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
