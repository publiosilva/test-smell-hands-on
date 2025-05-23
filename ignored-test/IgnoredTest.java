/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 * 
 * SMELL: Teste Ignorado (Ignored Test)
 * 
 * ONDE ESTÁ O SMELL: O teste está marcado com @Ignore, indicando que ele foi desativado
 * temporariamente devido a problemas de instabilidade. Isso pode indicar que o teste
 * não está sendo executado regularmente, o que pode levar a problemas não detectados
 * no código.
 * 
 * COMO REMOVER:
 * 1. Corrigir os problemas que causam a instabilidade do teste
 * 2. Remover a anotação @Ignore e garantir que o teste seja executado regularmente
 * 3. Garantir que o teste seja robusto e não dependa de condições externas instáveis
 * 
 * Exemplo de correção:
 * - Corrigir os problemas que causam a instabilidade do teste
 * - Remover a anotação @Ignore
 * - Garantir que o teste seja robusto e não dependa de condições externas instáveis
 */ 
class IgnoredTest {
    @Ignore("disabled for now as this test is too flaky")
    public void peerPriority() throws Exception {
        final List addresses = Lists.newArrayList(
            new InetSocketAddress("localhost", 2000),
            new InetSocketAddress("localhost", 2001),
            new InetSocketAddress("localhost", 2002)
        );
        peerGroup.addConnectedEventListener(connectedListener);
        // .....
    }
}
