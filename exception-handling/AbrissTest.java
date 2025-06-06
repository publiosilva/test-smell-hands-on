/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 * 
 * SMELL: Tratamento de Exceção (Exception Handling)
 * 
 * ONDE ESTÁ O SMELL: O teste captura uma exceção (CalculationException) e falha
 * o teste com a mensagem da exceção, mas não verifica se a exceção é a esperada
 * ou se o comportamento do sistema está correto. Isso pode mascarar problemas
 * reais no código.
 * 
 * COMO REMOVER:
 * 1. Verificar se a exceção é a esperada e se a mensagem é a correta
 * 2. Usar asserções específicas para verificar o comportamento do sistema
 * 3. Garantir que o teste falhe de forma clara e informativa
 * 
 * Exemplo de correção:
 * - Verificar se a exceção é do tipo esperado
 * - Adicionar asserções para verificar a mensagem da exceção
 * - Garantir que o teste falhe de forma clara e informativa
 */
class AbrissTest {
    @Test
    public void realCase() {
        Point p34 = new Point("34", 556506.667, 172513.91, 620.34, true);
        Point p45 = new Point("45", 556495.16, 172493.912, 623.37, true);
        Point p47 = new Point("47", 556612.21, 172489.274, 0.0, true);
        Abriss a = new Abriss(p34, false);
        a.removeDAO(CalculationsDataSource.getInstance());
        a.getMeasures().add(new Measure(p45, 0.0, 91.6892, 23.277, 1.63));
        a.getMeasures().add(new Measure(p47, 281.3521, 100.0471, 108.384, 1.63));

        try {
            a.compute();
        } catch (CalculationException e) {
            Assert.fail(e.getMessage());
        }

        // test intermediate values with point 45
        Assert.assertEquals("233.2405",
            this.df4.format(a.getResults().get(0).getUnknownOrientation()));
        Assert.assertEquals("233.2435",
            this.df4.format(a.getResults().get(0).getOrientedDirection()));
        Assert.assertEquals("-0.1", this.df1.format(
            a.getResults().get(0).getErrTrans()));

        // test intermediate values with point 47
        Assert.assertEquals("233.2466",
            this.df4.format(a.getResults().get(1).getUnknownOrientation()));
        Assert.assertEquals("114.5956",
            this.df4.format(a.getResults().get(1).getOrientedDirection()));
        Assert.assertEquals("0.5", this.df1.format(
            a.getResults().get(1).getErrTrans()));

        // test final results
        Assert.assertEquals("233.2435", this.df4.format(a.getMean()));
        Assert.assertEquals("43", this.df0.format(a.getMSE()));
        Assert.assertEquals("30", this.df0.format(a.getMeanErrComp()));
    }
}
