import java.util.Scanner;

public class TratarInputs {

    public static int menuPrincipal(){

        while (true){
            try{
                Scanner sc = new Scanner(System.in);
                int menu = sc.nextInt();
                if(menu>=0&& menu<3) return menu;

            }catch (Exception e){

            }
        }
    }

    public static int menuConta(){

        while (true){
            try{
                Scanner sc = new Scanner(System.in);
                int menu = sc.nextInt();
                if(menu>=0&& menu<5) return menu;

            }catch (Exception e){

            }

        }
    }

    public static double rendaInput(){

        while (true){
            try{
                Scanner sc = new Scanner(System.in);
                double renda = sc.nextDouble();
                return renda;

            }catch (Exception e){

            }

        }
    }

    public static String celularInput(){

        while (true){
            try{
                Scanner sc = new Scanner(System.in);
                String celular = sc.nextLine();
                return celular;
            }catch (Exception e){

            }
        }
    }

    public static String cpfInput(){

        while (true){
            try{
                Scanner sc = new Scanner(System.in);
                String cpf = sc.nextLine();
                if (cpf.length()==11){

                    int[] cpfArray = new int[11];

                    for (int i = 0; i <cpf.length() ; i++) {
                        cpfArray[i]=Character.getNumericValue(cpf.charAt(i));
                    }

                    int digito1=0;
                    int digito2=0;
                    int y=2;
                    for (int i = 8; i >=0 ; i--) {
                        digito1 += (cpfArray[i]*y);
                        y++;
                    }
                    digito1 %=11;

                    if (digito1<2) digito1=0; else digito1 =11-digito1;

                    y=2;

                    for (int i = 9; i >=0 ; i--) {
                        digito2 += (cpfArray[i]*y);
                        y++;
                    }
                    digito2 %=11;

                    if (digito2<2) digito2=0; else digito2 =11-digito2;

                    if(digito1==cpfArray[9]&& digito2==cpfArray[10]) return cpf; else System.out.println("\nInforme um cpf válido");

                }
            }catch (Exception e){
                System.out.println("\nInforme um cpf válido");
            }
        }
    }


    public static int numeroCCInput(){

        while (true){
            try{
                Scanner sc = new Scanner(System.in);
                int numero = sc.nextInt();

                if (numero>0 && numero<=Banco.getContasCorrentes().size()) return numero;

            }catch (Exception e){

            }
        }

    }
    public static int numeroCPInput(){

        while (true){
            try{
                Scanner sc = new Scanner(System.in);
                int numero = sc.nextInt();

                if (numero>0 && numero<=Banco.getContasPoupancas().size()) return numero;

            }catch (Exception e){

            }
        }

    }

    public static double depositarInput(){

        while (true){
            try{
                Scanner sc = new Scanner(System.in);
                System.out.println("Quanto deseja depositar: ");
                double numero = sc.nextDouble();
                return numero;
            }catch (Exception e){

            }
        }

    }
    public static double sacarInput(){

        while (true){
            try{
                Scanner sc = new Scanner(System.in);
                System.out.println("Quanto deseja sacar: ");
                double numero = sc.nextDouble();
                return numero;

            }catch (Exception e){

            }
        }

    }

    public static double transferirInput(){

        while (true){
            try{
                Scanner sc = new Scanner(System.in);
                double numero = sc.nextDouble();
                return numero;

            }catch (Exception e){

            }
        }

    }
    public static int tipoContaInput(){

        while (true){
            try{
                Scanner sc = new Scanner(System.in);
                int numero = sc.nextInt();
                if(numero==1 || numero==2) return numero;

            }catch (Exception e){

            }
        }

    }
    public static int numeroInput(){

        while (true){
            try{
                Scanner sc = new Scanner(System.in);
                int numero = sc.nextInt();

                return numero;

            }catch (Exception e){

            }
        }

    }

}
