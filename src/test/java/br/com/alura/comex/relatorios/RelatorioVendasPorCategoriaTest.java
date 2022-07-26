package br.com.alura.comex.relatorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;

class RelatorioVendasPorCategoriaTest {

	RelatorioVendasPorCategoria relCategoria = new RelatorioVendasPorCategoria();

	@Test
	void testandoEmCasoDeListaVazia() {
		List<Entry<String, Long>> listaPedido = null;
		   assertEquals(listaPedido, relCategoria.getListaVazia());
	}

}
