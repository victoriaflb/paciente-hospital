

import java.util.ArrayList;
import java.util.Scanner;

public class Funcionalidades {

    Paciente paciente = new Paciente();

    // Método para criar um paciente e adicioná-lo à lista de pacientes
    public static Paciente criarPaciente(Scanner input) {
        System.out.println("Cadastro de Pacientes");
        System.out.println("Digite o nome do paciente: ");
        String nome = input.nextLine();

        System.out.println("Digite o CPF do paciente: ");
        String cpf = input.nextLine();

        System.out.println("Digite o peso do paciente: ");
        float peso = input.nextFloat();

        System.out.println("Digite a altura do paciente: ");
        float altura = input.nextFloat();

        Paciente paciente = new Paciente(nome, cpf, peso, altura);

        return paciente;
    }

    // Método para alterar um paciente existente
    public static void alterarPaciente(ArrayList<Paciente> pacientes, String nome, String cpf, float peso, float altura) {
        if(pacientes.stream().filter(p -> p.getCpf().equals(cpf)).findFirst().isPresent()){
            Paciente paciente = pacientes.stream().filter(p -> p.getCpf().equals(cpf)).findFirst().get();
            paciente.setNome(nome);
            paciente.setPeso(peso);
            paciente.setAltura(altura);
            int index = pacientes.indexOf(paciente);
            pacientes.set(index, paciente);
        }
    }

    // Método para buscar um paciente por IMC
    public static void buscarPorIMC(float inicio, float fim, ArrayList<Paciente> listaPacientes) {

        System.out.println("Pacientes com IMC entre o intervalo de " + inicio + " a " + fim + ":");

        for (Paciente paciente : listaPacientes) {
            if (paciente.getImc() >= inicio && paciente.getImc() <= fim) {
                System.out.println(paciente.toString());
            }
        }
    }
}