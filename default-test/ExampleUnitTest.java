/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 */
public class ExampleUnitTest {
    @Test
	public void addition_isCorrect() throws Exception {
		assertEquals(4, 2 + 2);
	}

    @Test
    public void shareProblem() throws InterruptedException {
    	// .....
		Observable.just(200)
 		.subscribeOn(Schedulers.newThread())
		.subscribe(begin.asAction());
		begin.set(200);
		Thread.sleep(1000);
		assertEquals(beginTime.get(), "200");
    	// .....
	}
	// .....
}