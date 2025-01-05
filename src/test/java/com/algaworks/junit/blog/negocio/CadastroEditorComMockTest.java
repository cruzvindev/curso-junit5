package com.algaworks.junit.blog.negocio;

import com.algaworks.junit.blog.armazenamento.ArmazenamentoEditor;
import com.algaworks.junit.blog.modelo.Editor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.math.BigDecimal.TEN;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
public class CadastroEditorComMockTest {

    Editor editor;
    @Mock
    ArmazenamentoEditor armazenamentoEditor; //Os mocks são criados novamente a cada teste
    @Mock
    GerenciadorEnvioEmail gerenciadorEnvioEmail;
    @InjectMocks
    CadastroEditor cadastroEditor;

    @BeforeEach
    void init(){
        editor = new Editor(null, "Vinicius", "vinicius@email.com", TEN, true);
        Mockito.when(armazenamentoEditor.salvar(editor))
                .thenReturn(new Editor(1L, "Vinicius", "vinicius@email.com", TEN, true));
    }

    @Test
    void Dado_um_edito_valido_Quando_criar_Entao_deve_retornar_um_id_de_cadastro(){
        Editor editorSalvo = cadastroEditor.criar(editor);
        assertEquals(1L, editorSalvo.getId());
    }

}
