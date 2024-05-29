import entities.Banco;
import entities.CaixaEletronico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CaixaEletronicoTest {

    @Mock //Criando o Mock por anotacao, pois tem +1 tests
    private Banco banco;

    @InjectMocks//Coloca a classe q vai ser testada e ele injeta Spy e Mock dentro da classe que ta anotada
    private CaixaEletronico caixaEletronico;

    //Executa antes de cada test
    @BeforeEach //Fala para o Mockito inicializar
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Teste 1
    @Test
    public void testConsultaSaldoMock() {
        when(banco.getSaldoContaCorrente()).thenReturn(1000.00);
        when(banco.getSaldoContaPoupanca()).thenReturn(5000.00);
        // When utilizar a lista, get chamar saldo, return valor

        caixaEletronico.exibirSaldoContas();

        verify(banco).getSaldoContaCorrente();
        verify(banco).getSaldoContaPoupanca();
    }

    // Teste 2
    @Test
    public void testConsultaSaldoSpy() {
        Banco bancoSpy = Mockito.spy(new Banco());

        when(bancoSpy.getSaldoContaCorrente()).thenReturn(750.00);

        CaixaEletronico caixaEletronico = new CaixaEletronico(bancoSpy);
        caixaEletronico.exibirSaldoContas();

        assertEquals(750.00, bancoSpy.getSaldoContaCorrente());
        assertEquals(14000.0, bancoSpy.getSaldoContaPoupanca());
    }


}
