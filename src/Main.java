
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int opcao = 0;
        Scanner input = new Scanner(System.in); // Definindo o locale para usar o ponto como separador decimal
        Clinica clinica = new Clinica(500); // Defina a capacidade máxima de pacientes

        while (opcao != 5) {
            System.out.println("\nHospital da Elsa");
            System.out.println("\n*----------Menu----------*" +
                    "\n1 - Cadastrar Pacientes" +
                    "\n2 - Listar Pacientes" +
                    "\n3 - Alterar Pacientes" +
                    "\n4 - Buscar por IMC" +
                    "\n5 - Sair" +
                    "\nInforme uma opção:"
            );

            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    clinica.cadastrarPaciente(criarPaciente(input));
                    System.out.println("Paciente cadastrado com sucesso!");
                    break;
                case 2:
                    clinica.listarPacientes();
                    break;
                case 3:
                    alterarPaciente(input, clinica);
                    break;
                case 4:
                    buscarPorIMC(input, clinica);
                    break;
                case 5:
                    System.out.println("Saindo....");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        input.close();
    }

    public static Paciente criarPaciente(Scanner input) {
        System.out.println("Cadastro de Pacientes");
        System.out.println("Digite o nome do paciente: ");
        String nome = input.nextLine();

        System.out.println("Digite o CPF do paciente: ");
        String cpf = input.nextLine();

        System.out.println("Digite o peso do paciente: ");
        float peso = Float.parseFloat(input.nextLine());

        System.out.println("Digite a altura do paciente em centímetros: ");
        float alturaCm = Float.parseFloat(input.nextLine());


        return new Paciente(nome, cpf, peso, alturaCm);
    }


    public static void alterarPaciente(Scanner input, Clinica clinica) {
        System.out.println("Digite o CPF do paciente que deseja alterar: ");
        String cpf = input.nextLine();

        Paciente paciente = clinica.buscarPaciente(cpf);
        if (paciente != null) {
            System.out.println("Digite o novo nome: ");
            paciente.setNome(input.nextLine());

            System.out.println("Digite o novo peso: ");
            paciente.setPeso(input.nextFloat());

            System.out.println("Digite a nova altura: ");
            paciente.setAltura(input.nextFloat());

            System.out.println(paciente.confirmarPaciente());
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    public static void buscarPorIMC(Scanner input, Clinica clinica) {
        System.out.println("Digite o valor mínimo do IMC: ");
        float min = input.nextFloat();

        System.out.println("Digite o valor máximo do IMC: ");
        float max = input.nextFloat();

        clinica.listarPacientesPorIMC(min, max);
    }
}