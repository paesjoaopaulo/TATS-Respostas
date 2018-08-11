
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import paesjoaopaulo.maventeste.SenhaValidator;
import paesjoaopaulo.maventeste.Usuario;
import paesjoaopaulo.maventeste.UsuarioDAO;
import paesjoaopaulo.maventeste.UsuarioValidator;

/**
 *
 * @author João Paulo Paes
 */
public class TesteCobertura {

    private UsuarioDAO ud;
    private SenhaValidator sv;
    private UsuarioValidator uv;
    private Usuario us;

    public TesteCobertura() {
        ud = Mockito.mock(UsuarioDAO.class);
        sv = Mockito.mock(SenhaValidator.class);
        uv = new UsuarioValidator(ud);
        us = new Usuario();
    }

    @Test(expected = Exception.class)
    public void testNomeCurto() throws Exception {
        uv.setSenhaValidator(sv);
        us.setNome("Joao");
        uv.ehUsuarioValido(us);
    }

    @Test(expected = Exception.class)
    public void testSenhasDiferentes() throws Exception {
        uv.setSenhaValidator(sv);
        us.setNome("Joao Paulo");
        us.setSenha("joao#");
        us.setSenhaConfirmada("joao@");
        uv.ehUsuarioValido(us);
    }

    @Test(expected = Exception.class)
    public void testSenhasInvalida() throws Exception {
        uv.setSenhaValidator(sv);
        us.setNome("Joao Paulo");
        us.setSenha("joao#");
        us.setSenhaConfirmada("joao#");
        Mockito.when(sv.verificar("joao#")).thenReturn(Boolean.TRUE);
        uv.ehUsuarioValido(us);
    }

    @Test(expected = Exception.class)
    public void testUsuarioComArrobaJaExiste() throws Exception {
        uv.setSenhaValidator(sv);
        us.setNome("Joao@Paulo");
        us.setSenha("joao#");
        us.setSenhaConfirmada("joao#");
        Mockito.when(sv.verificar("joao#")).thenReturn(Boolean.FALSE);
        Mockito.when(ud.getByName("Joao@Paulo")).thenReturn(us);
        uv.ehUsuarioValido(us);
    }

    @Test
    public void testUsuarioComArrobaNaoExiste() {
        uv.setSenhaValidator(sv);
        us.setNome("Joao@Paulo");
        us.setSenha("joao#");
        us.setSenhaConfirmada("joao#");
        Mockito.when(sv.verificar("joao#")).thenReturn(Boolean.FALSE);
        Mockito.when(ud.getByName("Joao@Paulo")).thenReturn(null);
        try {
            uv.ehUsuarioValido(us);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }
}
