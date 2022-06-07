import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Criando Estancia do Banco Singleton
        Banco banco = Banco.getInstance();

        //Lendo as contas Salvas nos JSons
        JSONParser arquivoJson = new JSONParser();
        JSONParser arquivoJson2 = new JSONParser();

        try (FileReader arquivo = new FileReader("contasCorrentes.json");
             FileReader arquivo2 = new FileReader("contasPoupacas.json")) {
            JSONArray contasCorrentes = (JSONArray) arquivoJson.parse(arquivo);
            JSONArray contasPoupancas = (JSONArray) arquivoJson2.parse(arquivo2);
            new LerJson(contasCorrentes,contasPoupancas);

        } catch (Exception e) {
            e.printStackTrace();
        }
        int menuPrincipal;
        // Começo do Código


        do{

            System.out.println("========================================");
            System.out.println("======= BEM VINDO AO BANCO DIO =========");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("Escolha a uma opção abaixo:");
            System.out.println("");
            System.out.println("1 -------> Criar Conta");
            System.out.println("2 -------> Acessar Conta");
            System.out.println("0 -------> Sair ");

            menuPrincipal = TratarInputs.menuPrincipal();

            switch (menuPrincipal){
                case 1: CriarConta.menuCriarconta(); break;

                case 2: AcessarConta.menuAcessarConta(); break;
            }

        }while (menuPrincipal!=0);

        System.out.println("========================================");
        System.out.println("======= Obrigado e Volte Sempre ========");
        System.out.println("========================================");
        System.out.println("");

        GravarJson arquivos = new GravarJson();

        arquivos.gravar(Banco.getContasCorrentes(),Banco.getContasPoupancas());


    }
}
