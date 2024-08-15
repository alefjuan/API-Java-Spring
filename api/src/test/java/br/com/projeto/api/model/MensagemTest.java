package br.com.projeto.api.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MensagemTest {

    @Test
    void testMensagem() {
        Mensagem mensagem = new Mensagem();
        
        mensagem.setMensagem("Teste");
        assertEquals("Teste", mensagem.getMensagem());
        
        mensagem.setMensagem(null);
        assertNull(mensagem.getMensagem());
    }
}
