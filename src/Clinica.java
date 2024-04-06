


import java.util.ArrayList;

public class Clinica {
    private int qtdeMaxPacientes;
    private ArrayList<Paciente> pacientes;

    public Clinica(int qtdeMaxPacientes) {
        this.qtdeMaxPacientes = qtdeMaxPacientes;
        this.pacientes = new ArrayList<>();
    }

    public void cadastrarPaciente(Paciente paciente) {
        if (pacientes.size() < qtdeMaxPacientes) {
            pacientes.add(paciente);
        } else {
            System.out.println("Capacidade máxima de pacientes atingida!");
        }
    }

    public void listarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("Não há pacientes cadastrados.");
        } else {
            System.out.println("Lista de Pacientes:");
            for (Paciente paciente : pacientes) {
                System.out.println(paciente);
            }
        }
    }

    public Paciente buscarPaciente(String cpf) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                return paciente;
            }
        }
        return null;
    }

    public void listarPacientesPorIMC(float min, float max) {
        boolean encontrou = false;
        System.out.println("Pacientes com IMC entre " + min + " e " + max + ":");
        for (Paciente paciente : pacientes) {
            if (paciente.getImc() >= min && paciente.getImc() <= max) {
                System.out.println(paciente);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum paciente encontrado com IMC entre " + min + " e " + max + ".");
        }
    }
}