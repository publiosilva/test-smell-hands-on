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
