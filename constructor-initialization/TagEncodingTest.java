/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 * 
 * SMELL: Inicialização no Construtor (Constructor Initialization)
 * 
 * ONDE ESTÁ O SMELL: O teste inicializa objetos (crypto e tagKey) no construtor da classe,
 * o que pode dificultar a reutilização e a manutenção dos testes. Isso pode levar a
 * problemas de acoplamento e dificultar a criação de testes isolados.
 * 
 * COMO REMOVER:
 * 1. Mover a inicialização para métodos de setup, como @Before
 * 2. Usar injeção de dependência para os objetos necessários
 * 3. Garantir que cada teste tenha seu próprio contexto de inicialização
 * 
 * Exemplo de correção:
 * - Usar @Before para inicializar os objetos necessários
 * - Injetar dependências via construtor ou métodos de setup
 * - Garantir que cada teste tenha seu próprio contexto de inicialização
 */
public class TagEncodingTest extends BrambleTestCase {
	private final CryptoComponent crypto;
	private final SecretKey tagKey;
	private final long streamNumber = 1234567890;

	public TagEncodingTest() {
		crypto = new CryptoComponentImpl(new TestSecureRandomProvider());
		tagKey = TestUtils.getSecretKey();
	}

	@Test
	public void testKeyAffectsTag() throws Exception {
		Set set = new HashSet<>();
		for (int i = 0; i < 100; i++) {
			byte[] tag = new byte[TAG_LENGTH];
			SecretKey tagKey = TestUtils.getSecretKey();
			crypto.encodeTag(tag, tagKey, PROTOCOL_VERSION, streamNumber);
			assertTrue(set.add(new Bytes(tag)));
		}
	}
}
