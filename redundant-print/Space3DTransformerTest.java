/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 */ 
class Space3DTransformerTest {
    @Test
    public void testTransform10mNEUAndBack() {
        Leg northEastAndUp10M = new Leg(10, 45, 45);
        Coord3D result = transformer.transform(Coord3D.ORIGIN, northEastAndUp10M);
        System.out.println("result = " + result);
        Leg reverse = new Leg(10, 225, -45);
        result = transformer.transform(result, reverse);
        assertEquals(Coord3D.ORIGIN, result);
    }
}