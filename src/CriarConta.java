import java.util.Scanner;

public class CriarConta {

    public static void menuCriarconta(){
        int menu;
        do {
            System.out.println("========================================");
            System.out.println("========== CRIAR NOVA CONTA ============");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("Qual tipo de conta deseja Criar");
            System.out.println("");
            System.out.println("1 -------> Criar Conta Corrente");
            System.out.println("2 -------> Criar conta Poupança");
            System.out.println("0 -------> Voltar ");

            menu = TratarInputs.menuPrincipal();

            switch (menu){
                case 1: Banco.novaContaCorrente(criarClientes());

                        System.out.println("\n\nConta criada com sucesso:\nNº da conta : "
                                +Banco.getContasCorrentes().size()+"\n\n");

                         break;
                case 2: Banco.novaContaPoupanca(criarClientes());
                        System.out.println("\n\nConta criada com sucesso:\nNº da conta : "
                                +Banco.getContasPoupancas().size() +"\n\n");
                        break;
            }

        }while (menu!=0);


    }

    public static Cliente criarClientes(){
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("Informe o nome:");
        String nome = sc.nextLine();
        System.out.println("Informe endereço:");
        String endereco = sc.nextLine();
        System.out.println("Informe a renda:");
        Double renda = TratarInputs.rendaInput();
        System.out.println("Informe o número do Celular");
        String celular = TratarInputs.celularInput();
        System.out.println("Informe o CPF:");
        String cpf = TratarInputs.cpfInput();
        System.out.println("Digite uma senha:");
        String senha = sc.nextLine();
        senha = String.format("%d",senha.hashCode());

        return new Cliente(nome,endereco,renda,celular,cpf,senha);

    }
}
