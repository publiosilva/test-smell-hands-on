/**
 * Example extracted from https://testsmells.org/pages/testsmellexamples.html
 * 
 * SMELL: Teste Sonolento (Sleepy Test)
 * 
 * ONDE ESTÁ O SMELL: O teste usa Thread.sleep(500) para esperar por uma operação
 * assíncrona completar. Este tipo de espera fixa é frágil, pois o tempo real
 * necessário pode variar dependendo da carga do sistema, tornando os testes
 * instáveis e lentos.
 * 
 * COMO REMOVER:
 * 1. Usar mecanismos de espera explícitos (ex: waitForCondition)
 * 2. Implementar callbacks ou listeners para operações assíncronas
 * 3. Usar bibliotecas de teste que suportam espera inteligente
 * 
 * Exemplo de correção:
 * - Implementar um mecanismo de callback para notificar quando a busca estiver completa
 * - Usar waitForCondition para esperar até que o resultado esteja disponível
 * - Adicionar timeouts configuráveis para evitar esperas infinitas
 */
class ResultActivityTest {
    public void testEdictExternSearch() throws Exception {
        final Intent i = new Intent(getInstrumentation().getContext(), ResultActivity.class);
        i.setAction(ResultActivity.EDICT_ACTION_INTERCEPT);
        i.putExtra(ResultActivity.EDICT_INTENTKEY_KANJIS, "空白");
        tester.startActivity(i);
        assertTrue(tester.getText(R.id.textSelectedDictionary).contains("Default"));
        final ListView lv = getActivity().getListView();
        assertEquals(1, lv.getCount());
        DictEntry entry = (DictEntry) lv.getItemAtPosition(0);
        assertEquals("Searching", entry.english);
        Thread.sleep(500);
        final Intent i2 = getStartedActivityIntent();
        final List result = (List) i2.getSerializableExtra(ResultActivity.INTENTKEY_RESULT_LIST);
        entry = result.get(0);
        assertEquals("(adj-na,n,adj-no) blank space/vacuum/space/null (NUL)/(P)", entry.english);
        assertEquals("空白", entry.getJapanese());
        assertEquals("くうはく", entry.reading);
        assertEquals(1, result.size());
    }
}
