/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 * 
 * SMELL: Teste Padrão (Default Test)
 * 
 * ONDE ESTÁ O SMELL: O teste contém um método de teste (addition_isCorrect) que
 * verifica uma operação trivial (2 + 2 = 4), o que não contribui para a validação
 * do comportamento do sistema. Isso pode indicar que o teste foi criado como um
 * exemplo padrão e não foi adaptado para testar funcionalidades reais.
 * 
 * COMO REMOVER:
 * 1. Remover testes que não verificam comportamentos reais do sistema
 * 2. Adicionar testes que validem funcionalidades específicas
 * 3. Garantir que cada teste tenha um propósito claro e relevante
 * 
 * Exemplo de correção:
 * - Remover o teste addition_isCorrect
 * - Adicionar testes que validem funcionalidades específicas do sistema
 * - Garantir que cada teste tenha um propósito claro e relevante
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