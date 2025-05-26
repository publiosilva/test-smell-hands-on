/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 * 
 * SMELL: Roleta de Asserções (Assertion Roulette)
 * 
 * ONDE ESTÁ O SMELL: O teste contém múltiplas asserções (assertThat) sem mensagens claras
 * que expliquem o que está sendo testado em cada uma. Quando o teste falha, não fica claro
 * qual das asserções falhou e por quê.
 * 
 * COMO REMOVER:
 * 1. Adicionar mensagens descritivas para cada asserção
 * 2. Agrupar asserções relacionadas em métodos separados
 * 3. Usar asserções mais específicas com mensagens claras
 * 
 * Exemplo de correção:
 * - Adicionar mensagens como "O repositório deve conter o objeto Git específico"
 * - Adicionar mensagens como "O arquivo README deve existir no diretório de trabalho"
 * - Adicionar mensagens como "O arquivo README deve ter o tamanho correto"
 */
public class GitAsyncTaskTest {
    @Test
    public void testCloneNonBareRepoFromLocalTestServer() throws Exception {
        Clone cloneOp = new Clone(false, integrationGitServerURIFor("small-repo.early.git"), helper().newFolder());

        Repository repo = executeAndWaitFor(cloneOp);

        assertThat(repo, hasGitObject("ba1f63e4430bff267d112b1e8afc1d6294db0ccc"));

        File readmeFile = new File(repo.getWorkTree(), "README");
        assertThat(readmeFile, exists());
        assertThat(readmeFile, ofLength(12));
    }
}
