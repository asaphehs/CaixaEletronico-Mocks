package entities;

public class CaixaEletronico {
    private Banco banco; //Dependencia

    public CaixaEletronico(Banco banco) {
        this.banco = banco;
    }

    public void exibirSaldoContas() {
        double saldoContaCorrente = banco.getSaldoContaCorrente();
        double saldoContaPoupanca = banco.getSaldoContaPoupanca();
        System.out.println("O Saldo da Conta Corrente é: " + saldoContaCorrente);
        System.out.println("O Saldo da Conta Poupança é: " + saldoContaPoupanca);
    }


}
