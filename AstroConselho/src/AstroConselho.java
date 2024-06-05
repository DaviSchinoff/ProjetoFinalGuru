import java.util.Scanner;
import java.util.Calendar;

public class AstroConselho {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Informe seu nome: ");
        String nome = ler.nextLine();
        if (nome.length() <= 8) {
            System.out.println("Insira seu sobrenome também.");
            return;
        }

        System.out.println("Informe seu sexo (1 - Feminino, 2 - Masculino): ");
        int sexo = ler.nextInt();
        if (sexo != 1 && sexo != 2) {
            System.out.println("Por favor, insira um valor válido para o sexo.");
            return;
        }
        System.out.println("Informe seu estado civil (1 - Solteiro(a), 2 - Casado(a), 3 - Divorciado(a)): ");
        int estadoCivil = ler.nextInt();
        if (estadoCivil < 1 || estadoCivil > 3) {
            System.out.println("Por favor, insira um valor válido para o estado civil.");
            return;
        } System.out.println("Informe o dia que você nasceu: ");
        int diaNas = ler.nextInt();
        if (diaNas < 1 || diaNas > 31) {
            System.out.println("para de sacanear xiruzão.");
            return;
        }
        System.out.println("Informe o mês que você nasceu: ");
        int mesNas = ler.nextInt();
        if (mesNas < 1 || mesNas > 12) {
            System.out.println("para de sacanear xiruzão.");
            return;
        }
         System.out.println("Informe o ano que voce nasceu: ");
        int anoNas = ler.nextInt();
        if (anoNas < 1900 || anoNas > 2024) {
            System.out.println("ou tu já morreu ou ainda não nasceu xiruzão.");
            return;
        }

        System.out.println("Informe seu ascendente: ");
        String ascendente = ler.next();

        int idade = Idade(anoNas, mesNas, diaNas);
        String signo = Signo(mesNas, diaNas);
        int numerodasorte = Sorte();
        String estadoCivils = EstadoCivil(estadoCivil);

        String pronomes = (sexo == 1) ? "Sra." : "Sr.";
        System.out.println(pronomes + nome + ", " + estadoCivils + ", nascido(a) em " + diaNas + "-" + mesNas + "-" + anoNas +
                ", é do signo de " + signo + ", tem " + idade + " anos, seu número da sorte é " + numerodasorte + " e seu ascendente é " + ascendente + ".");
    }

    private static int Idade(int anoNasc, int mes, int dia) {
        Calendar hoje = Calendar.getInstance();
        int diaHJ = hoje.get(Calendar.DATE);
        int mesHJ = hoje.get(Calendar.MONTH) + 1; 
        int anoHJ = hoje.get(Calendar.YEAR);

        int idade = anoHJ - anoNasc;
        if (mesHJ < mes || (mesHJ == mes && diaHJ < dia)) {
            idade--; 
        }
        return idade;
    }

    private static String Signo(int mes, int dia) {
        String[] signos = {"Capricórnio", "Aquário", "Peixes", "Áries", "Touro", "Gêmeos", "Câncer", "Leão", "Virgem", "Libra", "Escorpião", "Sagitário"};
        int[] dias = {22, 20, 20, 20, 20, 21, 22, 22, 22, 22, 21, 21};
        int i = (mes + (dia < dias[mes - 1] ? 10 : 11)) % 12;
        return signos[i];
    }

    private static int Sorte() {
        return (int) (0 + Math.random() * 99);
    }

    private static String EstadoCivil(int estadoCivil) {
        String[] estados = {"Solteiro(a)", "Casado(a)", "Divorciado(a)"};
        return estados[estadoCivil - 1];
    }
}
//oi kk