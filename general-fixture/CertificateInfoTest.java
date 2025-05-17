/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
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