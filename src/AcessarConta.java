import java.util.Scanner;

public class AcessarConta {

    public static void menuAcessarConta(){
        int menu;
        do {
            System.out.println("========================================");
            System.out.println("========== ACESSE SUA CONTA ============");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("Qual tipo de conta deseja acessar");
            System.out.println("");
            System.out.println("1 -------> Conta Corrente");
            System.out.println("2 -------> Conta Poupança");
            System.out.println("0 -------> Voltar ");

            menu = TratarInputs.menuPrincipal();

            switch (menu){
                case 1: loginCC(); break;

                case 2:  loginCP(); break;

            }

        }while (menu!=0);
    }

    public static void loginCC(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o número da conta:");
        int numero = TratarInputs.numeroCCInput();
        System.out.println("Informe a senha: ");
        String senha = sc.nextLine();
        senha = String.format("%d",senha.hashCode());

        if(Banco.getContaCorrente(numero).getCliente().getSenha().equals(senha)) logarCC(Banco.getContaCorrente(numero)); else System.out.println("\n Senha não confere");

    }

    public static void logarCC(ContaCorrente conta){

        int menu;

        do{
            System.out.println("========================================");
            System.out.println("========== Conta Corrente ==============");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("Seja bem vindo "+conta.getCliente().getNome());
            System.out.println("Oque deseja fazer\n");
            System.out.println("1 -------> Ver saldo");
            System.out.println("2 -------> Depositar");
            System.out.println("3 -------> Sacar");
            System.out.println("4 -------> Transferir");
            System.out.println("0 -------> Voltar ");

            menu = TratarInputs.menuConta();

            switch (menu){
                case 1: conta.mostrarSaldo(); break;

                case 2: conta.depositar(TratarInputs.depositarInput()); break;

                case 3: conta.sacar(TratarInputs.sacarInput()); break;

                case 4: menuTransferir(conta);

            }

        }while (menu!=0);

    }
    public static void loginCP(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o número da conta:");
        int numero = TratarInputs.numeroCPInput();
        System.out.println("Informe a senha: ");
        String senha = sc.nextLine();
        senha = String.format("%d",senha.hashCode());

        if(Banco.getContaPoupanca(numero).getCliente().getSenha().equals(senha)) logarCP(Banco.getContaPoupanca(numero)); else System.out.println("\n Senha não confere");

    }

    public static void logarCP(ContaPoupanca conta) {

        int menu;

        do {
            System.out.println("========================================");
            System.out.println("========== Conta Corrente ==============");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("Seja bem vindo " + conta.getCliente().getNome());
            System.out.println("Oque deseja fazer\n");
            System.out.println("1 -------> Ver saldo");
            System.out.println("2 -------> Depositar");
            System.out.println("3 -------> Sacar");
            System.out.println("4 -------> Transferir");
            System.out.println("0 -------> Voltar");

            menu = TratarInputs.menuConta();

            switch (menu){
                case 1: conta.mostrarSaldo(); break;

                case 2: conta.depositar(TratarInputs.depositarInput()); break;

                case 3: conta.sacar(TratarInputs.sacarInput()); break;

                case 4: menuTransferir(conta);

            }

        } while (menu != 0);
    }

    public static void menuTransferir(ContaCorrente conta){

        System.out.println("Quanto deseja Transfer");
        double valor = TratarInputs.transferirInput();
        System.out.println("Informe o tipo de conta:\n1- Conta corrente\n2- Conta Poupança ");
        int tipo = TratarInputs.tipoContaInput();
        System.out.println("Informe o número da conta destino");
        int numero = TratarInputs.numeroInput();
        conta.transferir(valor,numero,tipo);

    }
    public static void menuTransferir(ContaPoupanca conta){

        System.out.println("Quanto deseja Transfer");
        double valor = TratarInputs.transferirInput();
        System.out.println("Informe o tipo de conta:\n1- Conta corrente\n2- Conta Poupança ");
        int tipo = TratarInputs.tipoContaInput();
        System.out.println("Informe o número da conta destino");
        int numero = TratarInputs.numeroInput();
        conta.transferir(valor,numero,tipo);

    }
}
