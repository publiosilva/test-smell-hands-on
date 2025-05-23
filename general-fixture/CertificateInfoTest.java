/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 * 
 * SMELL: Fixture Geral (General Fixture)
 * 
 * ONDE ESTÁ O SMELL: O método setUp() configura um conjunto geral de fixtures
 * (certificados) que são usados por todos os testes, mesmo que alguns testes
 * não precisem de todos os certificados. Isso torna os testes menos claros
 * e pode impactar o desempenho.
 * 
 * COMO REMOVER:
 * 1. Criar fixtures específicos para cada teste
 * 2. Mover a configuração comum para métodos auxiliares
 * 3. Configurar apenas os dados necessários para cada teste específico
 * 
 * Exemplo de correção:
 * - Criar métodos como setupDebianTestCA(), setupDebianTestNoCA()
 * - Configurar apenas os certificados necessários em cada teste
 * - Usar @Before para configuração mínima comum
 */
class CertificateInfoTest {
    protected void setUp() throws Exception {
        assetManager = getInstrumentation().getContext().getAssets();
        certificateFactory = CertificateFactory.getInstance("X.509");

        infoDebianTestCA = loadCertificateInfo("DebianTestCA.pem");
        infoDebianTestNoCA = loadCertificateInfo("DebianTestNoCA.pem");
        infoGTECyberTrust = loadCertificateInfo("GTECyberTrustGlobalRoot.pem");

        // user-submitted test cases
        infoMehlMX = loadCertificateInfo("mehl.mx.pem");
    }

    public void testIsCA() {
        assertTrue(infoDebianTestCA.isCA());
        assertFalse(infoDebianTestNoCA.isCA());
        assertNull(infoGTECyberTrust.isCA());

        assertFalse(infoMehlMX.isCA());
    }
}