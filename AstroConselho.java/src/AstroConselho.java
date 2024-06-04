import java.util.Scanner;
import java.util.Calendar;

public class AstroConselho {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        
        System.out.println("Informe seu nome: ");
    String nome = ler.nextLine();
    if (nome.length() <= 8) {
        System.out.println("insira seu sobrenome também.");
        return;
    }

    int sexo;
    System.out.println("Informe seu sexo (1 - Feminino, 2 - Masculino): ");
    sexo = ler.nextInt();
    if (sexo != 1 && sexo != 2) {
        System.out.println("Por favor, insira um valor válido para o sexo xiurzao.");
        return;
    }

    int estadoCivil;
    System.out.println("Informe seu estado civil (1 - Solteiro(a), 2 - Casado(a), 3 - Divorciado(a)): ");
    estadoCivil = ler.nextInt();
    if (estadoCivil < 1 || estadoCivil > 3) {
        System.out.println("Por favor, insira um valor válido para o estado civil xiruzão.");
        return;
    }
        System.out.println("Informe o dia de nascimento: ");
        int diaNascimento = ler.nextInt();
        if (diaNascimento < 1 || diaNascimento > 31) {
            System.out.println("que dia é esse xiru.");
            return;
        }

        System.out.println("Informe o mês de nascimento: ");
        int mesNascimento = ler.nextInt();
        if (mesNascimento < 1 || mesNascimento > 12) {
            System.out.println("que mês é esse xiru.");
            return;
        }

        System.out.println("Informe o ano de nascimento: ");
        int anoNascimento = ler.nextInt();
       
        if (anoNascimento < 1900 || anoNascimento > 2024) {
            System.out.println("mas tu é velho ein xiruzão.");
            return;
        }

       
        System.out.println("Informe seu ascendente: ");
        String ascendente = ler.nextLine(); 
        ascendente = ler.nextLine();

        
     
        int idade = Idade(anoNascimento, mesNascimento, diaNascimento);
        String signo = Signo(mesNascimento, diaNascimento);
        int numSorte = NumeroSorte();
        String estadoCivils = "";
        switch (estadoCivil) {
            case 1:
                estadoCivils = "Solteiro(a)";
                break;
            case 2:
                estadoCivils = "Casado(a)";
                break;
            case 3:
                estadoCivils = "Divorciado(a)";
                break;
        }

        if (sexo == 1) {
            System.out.println("Sra." + nome + ", " + estadoCivils + ", nascida no dia " + diaNascimento + "-" + mesNascimento + "-" + anoNascimento +
                    ", é do signo de " + signo + " - você tem " + idade + " anos - seu nº da sorte é " + numSorte + " e seu ascendente é " + ascendente + ".");
        } else {
            System.out.println("Sr." + nome + ", " + estadoCivils + ", nascido no dia " + diaNascimento + "-" + mesNascimento + "-" + anoNascimento +
                    ", é do signo de " + signo + " - você tem " + idade + " anos - seu nº da sorte é " + numSorte + " e seu ascendente é " + ascendente + ".");
        }
    }

   
    private static int Idade(int ano, int mes, int dia) {
        Calendar hoje = Calendar.getInstance();
        int diaAtual = hoje.get(Calendar.DATE);
        int mesAtual = hoje.get(Calendar.MONTH) + 1; 
        int anoAtual = hoje.get(Calendar.YEAR);

        int idade = anoAtual - ano;
        if (mesAtual < mes || (mesAtual == mes && diaAtual < dia)) {
            idade--; 
        }
        return idade;
        
    }

   
    private static String Signo(int mes, int dia) {
    String[] signos = {"Capricórnio", "Aquário", "Peixes", "Áries", "Touro", "Gêmeos", "Câncer", "Leão", "Virgem", "Libra", "Escorpião", "Sagitário"};
    int[] dias = {22, 20, 20, 20, 20, 21, 22, 22, 22, 22, 21, 21};
    return signos[(mes + (dia < dias[mes - 0] ? 10 : 11)) % 12];
}
    

       


    private static int NumeroSorte() {
        return (int) (1 + Math.random() * 99);
    }
}

