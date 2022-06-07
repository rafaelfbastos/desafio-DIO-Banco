public class ContaCorrente extends Conta {

    private double limite;


    private double limiteUtilizado;

    public ContaCorrente(int numero, Cliente cliente) {
        super(numero, cliente);
        limiteUtilizado = 0;
        if (cliente.getRenda() < 1000) {
            limite = 500;
        } else if (cliente.getRenda() < 5000) {
            limite = 1000;
        } else if (cliente.getRenda() < 10000) {
            limite = 3000;
        } else {
            limite = (long) cliente.getRenda() * 0.40;
        }

    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("\nR$ " + valor + " sacado com sucesso.\nSaldo atual: R$ " + saldo);
            System.out.println("\nSaldo atual: R$" + saldo);
            System.out.println("\n");

        } else if (valor <= saldo + (limite-limiteUtilizado)) {
            limiteUtilizado += (valor - saldo);
            saldo = 0;

            System.out.println("\nR$ " + valor + " sacado com sucesso.\nSaldo atual: R$ " + -limiteUtilizado);
            System.out.println("\n");

        } else {
            System.out.println("\nSaldo insuficiente");
            System.out.println("\n");
        }

    }

    @Override
    public void transferir(double valor, int nConta, int operacao) {

        if(operacao==1){
            try {
                ContaCorrente destino = Banco.getContaCorrente(nConta);
                if (valor <= saldo) {
                    saldo -= valor;
                    destino.saldo += valor;
                    System.out.println("\nR$ " + valor + " Transferido com sucesso para: " + destino.getCliente().getNome()
                            + "\nSaldo atual: R$ " + saldo);
                    System.out.println("\n");
                } else if (valor<=saldo+(limite-limiteUtilizado)){
                    limiteUtilizado += (valor - saldo);
                    saldo = 0;
                    destino.saldo += valor;
                    System.out.println("\nR$ " + valor + " Transferido com sucesso para: " + destino.getCliente().getNome()
                            + "\nSaldo atual: R$ " + -limiteUtilizado);
                    System.out.println("\n");
                }else{System.out.println("\nSaldo insuficiente");System.out.println("\n");}

            } catch (IndexOutOfBoundsException E) {
                System.out.println("\nConta destino não encontrada");
                System.out.println("\n");
            }
        }
        if(operacao==2){
            try {
                ContaPoupanca destino = Banco.getContaPoupanca(nConta);
                if (valor <= saldo) {
                    saldo -= valor;
                    destino.saldo += valor;
                    System.out.println("\nR$ " + valor + " Transferido com sucesso para: " + destino.getCliente().getNome()
                            + "\nSaldo atual: R$ " + saldo);
                    System.out.println("\n");
                } else if (valor<=saldo+(limite-limiteUtilizado)){
                    limiteUtilizado += (valor - saldo);
                    saldo = 0;
                    destino.saldo += valor;
                    System.out.println("\nR$ " + valor + " Transferido com sucesso para: " + destino.getCliente().getNome()
                            + "\nSaldo atual: R$ " + -limiteUtilizado);
                    System.out.println("\n");
                }else{System.out.println("\nSaldo insuficiente"); System.out.println("\n");}

            } catch (IndexOutOfBoundsException E) {
                System.out.println("\nConta destino não encontrada"); System.out.println("\n");;
            }
        }
    }


    @Override
    public void depositar(double valor) {
        if (limiteUtilizado==0){
            super.depositar(valor);
        }
        else {
            if (valor>=limiteUtilizado){
                saldo+=(valor-limiteUtilizado);
                limiteUtilizado=0;
                System.out.println("\nR$ "+valor+" depositado com sucesso.\nSaldo atual: R$ "+saldo);
                System.out.println("\n");
            }else {
                limiteUtilizado-=valor;
                System.out.println("\nR$ "+valor+" depositado com sucesso.\nSaldo atual: R$ "+-limiteUtilizado);
                System.out.println("\n");
            }
        }
    }

    @Override
    public void mostrarSaldo() {

        if (limiteUtilizado==0){
            System.out.println("\nSaldo da Conta: R$ " + saldo);
            System.out.println("\nLimite Utilizado: R$ " + limiteUtilizado);
            System.out.println("\nLimite Disponível: R$ " + (limite - limiteUtilizado));
            System.out.println("\n");
        }

        else {
            System.out.println("\nSaldo da Conta: R$ " + -limiteUtilizado);
            System.out.println("\nLimite Utilizado: R$ " + limiteUtilizado);
            System.out.println("\nLimite Disponível: R$ " + (limite - limiteUtilizado));
            System.out.println("\n");
        }
    }

    public double getLimite(){
        return limite;
    }
    public double getLimiteUtilizado(){
        return limiteUtilizado;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void setLimiteUtilizado(double limiteUtilizado) {
        this.limiteUtilizado = limiteUtilizado;
    }
}

